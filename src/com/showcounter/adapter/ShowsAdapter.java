package com.showcounter.adapter;

import java.util.ArrayList;


import com.example.showcounter.R;
import com.showcounter.model.Show;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ShowsAdapter extends ArrayAdapter<Show> {
    Activity context;
    ArrayList<Show>data;
    
    public ShowsAdapter(Activity context, ArrayList<Show>data) {
        super(context, R.layout.activity_main, data);
        this.context = context;
        this.data=data;
    }
 
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View item = convertView;
		ViewHolder holder;
		
		if(item == null)
		{
			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.listitem_titular, null);
			
			holder = new ViewHolder();
			holder.name = (TextView)item.findViewById(R.id.LblName);
			holder.date = (TextView)item.findViewById(R.id.LblDate);
			
			item.setTag(holder);
		}
		else
		{
			holder = (ViewHolder)item.getTag();
		}
		
		holder.name.setText(data.get(position).getName());
		holder.date.setText(data.get(position).getDate().toString());
		
		return(item);
	}
    static class ViewHolder {
    	TextView name;
    	TextView date;
    }
	public Activity getContext() {
		return context;
	}

	public void setContext(Activity context) {
		this.context = context;
	}

	public ArrayList<Show> getData() {
		return data;
	}

	public void setData(ArrayList<Show> data) {
		this.data = data;
	}
    
    
}
