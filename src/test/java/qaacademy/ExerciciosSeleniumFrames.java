package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciciosSeleniumFrames {
    static WebDriver driver;

    @BeforeClass
    public static void before () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Frames.html");
    }

    @Test
    public void testeFrames() {
        driver.switchTo().frame("singleframe"); //muda o contexto do driver para o frame
        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Teste QA Academy - Fe");
        driver.switchTo().defaultContent(); //voltar para o contexto anterior
    }
    
    @AfterClass
    public static void after () throws InterruptedException{
        Thread.sleep(2500);
        driver.quit();
    }
}
