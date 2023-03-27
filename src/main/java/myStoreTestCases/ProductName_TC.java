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

public class ProductName_TC extends CommonFunctions {

    String name;

    public void searchProduct()
    {
        test.info("Clicking the search bar");
        ProductDetailsObjects.searchBar.click();

        test.info("Entering a product name");
        driver.switchTo().activeElement().sendKeys("Blackstock Altitude Jacket - Hunting Jacket"+Keys.ENTER);

        test.info("Getting the product name");
        name=ProductDetailsObjects.productName.getText();

    }

    public void validateName()
    {
        test.info("Expected result is : Blackstock Altitude Jacket - Hunting Jacket");
        test.info("Actual result is : "+name);

        if (name.equals("Blackstock Altitude Jacket - Hunting Jacket"))
        {
            test.pass("The product name is displaying");
        }
        else {
            test.fail("The product name is not displaying");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("productName.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            try {
                test.addScreenCaptureFromPath("ProductName.png");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        Assert.assertEquals(name,"Blackstock Altitude Jacket - Hunting Jacket");
    }

    @Test
    public void productPrice()
    {
        test=reports.createTest("Product name test case");
        PageFactory.initElements(driver,ProductDetailsObjects.class);
        searchProduct();
        validateName();
        ProductDetailsObjects.homePage.click();
    }
}
