package pc.motorcycle.androidapp.AndroidActivites;

import pc.motorcycle.androidapp.R;
import pc.motorcycle.androidapp.R.id;
import pc.motorcycle.androidapp.R.layout;
import pc.motorcycle.androidapp.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateActivity extends Activity {

	private Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
		Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
		String[] items = new String[]{"Ride", "Event"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);
		
		submit = (Button)findViewById(R.id.submit);
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
		         Toast.makeText(getBaseContext(), "Submitted" ,Toast.LENGTH_SHORT).show();
				Intent i = new Intent(CreateActivity.this, EventActivity.class);
				startActivity(i);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create, menu);
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
