package com.qa.ebay.Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	
	int counter=0;
	int retrylimit=3;
	
	public boolean retry(ITestResult Result)
	{
		if(counter<retrylimit)
		{
			counter++;
			return true;
		}
		return false;
	}

}
