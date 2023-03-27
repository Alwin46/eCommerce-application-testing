package MystoreTestCases;

import MystoreTestObjects.CategoryObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BeautyProductsCategory_TC extends CommonFunctions {

    String categorized;

    public void categorize()
    {
        test.info("Clicking the beauty products category");
        CategoryObjects.beautyProductsCategory.click();

        test.info("Getting the categorized result");
        categorized= CategoryObjects.categorizedProducts.getText();
    }

    public void validateCategorizedProducts()
    {
        test.info("Expected result is : Beauty");
        test.info("Actual result is : "+categorized);

        if (categorized.equals("Beauty"))
        {
            test.pass("The beauty products has been categorized");
        }
        else
        {
            test.fail("The beauty products hasn't been categorized");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("beauty.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("beauty.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        Assert.assertEquals(categorized,"Beauty");
    }

    @Test
    public void beautyProducts()
    {
        test=reports.createTest("Search beauty products category Test Case");
        PageFactory.initElements(driver, CategoryObjects.class);
        categorize();
        validateCategorizedProducts();
        CategoryObjects.homePage.click();
    }
}
