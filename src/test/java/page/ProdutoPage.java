package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage extends BasePage {

	final String PRECO_NOTEBOOK = "//*[@id=\"content\"]/div/div/div[2]/div/section/div/div[2]/div[2]/div/div[1]/div[1]/div/div[1]/div/div/span";
	final String PRECO_NOTEBOOK_CSS = "#content > div > div > div.GridUI-wcbvwm-0.idBPEj.ViewUI-sc-1ijittn-6.iXIDWU > div > section > div > div.product-main-area__ProductMainAreaUI-sc-1xcgrsz-0.kcqktA.ViewUI-sc-1ijittn-6.iXIDWU > div.offer-box__Wrapper-sc-1hat60-0.dKwBwA.ViewUI-sc-1ijittn-6.iXIDWU > div > div.buybox__BigSection-sc-4z0zqv-1.itEiUd.ViewUI-sc-1ijittn-6.iXIDWU > div:nth-child(1) > div > div.main-offer__ContainerUI-sc-1c7pzd1-1.iNXNAo.ViewUI-sc-1ijittn-6.iXIDWU > div > div > span";
	public ProdutoPage(WebDriver driver) {
		super(driver);
	}

	public String retornaValorProduto() throws Exception {
		logger.info("Retorna Valor do Produto");
		takeScreenShot("Retorna Valor do Produto");
		String valorProduto;
		try {
			valorProduto = driver.findElement(By.xpath(PRECO_NOTEBOOK)).getText();
		} catch (Exception e) {
			valorProduto = driver.findElement(By.cssSelector(PRECO_NOTEBOOK_CSS)).getText();
		}
		return valorProduto;
	}

	public void preencheClicaCep() {
		driver.findElement(By.xpath("//input[@id='freight-field']")).sendKeys("05346-000");
		driver.findElement(By.xpath("//span[contains(text(),'Ok')]")).click();

	}

	public void confirmaVoltagemProduto() {
		driver.findElement(By.xpath("//span[contains(text(),'Sim, continuar')]"));

	}

	private void clicarComprarProduto() {
		driver.findElement(By.xpath("//span[contains(text(),'comprar')]"));
	}

}
