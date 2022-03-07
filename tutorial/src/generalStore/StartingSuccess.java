package generalStore;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class StartingSuccess extends Base {
	public static void main(String[] args) throws MalformedURLException{
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		@SuppressWarnings("rawtypes")
//		TouchAction t = new TouchAction(driver);
		
		// select options of Indonesia
		// click the placeholder first
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/spinnerCountry\")")
		.click();
		
		// scroll down until we found Indonesia
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Indonesia\"));").click();
	
		//fill the name first
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/nameField\")")
		.sendKeys("HannahMontana");
		driver.hideKeyboard();
		
		// select gender female
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioFemale\")")
		.click();
		
		// click on the enter button
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")")
		.click();
		
		// Verify whether we enter the correct page
		// first verify if the page title is correct
		String Title = driver.findElementByAndroidUIAutomator
		("new UiSelector().resourceId(\"com.androidsample.generalstore:id/toolbar_title\")").getText();
		Assert.assertEquals("Products", Title);
		
		// verify if cart button is displayed
		Boolean cart = driver.findElementByAndroidUIAutomator
		("new UiSelector().resourceId(\"com.androidsample.generalstore:id/appbar_btn_cart\")").isDisplayed();
		Assert.assertTrue(cart);
		
		// verify the product displayed
		Boolean Product = driver.findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"));").isDisplayed();
		Assert.assertTrue(Product);
		
		driver.closeApp();
	}
}