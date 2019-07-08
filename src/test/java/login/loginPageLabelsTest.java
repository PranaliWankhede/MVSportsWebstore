package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import driver.Invoke;

public class loginPageLabelsTest {
	loginPageLabels labels;
	
	@Test(priority=1)
	public void click()
	{
		Invoke.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		labels = PageFactory.initElements(Invoke.webDriver,loginPageLabels.class);
		labels.clickLogin();
	}
}
