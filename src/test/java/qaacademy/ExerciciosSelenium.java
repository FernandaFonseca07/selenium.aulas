package qaacademy;

import org.junit.AfterClass;
import org.junit.Assert;
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

        // Selecionando os boxes de opções
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='FeMale']")).click();
        ;
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='FeMale']")).isSelected());

        driver.findElement(By.xpath("//*[@value='Movies']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Movies']")).isSelected());

       
        // language button
        // Thread.sleep(1000);
        // driver.findElement(By.xpath("//div[@id='msdd']")).click();

        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();

        // Thread.sleep(2000);
        // Assert.assertTrue("Elemento não selecionado",
        // driver.findElement(By.xpath("//a[contains(text(),'English')]")).isSelected());

        //Skills 
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@ng-model='Skill']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@value='Adobe Photoshop']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Adobe Photoshop']")).isSelected());

    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
