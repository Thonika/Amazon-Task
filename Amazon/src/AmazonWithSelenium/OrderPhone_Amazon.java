package AmazonWithSelenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderPhone_Amazon {
 
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\RAMA2739\\workspace\\Rama Selenium\\Amazon\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//implicit wait 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Navigate to Amazon URL
		driver.get("https://www.amazon.in/");
		System.out.println("Amazon URL Loaded");
		
		//Get the Parent Window
		String Parent_Window =driver.getWindowHandle();
		System.out.println("Parent URL is"+Parent_Window);
		driver.manage().window().maximize();
		System.out.println("Page got Maximized");
		
		//Search any Product & Click Enter
		WebElement Searchfield =  driver.findElement(By.id("twotabsearchtextbox"));
		Searchfield.sendKeys("Phones");
		System.out.println("Product Entered in Search Field");
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("Search Button Clicked");
		driver.findElement(By.xpath("//span[text()='Samsung Galaxy M01 Core (Blue, 1GB RAM, 16GB Storage) with No Cost EMI/Additional Exchange Offers']")).click();
		System.out.println("Navigated to New Window");
		
		//To Handle both the Parent and Child Window
		Set<String> AllWindows = driver.getWindowHandles();
		
		
		//For each loop to locate the child element
		for (String newWindow : AllWindows) {
			driver.switchTo().window(newWindow);
		}
		
		//Child window's WebElement "Click Add to Cart"
		WebElement AddToCart = driver.findElement(By.id("add-to-cart-button"));
		AddToCart.click();
		System.out.println("Add to cart clicked");
		
		//Navigate to Cart
		WebElement cart = driver.findElement(By.xpath("//form[@id='attach-view-cart-button-form']"));
		cart.click();
		System.out.println("Navigated to Cart Page");
		
		//Click "Proceed to Buy"
		WebElement buy = driver.findElement(By.xpath("//span[@id='sc-buy-box-ptc-button']"));
		buy.click();
		System.out.println("Navigated to Proceed to buy page");
	
		
		
		
		
		
	}

}
