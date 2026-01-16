package com.comcast.crm.generic.Fileutiliy;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws Throwable, ParseException {
		
		FileReader fi = new FileReader("./configAppData/AppCommonData.json");
		JSONParser p= new JSONParser();
		Object obj = p.parse(fi);
	   JSONObject map =  (JSONObject)obj;
		System.out.println(map.get("URL"));
		String data = (String) map.get(key);
		return data;
		
		
		
	}
	

}
