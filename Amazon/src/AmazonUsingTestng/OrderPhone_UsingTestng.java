package AmazonUsingTestng;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrderPhone_UsingTestng {

	static WebDriver driver;

	@BeforeSuite

	//Navigate to Amazon URL
	public void OpenBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println("Amazon URL Loaded");
		//Get the Parent Window
		String Parent_Window =driver.getWindowHandle();
		System.out.println("Parent URL is"+Parent_Window);
		driver.manage().window().maximize();
		System.out.println("Page got Maximized");
	}
	
	@Test(priority=1)
	public void SearchItem() {
		//Search any Product & Click Enter
		WebElement Searchfield =  driver.findElement(By.id("twotabsearchtextbox"));
		Searchfield.sendKeys("Phones");
		System.out.println("Product Entered in Search Field");
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("Search Button Clicked");
		driver.findElement(By.xpath("//span[text()='Samsung Galaxy M01 Core (Blue, 1GB RAM, 16GB Storage) with No Cost EMI/Additional Exchange Offers']")).click();
		System.out.println("Navigated to New Window");
	}

	@Test(priority=2)
	public void newWindow() {
		//To Handle both the Parent and Child Window
		Set<String> AllWindows = driver.getWindowHandles();
		//For each loop to locate the child element
		for (String newWindow : AllWindows) {
			driver.switchTo().window(newWindow);
		}
	}

	@Test(priority=3)
	public void AddItemToCart() {
		//Child window's WebElement "Click Add to Cart"
		WebElement AddToCart = driver.findElement(By.id("add-to-cart-button"));
		AddToCart.click();
		System.out.println("Add to cart clicked");
	}

	@Test(priority=4)
	public void OpenCart() {
		//Navigate to Cart
		WebElement cart = driver.findElement(By.xpath("//form[@id='attach-view-cart-button-form']"));
		cart.click();
		System.out.println("Navigated to Cart Page");
	}

	@Test(priority=5)
	public void ClickProceedtoBuy() {
		//Click "Proceed to Buy"
		WebElement buy = driver.findElement(By.xpath("//span[@id='sc-buy-box-ptc-button']"));
		buy.click();
		System.out.println("Navigated to Proceed to buy page");
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}


}

