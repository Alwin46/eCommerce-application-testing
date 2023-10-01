package myStoreTestCases;

import myStoreTestObjects.DeleteCartObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DeleteCart_TC extends CommonFunctions {

    String product;

    public void deleteCartProduct()
    {
        test.info("Opening the cart page");
        DeleteCartObjects.cartPage.click();

        test.info("Clicking the product delete button");
        DeleteCartObjects.deleteButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void validateDelete()
    {

        try {
            test.info("Checking the product in cart");
            test.info("Expected result is : null");

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            product= DeleteCartObjects.addCartProduct.getText();
            test.info("Actual result is :"+product);

            test.fail("The product hasn't been deleted from cart");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("deleteAddToCart.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            test.addScreenCaptureFromPath("deleteAddToCart.png");
        }
        catch (NoSuchElementException e)
        {
            test.info("Actual result is :"+product);
            test.pass("The product has been deleted from cart");
            Assert.assertNull(product);
        }
    }

    @Test
    public void deleteCart()
    {
        test=reports.createTest("Delete cart product test case");
        PageFactory.initElements(driver, DeleteCartObjects.class);
        deleteCartProduct();
        validateDelete();
        DeleteCartObjects.closeCartWindow.click();
    }
}
