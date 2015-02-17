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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Settings extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		ArrayList<String> info = new ArrayList<String>();
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
	        Object o = this.getListAdapter().getItem(position);
	        String pen = o.toString();
	        Toast.makeText(this, "You have chosen the pen: " + " " + pen, Toast.LENGTH_LONG).show();
	        //Intent ii = new Intent(pen);
			//startActivity(ii);
	    
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
