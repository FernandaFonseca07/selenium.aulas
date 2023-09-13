package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSelenium_novaTab {
    static WebDriver driver;

    @BeforeClass
    public static void antes (){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Windows.html");

    }

    @Test
    public void abrirNovaTab (){
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.linkText("click")).click();
        Object [] janelas = driver.getWindowHandles().toArray(); //mapeando janelas abertas
        driver.switchTo().window(janelas[1].toString()); //faz a troca de janela
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/"));

        //voltando para a outra janela e selecionando outra opção
        driver.switchTo().window(janelas[0].toString());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[contains(text(),'Open New Seperate Windows')]")).click();
        driver.findElement(By.xpath("//*[@id='Seperate']/button")).click();
        Object [] janela2 = driver.getWindowHandles().toArray();
        driver.switchTo().window(janela2[2].toString());
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/"));

    }

    @AfterClass
    public static void after () throws InterruptedException{
        Thread.sleep(2500);
        driver.quit();
    }


}
