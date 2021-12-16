package com.mapreduce.Q3_Step2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Q3_Step2Partitioner extends Partitioner<Text,Text>{

	@Override
	public int getPartition(Text k2, Text v2, int num) {
		String name = k2.toString();
		// 还有中括号
		if(name.length()>=6) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
