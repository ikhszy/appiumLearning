package tutorial;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

// this is the additional packages
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Swipe extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// add touch action for swipe use in later part of the code
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		
		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text = 'Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text = '2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc = '12']").click();
		
		// Swiping gesture starts here
		WebElement minuteFirst = driver.findElementByXPath("//*[@content-desc = '15']");
		WebElement minuteSecond = driver.findElementByXPath("//*[@content-desc = '45']");
		
		// long press first for 1 second
		// virtually move your finger to another element
		// release the finger
		t.longPress(longPressOptions().withElement(element(minuteFirst)).withDuration(ofSeconds(2))).moveTo(element(minuteSecond)).release().perform();
		
		// verify if the swiping is correct
		if(minuteSecond.isSelected()) {
			System.out.println("The gesture is a success");
		} else {
			System.out.println("Failed");
		}
		driver.closeApp();
	}

}
