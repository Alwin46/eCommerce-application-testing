package myStoreTestCases;

import myStoreTestObjects.FilterObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FilterSize_TC extends CommonFunctions {

    String filtered;

    public void filter()
    {
        test.info("Clicking the clothes category");
        FilterObjects.clothesCategory.click();

        test.info("Selecting the small size in filter");
        FilterObjects.smallSize.click();

        test.info("Getting the filtered size");
        filtered=FilterObjects.sizeFiltered.getText();

    }

    public void validateSize()
    {
        test.info("Expected result is : Small");
        test.info("Actual result is : "+filtered);

        if (filtered.equals("Small"))
        {
            test.pass("The size has been filtered to small");
        }
        else
        {
            test.fail("The size hasn't been filtered to small");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("sizeFilter.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("sizeFilter.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
        Assert.assertEquals(filtered,"Small");
    }

    @Test
    public void filterSize()
    {
        test=reports.createTest("Filter size test case");
        PageFactory.initElements(driver, FilterObjects.class);
        filter();
        validateSize();
        FilterObjects.homePage.click();

    }
}
