package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.PlayerAccountPage;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import org.junit.Assert;

public class PlayerAccountStepDefs {

    PlayerAccountPage playerAccountPage = new PlayerAccountPage();

    String avatar = "";

    @When("User clicks on Player Account button")
    public void userClicksOnPlayerAccountButton() {
        playerAccountPage.clickPlayerAccountButton();
    }

    @Given("User clicks on avatar")
    public void user_clicks_on_avatar() {
        playerAccountPage.clickAvatar();
    }

    @Then("User verifies player name")
    public void userVerifiesPlayerName() {
        Assert.assertEquals(playerAccountPage.playerName.getText(), ConfigurationReader.get("playerName"));
    }

    @When("User clicks on Player Profile")
    public void userClicksOnPlayerProfile() {
        playerAccountPage.clickPlayerProfile();
    }

    @Then("User verifies player name equals name in player profile page")
    public void userVerifiesPlayerNameEqualsNameInPlayerProfilePage() {
        Assert.assertEquals(playerAccountPage.playerName.getText(), playerAccountPage.playerNameInPlayerProfile.getText());
    }

    @When("User clicks on log out button")
    public void userClicksOnLogOutButton() {
        playerAccountPage.clickOnLogOutButton();
    }

    @Then("User verifies login button is visible")
    public void userVerifiesLoginButtonIsVisible() {
        playerAccountPage.verifyLogInButton();
    }

    @When("User clicks back button")
    public void userClicksBackButton() {
        Driver.get().navigate().back();
    }

    @And("User clicks on avatar edit icon")
    public void userClicksOnAvatarEditIcon() {
        playerAccountPage.clickEditIconAvatar();
    }

    @And("User clicks on choose avatar button")
    public void userClicksOnChooseAvatarButton() {
        playerAccountPage.clickChooseAvatarButton();
    }

    @When("User selects avatar")
    public void userSelectsAvatar() {
        avatar = playerAccountPage.selectAvatar();
    }

    @When("User clicks on close Icon")
    public void userClicksOnCloseIcon() {
        playerAccountPage.clickCloseIcon();
    }

    @And("User verifies avatar is selected avatar")
    public void userVerifiesAvatarIsSelectedAvatar() {
        Assert.assertEquals(playerAccountPage.avatar.getAttribute("src"), avatar);
    }

    @And("User clicks on settings button")
    public void userClicksOnSettingsButton() {
        playerAccountPage.clickSettingsButton();
    }

    @And("User clicks on edit comm button")
    public void userClicksOnEditCommButton() {
        playerAccountPage.clickEditCommButton();
    }

    @When("User clicks on privacy policy button in edit comm")
    public void userClicksOnPrivacyPolicyButtonInEditComm() {
        playerAccountPage.clickPrivacyPolicyButtonInEditComm();
    }

    @Then("User verifies privacy policy is opened in new tab")
    public void userVerifiesPrivacyPolicyIsOpenedInNewTab() {
        playerAccountPage.verifyPrivacyPolicy();
    }

    @When("User click on notifications button")
    public void userClickOnNotificationsButton() {
        playerAccountPage.clickNotificationsButton();
    }

    @Then("User verifies that notifications are visible")
    public void userVerifiesThatNotificationsAreVisible() {
        playerAccountPage.validateNotifications();
    }

    @When("User selects checkboxes of EditComm")
    public void userSelectsCheckboxesOfEditComm() {
        playerAccountPage.selectCheckBoxEditComm();
    }

    @When("User validates phone number input and email input")
    public void userValidatesPhoneNumberInputAndEmailInput() {
        playerAccountPage.validatePhoneNumberAndEmailInput();
    }

    @And("User clicks on Contact Us button")
    public void userClicksOnContactUsButton() {
        playerAccountPage.clickOnContactUsButton();
        playerAccountPage.verifyWhatAreYouLookingFor();
    }

    @And("User validates Contact Us menu")
    public void userValidatesContactUsMenu() {
        playerAccountPage.validateContactUsMenu();
    }

    @Then("User verifies that {string} message is showed up")
    public void userVerifiesThatMessageIsShowedUp(String message) {
        Assert.assertEquals(playerAccountPage.accountCannotBeCreatedMessage.getText(), message);
    }
}
