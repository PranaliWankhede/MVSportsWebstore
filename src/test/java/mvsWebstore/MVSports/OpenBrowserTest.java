package mvsWebstore.MVSports;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import driver.Invoke;

public class OpenBrowserTest {
	private static final String Invoke = null;
	OpenBrowserTest openbrowser;
	
	@Test(priority=1)
	public void click()
	{
		Invoke.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
    }
}