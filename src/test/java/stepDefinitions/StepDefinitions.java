package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions {

  private int num1 = 0, num2 = 0, result = 0;
  private String today;

  @Given("^I have two numbers (\\d+) and (\\d+)$")
  public void receiveNumbers(Integer number1, Integer number2) {
    this.num1 = number1;
    this.num2 = number2;
  }

  @When("^I wish sum$")
  public void sumNumbers() {
    this.result = num1 + num2;
  }

  @When("^I wish subtract")
  public void subNumbers() {
    this.result = num1 - num2;
  }

  @When("^I wish multiple$")
  public void multipleNumbers() {
    this.result = num1 * num2;
  }

  @When("^I wish divide$")
  public void divideNumbers() {
    this.result = num1 / num2;
  }

  @Then("^I expect result (\\d+)$")
  public void resultSum(Integer expectedResult) {
    assertThat(result, equalTo(expectedResult));
  }
}
