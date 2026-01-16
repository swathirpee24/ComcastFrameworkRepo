package com.comcast.crm.generic.Fileutiliy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	public  String getDataFromPropertiesFile(String key) throws Throwable {
	FileInputStream fis = new FileInputStream("./configAppData/commondata.Properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	String data = pObj.getProperty(key);
	
	return data;
	
	
	
}
}
