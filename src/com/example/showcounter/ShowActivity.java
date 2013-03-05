package com.example.showcounter;

import com.showcounter.adapter.MyCountDown;
import com.showcounter.model.Show;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends Activity{
	protected void onCreate(Bundle savedInstance){
		super.onCreate(savedInstance);
		setContentView(R.layout.show_layout);
		TextView tV=((TextView) findViewById(R.id.textView1));
		Show show=this.getIntent().getParcelableExtra("show");
		MyCountDown cDown=new MyCountDown(show.getDate().getTime()-System.currentTimeMillis(), 1000, tV);
		cDown.start();
	}
}
