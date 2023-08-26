package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadAssignment {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		//Launch the browser
		ChromeDriver driver = new ChromeDriver(co);
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		//Maximize the browser
		driver.manage().window().maximize();
		//Find the username and enter username value
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//Find the password field and enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click on Login button
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on CRMSFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on Lead tab
		driver.findElement(By.linkText("Leads")).click();
		//Click find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//Enter first name
		driver.findElement(By.name("firstName")).sendKeys("Bharath");
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		//Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();  //click the first resulting lead
		//Verify title of the page
		System.out.println(driver.getTitle());
		//Click Edit
		driver.findElement(By.linkText("Edit")).click();
		//Change company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeafs");
        //Click update
		driver.findElement(By.name("submitButton")).click();
		//Confirm the changed name appears
		//Close the browser (Do not logout)
		driver.close();


	}

}
