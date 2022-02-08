// the purpose of this is to try drag n drop
// in this part i'm trying to tap and hold + move + release

package tutorial;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDrop extends Base{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		@SuppressWarnings("rawtypes")
		TouchAction t = new TouchAction(driver);
		
		// enter the drag n drop menu
		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text = 'Drag and Drop']").click();
		
		AndroidElement firstObject = driver.findElementsByClassName("android.view.View").get(0);
		AndroidElement secondObject = driver.findElementsByClassName("android.view.View").get(2);
		
		// this is where we do the drag n drop
		// t.longPress(longPressOptions().withElement(element(firstObject)).withDuration(ofSeconds(2))).moveTo(element(secondObject)).perform();
		
//		t.longPress(longPressOptions()
//			.withPosition(point(fo.x, fo.y))
//			.withDuration(ofSeconds(8)))
//			.moveTo(point(so.x, so.y))
//			.perform();
		
		t.longPress(element(firstObject)).moveTo(element(secondObject)).release().perform();
		
		AndroidElement dragText = driver.findElementByXPath("//android.widget.TextView[@index = 4]");
		String textnya = dragText.getText();
		System.out.println(textnya);

	}
}
