package commonActions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonFunctions {

   public static WebDriver driver;
   public static Properties properties;
   public static ExtentReports reports;
   public ExtentTest test;


    public void loadPropertyFile()
    {
        try {
            FileInputStream stream=new FileInputStream("config.properties");
            properties=new Properties();
            properties.load(stream);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void setupExtentReport()
    {
        reports=new ExtentReports();
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("TestReport.html");
        reports.attachReporter(reporter);
    }


    @BeforeSuite
    public void setup()
    {
        loadPropertyFile();
        setupExtentReport();

        String browser=properties.getProperty("Browser");
        String url=properties.getProperty("Url");

        if (browser.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);

    }

    @AfterSuite
    public void tearDown()
    {
        driver.quit();
        reports.flush();
    }



}
