package myStoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuantityACartObjects {

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/div/div/ul/li[4]/span/span[1]")
    public static WebElement cartPage;

    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div[1]/div[2]/div[1]/a[2]")
    public static WebElement addQuantityButton;

    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div[1]/div[2]/div[1]/a[1]")
    public static WebElement lessQuantityButton;

    @FindBy(xpath = "//ul[@class='header links']//li[4]//ol//li[1]//input[@class='item-qty cart-item-qty']")
    public static WebElement quantityValue;

    @FindBy(xpath = "//*[@id=\"btn-minicart-close\"]")
    public static WebElement closeCartWindow;
}
