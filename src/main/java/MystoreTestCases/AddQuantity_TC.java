package MystoreTestCases;

import MystoreTestObjects.QuantityACartObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AddQuantity_TC extends CommonFunctions {

    String quantity;

    public void increaseQuantity()
    {
        test.info("Opening the cart page");
        QuantityACartObjects.cartPage.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        test.info("Adding the quantity once");
        QuantityACartObjects.addQuantityButton.click();

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
        test.info("Expected result is : 2");
        test.info("Actual result is : "+quantity);

        if (quantity.equals("2"))
        {
            test.pass("The quantity has been increased");
        }
        else
        {
            test.fail("The quantity hasn't been increased");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("increaseQuantity.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("increaseQuantity.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        Assert.assertEquals(quantity,"2");
    }

    @Test
    public void addQuantity()
    {
        test=reports.createTest("Add quantity test case");
        PageFactory.initElements(driver, QuantityACartObjects.class);
        increaseQuantity();
        validateQuantity();
        QuantityACartObjects.closeCartWindow.click();
    }
}
