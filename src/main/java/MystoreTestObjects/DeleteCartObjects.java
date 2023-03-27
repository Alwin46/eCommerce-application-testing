package MystoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCartObjects {

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/div/div/ul/li[4]/span/span[1]")
    public static WebElement cartPage;

    @FindBy(xpath = "//*[@id=\"mini-cart\"]/li/div/div[1]/div[1]/div/div/a")
    public static WebElement deleteButton;

    @FindBy(xpath = "//a[@data-bind='attr: {href: product_url}, html: $parent.getProductNameUnsanitizedHtml(product_name)']")
    public static WebElement addCartProduct;

    @FindBy(xpath = "//*[@id=\"btn-minicart-close\"]")
    public static WebElement closeCartWindow;
}
