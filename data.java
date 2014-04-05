package com.androidtesting1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class data extends Activity implements View.OnClickListener, OnCheckedChangeListener{

	
	
	TextView recievedData, setData;
	Button send;
	RadioGroup selectedData;
	String pack2, getData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data);
		Initializer();
		
		SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et = getData.getString("name", "Amit Sharma is  ");
		String values = getData.getString("list", "4");
		
		if(values.contentEquals("1")){
			recievedData.setText(et);
			
		}
		
		//Bundle pack = getIntent().getExtras();
		//getData=  pack.getString("packet");
		//recievedData.setText(getData);
		
			}
	
	public void Initializer() {
		
		recievedData = (TextView) findViewById(R.id.tvRecievedData);
		setData = (TextView) findViewById(R.id.tvDataradio);
		send = (Button) findViewById(R.id.bReturn);
		selectedData = (RadioGroup) findViewById(R.id.radioGroup1);
		send.setOnClickListener(this);
		selectedData.setOnCheckedChangeListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
			Intent sendPacket1 = new Intent();
			Bundle buck = new Bundle();
			buck.putString("ans", pack2);
			sendPacket1.putExtras(buck);
			setResult(RESULT_OK, sendPacket1);
			finish();
			
		
			
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.r1:
			pack2 = "android Developer";
			break;

		case R.id.r3:
			pack2 = "PHP Developer";
			
			break;
		case R.id.r2:
			pack2 = "Network Engineer";
			
			break;

	
		}
		
		setData.setText(pack2);

	
	}

}
