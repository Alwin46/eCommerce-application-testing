package myStoreTestCases;

import myStoreTestObjects.CategoryObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class MystoreAllProductsCategory_TC extends CommonFunctions {

    String categorized;
    public void categorize()
    {
        test.info("Clicking the Mystore all category");
        CategoryObjects.allProductsCategory.click();

        test.info("Getting the categorized result");
        categorized= CategoryObjects.categorizedProducts.getText();

    }

    public void validateCategorizedProducts()
    {
        test.info("Expected result is : MyStore");
        test.info("Actual result is : "+categorized);

        if (categorized.equals("MyStore"))
        {
            test.pass("The Mystore all products has been categorized");
        }
        else
        {
            test.fail("The Mystore all products hasn't been categorized");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("MyStore.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("MyStore.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        Assert.assertEquals(categorized,"MyStore");
    }

    @Test
    public void beautyProducts()
    {
        test=reports.createTest("Search all products category Test Case");
        PageFactory.initElements(driver, CategoryObjects.class);
        categorize();
        validateCategorizedProducts();
        CategoryObjects.homePage.click();
    }
}
