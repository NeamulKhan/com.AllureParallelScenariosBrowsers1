package stepDefinationAllureParallelScenariosBrowsers1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilityAllureParallelScenariosBrowsers1.BaseClassAllureParallelScenariosBrowsers1;


public class HooksAllureParallelScenariosBrowsers1 extends BaseClassAllureParallelScenariosBrowsers1 {
	
	private static final Logger logger = LoggerFactory.getLogger(HooksAllureParallelScenariosBrowsers1.class);
	
	@Before
	
	public void setUp(Scenario scenario) {
		logger.info("Starting scenario: {}", scenario.getName());
		System.out.println("Launching " + getBrowser() + " for scenario: " + scenario.getName());
		allureParallelScenariosBrowsers1_initializeDriver(getBrowser());
		System.out.println("Running scenario on Thread ID: " + Thread.currentThread().getId());
	}
	
	@After
    public void tearDown(Scenario scenario) {
	  
	 if (scenario.isFailed()) {
		 logger.error("!!!! FAILED Scenario: {} !!!!", scenario.getName());
		 logger.error("Scenario failed: {}", scenario.getName());
            byte[] screenshot = ((TakesScreenshot) BaseClassAllureParallelScenariosBrowsers1.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }else {
            logger.info("Scenario passed: {}", scenario.getName());
            logger.info("==== PASSED Scenario: {} ====", scenario.getName());
        }
	 
	 BaseClassAllureParallelScenariosBrowsers1.quitDriver();
        System.out.println("---------------------------------------");
    }

}
