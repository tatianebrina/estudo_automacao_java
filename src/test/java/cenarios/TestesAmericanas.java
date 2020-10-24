package cenarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.MidiDevice.Info;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utils.LeitorJson;
import exceptions.ElementoNaoEncontradoException;
import page.BasePage;
import page.HomePage;
import page.ProdutoPage;
import page.ResultadoDaBuscaPage;

public class TestesAmericanas {
	@Rule
	public TestName testName = new TestName(); // Devolve o nome do meu @Teste

	WebDriver driver;
	HomePage homePage;
	ResultadoDaBuscaPage resultadoDabuscaPage;
	ProdutoPage produtoPage;
	public static final Logger logger = Logger.getLogger(TestesAmericanas.class);
	long inicioTeste;
	long fimTeste;
	LeitorJson leitorMassa;

	@Before
	public void before() throws IOException {
		inicioTeste = System.currentTimeMillis();
		leitorMassa = new LeitorJson();
		leitorMassa.leitorJson();
		verificaSistemaOperacionalESetaChromeDriver();
		configuraChromeDriver();
		homePage = new HomePage(driver);
		resultadoDabuscaPage = new ResultadoDaBuscaPage(driver);
		produtoPage = new ProdutoPage(driver);

	}

	@After
	public void fecharSite() {
		driver.quit();
		fimTeste = System.currentTimeMillis();

		logger.info("Teste: " + testName + " Finalizado com Sucesso!");
		logger.info("Tempo de execução: " + calculaTempoExecucao(inicioTeste, fimTeste) + " - segundos");

	}

	@Test
	public void buscarNotebook() throws IOException {
		try {
			String preco = leitorMassa.getMassa("preço");
			homePage.abrirUrl(leitorMassa.getMassa("url"));
			homePage.realizarBuscaProdutoEClica(leitorMassa.getMassa("produto"));
			resultadoDabuscaPage.clicaCookies();
			resultadoDabuscaPage.clicaNotebook();
			String valorSite = produtoPage.retornaValorProduto();
			logger.info("Valor Retornado: " + valorSite);
			logger.info(preco);
			assertEquals("Valor diferente do que o esperado:", preco, valorSite);

		} catch (Exception e) {
			logger.info(e.getStackTrace() + " " + e.getMessage());
			fail();
		}

	}

	/**
	 * Configura o Chrome Driver com espera Implicita de até 60 Segundos
	 */
	private void configuraChromeDriver() {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments(
//				   "--headless",
				"--disable-web-security", "--ignore-certificate-errors", "--disable-gpu", "window-size=1200x600",
				"disable-popup-blocking", "disable-infobars");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	private void verificaSistemaOperacionalESetaChromeDriver() {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			System.setProperty("webdriver.chrome.driver", "chromedriverWin/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "chromedriverLix/chromedriver");
		}
	}

	public Long calculaTempoExecucao(long inicio, long fim) {
		return (fim - inicio) / 1000;

	}

	/**
	 * criar o metodo para ler o json
	 * 
	 * @throws IOException
	 */
	@Test
	public void leitorJson() throws IOException {
		LeitorJson leitorJson = new LeitorJson();
		leitorJson.leitorJson();
		leitorJson.getMassa("url");

		// TODO Auto-generated method stub

	}

}
