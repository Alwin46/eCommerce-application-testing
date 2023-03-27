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


public class LowToHighSorting_TC extends CommonFunctions {

    float price;

    public void sort()
    {
        test.info("Clicking the sports category");
        SortByObjects.sportsCategory.click();

        test.info("Selecting the low to high sort");
        Select select=new Select(SortByObjects.sort);
        select.selectByIndex(4);

        test.info("Getting the sorted products price");
        String lowPrice=SortByObjects.lowToHigh.getText().replace("$","");
        price=Float.parseFloat(lowPrice);
    }

    public void validate()
    {
        test.info("Expected result is : less than 10 dollars");
        test.info("Actual result is : "+price);

        if (price<10)
        {
            test.pass("The price has been sorted as low to high");
        }
        else
        {
            test.fail("The price hasn't been sorted as low to high");

            TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("lowToHigh.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("lowToHigh.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    public void priceLowToHigh()
    {
        test=reports.createTest("Price low to high sort test case");
        PageFactory.initElements(driver, SortByObjects.class);
        sort();
        validate();
        SortByObjects.homePage.click();
    }
}
