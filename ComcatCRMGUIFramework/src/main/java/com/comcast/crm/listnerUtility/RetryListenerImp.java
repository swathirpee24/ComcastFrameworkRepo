package com.comcast.crm.listnerUtility;


import org.testng.ITestResult;

public class RetryListenerImp Implements IRetryAnalyzer {
	
	int count = 0;
	int limitCount = 5;
	public boolean retry(ITestResult result) {
		if(count<limitCount) {
			Count++;
			return true;
		}
		return false;
		
		
			
		}
	
	
	
	
	


