package sk.gorwell.barkochba;


import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BarkochbaActivity extends Activity {

	private int num = 0; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.barkochba);
		
		TextView tvStatus = (TextView) findViewById(R.id.tvStatus);
		tvStatus.setText(this.getString(R.string.tvStatus));
		
		Button btNew = (Button) findViewById(R.id.btNew);		
		btNew.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				generateNewNumber();
				
			}}
        );
		
		Button btAnswer = (Button) findViewById(R.id.btAnswer);
		btAnswer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				setStatus();
				
			}}
        );
	}
	
	private void generateNewNumber() {
		Random randomGenerator = new Random();
	    num = randomGenerator.nextInt(100);
	    Log.i("TEST", "Új szám generálva.");

	}
	
	private void setStatus() {
		EditText etNum = (EditText) findViewById(R.id.etNum);
		TextView tvStatus = (TextView) findViewById(R.id.tvStatus);
		
		int g = Integer.parseInt(etNum.getText().toString());
		
		if(g>num)
		{
			tvStatus.setText(this.getString(R.string.less));
		}
		else if(g<num)
		{
			tvStatus.setText(this.getString(R.string.more));
		}
		else
		{
			tvStatus.setText(this.getString(R.string.guessed));
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.barkochba, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.menu_1 :
			Toast.makeText(this, "menu1", Toast.LENGTH_LONG).show();
			break;
		case R.id.menu_2 :
			Toast.makeText(this, "menu2", Toast.LENGTH_LONG).show();
			break;	
		default:
			break;
		}
		return true;
	}
	
	

}
