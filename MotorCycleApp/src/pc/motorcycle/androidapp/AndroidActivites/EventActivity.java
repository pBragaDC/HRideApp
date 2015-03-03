package pc.motorcycle.androidapp.AndroidActivites;

import java.util.ArrayList;

import pc.motorcycle.androidapp.R;
import pc.motorcycle.androidapp.R.id;
import pc.motorcycle.androidapp.R.layout;
import pc.motorcycle.androidapp.R.menu;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class EventActivity extends  Activity {
	ArrayList<String> events;
	private Button Events;
	private Button Rides;
	private Button Profile;
	private Button Settings;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_layout);
		
		/*events = new ArrayList<String>();
		events.add("Ride 1");
		events.add("Ride 2");
		events.add("Ride 3");
		events.add("Ride 4");
		events.add("Ride 5");
		final ListView listview = getListView();
        listview.setTextFilterEnabled(true);
        final ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.event_layout, R.id.output, events);
        listview.setAdapter(adapter);*/
		
        
        Settings = (Button)findViewById(R.id.btnSettings);
		Settings.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(EventActivity.this, Settings.class);
				startActivity(i);
			}
			
		});
	}
	/*public void onListItemClick(ListView l, View v, int position, long id)
	{
	        super.onListItemClick(l, v, position, id);}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
