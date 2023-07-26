package net.avantage.pages;

import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(css = "button#onetrust-accept-btn-handler")
    public WebElement acceptAllCookies;

    @FindBy(xpath = "//span[text()='Yes']")
    public WebElement yesButton;

    @FindBy(xpath = "//button[contains(@class,'account')]//img")
    public WebElement avatar;

    @FindBy(xpath = "(//button[contains(@class,'account')]//div)[1]")
    public WebElement avatarInitials;

    @FindBy(xpath = "//button[@aria-label='open drawer']")
    public WebElement hamburgerMenu;

    @FindBy(xpath = "//div[@class='casino-jss68 casino-jss70 casino-jss27 casino-jss69']")
    public WebElement obscureElement;

    @FindBy(css = "div[class='casino-jss24']")
    public WebElement obscureElementIrs;

    @FindBy(css="div[class='casino-jss68 casino-jss70 casino-jss27 casino-jss69']")
    public WebElement obscureElementIrs2;

    @FindBy(css = "header[class='casino-jss40 casino-jss29 casino-jss30 casino-jss36 casino-jss22 mui-fixed casino-jss47']")
    public WebElement obscureElementIrs3;

    /**
     * provides accepting all cookies
     */
    public void acceptCookies() {
        BrowserUtils.waitForVisibility(acceptAllCookies, 60);
        acceptAllCookies.click();
        BrowserUtils.waitForPageToLoad(2);
    }

    /**
     * provides accepting +18 age question.
     */
    public void acceptAge() {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitForClickablility(yesButton, 5);
        BrowserUtils.clickWithJS(yesButton);
        BrowserUtils.waitFor(1);
    }

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}