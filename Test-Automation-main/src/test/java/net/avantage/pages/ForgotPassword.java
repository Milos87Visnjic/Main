package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ForgotPassword extends LoginPage {

    @FindBy(xpath = "//p[contains(text(),'Forgot')]")
    public WebElement forgotPasswordButton;

    @FindBy(css = "input[name='email']")
    public WebElement emailInputForgotPasswordMenu;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButtonForgotPassword;

    @FindBy(css = "button[type='submit']")
    public WebElement okButtonForgotPassword;

    @FindBy(css = "img[alt='image']")
    public WebElement acceptedImage;

    @FindBy(xpath = "//h1")
    public WebElement youAreAllSet;
    @FindBy(css = "input[inputmode='numeric']")
    public List<WebElement> digitCodes;

    @FindBy(css = "input[name='password']")
    public WebElement passwordInput;

    @FindBy(css = "input[name='confirmPassword']")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//p[contains(text(),'To continue')]")
    public WebElement toContinueMessage;

    /**
     * This method enables to click forgot password Button
     */
    public void clickForgotPassword() {
        BrowserUtils.waitForClickablility(forgotPasswordButton, 5);
        forgotPasswordButton.click();
    }

    /**
     * This method enables to click email Button
     * @param email
     */
    public void enterEmailInForgotPassword(String email) {
        BrowserUtils.waitForVisibility(emailInputForgotPasswordMenu, 5);
        emailInputForgotPasswordMenu.sendKeys(email);
        submitButtonForgotPassword.click();
    }

    /**
     * This method enables to enter digital codes
     * @param code
     */
    public void enterDigitalCode(String code) {
        BrowserUtils.waitForClickablilityListOfElements(digitCodes, 5);
        for (int i = 0; i <= 5; i++) {
            digitCodes.get(i).sendKeys(code.charAt(i) + "");
        }
        System.out.println(code);
    }

    /**
     * This method enables to enter password
     */
    public void enterPassword() {
        BrowserUtils.waitForVisibility(passwordInput, 5);
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        confirmPasswordInput.sendKeys(ConfigurationReader.get("password"));
        submitButtonForgotPassword.click();
        BrowserUtils.waitForVisibility(acceptedImage,5);
        Assert.assertTrue(acceptedImage.isDisplayed());
        Assert.assertEquals(youAreAllSet.getText(),"You’re all set");
        okButtonForgotPassword.click();
    }
}
