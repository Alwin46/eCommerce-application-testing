package myStoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsObjects {

    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[1]/label")
    public static WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"description\"]/div/div/div[2]/div/div/div/p[2]")
    public static WebElement productDescription;

    @FindBy(xpath = "//*[@id=\"product-price-7560\"]/span")
    public static WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div/div/div[1]/div[2]/h1/span")
    public static WebElement productName;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/a/picture/img")
    public static WebElement homePage;

}
