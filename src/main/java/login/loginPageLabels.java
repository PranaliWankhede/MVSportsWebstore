package login;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.Invoke;


public class loginPageLabels {
	loginPageLabels labels;
	
	@FindBy(xpath = "(//i[@data-test-selector='lblZfLoginUser'])[1]")
	private WebElement linkLogin;
	
	@FindBy(xpath = "//button[@data-test-selector='btnLoginButton']")
	private WebElement btnLogin;
	
	public void clickLogin()
	{
		Invoke.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		linkLogin.click();
	}
	
	public void verifyElements()
	{
		Invoke.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Invoke.webDriver.findElement(By.xpath("//label[@data-test-selector='lblLoginUserName']")).isDisplayed();
		Invoke.webDriver.findElement(By.xpath("//label[@data-test-selector='lblLoginPassword']")).isDisplayed();
		Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtUserName']")).isDisplayed();
		Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtLoginPassword']")).isDisplayed();
		Invoke.webDriver.findElement(By.xpath("//button[@data-test-selector='btnLoginButton']")).isDisplayed();
		Invoke.webDriver.findElement(By.xpath("//label[@data-test-selector='lblRememberMe']")).isDisplayed();
		Invoke.webDriver.findElement(By.xpath("//a[@data-test-selector='linkForgetPassword']")).isDisplayed();
	}
	
	public void verifyBlankValidations()
	{
		Invoke.webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		btnLogin.click();
		
        WebElement userNameErrMsg = Invoke.webDriver.findElement(By.xpath("//p[@data-test-selector='lblUserNameErrMsg']"));
        String actualusermsg = userNameErrMsg.getText();
        String expectedusermsg = "Username is required.";
        expectedusermsg.equals(actualusermsg);
        
        WebElement passwordErrMsg = Invoke.webDriver.findElement(By.xpath("//p[@data-test-selector='lblPasswordErrMsg']"));
        String actualpasswordmsg = passwordErrMsg.getText();
        String expectedpasswordmsg = "Password is required.";
        expectedpasswordmsg.equals(actualpasswordmsg);
        
        for(int count = 1; count <= 2; count++)
        {
        	if(count == 1)
        	{
        		Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtUserName']")).sendKeys("abc");
        		btnLogin.click();
        		verifyDataValidations(count);
        	}
        	if(count == 2)
        	{
	        	Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtUserName']")).sendKeys("abc");
	            Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtLoginPassword']")).sendKeys("123");
	            btnLogin.click();
        		verifyDataValidations(count);
        	}
        }
        for(int counter = 1; counter <= 3; counter++)
        {
	        if(counter == 1)
	    	{
	        	Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtUserName']")).sendKeys("admin@123");
	            Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtLoginPassword']")).sendKeys("admin@12345");
	            btnLogin.click();
	            popUpValidation(counter);
	    	}
	    	if(counter == 2)
	    	{
	        	Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtUserName']")).sendKeys("admin");
	            Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector='txtLoginPassword']")).sendKeys("admin@12345");
	            btnLogin.click();
	            popUpValidation(counter);
	    	}
        }
	}
	
	public void verifyDataValidations(int choice)
	{
		WebElement passwordErrMsg = Invoke.webDriver.findElement(By.xpath("//p[@data-test-selector='lblPasswordErrMsg']"));
        String actualpasswordmsg = passwordErrMsg.getText();
        switch (choice)
        {
	        case 1: 
		        String expectedpasswordmsg1 = "Password is required.";
		        expectedpasswordmsg1.equals(actualpasswordmsg);
		        break;
		        
	        case 2: 
		        String expectedpasswordmsg2 = "Password must be at least 8 alphanumeric characters and contain at least one number.";
		        expectedpasswordmsg2.equals(actualpasswordmsg);
		        break;
		        
		    default :
		    	System.out.println("Default case executed");
        }
	}
	
	public void popUpValidation(int choice)
	{
		WebElement popupErrMsg = Invoke.webDriver.findElement(By.xpath("//*[@data-test-selector='lblNotificationsMsg']"));
		String actualpopupErrMsg = popupErrMsg.getText();
		
		switch (choice)
        {
	        case 1: 
		        String expectedpopupmsg1 = "Invalid Username or Password.";
		        expectedpopupmsg1.equals(actualpopupErrMsg);
		        break;
		        
	        case 2: 
		        String expectedpopupmsg2 = "Password must be at least 8 alphanumeric characters and contain at least one number.";
		        expectedpopupmsg2.equals(actualpopupErrMsg);
		        break;
		        
		    default :
		    	System.out.println("Default case executed");
        }
	}
}
