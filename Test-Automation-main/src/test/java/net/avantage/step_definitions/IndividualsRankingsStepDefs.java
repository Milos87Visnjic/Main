package net.avantage.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.avantage.pages.IndividualRankingsPage;
import net.avantage.pages.LoginPage;
import net.avantage.utils.ConfigurationReader;
import net.avantage.utils.Driver;
import org.junit.Assert;

public class IndividualsRankingsStepDefs {
    IndividualRankingsPage individualRankingsPage = new IndividualRankingsPage();

    @Given("User navigates to Game Portal Page")
    public void user_navigates_to_game_portal_page() {
        Driver.get().navigate().to(ConfigurationReader.get("url_GP"));
    }

    @And("User accepts all cookies and age questions")
    public void userAcceptsAllCookiesAndAgeQuestions() {
        individualRankingsPage.acceptCookies();
        individualRankingsPage.acceptAge();
    }
}
