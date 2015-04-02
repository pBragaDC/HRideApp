package pc.motorcycle.androidapp.AndroidActivites;

import java.util.ArrayList;

import pc.motorcycle.androidapp.About;
import pc.motorcycle.androidapp.FAQ;
import pc.motorcycle.androidapp.Help;
import pc.motorcycle.androidapp.Logout;
import pc.motorcycle.androidapp.R;
import pc.motorcycle.androidapp.R.id;
import pc.motorcycle.androidapp.R.layout;
import pc.motorcycle.androidapp.R.menu;
import pc.motorcycle.androidapp.Settme;
import pc.motorcycle.androidapp.ServerActivities.CompletedTasks;
import pc.motorcycle.androidapp.ServerActivities.HttpAsyncTask;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Settings extends ListActivity {
	ArrayList<String> info;
	String x;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		info = new ArrayList<String>();
		info.add("About");
		info.add("FAQ");
		info.add("Help");
		info.add("Settings");
		info.add("Logout");
		
		final ListView listview = getListView();
        listview.setTextFilterEnabled(true);
        final ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.activity_settings, R.id.output, info);
        listview.setAdapter(adapter);
		
		
	}
	public void onListItemClick(ListView l, View v, int position, long id)
	{
	        super.onListItemClick(l, v, position, id);
	         x = info.get(position);
	         Toast.makeText(getBaseContext(), x ,Toast.LENGTH_SHORT).show();
	         
	         if ( x == "About") {
	         Intent i = new Intent(Settings.this, CreateActivity.class);
	         Settings.this.startActivity(i);
	         Settings.this.finish();
	         }
	         if ( x == "FAQ") {
		         Intent i = new Intent(Settings.this, FAQ.class);
		         Settings.this.startActivity(i);
		         Settings.this.finish();
		         }
	         if ( x == "Help") {
		         Intent i = new Intent(Settings.this, Help.class);
		         Settings.this.startActivity(i);
		         Settings.this.finish();
		         }
	         if ( x == "Settings") {
		         Intent i = new Intent(Settings.this, Settme.class);
		         Settings.this.startActivity(i);
		         Settings.this.finish();
		         }
	         if ( x == "Logout") {
					Thread thread = new Thread(new Runnable()  {
		                @Override
		                public void run() {
									HttpAsyncTask GPS = new HttpAsyncTask(
											new CompletedTasks() {
												public void callBack(
														String result) {
													Intent i = new Intent(
															Settings.this,
															Login.class);
													Settings.this
															.startActivity(i);
													Settings.this
															.finish();
												}
													});

									if (GPS.isConnected(Settings.this)) {
										GPS.execute("logout.php");
									}
								 
		            };
		           
		            });
					
				thread.start();
				}
	         
	}
	 public void onBackPressed()
	    {
	        super.onBackPressed();
	        super.finish(); 
	        //Intent
	    }
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
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
