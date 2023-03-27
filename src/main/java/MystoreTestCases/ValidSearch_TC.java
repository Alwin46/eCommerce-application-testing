package MystoreTestCases;

import MystoreTestObjects.SearchBarobjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ValidSearch_TC extends CommonFunctions {

    String result;

   public void search()
   {
       test.info("Clicking the search bar");
       SearchBarobjects.searchBar.click();

       test.info("Entering a valid data");
       driver.switchTo().activeElement().sendKeys("Plant Knight Protectors - 3 PACK"+ Keys.ENTER);

       test.info("Getting the search result");
       result=SearchBarobjects.searchResult.getText();
   }

   public void validate()
   {
       test.info("Expected result is : Plant Knight Protectors - 3 PACK");
       test.info("Actual result is : "+result);

       if (result.equals("Plant Knight Protectors - 3 PACK"))
       {
           test.pass("This is valid data");
       }
       else
       {
           test.fail("This is invalid data");

           TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
           File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
           File file=new File("validData.png");
           try {
               FileHandler.copy(screenShot,file);
           } catch (IOException e)
           {
               System.out.println(e.getMessage());
           }

           try {
               test.addScreenCaptureFromPath("validData.png");
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }
       }

       Assert.assertEquals(result,"Plant Knight Protectors - 3 PACK");
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
