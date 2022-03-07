package generalStore;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class StartingEmptyName extends Base {
	public static void main(String[] args) throws MalformedURLException{
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		@SuppressWarnings("rawtypes")
//		TouchAction t = new TouchAction(driver);
		
		// select options of Cyprus
		// click the placeholder first
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/spinnerCountry\")")
		.click();
		
		// scroll down until we found Cyprus
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cyprus\"));").click();
		
		// select gender female
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioFemale\")")
		.click();
		
		// click on the enter button
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")
		.click();
		
		// Verify error message
		String toast = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals("Please enter your name", toast);
		
		driver.closeApp();
	}
}