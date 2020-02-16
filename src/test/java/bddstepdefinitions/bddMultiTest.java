package bddstepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class bddMultiTest {

    @Given("^F01 S03 want to do during smoke and regression$")
    public void f01_s03_want_to_do_during_smoke_and_regression() throws Throwable {
		System.out.println("Something...");
    }

    @When("^F01 S03 page x is loaded$")
    public void f01_s03_page_x_is_loaded() throws Throwable {
		System.out.println("Everything...");
    }

    @Then("^F01 S03 page x title is validated$")
    public void f01_s03_page_x_title_is_validated() throws Throwable {
		System.out.println("Nothing...");
    }
    

}