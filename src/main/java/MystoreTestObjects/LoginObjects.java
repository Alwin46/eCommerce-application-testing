package MystoreTestObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjects {

    @FindBy(xpath = "//*[@id=\"ltkpopup-text-btn\"]/button")
    public static WebElement specialOffersPopup;

    @FindBy(xpath = "//*[@id=\"html-body\"]/div[2]/header/div[1]/div/div/ul/li[2]/a/div/p")
    public static WebElement signUp;

    @FindBy(xpath = "//input[@name='login[username]']")
    public static WebElement email;

    @FindBy(xpath = "//input[@name='login[password]']")
    public static WebElement password;

    @FindBy(xpath = "//*[@id=\"send2\"]/span")
    public static WebElement loginButton;

}
