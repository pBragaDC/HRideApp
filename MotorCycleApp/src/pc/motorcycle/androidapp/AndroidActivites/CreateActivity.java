package pc.motorcycle.androidapp.AndroidActivites;

import pc.motorcycle.androidapp.R;
import pc.motorcycle.androidapp.R.id;
import pc.motorcycle.androidapp.R.layout;
import pc.motorcycle.androidapp.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CreateActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
		Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
		String[] items = new String[]{"Ride", "Event"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create, menu);
		return true;
	}
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) { 
        	Intent i = new Intent(CreateActivity.this, EventActivity.class);
        	startActivity(i);
        	finish();           
        	return true;
        }
        return super.onKeyDown(keyCode, event);
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
