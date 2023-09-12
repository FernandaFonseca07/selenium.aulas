package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSeleniumAlertas {
    static WebDriver driver;

    @BeforeClass
    public static void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    @Test
    public void alertaSimplesTeste() {
        driver.findElement(By.xpath("// button[contains(text(),'alert box:')]")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAtual = alert.getText();
        String mensagemEsperada = "I am an alert box!";
        alert.accept();
        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void alertaConfirmarOuCancelar() {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
        Alert alert = driver.switchTo().alert();
        String mensagemAtual = alert.getText();
        String mensagemEsperada = "Press a Button !";
        alert.dismiss();
        Assert.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @Test
    public void alertaComPrompt() {
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Testando alertas com prompt");
        alert.accept();
    }

    @AfterClass
    public static void fechar() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();
    }

}
