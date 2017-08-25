package com.example.laborin.sampletodo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;

import static com.example.laborin.sampletodo.R.id.lvItems;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> itemsList;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private final int REQUEST_CODE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, itemsList);
        lvItems.setAdapter(itemsAdapter);
        removeItemListener();
        editItemListener();
    }

    public void addItem(View view){
        EditText editText = (EditText) findViewById(R.id.etNewItem);
        String newItem = editText.getText().toString();
        if (newItem.length() == 0) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Empty String")
                    .setMessage("New Item cannot be empty")
                    .setCancelable(true)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        } else {
            itemsList.add(newItem);
            editText.setText("");
            saveItems();
        }
    }

    private void removeItemListener(){
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id){
                itemsList.remove(pos);
                itemsAdapter.notifyDataSetChanged();
                saveItems();
                return true;
            }
        });
    }

    private void editItemListener(){
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapter, View item, int pos, long id){
                Intent editActivity = new Intent(MainActivity.this, EditItemActivity.class);
                editActivity.putExtra("text2Edit",itemsList.get(pos));
                editActivity.putExtra("pos",pos);
                startActivityForResult(editActivity, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            itemsList.set(data.getExtras().getInt("pos"),
                    data.getExtras().getString("newValue"));
            itemsAdapter.notifyDataSetChanged();
            saveItems();
        }

    }

    private void readItems(){
        File dirFiles = getFilesDir();
        File todoFile = new File(dirFiles, "SampleTodo.txt");
        try{
            itemsList = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException exc){
            itemsList = new ArrayList<String>();
        }
    }

    private void saveItems(){
        File dirFiles = getFilesDir();
        File todoFile = new File(dirFiles, "SampleTodo.txt");
        try{
            FileUtils.writeLines(todoFile,itemsList );
        } catch (IOException exc){
            exc.printStackTrace();
        }
    }
}
