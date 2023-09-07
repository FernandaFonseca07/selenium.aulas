package qaacademy;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSelenium {
    static WebDriver driver;

    @Test
    public void exercicioFormulario() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Fernanda");
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Fonseca");
        driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys("Brazil");
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("fernandafonseca@gmail.com");
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("1234-5678");
    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
