package com.showcounter.webservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;

import com.showcounter.model.Show;

public class WebServiceManager extends AsyncTask<String, Void, ArrayList<Show>>{
	@Override
	protected ArrayList<Show> doInBackground(String... arg0) {
		HttpClient httpClient=new DefaultHttpClient();
		HttpGet del=new HttpGet("http://10.0.2.2:3000/shows.json");
		del.setHeader("content-type", "application/json");
		ArrayList<Show>lSeries=new ArrayList<Show>();
		try{
			HttpResponse resp = httpClient.execute(del);
	        String respStr = EntityUtils.toString(resp.getEntity());
	
	        JSONArray respJSON = new JSONArray(respStr);
	        for(int i=0;i<respJSON.length();i++){
	            JSONObject obj = respJSON.getJSONObject(i);
	        
	            String name = obj.getString("name");
	            String date = obj.getString("date");
	            String dateh=obj.getString("dateh");
	            SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	            lSeries.add(new Show(name, textFormat.parse(dateh)));
	        }
		}catch	(Exception e){
			System.out.println("Excepción al recuperar todas las series");
			e.printStackTrace();
		}
		return lSeries;
	}
	
}
