package com.showcounter.adapter;

import android.os.CountDownTimer;
import android.widget.TextView;

public class MyCountDown extends CountDownTimer{
	private TextView tV;
	public MyCountDown(long millisInFuture, long countDownInterval, TextView tV) {
		super(millisInFuture, countDownInterval);
		this.tV=tV;
	}

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTick(long millisUntilFinished) {
		millisUntilFinished=millisUntilFinished/1000;
        int dias=(int)(millisUntilFinished/(3600*24));
        millisUntilFinished=millisUntilFinished%(3600*24);
        int horas=(int) (millisUntilFinished/3600);
        millisUntilFinished=(int) (millisUntilFinished%3600);
        int minutos=(int)millisUntilFinished/60;
        millisUntilFinished=(int)(millisUntilFinished%60);
        tV.setText( "   "+dias+" Días "+horas+" horas "+ minutos+" Minutos "+ millisUntilFinished+" Segundos ");
	}

}
