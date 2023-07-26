package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//span[text()='Log In']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Join']/parent::button")
    public WebElement joinButton;
    @FindBy(xpath = "//span[contains(text(), 'Email')]")
    public WebElement emailButton;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(css = "input[name='confirmPassword']")
    public WebElement confirmPasswordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//form[@id='logInForm']//input[@name='password']")
    public WebElement passwordBoxFeedback;

    @FindBy(xpath = "//input[@type='checkbox'][@name='acknowledged']")
    public WebElement termsAndConditionsCheckBox;

    @FindBy(xpath = "//form//input[@name='email']/parent::div/following-sibling::p")
    public WebElement popupMessageForEmail;

    @FindBy(xpath = "//form//input[@name='password']/parent::div/following-sibling::p")
    public WebElement requiredMessageForPassword;

    @FindBy(xpath = "//p[text()='Show']")
    public WebElement showButton;

    @FindBy(xpath = "//span[contains(text(),'Facebook')]/parent::button")
    public WebElement continueWithFaceBook;

    @FindBy(xpath = "//span[contains(text(),'Google')]/parent::button")
    public WebElement continueWithGoogle;

    @FindBy(xpath = "//h1")
    public WebElement verifyEmailSent;

    @FindBy(xpath = "//h2[text()='Account Exists']")
    public WebElement accountExistMessage;


    /**
     * provides entering email and password, and then submit.
     *
     * @param email for
     */
    public void logIn(String email) {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(loginButton, 10);
        loginButton.click();
        emailButton.click();
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        submitButton.click();
    }

    /**
     * This method enables to verify avatar or initials
     */
    public void verifyAvatarOrAvatarInitials() {
        try {
            Assert.assertTrue(avatar.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(avatarInitials.isDisplayed());
        }
    }

    /**
     * This method enables to verify avatar or initials
     * @param avtr
     */
    public void verifyAvatarOrAvatarInitials(String avtr) {
        if (avtr == "avatar") {
            Assert.assertTrue(avatar.isDisplayed());
        } else if (avtr == "initials") {
            Assert.assertTrue(avatarInitials.isDisplayed());
        }
    }
    /**
     * This method enables to join with email and password
     * @param email
     * @param password
     */
    public void join(String email,String password) {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(1);
        joinButton.click();
        emailButton.click();
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        confirmPasswordBox.sendKeys(password);
        submitButton.click();
    }

    /**
     * This method enables to enter password to confirm
     */
    public void enterPasswordToConfirm() {
        BrowserUtils.switchToWindow("Play Avantage Baccarat");
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForVisibility(passwordBoxFeedback, 5);
        passwordBoxFeedback.sendKeys(ConfigurationReader.get("password"));
        submitButton.click();
    }

    /**
     * This method enables to select checkbox of Terms and Conditions
     */
    public void selectCheckBoxOfTermsAndConditions() {
        BrowserUtils.waitForPageToLoad(5);
        termsAndConditionsCheckBox.click();
        submitButton.click();
    }

    /**
     * This method enables to login with parameters
     * @param userName
     * @param passWord
     */
    public void loginWithParameters(String userName, String passWord) {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(loginButton, 5);
        loginButton.click();
        emailButton.click();
        emailInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(passWord);
        submitButton.click();
    }

    /**
     * This method enables to verify PopUp Message
     * @param email
     * @param password
     * @param message
     * @param promptMessage
     */
    public void verifyPopUpMessage(String email, String password, String message, String promptMessage) {
        if (email.isEmpty()) {
            Assert.assertEquals(popupMessageForEmail.getText(), message);
        } else if (password.isEmpty()) {
            Assert.assertEquals(requiredMessageForPassword.getText(), message);
        } else {
            Assert.assertEquals(popupMessageForEmail.getText(), message);
            emailInputBox.sendKeys(Keys.ENTER);
            System.out.println(emailInputBox.getAttribute("validationMessage"));
            Assert.assertEquals(emailInputBox.getAttribute("validationMessage"), promptMessage);
        }
    }

    /**
     * This method enables to click Join Button
     */
    public void clickOnJoinButton(){
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(joinButton,5);
        joinButton.click();
    }

    /**
     * This method enables to click Login Button
     */
    public void clickOnLogInButton(){
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(loginButton,5);
        loginButton.click();
    }

    /**
     * This method enables to click email Button
     */
    public void clickOnEmailButton(){
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(loginButton, 10);
        emailButton.click();
    }

    /**
     * This method enables to verify initials
     */
    public void verifyInitials(){
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(avatarInitials,5);
        Assert.assertTrue(avatarInitials.isDisplayed());
    }

    /**
     * This method enables to click FB Button
     */
    public void clickOnFaceBookButton(){
        BrowserUtils.waitForClickablility(continueWithFaceBook,5);
        continueWithFaceBook.click();
    }

    /**
     * This method enables to click Google Button
     */
    public void clickOnGoogleButton(){
        BrowserUtils.waitForClickablility(continueWithGoogle,5);
        continueWithGoogle.click();
    }

    /**
     * This method enables to validate that verification mail is sent
     */
    public void validateVerificationMailSent(){
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForVisibility(verifyEmailSent,5);
        Assert.assertTrue(verifyEmailSent.isDisplayed());
        System.out.println(verifyEmailSent.getText());
    }

}
