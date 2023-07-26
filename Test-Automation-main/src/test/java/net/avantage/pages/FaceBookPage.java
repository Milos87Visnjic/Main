package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage {

    @FindBy(css = "input[name='email']")
    public WebElement emailFB;

    @FindBy(css = "input[type='password']")
    public WebElement passwordFB;

    @FindBy(css = "button[id='loginbutton']")
    public WebElement loginButtonFB;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    public WebElement continueAsButtonFB;

    /**
     * This method enables to login to FB
     * @param email
     * @param password
     */
    public void loginToFB(String email, String password) {
        BrowserUtils.waitForClickablility(emailFB, 5);
        emailFB.sendKeys(email);
        passwordFB.sendKeys(password);
        loginButtonFB.click();
    }

    /**
     * This method enables to click continue as Button
     */
    public void clickOnContinueAsButton(){
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(continueAsButtonFB,5);
        continueAsButtonFB.click();
    }

    public FaceBookPage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
