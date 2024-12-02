package Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import MainPack.Wrapper;

public class RerunTestCase extends Wrapper implements IRetryAnalyzer{

	private int RetryCount=0;
	private static final int maxcount = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		Navigate_Home();
		if(RetryCount < maxcount) 
		{
			RetryCount++;
			return true;
		}
		return false;
	}

}
