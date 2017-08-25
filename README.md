# Pre-work - SampleTodo

SampleTodo is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Luis Manuel Laborin Aguilar

Time spent: 5 hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **successfully add and remove items** from the todo list
* [X] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [X] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<iframe width="420" height="315"
src="https://youtu.be/lveV7vMeocc">
</iframe>

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

It is great to know a new API, it's also very clear to understand what are you doing and how to add some behavior to the elements on the app. Once you get to know on how to handle xml and java and how they interact is easy to manipulate data between them.
In comparision of another Java frameworks or API, I found this one easier in the way that data can be sent and a lot of things are already implemented so Developers just have to thing in what they want and search on what class already does. Also there is a lot of documentation which is a good point to take in consideration.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

Basically as I can see in code, the adapter is in charge of handle your array. With this I mean that this is in charge to give it format, to have listener to see if something has change on your array and in that way the adapter can repaint the list.

## Notes

First challenge that I found is to check on how to get the front end in line, I mean at the beggining without using LinearLayout tag it was difficult for me to get things in order.
Another Challenge that I had was to set keyboard while getting on the edit activity.

## License

    Copyright 2017 Luis Manuel Laborin Aguilar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
