package MystoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryObjects {

    @FindBy(xpath = "//*[@id=\"ui-id-5\"]/span")
    public static WebElement booksAndVideosCategory;

    @FindBy(xpath = "//*[@id=\"ui-id-4\"]/span")
    public static WebElement beautyProductsCategory;

    @FindBy(xpath = "//*[@id=\"ui-id-1\"]/span")
    public static WebElement allProductsCategory;

    @FindBy(xpath = "//span[@class='base']")
    public static WebElement categorizedProducts;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/a/picture/img")
    public static WebElement homePage;

}
