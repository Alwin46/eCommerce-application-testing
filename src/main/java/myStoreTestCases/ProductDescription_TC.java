package myStoreTestCases;

import myStoreTestObjects.ProductDetailsObjects;
import commonActions.CommonFunctions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ProductDescription_TC extends CommonFunctions {

    String Description;

    public void searchProduct()
    {
        test.info("Clicking the search bar");
        ProductDetailsObjects.searchBar.click();

        test.info("Entering a product name");
        driver.switchTo().activeElement().sendKeys("Blackstock Altitude Jacket - Hunting Jacket"+Keys.ENTER);

        test.info("Getting the product description");
        Description=ProductDetailsObjects.productDescription.getText();
    }

    public void validateProductDetails()
    {
        test.info("Expected result is : The product description should be in the product page");

        if (Description.contains("This Hybrid 3 Layer Laminate Waterproof Breathable Softshell jacket is Waterproof"))
        {
            test.info("Actual result is : The product description are in the product page");
            test.pass("The product description is displaying");
        }
        else
        {
            test.fail("The product description is not displaying");

            TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
            File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File("productDescription.png");
            try {
                FileHandler.copy(screenShot,file);
            } catch (IOException e)
            {
                System.out.println(e.getMessage());
            }

            test.addScreenCaptureFromPath("productDescription.png");

        }
    }

    @Test
    public void productDetails()
    {
        test=reports.createTest("Product description test case");
        PageFactory.initElements(driver, ProductDetailsObjects.class);
        searchProduct();
        validateProductDetails();
        ProductDetailsObjects.homePage.click();
    }
}
