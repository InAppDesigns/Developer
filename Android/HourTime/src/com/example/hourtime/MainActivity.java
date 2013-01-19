package com.example.hourtime;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Handler handler = new Handler();
		final Runnable vai = new Runnable() {

			@Override
			public void run() {
				onCreate(savedInstanceState);
				Calendar c = Calendar.getInstance();
				int segundos = c.get(Calendar.SECOND);
				int hora = c.get(Calendar.HOUR);
				int minutos = c.get(Calendar.MINUTE);

				Date d = new Date();
				CharSequence s  = DateFormat.format("EEEE, MMMM d, yyyy ", d.getTime());
				TextView t = (TextView)findViewById(R.id.Teste);
				t.setText(""+hora+":"+minutos+":"+segundos+"\n"+s);				
			}
		};

		final Runnable Refresh = new Runnable() {

			@Override
			public void run() {
				handler.postDelayed(vai, 100);
			}
		};

		handler.post(Refresh);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
