package com.mapreduce.Q2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Q2Partitioner extends Partitioner<Text,sortBean>{

	@Override
	public int getPartition(Text k2, sortBean v2, int num) {
		String name = k2.toString();
		// 还有中括号
		if(name.length()>=6) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
