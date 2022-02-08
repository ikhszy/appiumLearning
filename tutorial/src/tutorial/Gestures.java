// purpose of this class is to learn gestures on mobile
// there are multiple packages for these
// the needed package will be marked

package tutorial;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

// this is the additional packages
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;


public class Gestures extends Base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// specific library from appium to perform mobile gestures
		@SuppressWarnings("rawtypes")
		TouchAction ta = new TouchAction(driver);
		
		// trying to 'tap'
		WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		ta.tap(tapOptions().withElement(element(views))).perform();
		
		WebElement exl = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
		ta.tap(tapOptions().withElement(element(exl))).perform();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ca = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
		ta.tap(tapOptions().withElement(element(ca))).perform();
		
		// Long Press on people name for 2 seconds to see the hidden menu
		// Releasing after 2 seconds
		// for duration, added java duration package
		WebElement pn = driver.findElementByXPath("//android.widget.TextView[@text = 'People Names']");
		ta.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
		
		// to verify if the hidden menu appeared
		WebElement hm = driver.findElementByXPath("//android.widget.FrameLayout");
		
		if (hm.isDisplayed()) {
			System.out.println("hidden menu appeared");
			WebElement sm = driver.findElementByXPath("//android.widget.TextView[@text = 'Sample menu']");
			if (sm.isDisplayed()) {
				System.out.println("correct menu displayed");
			} else {
				System.out.println("wrong menu displayed");
			}
		} else {
			System.out.println("long press doesn't work");
		}
		
		driver.closeApp();
	}
}
