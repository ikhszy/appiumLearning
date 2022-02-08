package tutorial;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends Base{

	//what i want to do is to change the wifi settings by clicking multiple things first then change the value
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Preference button
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		//Click on Preferences from XML button
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		//Click on Preferences from XML button
		driver.findElementByXPath("//android.widget.CheckBox").click();
		
		//Enter the wifi menu
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		//change the value
		driver.findElementByXPath("//android.widget.EditText").sendKeys("whatever it is");
		
		//confirm the value change
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
		
		//confirm the changes
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		String confirmText = driver.findElementByXPath("//android.widget.EditText").getText();		
		Assert.assertEquals(confirmText, "whatever it is");
		
		driver.closeApp();
		}

}
