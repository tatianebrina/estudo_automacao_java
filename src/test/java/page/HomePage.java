package page;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import exceptions.ElementoNaoEncontradoException;

public class HomePage {
	WebDriver driver;

public HomePage(WebDriver driver) {
		this.driver = driver;
	}

public void abrirUrl(String url) {
	driver.get(url);

}

public void realizarBuscaProdutoEClica(String produto) throws ElementoNaoEncontradoException{
	
		driver.findElement(By.cssSelector("#h_search-input")).sendKeys(produto);
		driver.findElement(By.xpath("//button[@id='h_search-btn']")).click();
	

}

		
}
