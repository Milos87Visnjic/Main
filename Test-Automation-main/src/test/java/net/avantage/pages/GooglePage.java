package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    public GooglePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "a[href*='/?tab=rm&ogbl']")
    public WebElement gmailButton;

    @FindBy(css = "input[type='email']")
    public WebElement emailGoogle;

    @FindBy(css = "input[type='password']")
    public WebElement passwordGoogle;

    @FindBy(css = "div#identifierNext")
    public WebElement nextButtonUserName;

    @FindBy(css = "div#passwordNext")
    public WebElement passwordNextButton;

    @FindBy(xpath = "(//table//tbody/tr[1]/td[5])[2]")
    public WebElement confirmMail;

    @FindBy(xpath = "(//iframe[@tabindex='-1'])[1]")
    public WebElement iframe;

    public WebElement confirmLink(String email) {
        String css = "a[href*='qatestester1002@gmail.com']";
        return Driver.get().findElement(By.cssSelector(css));
    }

    public void enterEmail(String email) {
        BrowserUtils.waitForClickablility(emailGoogle, 5);
        emailGoogle.sendKeys(email);
        nextButtonUserName.click();
        BrowserUtils.waitFor(3);
    }

    public void enterPassword(String password) {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(4);
        BrowserUtils.waitForVisibility(passwordGoogle, 5);
        passwordGoogle.sendKeys(password);
        passwordNextButton.click();
        BrowserUtils.waitFor(1);
    }

    public void confirmEmail(String email) {
        BrowserUtils.waitForPageToLoad(5);
        Driver.get().switchTo().frame(iframe);
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(confirmMail);
        confirmLink(email).click();
    }


}
