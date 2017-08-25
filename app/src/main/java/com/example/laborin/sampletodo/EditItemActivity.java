package com.example.laborin.sampletodo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        pos = getIntent().getIntExtra("pos",0);
        EditText text2Edit = (EditText) findViewById(R.id.etItem2Edit);
        text2Edit.setText(getIntent().getStringExtra("text2Edit"));
        text2Edit.setSelection(text2Edit.getText().length());
        text2Edit.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public void onSaveNewText(View view){
        String newText = ((EditText) findViewById(R.id.etItem2Edit)).getText().toString();
        if (newText.length() == 0){
            new AlertDialog.Builder(EditItemActivity.this)
                    .setTitle("Empty String")
                    .setMessage("New text cannot be empty")
                    .setCancelable(true)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("newValue", newText);
            intent.putExtra("pos",pos);
            setResult(RESULT_OK, intent);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY,0);
            finish();
        }
    }
}
