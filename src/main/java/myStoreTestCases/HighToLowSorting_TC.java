package myStoreTestCases;

import myStoreTestObjects.SortByObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class HighToLowSorting_TC extends CommonFunctions {

    float price;

    public void sort()
    {
        test.info("Clicking the sports category");
        SortByObjects.sportsCategory.click();

        test.info("Selecting the high to low sort");
        Select select=new Select(SortByObjects.sort);
        select.selectByIndex(5);

        test.info("Getting the sorted products price");
        String lowPrice=SortByObjects.highToLow.getText().replace("$","");
        price=Float.parseFloat(lowPrice);
    }

    public void validate()
    {
        test.info("Expected result is : greater than 500 dollars");
        test.info("Actual result is : "+price);

        if (price>500)
        {
            test.pass("The price has been sorted as high to low");
        }
        else
        {
            test.fail("The price hasn't been sorted as high to low");

            TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("highToLow.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            test.addScreenCaptureFromPath("highToLow.png");
        }
    }

    @Test
    public void priceLowToHigh()
    {
        test=reports.createTest("Price high to low sort test case");
        PageFactory.initElements(driver, SortByObjects.class);
        sort();
        validate();
        SortByObjects.homePage.click();
    }
}
