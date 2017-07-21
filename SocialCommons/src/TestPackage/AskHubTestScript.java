import page_object.CommonsDashBoard;
import page_object.AskHub;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
//import screenshot.basic;
public class AskHubTestScript {
	 
	 private static String title_name;
	 
	 public static WebDriver initiate_driver()
	 {
		 WebDriver driver = new ChromeDriver();
		 driver.navigate().to("https://social.athenahealth.com/welcome");
		 return driver;
	 }
	 
	 public static void navigate_to_dashboard (WebDriver driver) {
		 CommonsDashBoard.top_destination(driver).click();
		 CommonsDashBoard.top_destination_more(driver).click();
		 CommonsDashBoard.ask_hub(driver).click();
		 
	 }
	 
	 public static void play_video ( WebDriver driver) {
	 AskHub.identity_iq(driver).click();
	 title_name = AskHub.video_title(driver).getText();
	// Screenshot buffered = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
	 }
	 
	 public static boolean validate_title () {
		 if (title_name.contains("New desk")) {
			return true;
	      }else {
	         return false;
	      }
	 }
	 
	 public static void back_to_dashboard(WebDriver driver)
	 {
		 CommonsDashBoard.commons_home_page(driver).click();
		 driver.quit();
	 }
	 
     public void getscreenshot(WebDriver driver, String location) throws Exception 
     {
   	  System.out.println("JP");
             File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           System.out.println("JP2");
          //The below method will save the screen shot in d drive with name "screenshot.png"
             FileUtils.copyFile(scrFile, new File(location));
     }

	public void onTestFailure(ITestResult result, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	
}
