package qaacademy;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExercicioSeleniumScreenshot {
    static WebDriver driver;

    @BeforeClass
    public static void antes() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Alerts.html");

    }

    @Test
    public void alertaSimplesTeste() throws IOException {
        screenshots("Alerta Simples");
        driver.findElement(By.xpath("// button[contains(text(),'alert box:')]")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAtual = alert.getText();
        String mensagemEsperada = "I am an alert box!";
        alert.accept();
        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void alertaConfirmarOuCancelar() throws IOException {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        screenshots("Alerta Confirmar e Cancelar");
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAtual = alert.getText();
        String mensagemEsperada = "Press a Button !";
        alert.dismiss();
        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void alertaComPrompt() throws IOException {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        screenshots("Alerta com Prompt");
        driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]"))
                .click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Testando alertas com prompt");
        alert.accept();
    }

    public void screenshots(String nomeScreenshot) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver; // Convertendo o driver em TakesScreenshot
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE); // Tira o screenshot e transforma
        FileUtils.copyFile(arquivo, new File("output" + File.separator + nomeScreenshot + "_screenshot.jpg")); // criar diretorio output e criar arquivo
                                                                        // output/screenshot.jpg
    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }

}
