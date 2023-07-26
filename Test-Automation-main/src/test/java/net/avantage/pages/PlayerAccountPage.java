package net.avantage.pages;

import com.github.javafaker.Faker;
import net.avantage.utils.BrowserUtils;
import net.avantage.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class PlayerAccountPage extends LoginPage {

    @FindBy(xpath = "//button[@id='accountDropdownTab-tab-Player Account']")
    public WebElement playerAccountButton;

    @FindBy(xpath = "//span[@id='accountDropdownTab-tabpanel-Player Account']//h1")
    public WebElement playerName;

    @FindBy(xpath = "//a//p[text()='Player Profile']")
    public WebElement playerProfile;

    @FindBy(xpath = "//div//p[text()='Name']")
    public WebElement name;

    @FindBy(xpath = "//p[text()='Name']/following-sibling::p")
    public WebElement playerNameInPlayerProfile;

    @FindBy(xpath = "//p[text()='Log Out']")
    public WebElement logOutButton;

    @FindBy(xpath = "//p[text()='Settings']")
    public WebElement settingsButton;

    @FindBy(xpath = "//p[text()='Contact Us']")
    public WebElement contactUsButton;

    @FindBy(css = "img[alt='Feedback']")
    public WebElement feedbackButton;

    @FindBy(xpath = "(//div[@data-testid='edit-icon'])[1]")
    public WebElement pencilIconAvatar;

    @FindBy(xpath = "//span[text()='Choose Avatar']")
    public WebElement chooseAvatarButton;

    @FindBy(css = "img[src*='provided']")
    public List<WebElement> avatarsList;

    @FindBy(css = "button[type='submit']")
    public WebElement saveButton;

    @FindBy(css = "svg[data-testid='close-icon']")
    public WebElement closeIcon;

    @FindBy(xpath = "//p[text()='Edit Communications']")
    public WebElement editCommunicationButton;

    @FindBy(xpath = "//p//a[contains(text(),'Privacy Policy')]")
    public WebElement privacyPolicyInEditComm;

    @FindBy(css = "svg[data-testid='fiber_icon']")
    public List<WebElement> notificationsDots;

    @FindBy(xpath = "//h5/ancestor::span[contains(@id,'accountDropdown')]//p[1]")
    public List<WebElement>notificationsList;

    @FindBy(css = "button#accountDropdownTab-tab-Notifications")
    public WebElement notificationsButton;

    @FindBy(css = "input[name='marketingNotificationsAccepted']")
    public WebElement futureContestsCheckBox;

    @FindBy(css = "input[name='phoneNumber']")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='phoneNumber']/parent::div/following-sibling::p")
    public WebElement validPhoneNumberMessage;

    @FindBy(name = "notificationEmail")
    public WebElement notificationEmailBox;

    @FindBy(xpath = "//input[@name='notificationEmail']/parent::div/following-sibling::p")
    public WebElement invalidEmailMessage;

    @FindBy(name = "isMarketingNotificationsEmailActive")
    public WebElement emailCheckBox;

    @FindBy(name = "isMarketingNotificationsTextActive")
    public WebElement textCheckBox;

    @FindBy(css = "iframe[id*='us–style-manager-1widgetIframe']")
    public WebElement iframeContactUs;

    @FindBy(css = "h1[aria-live='polite']")
    public WebElement whatAreYouLookingFor;

    @FindBy(css = "input#request")
    public WebElement titleInputBox;

    @FindBy(css = "div#comment")
    public WebElement descriptionInputBox;

    @FindBy(css = "input#visitor")
    public WebElement emailInputBox;

    @FindBy(xpath = "//span[text()='Submit']")
    public WebElement submitButton;

    @FindBy(css = "label[class*='container']")
    public List<WebElement> rateNumbers;

    @FindBy(css = "div[role='textbox']")
    public WebElement pleaseTellUs;

    @FindBy(css = "svg[class*='dropdown']")
    public WebElement dropDownArrow;

    @FindBy(css = "li[id*='downshift']")
    public List<WebElement> downShiftItems;

    @FindBy(xpath = "(//div[contains(@class,'errorMessages')])[1]")
    public WebElement errorMessage;

    @FindBy(xpath = "//h2[contains(text(),'Cannot')]")
    public WebElement accountCannotBeCreatedMessage;

    @FindBy(xpath = "//div[text()='Notifications']/following-sibling::div/div")
    public List<WebElement> notificationsNumbers;

    @FindBy(xpath = "//button[contains(text(),'Mark')]")
    public WebElement markAllAssRead;

    public WebElement selectContactUsMenu(String item) {
        String xpath = "//span[text()='" + item + "']";
        return Driver.get().findElement(By.xpath(xpath));
    }

    /**
     * This method enables to click avatar or userInitials
     */
    public void clickAvatar() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForPageToLoad(5);
        try {
            avatar.click();
        } catch (Exception e) {
            avatarInitials.click();
            e.printStackTrace();
        }
    }

    /**
     * This method enables to click Initials
     */
    public void clickOnInitials() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForPageToLoad(5);
        avatarInitials.click();
    }

    /**
     * This method enables to click Player Account Button
     */
    public void clickPlayerAccountButton() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(playerAccountButton, 5);
        playerAccountButton.click();
    }

    /**
     * This method enables to click Player Profile Button
     */
    public void clickPlayerProfile() {
        BrowserUtils.waitForClickablility(playerProfile, 5);
        playerProfile.click();
    }

    /**
     * This method enables to click Logout Button
     */
    public void clickOnLogOutButton() {
        BrowserUtils.waitForClickablility(logOutButton, 5);
        logOutButton.click();
    }

    /**
     * This method enables to verify login button
     */
    public void verifyLogInButton() {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(1);
        Assert.assertTrue(loginButton.isDisplayed());
    }

    /**
     * This method enables to click Edit Icon Button
     */
    public void clickEditIconAvatar() {
        BrowserUtils.waitForClickablility(pencilIconAvatar, 5);
        pencilIconAvatar.click();
    }

    /**
     * This method enables to click Choose Avatar Button
     */
    public void clickChooseAvatarButton() {
        BrowserUtils.waitForClickablility(chooseAvatarButton, 5);
        chooseAvatarButton.click();
    }

    /**
     * This method enables to select avatar randomly and return it
     * @return
     */
    public String selectAvatar() {
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.waitFor(2);
        Random random = new Random();
        int intRandom = random.nextInt(avatarsList.size() - 1);
        avatarsList.get(intRandom).click();
        BrowserUtils.waitForClickablility(saveButton, 5);
        String avatar = avatarsList.get(intRandom).getAttribute("src");
        saveButton.click();
        return avatar;
    }

    /**
     * This method enables to click close Icon
     */
    public void clickCloseIcon() {
        BrowserUtils.waitForClickablility(closeIcon, 5);
        BrowserUtils.waitFor(2);
        closeIcon.click();
    }

    /**
     * This method enables to click settings button
     */
    public void clickSettingsButton() {
        BrowserUtils.waitForClickablility(settingsButton, 5);
        settingsButton.click();
    }

    /**
     * This method enables to click Edit Comm Button
     */
    public void clickEditCommButton() {
        BrowserUtils.waitForClickablility(editCommunicationButton, 5);
        editCommunicationButton.click();
    }

    /**
     * This method enables to click Privacy Policy Button In Edit Comm
     */
    public void clickPrivacyPolicyButtonInEditComm() {
        BrowserUtils.waitForClickablility(privacyPolicyInEditComm, 5);
        BrowserUtils.waitFor(1);
        privacyPolicyInEditComm.click();
    }

    /**
     * This method enables to click Privacy Policy Button
     */
    public void verifyPrivacyPolicy() {
        Driver.get().getWindowHandles().forEach(tab -> Driver.get().switchTo().window(tab));
        BrowserUtils.waitFor(1);
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("Privacy_Policy_Freemium"));
    }

    /**
     * This method enables to click Notifications Button
     */
    public void clickNotificationsButton() {
        BrowserUtils.waitForClickablility(notificationsButton, 5);
        notificationsButton.click();
    }



    /**
     * This method enables to select check box in Edit Comm
     */
    public void selectCheckBoxEditComm() {
        BrowserUtils.waitFor(1);
        if (!futureContestsCheckBox.isSelected()) {
            futureContestsCheckBox.click();
        }
        if (!emailCheckBox.isSelected()) {
            emailCheckBox.click();
        }
        if (!textCheckBox.isSelected()) {
            textCheckBox.click();
        }
    }

    /**
     * This method enables to validate phone number and email in edit comm
     */
    public void validatePhoneNumberAndEmailInput() {
        BrowserUtils.waitForClickablility(phoneNumberInput, 5);
        Faker faker = new Faker();
        Random random = new Random();
        int[] operators = {505, 506, 507, 530, 531, 532, 533, 534, 535, 536, 537, 541, 542, 543, 544, 545, 546};
        int opRand = random.nextInt(16);
        String number = "" + operators[opRand] + faker.number().numberBetween(0, 10000000L);
        System.out.println("+90" + number);
        String incompleteNumber = number.substring(0, 4);
        int intRand = random.nextInt(10);
        String addNumber = number + intRand;
        String email = "testerQAtester101@gmail.com";
        String[] inputNumber = {" ", incompleteNumber, addNumber, number};
        String[] inputEmail = {"  ", "name", "name@@", email};

        for (int i = 0; i <= 3; i++) {
            phoneNumberInput.clear();
            phoneNumberInput.sendKeys(inputNumber[i]);
            phoneNumberInput.sendKeys(Keys.ENTER);
            notificationEmailBox.clear();
            notificationEmailBox.sendKeys(inputEmail[i]);
            notificationEmailBox.sendKeys(Keys.ENTER);
            if (i != 3) {
                Assert.assertTrue(validPhoneNumberMessage.isDisplayed());
                Assert.assertTrue(invalidEmailMessage.isDisplayed());
            }
            BrowserUtils.waitFor(1);
        }
        BrowserUtils.waitFor(1);
        editCommunicationButton.click();
        Assert.assertEquals(phoneNumberInput.getAttribute("value"), "+90" + number);
        Assert.assertEquals(notificationEmailBox.getAttribute("value"), email);
    }

    /**
     * This method enables to click Contact Us Button
     */
    public void clickOnContactUsButton() {
        BrowserUtils.waitForClickablility(contactUsButton, 5);
        contactUsButton.click();
    }

    /**
     * This method enables to verify "What are you looking for" message
     */
    public void verifyWhatAreYouLookingFor() {
        Driver.get().switchTo().frame(iframeContactUs);
        BrowserUtils.waitForVisibility(whatAreYouLookingFor, 5);
        System.out.println(whatAreYouLookingFor.getText());
    }

    /**
     * This method enables to validate Contact Us menu
     */
    public void validateContactUsMenu() {
        String[] menus = {"Account/My Contests", "Technical Support", "Other", "Rate Us"};
        String[] title = {"     ", "Question", "Tech Question", "other"};
        String[] messages = {"I like", "I don't like", "I like", "perfect"};
        for (int i = 0; i <= 3; i++) {
            BrowserUtils.waitFor(2);
            BrowserUtils.waitForClickablility(feedbackButton, 5);
            feedbackButton.click();
            verifyWhatAreYouLookingFor();
            BrowserUtils.waitForClickablility(selectContactUsMenu(menus[i]), 5);
            selectContactUsMenu(menus[i]).click();
            Driver.get().switchTo().frame(iframeContactUs);

            if ((i == 0) || (i == 2)) {
                for (int j = 0; j < 1; j++) {
                    BrowserUtils.waitForClickablility(titleInputBox, 5);
                    titleInputBox.sendKeys(title[j]);
                    BrowserUtils.waitForVisibility(errorMessage, 5);
                    Assert.assertTrue(errorMessage.isDisplayed());
                    titleInputBox.clear();
                    titleInputBox.sendKeys(title[j + 1]);
                    descriptionInputBox.sendKeys(messages[i]);
                    submitButton.click();
                }
            } else if (i == 1) {
                validateTechnicalSupport(title[i]);
            }
            if (i == 3) {
                validateRateUs(messages[i]);
            }
        }
    }

    /**
     * This method enables to validate rate us menu
     * @param description
     */
    public void validateRateUs(String description) {
        Random random = new Random();
        int intRandom = random.nextInt(10);
        rateNumbers.get(intRandom).click();
        descriptionInputBox.sendKeys(description);
        submitButton.click();
    }

    /**
     * This method enables to validate technical support menu
     * @param title
     */
    public void validateTechnicalSupport(String title) {
        BrowserUtils.waitForClickablility(pleaseTellUs, 5);
        pleaseTellUs.sendKeys(title);
        BrowserUtils.waitFor(1);
        Random random = new Random();
        int intRandom = random.nextInt(4);
        dropDownArrow.click();
        downShiftItems.get(intRandom).click();
        BrowserUtils.waitFor(1);
        submitButton.click();
    }

    public void validateNotifications(){
        if(notificationsNumbers.size()>0) {
            BrowserUtils.waitForVisibility(notificationsButton, 5);
            System.out.println("There are : " + notificationsNumbers.size() + " notifications");
            int preNumber = notificationsList.size();
            notificationsList.get(0).click();
            BrowserUtils.waitFor(1);
            System.out.println(notificationsDots.size());
            Assert.assertTrue(notificationsDots.size() < preNumber);
            Driver.get().navigate().refresh();
            BrowserUtils.waitForClickablility(avatar, 5);
            avatar.click();
            int postNumber = notificationsDots.size();
            Assert.assertTrue(preNumber > postNumber);
            markAllAssRead.click();
            Driver.get().navigate().refresh();
            BrowserUtils.waitForClickablility(avatar, 5);
            avatar.click();
            System.out.println("There are : " + notificationsNumbers.size() + " notifications");
            Assert.assertTrue(notificationsNumbers.size() < 1);
        }
    }
}
