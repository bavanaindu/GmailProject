package Gmaillogin;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


class gmailnew
{
public static void main(String[] args) throws Exception 
	{
	    //Enter Username and Password Manually
		String uid,pswd;
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter User Id");
		uid=s.nextLine();
		System.out.println("Enter Password");
		pswd=s.nextLine();
		
		//Launch Gmail
		
		WebDriver obj=new FirefoxDriver();
		obj.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		obj.get("http://www.gmail.com");
		obj.manage().window().maximize();
		Thread.sleep(2000);
		
		//filling fields automatically by calling username and password
		//Locating elements using firebug
		
		obj.findElement(By.id("Email")).sendKeys(uid);
		obj.findElement(By.id("next")).click();
		Thread.sleep(2000);
		
		//Locating element using firepath
		
		obj.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(pswd);
        //Thread.sleep(3000);
		//Click Signin
		obj.findElement(By.id("signIn")).click();
		Thread.sleep(4000);
		
		//Go to compose box
		obj.findElement(By.xpath("//div[2]/div/div/div/div[2]/div/div/div/div/div")).click();
		Thread.sleep(2000);
		//Filling field by calling uid
		obj.findElement(By.xpath("//textarea[@name='to']")).sendKeys(uid);
		Thread.sleep(2000);
		
		obj.findElement(By.xpath("//input[contains(@name,'subjectbox')]")).sendKeys("Message");
		Thread.sleep(2000);
		//By using xpath find textbox
		WebElement x=obj.findElement(By.xpath("//td[2]/div[2]/div"));
		Thread.sleep(2000);
		
		//By using actions compose a message
		Actions as=new Actions(obj);
		as.moveToElement(x).click().sendKeys("Hai").sendKeys(Keys.ENTER).sendKeys("How are you?").sendKeys(Keys.ENTER).sendKeys("Regards").sendKeys(Keys.ENTER).sendKeys("Bhavana").build().perform();
		
		//Locating send button through xpath(sending mail)
		obj.findElement(By.xpath("//td/div/div/div[4]/table/tbody/tr/td/div/div[2]")).click();
		Thread.sleep(2000);
		
	    //condition is check wheather new message is added or not
		 if(obj.findElement(By.xpath("//div[@class='aio UKr6le']/span/a")).getText() != null)
	     {
	         System.out.println("New message is updated" );
	     }
	     else
	     {
	         obj.findElement(By.linkText("Logout")).click();

	     System.out.println("New message is  not updated" );
	     }
        
		
		//message count and New message is updated
        //String inboxcount =obj.findElement(By.xpath("//div[@class='aio UKr6le']/span/a")).getText();
        //System.out.println(inboxcount +" : "+"New message is updated");
       
        
        
        //Locate signout through xpath
        obj.findElement(By.xpath("//span[contains(@class,'Ka gbii')]")).click();
        obj.findElement(By.xpath("//a[contains(.,'Sign out')]"));
		//closing all windows
		obj.close();
		

	}


	}


