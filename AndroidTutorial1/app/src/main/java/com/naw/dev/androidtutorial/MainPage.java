package com.naw.dev.androidtutorial;

import java.util.ArrayList;

import com.naw.dev.androidtutorial1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * @author Cole Willison
 * @since 2014-11-25
 * 
 * 
 * */
public class MainPage extends Activity {
	
	public static final String ITEM_KEY = "item_key";
	public static final String DEBUG_TAG = "Android Tutorial App";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// sets the android xml view file to this activity
		setContentView(R.layout.activity_main_page);
		// method convention I use to set all UI widgets
		setUpWidgets();

	}

	private void setUpWidgets() {
		/*
		 * findViewById finds the widget in the XML file from its resource
		 * identifier. The resource identifier is the id you set in the XML file
		 * (R.id.RESOURCE_ID_NAME). This is actually an auto-generated number
		 * found in the gen/R.java class, but you do not need to worry about
		 * that. You then type cast the known object type to initialize the
		 * variable.
		 */
		ListView list = (ListView) findViewById(R.id.lvItemList);

		/*
		 * Create a String Array List to hold the list items. In a later
		 * tutorial I will show you have to make a list of objects, ie. A list
		 * with pictures and text or even a list of UI widgets.
		 */
		ArrayList<String> items = new ArrayList<String>();

		items.add("Cross Product Calculator");
		items.add("Weather Request");
		items.add("Future item:2");
		items.add("Future item:3");

		/*
		 * Create an array adapter which is a layer between the data source
		 * (ArrayList<String>) and the adapter view.
		 * 
		 * Note: android.R.layout.simple_list_item_1 is provided in the android
		 * SDK for lists with just strings I am using it for simplicity and
		 * demonstrative purposes.
		 */
		ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);

		// link the ListView to the ArrayAdapter
		list.setAdapter(itemAdapter);

		/*
		 * Set and create a item listener on the list. This is how you know when
		 * an item was clicked
		 */
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// arg2 returns the element number of the list
				// call a method to handle the itemClick
				itemSelected(arg2);
			}
		});
	}

	private void itemSelected(int arg) {
		switch (arg) {
		case 0:
			// item 0
			
			/*
			 * Intents are used to launch activities. The inputs to 
			 * the Intent constructor are the application context (itself -> this) and the
			 * class you want to launch. This can also be called by the package name. ie.
			 * CrossProductActivity.class  -> "com.naw.dev.androidtutorial1.crossproductactivity"
			 * 
			 * Bundle object is used as a container of information passing between activities
			 * 
			 * */
			Intent intent = new Intent(this, CrossProductSolverActivity.class);
			Bundle extras = new Bundle();
			extras.putString("item_key", "This is to show how pass information between activities");
			
			//attach the bundle to the intent
			intent.putExtras(extras);
			
			//Log what is happening for  debugging purposes, this is a good practice when in development
			Log.d(DEBUG_TAG, "Starting cross product activity");
			
			//start activity
			startActivity(intent);
			break;
		case 1:

            intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);

			// item 1
			break;
		case 2:
			// item 2
			break;
		case 3:
			// item 3
			break;
		}
		Toast.makeText(this, "Item Number: " + arg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
