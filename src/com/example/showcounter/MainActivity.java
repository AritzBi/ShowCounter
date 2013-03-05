package com.example.showcounter;


import java.util.concurrent.ExecutionException;


import com.showcounter.adapter.ShowsAdapter;
import com.showcounter.webservice.WebServiceManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ShowsAdapter adaptador;
		try {
			adaptador = new ShowsAdapter(this, new WebServiceManager().execute("ola").get());
	        lstOpciones = (ListView)findViewById(R.id.LstOpciones);
	        lstOpciones.setAdapter(adaptador);
			lstOpciones.setOnItemClickListener(new OnItemClickListener(){
				public void onItemClick(AdapterView<?>a, View v, int position, long id){
					Intent intent=new Intent(MainActivity.this, ShowActivity.class);
					Bundle b=new Bundle();
					b.putParcelable("show", adaptador.getData().get(position));
					intent.putExtras(b);
					startActivity(intent);
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
