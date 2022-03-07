package tutorial;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ToastMessage extends Base {
	public static void main(String[] args) throws MalformedURLException{
		AndroidDriver<AndroidElement> driver = capabilities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Toast message usually
		// have the same component
		// android.widget.Toast[1]
		// the array showing order of toast appearing
		
		driver.findElement(By.xpath("android.widget.Toast[1]"));
		// the above code means
		// we're looking for a toast element
		// which appeared first
		
		String toastMessage = driver.findElement(By.xpath("android.widget.Toast[2]")).getAttribute("name");
		// above code will return
		// the text that was used 
		// as toast message
	}
}
