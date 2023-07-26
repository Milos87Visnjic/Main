package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class Mail7Page {
    public Mail7Page() {
        PageFactory.initElements(Driver.get(), this);
    }

    Random random = new Random();
    int intRandom = random.nextInt(1000);
    public String userName = ConfigurationReader.get("userName").concat(String.valueOf(intRandom));

    public String digitalCode = "";
    @FindBy(css = "input[name='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[value='Go to inbox']")
    public WebElement goToInboxButton;

    @FindBy(xpath = "//b[contains(text(),'Avantage')]")
    public WebElement avantageVerificationMail;

    @FindBy(xpath = "//a[contains(text(),'Please')]")
    public WebElement clickLink;

    @FindBy(css = "button[class*='btn-primary ml-1 waves-effect waves-light']")
    public WebElement refreshButton;

    @FindBy(css = "input#deusername")
    public WebElement inboxInput;

    @FindBy(css = "input#popupusername")
    public WebElement popUpInput;

    @FindBy(xpath = "//iframe")
    public WebElement iframeInMail;
    @FindBy(xpath = "//button[text()='Inbox']")
    public WebElement popUpInboxButton;

    @FindBy(xpath = "//b[contains(text(),'Password')]")
    public WebElement forgotPasswordMail;

    @FindBy(xpath = "//p[contains(text(),'We have received')]")
    public WebElement digitalCodeMail;

    public void enterUserName() {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(usernameInput, 5);
        usernameInput.sendKeys(userName);
        System.out.println(userName);
    }

    public void clickGoToInboxButton() {
        BrowserUtils.waitForClickablility(goToInboxButton, 5);
        goToInboxButton.click();
    }

    public void clickAvantageVerificationEmail() {
        BrowserUtils.waitForClickablility(avantageVerificationMail, 5);
        avantageVerificationMail.click();
    }

    public void clickHyperLinkOfAvantage() {
        BrowserUtils.waitForPageToLoad(5);
        Driver.get().switchTo().frame(iframeInMail);
        BrowserUtils.waitFor(1);
        clickLink.click();
    }

    public void clickRefreshButton() {
        BrowserUtils.waitForClickablility(refreshButton, 5);
        refreshButton.click();
    }

    public void enterInboxInput() {
        BrowserUtils.waitForClickablility(inboxInput, 5);
        inboxInput.sendKeys(userName);

    }

    public void enterPopUpInput() {
        BrowserUtils.waitForClickablility(popUpInput, 5);
        popUpInput.sendKeys(userName);
        popUpInboxButton.click();
    }
    public void enterPopUpInput(String email) {
        BrowserUtils.waitForClickablility(popUpInput, 5);
        popUpInput.sendKeys(email);
        popUpInboxButton.click();
    }

    public void clickPasswordResetMail() {
        BrowserUtils.waitForClickablility(forgotPasswordMail, 5);
        forgotPasswordMail.click();
    }

    public String getDigitalCode() {
        BrowserUtils.waitForVisibility(iframeInMail, 15);
        Driver.get().switchTo().frame(iframeInMail);
        String code = digitalCodeMail.getText();
        System.out.println(code);
        digitalCode = code.split(": ")[1];
        return digitalCode;
    }


}
