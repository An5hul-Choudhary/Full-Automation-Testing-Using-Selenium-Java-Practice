import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.SuiteRunState;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extentReports;

    @BeforeTest
    public void config(){

        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Anshul");

    }


    @Test
    public void initialDemo(){

        ExtentTest test = extentReports.createTest("Initial Demo");
        WebDriver driver = new EdgeDriver();
        driver.get("https://mvnrepository.com/search?q=Webdriver");
        System.out.println(driver.getTitle());
        driver.close();
        test.fail("Results do not match");
        extentReports.flush();
    }


}
