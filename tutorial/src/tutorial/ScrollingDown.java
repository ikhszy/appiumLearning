// purpose of this is to learn scroll down
// until you reach certain point
// in this part, we'll try to scroll until we found menu called SPINNER

package tutorial;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.net.MalformedURLException;

public class ScrollingDown extends Base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// define the touch action
		@SuppressWarnings("rawtypes")
		TouchAction ta = new TouchAction(driver);
		
		// enter the first menu (Views)
		WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		ta.tap(tapOptions().withElement(element(views))).perform();
		
		// this is the part where we scroll until we found the point
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Rotating Button\"));");
		
		// next is to verify whether we have arrive at the destination point
		String T = driver.findElementByXPath("//android.widget.TextView[@text = 'Rotating Button']").getAttribute("displayed");
		System.out.println("the element isDisplayed = " + T);
		
		// another example of scrolling down is
		// using parent id to scroll
		// this is useful when you need to get to an exact part of a list
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"\").instance(0))"));
	}

}
