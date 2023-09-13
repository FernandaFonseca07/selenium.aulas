package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ExercicioSeleniumDragandDrop {
    static WebDriver driver;

    @BeforeClass
    public static void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Static.html");
    }

    @Test
    public void testeDragAndDrop() {
        WebElement elementoUM = driver.findElement(By.id("node")); //elemento que será jogado
        WebElement areaDestino = driver.findElement(By.id("droparea")); //area destino do elemento
        Actions actionProvider = new Actions(driver); //Instancia do ActionProvider
        actionProvider.dragAndDrop(elementoUM, areaDestino).build().perform();

        WebElement elementoDois = driver.findElement(By.id("mongo"));
        actionProvider.dragAndDrop(elementoDois, areaDestino).build().perform();

        WebElement elementoTres = driver.findElement(By.id("angular"));
        actionProvider.dragAndDrop(elementoTres, areaDestino).build().perform();
    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(2500);
        driver.quit();

    }

}
