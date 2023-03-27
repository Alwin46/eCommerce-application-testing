package myStoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBarobjects {

    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[1]/label")
    public static WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div/div/div[1]/div[2]/h1/span")
    public static WebElement searchResult;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/a/picture/img")
    public static WebElement homePage;

}
