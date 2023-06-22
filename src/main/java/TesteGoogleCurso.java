
//import java.util.ArrayList;
//import java.util.List;

//import org.junit.After;
import org.junit.Assert;
//import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Duration;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogleCurso {
	
	public WebDriver driver;
	
	
	/*@Before
	public void inicializa() {
	}
	
	
	@After  //ao finalizar o teste
	public void finalize(){
		driver.close();
	}
	  */
	 
	@Test
	public void teste() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
		WebDriver driver = new ChromeDriver();//abre navagador
	
		driver.get("http://www.google.com");//google
		Assert.assertEquals("Google", driver.getTitle());//verifica se está no google
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("ntt data");// informa campo de busca ntt com  xpath copia e cola
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);// realiza a busca
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/div/a/div/div/span")).click();//realiza a busca pelo resultado xpath 
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		Thread.sleep(5000);//aguarda pagina
		
		
		
		//Pesquisa no iframe
		// WebDriverWait firstResult2 = new WebDriverWait(driver, 2000, 2000);
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Cookie Banner']"));// muda para 0 iframe do cookie
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[@class='intro-banner-btn save-consents evSpAcceptBtn']")).click();
		driver.switchTo().defaultContent(); //retorna para a tela principal
		driver.findElement(By.xpath("//a[contains(.,'Careers')]")).click();// criando xpath para carrers
		driver.findElement(By.xpath("//a[contains(.,'Job opportunities')]")).click();//criando xpath para Job opportunities

		
		
		//abre nova janela
		String originalWindow = driver.getWindowHandle();//para trocar de janela
		Thread.sleep(5000); //espera carregar 
		for (String windowHandle : driver.getWindowHandles()) {//para trocar de aba no chrome 
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		Thread.sleep(5000);//espera carregar 
		WebElement iframe2 = driver.findElement(By.xpath("//iframe[@title='Cookie Banner']"));// muda para iframe
		driver.switchTo().frame(iframe2);
		driver.findElement(By.xpath("//button[@class='intro-banner-btn save-consents evSpAcceptBtn']")).click();//clica no xpath do banner
		driver.switchTo().defaultContent();// retonar para a tela principalL 
	
		

		
		//Pesquisa Final
		driver.findElement(By.xpath("//input[@name='sGlobal']")).sendKeys("PESSOA ENGENHEIRA DE DADOS");//informa busca no campo id do textarea
	    driver.findElement(By.xpath("//input[@name='sGlobal']")).sendKeys(Keys.ENTER); //enter para prosseguir 
	    Thread.sleep(5000);// aguarda novamente a consulta 
		String texto = driver.findElement(By.xpath("//a[contains(.,'Pessoa Engenheira de Dados - Híbrido')]")).getText().toUpperCase();//verifica se achou Pessoa Engenheira de Dados - Híbrido uper para deixar maiuscula o resultado.
		Assert.assertEquals("PESSOA ENGENHEIRA DE DADOS - HÍBRIDO", texto);	//Assert para verificar se encontrou
		//driver.close(); //fecha o navegador, 
		//driver.quit() da erro 
		
	}

}
