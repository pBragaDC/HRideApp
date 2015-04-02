package pc.motorcycle.androidapp.AndroidActivites;

import java.util.StringTokenizer;

import pc.motorcycle.androidapp.R;
import pc.motorcycle.androidapp.R.id;
import pc.motorcycle.androidapp.R.layout;
import pc.motorcycle.androidapp.R.menu;
import pc.motorcycle.androidapp.ServerActivities.AppData;
import pc.motorcycle.androidapp.ServerActivities.CompletedTasks;
import pc.motorcycle.androidapp.ServerActivities.EncryptString;
import pc.motorcycle.androidapp.ServerActivities.HttpAsyncTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class CreateActivity extends Activity {
	private Spinner dropdown;
	private TimePicker time;
	private DatePicker date;
	private EditText title;

	private Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
		time = (TimePicker)findViewById(R.id.timePicker1);
		date = (DatePicker)findViewById(R.id.datePicker1);
		title = (EditText)findViewById(R.id.editText4);
	    dropdown = (Spinner)findViewById(R.id.spinner1);
		String[] items = new String[]{"Ride", "Event"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);
		
		submit = (Button)findViewById(R.id.submit);
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				if (dropdown.getItemAtPosition(dropdown.getSelectedItemPosition()).toString().contains("E")){
					
					class LoginThread implements Runnable {
						@Override
						public void run() {
		
								HttpAsyncTask event = new HttpAsyncTask(
										new CompletedTasks() {
											public void callBack(
													String result) {
												

												if (result.contains("5"))
												{
													Toast.makeText(getApplicationContext(),
															"fill all fields",
															Toast.LENGTH_LONG).show();
				
												 }
											 if (result.contains("0")) {
												HttpAsyncTask nextTask = new HttpAsyncTask(
														new CompletedTasks() {
															public void callBack(
																	String result) {
																Intent i = new Intent(
																		CreateActivity.this,
																		EventActivity.class);
																CreateActivity.this
																		.startActivity(i);
																CreateActivity.this
																		.finish();
																AppData.friends.clear();
																StringTokenizer st = new StringTokenizer(result, " :,"); 
																	while (st.hasMoreTokens()) {	
																		AppData.friends.add(st.nextToken());
																		
																	
																
																
															};
															} 
															
														});

												nextTask.execute("getevents.php");
												
											}
											
											}});
								
								if (event.isConnected(CreateActivity.this)) {
									event.execute("createevent.php");
								}
							
						};
					}

					LoginThread loginThread = new LoginThread();

					loginThread.run();
					
				}
				
				if (dropdown.getItemAtPosition(dropdown.getSelectedItemPosition()).toString().contains("R")) {
					
					class LoginThread implements Runnable {
						@Override
						public void run() {
		
								HttpAsyncTask ride = new HttpAsyncTask(
										new CompletedTasks() {
											public void callBack(
													String result) {
												

												if (result.contains("5"))
												{
													Toast.makeText(getApplicationContext(),
															"fill all fields",
															Toast.LENGTH_LONG).show();
				
												 }
											 if (result.contains("0")) {
												HttpAsyncTask nextTask = new HttpAsyncTask(
														new CompletedTasks() {
															public void callBack(
																	String result) {
																Intent i = new Intent(
																		CreateActivity.this,
																		EventActivity.class);
																CreateActivity.this
																		.startActivity(i);
																CreateActivity.this
																		.finish();
																AppData.friends.clear();
																StringTokenizer st = new StringTokenizer(result, " :,"); 
																	while (st.hasMoreTokens()) {	
																		AppData.friends.add(st.nextToken());
																		
																	
																
																
															};
															} 
															
														});

												nextTask.execute("getrides.php");
												
											}
											
											}});
								
								if (ride.isConnected(CreateActivity.this)) {
									ride.execute("createride.php");
								}
							
						};
					}

					LoginThread loginThread = new LoginThread();

					loginThread.run();
					
					
					
				}
				
				//Intent i = new Intent(CreateActivity.this, EventActivity.class);
				//startActivity(i);
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
