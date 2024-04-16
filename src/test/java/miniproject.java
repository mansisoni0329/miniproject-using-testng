import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

public class miniproject {
	WebDriver driver;
   @BeforeClass
   public void beforeClass()
   {
	    driver = new ChromeDriver();
	   driver.get("https://ishahomes.com/");
	   driver.manage().window().maximize();
   }
	
  @Test(priority=1)
  public void waittime()
  {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }
  
  @Test(priority=2)
  public void handlelivechat() throws InterruptedException
  {
	  WebElement livchat=driver.findElement(By.id("livchat_close"));
	  
  	if(livchat.isDisplayed())
  	{
  		Thread.sleep(5000);
  		livchat.click();
  	}
  }
  
  @Test(priority=3)
  public void handlepopup() throws InterruptedException 
  {
	  waittime();
		WebElement handle = null;
		try{
			handle=driver.findElement(By.xpath("//a[@class='close-indicator']"));
		}catch(NoSuchElementException e) {
			
		}
       
	   if (handle.isDisplayed()) 
	   {
		   Thread.sleep(3000);
			handle.click();
		}
	}
  
  @Test(priority=4)
  public void completedprojectclick() throws InterruptedException 
  {
	  waittime();
	  handlelivechat();
		driver.findElement(By.xpath("//*[@id=\"menu-item-25810\"]/a")).click();
  }
  
  @Test(priority=5)
  public  void totalnumber()
  {
      waittime();
      WebElement container=driver.findElement(By.xpath("//*[@id=\"boosted-tab-0\"]/div[1]/section/div/div/div"));
		   List<WebElement> lst=container.findElements(By.className("item-title"));
		   System.out.println(lst.size());
		   
		   for(int i=0;i<5;i++) {
			   System.out.println(lst.get(i).getText());
		   }
		
		// click the enquire button
		driver.findElement(By.xpath("//i[@class='far fa-edit']")).click();
	}
  
  @Test(priority=6)
  public  void verify() // read and display the email id
	{
		waittime();
		String act_text = driver.findElement(By.linkText("Other Enquiry")).getText();
		if (act_text.equals("Other Enquiry"))
		{
			System.out.println("Verified-Found");
		} 
		else 
		{
			System.out.println("Verified But Not Found");
		}
		driver.findElement(By.xpath("//span[text()=\"Other Enquiry\"]")).click();
		String mail_id = driver.findElement(By.linkText("marketing@ishahomes.com")).getText();
		System.out.println(mail_id);
	}
 
  

  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
  }

}
