package testRunnerAllureParallelScenariosBrowsers1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "src/test/resources/featureFolderAllureParallelScenariosBrowsers1",
        plugin = {"pretty", "json:target/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "testng:target/cucumber-reports/testng.xml"},
        glue = {"stepDefinationAllureParallelScenariosBrowsers1"},
        monochrome = true,
        publish = true
        
)

public class TestRunnerAllureParallelScenariosBrowsers1 extends AbstractTestNGCucumberTests {
	
	@Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setupBrowser(@Optional("chrome") String browser) {
        System.setProperty("browser", browser);  // Make browser accessible in Hooks
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
