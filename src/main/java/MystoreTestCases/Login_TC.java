package MystoreTestCases;

import MystoreTestObjects.LoginObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Login_TC extends CommonFunctions {

    public void loginMystore()
    {
        LoginObjects.specialOffersPopup.click();

        test.info("Clicking the sign up button");
        LoginObjects.signUp.click();

        test.info("Entering the valid email");
        LoginObjects.email.sendKeys(properties.getProperty("Email"));

        test.info("Entering the valid password");
        LoginObjects.password.sendKeys(properties.getProperty("Password"));

        test.info("Clicking the login button");
        LoginObjects.loginButton.click();
    }


    public void titleValidation()
    {
        test.info("Getting the title of the application");
        String title=driver.getTitle();

        test.info("Expected result is : MyStore, My Store");
        test.info("Actual result is : "+title);

        if (title.equals("MyStore, My Store"))
        {
            test.pass("The Mystore application is logged in successfully");
        }
        else
        {
            test.fail("The Mystore application is not logged in successfully");
            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("login.png");

            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("login.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
        Assert.assertEquals(title,"MyStore, My Store");
    }

    @Test
    public void login()
    {
        test=reports.createTest("Login Test Case");
        PageFactory.initElements(driver, LoginObjects.class);
        loginMystore();
        titleValidation();
    }

}
