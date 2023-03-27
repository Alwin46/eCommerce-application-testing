package MystoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortByObjects {

    @FindBy(xpath = "//*[@id=\"ui-id-17\"]/span")
    public static WebElement sportsCategory;

    @FindBy(xpath = "//select[@id='sorter']")
    public static WebElement sort;

    @FindBy(xpath = "//div[@data-product-id='7395']//span[@class='normal-price']//span[@class='price']")
    public static WebElement lowToHigh;

    @FindBy(xpath = "//div[@data-product-id='3599']//span[@class='normal-price']//span[@class='price']")
    public static WebElement highToLow;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/a/picture/img")
    public static WebElement homePage;
}
