package MystoreTestCases;

import MystoreTestObjects.SignOutObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SignOut_TC extends CommonFunctions {

    String status;

    public void signOutMystore()
    {
        test.info("Clicking the my account page");
        SignOutObjects.accountButton.click();

        test.info("Clicking the sign out button");
        SignOutObjects.signOutButton.click();

        test.info("Clicking the home page");
        SignOutObjects.homePage.click();

        test.info("Getting the account status");
        status=SignOutObjects.accountStatus.getText();

        test.info("Expected result is : Sign in or Join");
        test.info("Actual result is : "+status);
    }

    public void validateSignOut()
    {
      if (status.equals("Sign in or Join"))
      {
          test.pass("The account has been signed out successfully");
      }
      else
      {
          test.fail("The account hasn't been signed out successfully");

          TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
          File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
          File file=new File("signOut.png");
          try {
              FileHandler.copy(screenShot,file);
          } catch (IOException e)
          {
              System.out.println(e.getMessage());
          }

          try {
              test.addScreenCaptureFromPath("signOut.png");
          } catch (IOException e) {
              System.out.println(e.getMessage());
          }
      }

        Assert.assertEquals(status,"Sign in or Join");
    }

    @Test
    public void signOut()
    {
        test=reports.createTest("Sign out test case");
        PageFactory.initElements(driver, SignOutObjects.class);
        signOutMystore();
        validateSignOut();
    }
}
