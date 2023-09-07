package qaacademy;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrincipaisComandosSelenium {
    static WebDriver driver;

    @Test
    public void testeSeleniumClickLinkedIn() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.qaacademy.com.br/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='mQxxMq bqbmwD Pg7AcP dukD6Z ']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='img_1_comp-k0wqferu']")).click();
    }

    @Test
    public void testeSeleniumClickInstagram() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.qaacademy.com.br/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='mQxxMq bqbmwD Pg7AcP dukD6Z ']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//wow-image[@id='img_0_comp-k0wqferu']")).click();
    }

    @Test
    public void testeSeleniumTextoDigitado() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.qaacademy.com.br/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='mQxxMq bqbmwD Pg7AcP dukD6Z ']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@placeholder='Nome']")).sendKeys("Fernanda Fonseca");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("fernanda_fonseca0107@hotmail.com");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='comp-k37gdiro']")).click();
    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}