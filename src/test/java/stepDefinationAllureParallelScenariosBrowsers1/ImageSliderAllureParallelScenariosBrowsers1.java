package stepDefinationAllureParallelScenariosBrowsers1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilityAllureParallelScenariosBrowsers1.BaseClassAllureParallelScenariosBrowsers1;

public class ImageSliderAllureParallelScenariosBrowsers1 extends BaseClassAllureParallelScenariosBrowsers1 {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageSliderAllureParallelScenariosBrowsers1.class);
	
	@Given("I am on the website homepage")
	public void i_am_on_the_website_homepage() {
	   
		logger.info("Thread ID: {} - Verifying homepage title", Thread.currentThread().getId());
		allureParallelScenarios1_launchURL();
		
	}

	@Then("the homepage image slider should be visible")
	public void the_homepage_image_slider_should_be_visible() {
	  
		
	}

	@When("I wait for the image slider to change")
	public void i_wait_for_the_image_slider_to_change() {
	   
		
	}

	@Then("the displayed image should be different from the previous one")
	public void the_displayed_image_should_be_different_from_the_previous_one() {
	   
		
	}


	

}
