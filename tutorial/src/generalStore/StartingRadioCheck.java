package generalStore;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class StartingRadioCheck extends Base{

	public static void main(String[] args) throws MalformedURLException{
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		@SuppressWarnings("rawtypes")
//		TouchAction t = new TouchAction(driver);
		
		// select options of Argentina
		// click the placeholder first
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/spinnerCountry\")")
		.click();
		
		// scroll down until we found Argentina
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();
		
		//fill the name first
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/nameField\")")
		.sendKeys("HannahMontana");
		driver.hideKeyboard();
		
		// let's use if to click buttons
		WebElement rdMale = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioMale\")");
		WebElement rdFemale = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/radioFemale\")");
		
		String rdefault = rdMale.getAttribute("checked");
		Boolean rdefaults = Boolean.parseBoolean(rdefault);
		Assert.assertTrue(rdefaults);

		
		rdFemale.click();
		
		String rdchanged = rdFemale.getAttribute("checked");
		Boolean radioChanged = Boolean.parseBoolean(rdchanged);
		Assert.assertTrue(radioChanged);
		
		driver.closeApp();
	}
}