package programs;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	


public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	onTestStart(result);
	System.out.println("TestStarted:"+result.getName());
	
}

public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	onTestSuccess(result);
System.out.println("TestSuccess:"+result.getName());
}


public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	onTestFailure(result);
}

public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
onTestSkipped(result);
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	onTestFailedButWithinSuccessPercentage(result);
}

public void onTestFailedWithTimeout(ITestResult result) {
	// TODO Auto-generated method stub
	onTestFailedWithTimeout(result);
}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	onStart(context);
}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	onFinish(context);
}}