package myStoreTestCases;

import myStoreTestObjects.ProductDetailsObjects;
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

public class ProductPrice_TC extends CommonFunctions {

    String price;

    public void searchProduct()
    {
        test.info("Clicking the search bar");
        ProductDetailsObjects.searchBar.click();

        test.info("Entering a product name");
        driver.switchTo().activeElement().sendKeys("Blackstock Altitude Jacket - Hunting Jacket"+ Keys.ENTER);

        test.info("Getting the product price");
        price=ProductDetailsObjects.productPrice.getText();

    }

    public void validatePrice()
    {
        test.info("Expected result is : $349.99");
        test.info("Actual result is : "+price);

        if (price.equals("$349.99"))
        {
            test.pass("The product price is displaying");
        }
        else {
            test.fail("The product price is not displaying");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("productPrice.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            test.addScreenCaptureFromPath("productPrice.png");
        }
        Assert.assertEquals(price,"$349.99");
    }

    @Test
    public void productPrice()
    {
        test=reports.createTest("Product price test case");
        PageFactory.initElements(driver, ProductDetailsObjects.class);
        searchProduct();
        validatePrice();
        ProductDetailsObjects.homePage.click();
    }
}
