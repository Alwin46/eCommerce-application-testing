package MystoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutObjects {

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/div/div/ul/li[2]/span/button")
    public static WebElement accountButton;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/div/div/ul/li[2]/div/ul/li[2]/a/span")
    public static WebElement signOutButton;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/div/div/ul/li[2]/a/div/p")
    public static WebElement accountStatus;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/a/picture/img")
    public static WebElement homePage;
}
