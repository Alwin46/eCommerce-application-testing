package MystoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterObjects {

    @FindBy(xpath = "//*[@id=\"ui-id-6\"]/span")
    public static WebElement clothesCategory;

    @FindBy(xpath = "//*[@id=\"sizeFilter_option_1\"]")
    public static WebElement smallSize;

    @FindBy(xpath = "//*[@id=\"modal-content-3\"]/div/div[1]/ol/li/span[2]")
    public static WebElement sizeFiltered;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[2]/div[2]/div/div/a[2]/div")
    public static WebElement genderWomen;

    @FindBy(xpath = "//span[@class='filter-value']")
    public static WebElement genderFiltered;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[1]/div[2]/div/div[3]/a[1]")
    public static WebElement price;

    @FindBy(xpath = "//*[@id=\"modal-content-3\"]/div/div[1]/ol/li/span[2]")
    public static WebElement priceFiltered;

    @FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[1]/div[2]/div/div[4]/div[2]/a/span")
    public static WebElement okButton;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/a/picture/img")
    public static WebElement homePage;



}
