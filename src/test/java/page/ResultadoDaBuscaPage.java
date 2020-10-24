package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoDaBuscaPage extends BasePage {
	final String COOKIES = "//button[@id='lgpd-accept']";
	final String NOTEBOOK = "//picture[1]/img[contains(@src,'https://images-americanas.b2w.io/produtos/01/00/offers/01/00/item/132490/7/132490742_1GG.png')]";
	
	
	
	public ResultadoDaBuscaPage(WebDriver driver) {
		super(driver);
	}

	public void clicaNotebook() throws IOException {
		logger.info("clicaNotebook");
		driver.findElement(By.xpath(NOTEBOOK))
				.click();
		takeScreenShot("Clica Notebook");

	}
	
	public void clicaCookies() throws IOException {
		logger.info("clicaNotebook");
		driver.findElement(By.xpath(COOKIES))
				.click();
		takeScreenShot("Clica Cookies");

	}
	
}
