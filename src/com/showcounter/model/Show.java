package com.showcounter.model;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Show implements Parcelable{
	private String name;
	private Date date;
	
	public Show(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
	
	public Show(Parcel in){
		readFromParcel(in);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		arg0.writeString(name);
		arg0.writeLong(date.getTime());
		
	}
	
	public void readFromParcel(Parcel in){
		name=in.readString();
		date=new Date(in.readLong());
	}
	
	public static final Parcelable.Creator<Show> CREATOR
	=new Parcelable.Creator<Show>(){
		public Show createFromParcel(Parcel in){
			return new Show(in);
		}

		@Override
		public Show[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Show[size];
		}
	};
	
	
}
