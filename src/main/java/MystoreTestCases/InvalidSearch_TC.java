package MystoreTestCases;

import MystoreTestObjects.SearchBarobjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class InvalidSearch_TC extends CommonFunctions {

    String result;

   public void search()
   {
       test.info("Clicking the search bar");
       SearchBarobjects.searchBar.click();

       test.info("Entering a Invalid data");
       driver.switchTo().activeElement().sendKeys("12345"+ Keys.ENTER);

   }

   public void validate()
   {
       try {
           test.info("Getting the search result");
           test.info("Expected result is : null");

           result=SearchBarobjects.searchResult.getText();
           test.info("Actual result is : "+result);

           test.fail("The is valid data");

           TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
           File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
           File file=new File("inValidData.png");
           try {
               FileHandler.copy(screenShot,file);
           } catch (IOException e)
           {
               System.out.println(e.getMessage());
           }

           try {
               test.addScreenCaptureFromPath("inValidData.png");
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }

       }
       catch (NoSuchElementException e){

           test.info("Actual result is :"+result);
           test.pass("This is invalid data");
       }
       Assert.assertNull(result);
   }


    @Test
    public void validSearch() {
        test = reports.createTest("Valid data search test case");
        PageFactory.initElements(driver, SearchBarobjects.class);
        search();
        validate();
        SearchBarobjects.homePage.click();
    }

}
