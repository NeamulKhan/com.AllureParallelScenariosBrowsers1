package utilityAllureParallelScenariosBrowsers1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseClassAllureParallelScenariosBrowsers1 {
	
	public static Properties allureParallelScenariosBrowsers1_prop;
	public static WebDriverWait wait;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<String>browserName = new ThreadLocal<>();
	private static ThreadLocal<String>osDetails = new ThreadLocal<>();
	
	private static Logger logger = LoggerFactory.getLogger(BaseClassAllureParallelScenariosBrowsers1.class);
	
	
	public BaseClassAllureParallelScenariosBrowsers1 () {
		
		try {
			
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/allureParallelScenarios1.config/allureParallelScenarios1.properties");
			
			allureParallelScenariosBrowsers1_prop = new Properties();
			allureParallelScenariosBrowsers1_prop.load(file);
			
		} catch (FileNotFoundException e) {
		    System.err.println("Properties file not found: " + e.getMessage());
		}
		  catch (IOException e) {
		    System.err.println("Error loading properties file: " + e.getMessage());
		}
		
		}
	
	//Getter method to retrieve WebDriver instance
		public static WebDriver getDriver() {
				if (driver.get() == null) {
				throw new IllegalStateException("Driver is not initialized properly.");
			}
				return driver.get();
		}
		
		
	//Getter method to retrieve browser name
		public static String getBrowser() {
						
				return browserName.get();
				
				}
				
	//Getter method to retrieve OS details
		public static String getOS() {
						
				return osDetails.get();
				}	
		
		
	
	// Ensure method is static to be called before every test scenario
	
	public static void allureParallelScenariosBrowsers1_initializeDriver(String browser) {
		
		System.out.println("Initializing browser on Thread ID: " + Thread.currentThread().getId() + ", Browser: " + browser);
		
		//Get OS details
		
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		String osArch = System.getProperty("os.arch");
		String osInfo = osName + " " + osVersion + " (" + osArch + ")";
		
		osDetails.set(osInfo); //Store OS details in ThreadLocal
		browserName.set(browser); // Store browser name in ThreadLoca
		
		logger.info("**** Setting up WebDriver for browser: {} on OS: {} ****", browser, osInfo);
		
		
		if (driver.get() == null) {
			 
			 
            switch (browser.toLowerCase()) {
            
                case "chrome":
                	System.out.println("Initializing Chrome browser...");
                    driver.set(new ChromeDriver());
                    break;
               
                case "edge":
                	System.out.println("Initializing Edge browser...");
                    driver.set(new EdgeDriver());
                    break;
                    
                default:
                    throw new RuntimeException("Invalid browser: " + browser);
            }
			
	

			wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10)); // Initialize WebDriverWait here
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();

		}
	}
	
	public static void allureParallelScenarios1_launchURL() {
		
		logger.info("Launching URL on browser: {}", getBrowser());
		
		getDriver().get(allureParallelScenariosBrowsers1_prop.getProperty("base.url"));
	}
	
	 public static void quitDriver() {
		 
		 logger.info("Closing browser: {}", getBrowser());
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();// remove from ThreadLocal to avoid memory leaks
				System.out.println("Test completed successfully and browser closed.");
	        }else {
		        System.out.println("No active driver found to quit.");
		    }
	 }
	}
	
	
	
	


