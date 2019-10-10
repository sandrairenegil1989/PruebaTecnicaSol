package com.pruebatecnica.sandragil;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbaySearchTest {

	private WebDriver driver;
	By TextBuscarLocator = By.id("gh-ac");
	By ButtonBuscarLocator = By.id("gh-btn");
	By LogoEbayLocator = By.id("gh-logo");
	By ClassResulLocaltor = By.className("srp-controls__count-heading");
	
	
	@Before
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ebay.com");
	}
	
	@Test
	public void testEbayPage() throws InterruptedException
	{
		//Busco logo, para verificar que haya ingresado correctamente a la página de Ebay
		if (driver.findElement(LogoEbayLocator).isDisplayed())
		{
			//Escribo Pilas en el textbox de búsqueda
			driver.findElement(TextBuscarLocator).sendKeys("Pilas");
			//Hago click en el campo de búsqueda
			driver.findElement(ButtonBuscarLocator).click();
			Thread.sleep(5000);

			System.out.print("El test devolvió:"+ driver.findElement(ClassResulLocaltor).getText());
			
		}
		else 
		{
			System.out.print("No se pudo entrar a la página");
			
		}
		
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
		
	}
	
}

