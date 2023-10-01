package myStoreTestCases;

import myStoreTestObjects.CartObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AddCart_TC extends CommonFunctions {

    String product;

    public void addProductToCart()
    {
        test.info("Clicking the search bar");
        CartObjects.searchBar.click();

        test.info("Entering a product name");
        driver.switchTo().activeElement().sendKeys("EyeProtect19"+Keys.ENTER);

        CartObjects.closeMessage1.click();

        test.info("Clicking the add to cart button");
        CartObjects.addToCartButton.click();

        CartObjects.closeMessage2.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        test.info("Checking the product in cart");
        product= CartObjects.CartProduct.getText();
    }

    public void validateAddToCart()
    {
        test.info("Expected result is : EyeProtect19");
        test.info("Actual result is : "+product);

        if (product.equals("EyeProtect19"))
        {
            test.pass("The product has been added to the cart");
        }
        else
        {
            test.fail("The product hasn't been added to the cart");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("addToCart.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            test.addScreenCaptureFromPath("addToCart.png");
        }
        Assert.assertEquals(product,"EyeProtect19");
    }

    @Test
    public void addToCart()
    {
        test=reports.createTest("Add cart test case");
        PageFactory.initElements(driver,CartObjects.class);
        addProductToCart();
        validateAddToCart();
        CartObjects.closeCartWindow.click();
        CartObjects.homePage.click();
    }
}
