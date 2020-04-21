package Annotation; 

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When;
import junit.framework.Assert; 

public class annotation { 
   WebDriver driver = null; 
   
   @Given("^I navigate to the login page$") 
	
   public void goToFacebook() throws Throwable { 
     // driver = new FirefoxDriver(); 
       System.setProperty(
               "webdriver.chrome.driver",
               "C:/chromedriver_win32/chromedriver.exe");
      driver = new ChromeDriver();
      System.out.println("driver");
      driver.navigate().to("https://www.facebook.com/"); 
   }
   
   @When("^I enter username as \"(.*)\"$") 
   public void enterUsername(String arg1) {   
      driver.findElement(By.name("email")).sendKeys(arg1); 
	  System.out.println("driver");  
   }
   
   @When ("^I enter password as \"(.*)\"$") 
   public void enterPassword(String arg1) {
	  driver.findElement(By.name("email")).sendKeys(arg1); 
      driver.findElement(By.name("pass")).sendKeys(arg1);
      driver.findElement(By.id("loginbutton")).click(); 
   } 
	
   @Then("^Login should fail$") 
   public void checkFail() {  
      if(driver.getCurrentUrl().equalsIgnoreCase(
         "https://www.facebook.com/login/help.php?email=TOM&st=h_noacct&lwv=120&lwc=1348028")){ 
            System.out.println("Test1 Pass"); 
      } else { 
         System.out.println("Test1 Failed"); 
      } 
      //driver.close(); 
   }
	
   @Then("^Relogin option should be available$") 
   public void checkRelogin() { 
      if(driver.getCurrentUrl().equalsIgnoreCase(
         "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=11022")){ 
            System.out.println("Test2 Pass"); 
      } else { 
         System.out.println("Test2 Failed");
         Assert.fail("Test2 Failed");
      } 
      
      driver.close(); 
   }

} 