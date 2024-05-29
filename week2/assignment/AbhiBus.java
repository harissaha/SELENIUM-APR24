package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhiBus {
	public static void main(String[] args) throws InterruptedException {
		// 01) Launch Firefox / Chrome / Safari / Edge
		ChromeDriver driver = new ChromeDriver();
		// 02) Load https://www.abhibus.com/
		// Add implicitlyWait -
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 03) Type "Chennai" in the FROM text box
		// 04) Click the first option from the popup box
		Thread.sleep(3000);
		WebElement fromEle = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
		fromEle.sendKeys("Chennai");
		Thread.sleep(2000);
		fromEle.sendKeys(Keys.TAB);
		// 05) Type "Bangalore" in the TO text box
		// 06) Click the first option from the popup box
		WebElement toEle = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
		toEle.sendKeys("Bangalore");
		Thread.sleep(2000);
		toEle.sendKeys(Keys.ENTER);
		// 07) Click the'Tomorrow' button
		driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
		// 08) Print the name of the first resulting bus (use .getText())
		System.out
				.println("Transport Name: "+driver.findElement(By.xpath("(//div[contains(@class,'operator-info col')]/h5)[1]")).getText());
		// 09) Choose SLEEPER in the left menu from Bus Type
		driver.findElement(By.xpath("//span[text()='AC']")).click();
		// 10) Print the first resulting bus seat count(Example:35 Seats Available)(use
		// .getText())
		WebElement seatAvil = driver.findElement(By.xpath("//small[text()=' Seats Available']"));
		System.out.println("Seats Available: "+seatAvil.getText());
		// 11) Click Show Seats
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Show Seats'])[1]")).click();
		// 12) Choose any one Available seat
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//table[@id='seat-layout-details']/tbody/tr/td//button)[10]")).click();
		// 13) Select the first resulting checkbox from the Boarding Point and Dropping
		// Point
		driver.findElement(By.xpath("(//div[@id='place-container']//input)[1]")).click();
		driver.findElement(By.xpath("(//div[@id='place-container']//input)[1]")).click();
		// 14) Print Seats Selected, Total Fare
		WebElement seatSelected = driver.findElement(By.xpath("//span[text()='Seat Selected :']/span"));
		System.out.println("Selected Seat: "+seatSelected.getText());
		WebElement selectedSeatFare = driver.findElement(By.xpath("//span[text()='Base Fare :']/span"));
		System.out.println("Fare: "+selectedSeatFare.getText());
		// 15) Get the Title of the page(use .getTitle())
		System.out.println("Title Of The Page: "+driver.getTitle());
		// 16) Close the browser
		driver.close();
		
	}
}
