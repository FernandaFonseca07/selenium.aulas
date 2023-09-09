package qaacademy;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("(11) 5875-3658");

        // Selecionando os boxes de opções
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='FeMale']")).click();
        ;
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='FeMale']")).isSelected());

        driver.findElement(By.xpath("//*[@value='Movies']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Movies']")).isSelected());

        // // language button
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//div[@id='msdd']")).click();

        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
        // driver.findElement(By.xpath("//a[contains(text(),'Portuguese')]")).click();

        // Thread.sleep(2000);

        // boolean linguagemPortugueseSelecionada = driver.findElement(By.xpath("//div [contains(text(), 'Portuguese') and @class='ui-autocomplete-multiselect-item']")).isDisplayed();
        // boolean linguagemEnglishSelecionada = driver.findElement(By.xpath("//div [contains(text(), 'English') and @class='ui-autocomplete-multiselect-item']")).isDisplayed();
        // Assert.assertTrue(linguagemPortugueseSelecionada && linguagemEnglishSelecionada);


        // driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[8]/label")).click();
        
        // Skills modo que eu fiz e funcionou
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//*[@ng-model='Skill']")).click();
        // Thread.sleep(500);
        // driver.findElement(By.xpath("//*[@value='Adobe Photoshop']")).click();
        // Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Adobe Photoshop']")).isSelected());

        //Skills com select
        // WebElement selectElement = driver.findElement (By.xpath("[@ng-model='Skill']"));
        Select selectObject = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
        selectObject.selectByVisibleText("Adobe Photoshop");

        driver.findElement(By.xpath("//label[contains(text(),'Select Country :')]")).click();

        // Country
        // Thread.sleep(1000);
        // driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//li[contains(text(),'Japan')]")).click();
        // Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Japan')]")).isSelected());

        Select selectCountry = new Select(driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[10]/div/span/span[1]/span")));
        selectCountry.selectByVisibleText("Japan");

        // Year
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@placeholder='Year']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='1997']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='1997']")).isSelected());

        // Month
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@placeholder='Month']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='April']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='April']")).isSelected());

        // Day
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@placeholder='Day']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@value='1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='1']")).isSelected());

        // password
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@ng-model='Password']")).sendKeys("Qaacademyteste");
        driver.findElement(By.xpath("//*[@ng-model='CPassword']")).sendKeys("Qaacademyteste");

        // Submit
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='submitbtn']")).click();

    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
