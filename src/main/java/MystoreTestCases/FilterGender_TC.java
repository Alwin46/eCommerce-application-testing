package MystoreTestCases;

import MystoreTestObjects.FilterObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FilterGender_TC extends CommonFunctions {

    String filtered;

    public void filter()
    {
        test.info("Clicking the clothes category");
        FilterObjects.clothesCategory.click();

        test.info("Selecting the gender women");
        FilterObjects.genderWomen.click();

        try {
            test.info("Getting the filtered gender");
            filtered= FilterObjects.genderFiltered.getText();
        }catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void validateGender()
    {
        test.info("Expected result is : Women");
        test.info("Actual result is : "+filtered);

        if(filtered.equals("Women"))
        {
            test.pass("The gender has been filtered to women");
        }
        else
        {
            test.fail("The gender hasn't been filtered to women");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("genderFilter.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("genderFilter.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        Assert.assertEquals(filtered,"Women");
    }

    @Test
    public void filterGender()
    {
        test=reports.createTest("Filter gender test case");
        PageFactory.initElements(driver, FilterObjects.class);
        filter();
        validateGender();
        FilterObjects.homePage.click();
    }
}
