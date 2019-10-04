package workingWithTestNGListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("TcFinish results are:"+ " "+ result.getName());
	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("TC onstart result are:"+" "+ result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("TC onTestFailedButWithinSuccessPercentage result are:"+" "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Tc ontestfailure result are:"+" "+ result.getName() );
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Tc onTestSkipped result are:"+" "+result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Tc onTestStart result are:"+" "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Tc onTestSuccess result are:"+" "+result.getName());
	}

	
}
