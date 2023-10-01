package myStoreTestCases;

import myStoreTestObjects.QuantityACartObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LessQuantity_TC extends CommonFunctions {

    String quantity;

    public void decreaseQuantity()
    {
        test.info("Clicking the add to cart page");
        QuantityACartObjects.cartPage.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        test.info("Lessing the quantity once");
        QuantityACartObjects.lessQuantityButton.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        test.info("Getting the quantity value");
        quantity= QuantityACartObjects.quantityValue.getAttribute("data-item-qty");
    }

    public void validateQuantity()
    {
        test.info("Expected result is : 1");
        test.info("Actual result is : "+quantity);

        if (quantity.equals("1"))
        {
            test.pass("The quantity has been decreased");
        }
        else
        {
            test.fail("The quantity hasn't been decreased");

            TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("decreaseQuantity.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            test.addScreenCaptureFromPath("decreaseQuantity.png");
        }

        Assert.assertEquals(quantity,"1");
    }

    @Test
    public void addQuantity()
    {
        test=reports.createTest("Less quantity test case");
        PageFactory.initElements(driver, QuantityACartObjects.class);
        decreaseQuantity();
        validateQuantity();
        QuantityACartObjects.closeCartWindow.click();
    }
}
