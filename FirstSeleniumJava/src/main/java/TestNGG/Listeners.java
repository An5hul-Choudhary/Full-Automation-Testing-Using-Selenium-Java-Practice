package TestNGG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("I successfully executed onTestFailure listeners interface class");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("I successfully executed onTestSuccess listeners interface class");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
