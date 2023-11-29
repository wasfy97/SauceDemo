package saucedemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class tests extends Parameters {
	
	
	@BeforeTest
	public void mybeforetest() {
		driver.get(MyUrl);
		driver.manage().window().maximize();
		
		
		
	}
	
	@Test(priority = 1)
	public void logintest () {
		WebElement UserLogin =driver.findElement(By.id("user-name"));
		UserLogin.sendKeys(UserName);
		
		WebElement PasswordLogin = driver.findElement(By.id("password"));
		PasswordLogin.sendKeys(Password);
		
		WebElement Login = driver.findElement(By.id("login-button"));
		Login.click();
		
	}
	
	@Test(priority = 2)
	public void AddToCart () {
		
		List<WebElement> Button = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> ItemsPrices = driver.findElements(By.className("inventory_item_price"));
		


		for (int i =0 ; i<Button.size();i++) {
			
		if (ItemsNames.get(i).getText().contains("Backpack") || ItemsNames.get(i).getText().contains("Fleece") || ItemsNames.get(i).getText().contains("Onesie")) {
			
			String PriceAfterTax = ItemsPrices.get(i).getText().replace("$", "");
			double PriceAsDouble = Double.parseDouble(PriceAfterTax);
			
			double Tax= 0.10;
			double FinalPrice= PriceAsDouble * Tax + PriceAsDouble;
			
			System.out.println("This item "+ItemsNames.get(i).getText()+" was not added " +" and the  Original price of this Item is" +ItemsPrices.get(i).getText() + " and the final price after tax of this item is " + FinalPrice  );
	        int intFinalPrice = (int) FinalPrice;

			if (  intFinalPrice %2==0) {
				System.out.println("and this number is an Even number");
				
			}
			else {
				System.out.println("and this number is  an Odd number");

			}
			
			
			continue;
			}
			
		else  { 
			String PriceAfterTax = ItemsPrices.get(i).getText().replace("$", "");
			double PriceAsDouble = Double.parseDouble(PriceAfterTax);
			
			double Tax= 0.10;
			double FinalPrice= PriceAsDouble * Tax + PriceAsDouble;
			
			
			
			Button.get(i).click(); 
			System.out.println("This item "+ItemsNames.get(i).getText()+" was added "+"and the  Original price of this Item is" +ItemsPrices.get(i).getText() + " and the final price after tax of this item is " + FinalPrice   );
			int intFinalPrice = (int) FinalPrice;
			if ( intFinalPrice  %2==0) {
				System.out.println("and this number is an Even number");
				
			}
			else {
				System.out.println("and this number is an Odd number");

			}
			
			
			}
			
			
		}
		
		
	}
	
	
	
	
	@AfterTest
	public void aftertest () {
		
	}

}
