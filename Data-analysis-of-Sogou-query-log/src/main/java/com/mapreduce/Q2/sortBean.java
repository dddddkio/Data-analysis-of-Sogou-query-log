package com.mapreduce.Q2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class sortBean implements Writable{
	
	String user;
	String url;
	
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		user = in.readUTF();
		url = in.readUTF();
	}
	
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(user);
		out.writeUTF(url);
	}

}
