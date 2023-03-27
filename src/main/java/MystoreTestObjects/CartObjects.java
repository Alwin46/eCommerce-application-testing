package MystoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartObjects {

    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[1]/label")
    public static WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[1]/div[2]/div/div/div[2]")
    public static WebElement closeMessage1;

    @FindBy(xpath = "//*[@id=\"product-addtocart-button\"]")
    public static WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[1]/div[2]/div[2]/div/div[2]")
    public static WebElement closeMessage2;

    @FindBy(xpath = "//a[@data-bind='attr: {href: product_url}, html: $parent.getProductNameUnsanitizedHtml(product_name)']")
    public static WebElement CartProduct;

    @FindBy(xpath = "//*[@id=\"btn-minicart-close\"]")
    public static WebElement closeCartWindow;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/a/picture/img")
    public static WebElement homePage;
}
