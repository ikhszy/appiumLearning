// purpose of this is to find element by AndroidUIAutomator
// other was just me trying to have fun

package tutorial;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class uiautomatortest extends Base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		driver.findElementByAndroidUIAutomator("text(\"3D Transition\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Lyon\")").click();
		
		//verify the element
		@SuppressWarnings("unused")
		boolean T = driver.findElementByXPath("//android.widget.ImageView").isDisplayed();
		
		if (T = true) {
			System.out.println("the image appeared");
		} else {
			System.out.println("image doesn't show");
		}
		
//		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
//		int textnyah = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
//		System.out.println("segini coy " + textnyah);
		
		driver.closeApp();
	}

}
