package MystoreTestCases;

import MystoreTestObjects.FilterObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FilterPrice_TC extends CommonFunctions {
    String filtered;

    public void filter()
    {
        test.info("Clicking the clothes category");
        FilterObjects.clothesCategory.click();

        test.info("Setting the price filter to 100$ to 350$");
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(FilterObjects.price,77,0).build().perform();

        test.info("Clicking the ok button");
        FilterObjects.okButton.click();

        test.info("Getting the filtered price");
        filtered= FilterObjects.priceFiltered.getText();

    }

    public void validatePrice()
    {
        test.info("Expected result is : $100.00 - $350.00");
        test.info("Actual result is : "+filtered);

        if (filtered.equals("$100.00 - $350.00"))
        {
            test.pass("The price has been filtered to $100.00 - $350.00 level");
        }
        else
        {
            test.fail("The price hasn't been filtered to $100.00 - $350.00 level");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("priceFilter.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("priceFilter.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        Assert.assertEquals(filtered,"$100.00 - $350.00");
    }

    @Test
    public void filterPrice()
    {
        test=reports.createTest("Filter price test case");
        PageFactory.initElements(driver, FilterObjects.class);
        filter();
        validatePrice();
        FilterObjects.homePage.click();
    }
}
