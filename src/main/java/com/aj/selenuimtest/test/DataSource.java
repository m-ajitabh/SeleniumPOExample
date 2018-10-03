package com.aj.selenuimtest.test;

import java.util.HashMap;
import java.util.Map;

public class DataSource {

	static Map<String, String> dataSource = new HashMap<String, String>();

	public static String getDataSource(String key) {
		return dataSource.get(key);
	}

	public static void setDataSource(String key,String data) {
		dataSource.put(key, data);
	}
	
	
	
}
