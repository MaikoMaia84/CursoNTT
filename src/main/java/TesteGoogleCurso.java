
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogleCurso {
	@Test
	public void teste() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");
		// System.out.println(driver.getTitle());

		Assert.assertEquals("Google", driver.getTitle());

		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("ntt data");// informa campo de busca ntt
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);// realiza a busca
		driver.findElement(By.xpath(
				"//*[substring(text(), string-length(text()) - string-length('NTT DATA: Global IT Services Provider & Consultant') + 1) = 'NTT DATA: Global IT Services Provider & Consultant']"))
				.click();// busca elemento NTT - DATA na pagina e clica

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		Thread.sleep(5000);

		// WebDriverWait firstResult = new WebDriverWait(driver, null, null, 10, 10);
		// WebDriverWait firstResult2 = new WebDriverWait(driver, 2000, 2000);

		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Cookie Banner']"));// muda para iframe
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[@class='intro-banner-btn save-consents evSpAcceptBtn']")).click();
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//a[contains(.,'Careers')]")).click();// criando xpath para carrers
		driver.findElement(By.xpath("//a[contains(.,'Job opportunities')]")).click();

		// a[@class='navbar-link has-children collapsed is-active']

		// driver.switchTo().newWindown(WindownType.TAB);

		// Loop through until we find a new window handle
		String originalWindow = driver.getWindowHandle();

		Thread.sleep(5000);

		// Loop through until we find a new window handle

		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}

		}
		Thread.sleep(5000);//gambi

		WebElement iframe2 = driver.findElement(By.xpath("//iframe[@title='Cookie Banner']"));// muda para iframe
		driver.switchTo().frame(iframe2);
		driver.findElement(By.xpath("//button[@class='intro-banner-btn save-consents evSpAcceptBtn']")).click();
		driver.switchTo().defaultContent();
	
		driver.findElement(By.xpath("//input[@name='sGlobal']")).sendKeys("PESSOA ENGENHEIRA DE DADOS");//informa busca no campo id do textarea
	    driver.findElement(By.xpath("//input[@name='sGlobal']")).sendKeys(Keys.ENTER);
	    
	    Thread.sleep(5000); 
	    
		String texto = driver.findElement(By.xpath("//a[contains(.,'Pessoa Engenheira de Dados - Híbrido')]")).getText().toUpperCase();//vefifica se achou Pessoa Engenheira de Dados - Híbrido
		Assert.assertEquals("PESSOA ENGENHEIRA DE DADOS - HÍBRIDO", texto);	
		driver.close();
		//driver.quit();
	}

}
