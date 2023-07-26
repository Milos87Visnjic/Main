package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.*;
import net.avantage.utils.BrowserUtils;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    FaceBookPage faceBookPage = new FaceBookPage();
    GooglePage googlePage = new GooglePage();
    Mail7Page mail7Page = new Mail7Page();

    PlayerAccountPage playerAccountPage=new PlayerAccountPage();

    ForgotPassword forgotPassword=new ForgotPassword();
    String email = ConfigurationReader.get("email");

    String url="";

    String code="";

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url_UI"));
    }

    @And("User accepts all cookies")
    public void userAcceptsAllCookies() {
        loginPage.acceptCookies();
    }

    @And("User accepts age question")
    public void userAcceptsAgeQuestion() {
        loginPage.acceptAge();
    }

    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPage.logIn(email);
    }

    @Then("the user views that avatar is visible")
    public void theUserViewsThatAvatarIsVisible() {
        BrowserUtils.waitForVisibility(loginPage.avatar, 15);
        loginPage.verifyAvatarOrAvatarInitials();
    }

    @And("User enters password in Avantage GamePortal")
    public void userEntersPasswordInAvantageGamePortal() {
        loginPage.enterPasswordToConfirm();
    }

    @And("User accepts termsAndConditions")
    public void userAcceptsTermsAndConditions() {
        loginPage.selectCheckBoxOfTermsAndConditions();
    }


    @When("User Log in {string} and {string}")
    public void userLogInAnd(String userName, String password) {
        loginPage.loginWithParameters(userName, password);
    }

    @Then("User verifies that {string} is visible")
    public void userVerifiesThatIsVisible(String avatar) {
        loginPage.verifyAvatarOrAvatarInitials(avatar);
    }

    @When("User tries to log in {string} and {string}")
    public void userTriesToLogInAnd(String email, String password) {
        loginPage.loginWithParameters(email, password);
    }

    @And("User verifies that LogIn button is not clicked")
    public void userVerifiesThatLogInButtonIsNotClicked() {
        Assert.assertEquals(loginPage.submitButton.getAttribute("aria-disabled"), "false");
    }

    @Then("According to {string} and {string} condition User verifies the popup {string}and {string}")
    public void accordingToAndConditionUserVerifiesThePopupAnd(String email, String password, String message, String promptMessage) {
        loginPage.verifyPopUpMessage(email, password, message, promptMessage);
    }

    @And("User clicks on join button")
    public void userClicksOnJoinButton() {
        loginPage.clickOnJoinButton();
    }

    @And("User clicks on FB button")
    public void userClicksOnFBButton() {
        loginPage.clickOnFaceBookButton();
    }

    @And("User login FB with {string} and {string}")
    public void userLoginFBWithAnd(String email, String password) {
        faceBookPage.loginToFB(email, password);
    }

    @And("User clicks on continue button")
    public void userClicksOnContinueButton() {
        faceBookPage.clickOnContinueAsButton();
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLogInButton();
    }

    @And("User clicks on Google button")
    public void userClicksOnGoogleButton() {
        loginPage.clickOnGoogleButton();
    }

    @And("User login Google with {string} and {string}")
    public void userLoginGoogleWithAnd(String email, String password) {
        googlePage.enterEmail(email);
        googlePage.enterPassword(password);
    }

    @Given("User Joins Avantage Games page with new email account")
    public void user_joins_avantage_games_page_with_new_email_account() {
        loginPage.join(mail7Page.userName + "@mail7.io", ConfigurationReader.get("password"));
    }

    @Given("User clicks hyperlink send by Avantage")
    public void user_clicks_hyperlink_send_by_avantage() {
        mail7Page.clickAvantageVerificationEmail();
        mail7Page.clickHyperLinkOfAvantage();
    }

    @And("User verifies that verification mail sent page is opened")
    public void userVerifiesThatVerificationMailSentPageIsOpened() {
        loginPage.validateVerificationMailSent();
    }

    @And("User navigates to mailseven page inbox")
    public void userNavigatesToMailsevenPageInbox() {
        Driver.get().get("https://console.mail7.io/admin/inbox/inbox");
    }

    @And("User enters username into inbox input")
    public void userEntersUsernameIntoInboxInput() {
        mail7Page.enterInboxInput();
        mail7Page.enterPopUpInput();
    }

    @Then("User verifies initials")
    public void userVerifiesInitials() {
        loginPage.verifyInitials();
    }

    @Then("User verifies The system shows {string} message")
    public void userVerifiesTheSystemShowsMessage(String message) {
        Assert.assertEquals(message,loginPage.accountExistMessage.getText());
    }

    @And("User clicks on email button")
    public void userClicksOnEmailButton() {
        loginPage.clickOnEmailButton();
    }

    @And("User clicks on forgot password button")
    public void userClicksOnForgotPasswordButton() {
        forgotPassword.clickForgotPassword();
    }

    @And("User enters email into forgot password email input")
    public void userEntersEmailIntoForgotPasswordEmailInput() {
        forgotPassword.enterEmailInForgotPassword("testertester856@mail7.io");
    }

    @And("User verifies that email sent message is popped up")
    public void userVerifiesThatEmailSentMessageIsPoppedUp() {
        url=Driver.get().getCurrentUrl();
        Assert.assertTrue(forgotPassword.toContinueMessage.isDisplayed());
    }

    @And("User enters {string} into inbox input")
    public void userEntersIntoInboxInput(String mail) {
        mail7Page.enterInboxInput();
        mail7Page.enterPopUpInput(mail);
    }

    @And("User clicks on forgot password mail")
    public void userClicksOnForgotPasswordMail() {
        mail7Page.clickPasswordResetMail();
    }

    @And("User gets digital codes")
    public void userGetsDigitalCodes() {
      code=mail7Page.getDigitalCode();
    }
    @And("User enters digital code")
    public void userEntersDigitalCode() {
        forgotPassword.enterDigitalCode(code);
    }

    @And("User opens new window")
    public void userOpensNewWindow() {
        Driver.get().switchTo().newWindow(WindowType.TAB);
    }


    @And("User navigates back to Avantage GamePortal")
    public void userNavigatesBackToAvantageGamePortal() {
        String current=Driver.get().getWindowHandle();
        Set<String>tabs=Driver.get().getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(current)){
                Driver.get().switchTo().window(tab);
            }
        }
    }

    @And("User enters passwords")
    public void userEntersPasswords() {
        forgotPassword.enterPassword();
    }

    @And("User clicks on initials")
    public void userClicksOnInitials() {
        playerAccountPage.clickOnInitials();
    }

    @And("User refresh")
    public void userRefresh() {
        Driver.get().navigate().refresh();
    }

    @When("User joins {string} and {string}")
    public void userJoinsAndQW(String email, String password) {
        loginPage.join(email,password);
    }

    @And("The user logs in")
    public void theUserLogsIn() {
        loginPage.logIn(ConfigurationReader.get("email"));
    }
}
