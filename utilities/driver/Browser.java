package driver;

public class Browser {
	public static Object webDriver;

	public static void maximizeBrowser()
	{
		Invoke.webDriver.manage().window().maximize();
		
	}// End of maximizeBrowser
	
}
