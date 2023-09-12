package qaacademy;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciciosSelenium {
    static WebDriver driver;

    @BeforeClass
    public static void iniciaTeste() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Register.html");

    }

    @Test
    public void exercicioFormulario() throws InterruptedException {
        driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Fernanda");
        driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Fonseca");
        driver.findElement(By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea")).sendKeys("Brazil");
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("fernandafonseca@gmail.com");
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("1234567890");

        // Selecionando os boxes de opções
        driver.findElement(By.xpath("//*[@value='FeMale']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='FeMale']")).isSelected());

        driver.findElement(By.xpath("//*[@value='Movies']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='Movies']")).isSelected());

        // // language button
        driver.findElement(
                By.xpath("//div[@id='msdd' and @class='ui-autocomplete-multiselect ui-state-default ui-widget']"))
                .click();

        driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Portuguese')]")).click();

        boolean linguagemPortugueseSelecionada = driver
                .findElement(
                        By.xpath("//div[contains(text(), 'Portuguese') and @class='ui-autocomplete-multiselect-item']"))
                .isDisplayed();
        boolean linguagemEnglishSelecionada = driver
                .findElement(
                        By.xpath("//div[contains(text(), 'English') and @class='ui-autocomplete-multiselect-item']"))
                .isDisplayed();
        Assert.assertTrue(linguagemPortugueseSelecionada && linguagemEnglishSelecionada);

        // Skills com select
        // WebElement selectElement = driver.findElement
        // (By.xpath("[@ng-model='Skill']"));
        Select selectObject = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
        selectObject.selectByVisibleText("Adobe Photoshop");

        // Country
        driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();
        driver.findElement(By.xpath("//li[contains(text(),'Japan')]")).click();
        Assert.assertTrue(
                driver.findElement(By.xpath("//span[contains(text(), 'Japan') and @id='select2-country-container']"))
                        .isDisplayed());

        // Year
        driver.findElement(By.xpath("//*[@placeholder='Year']")).click();
        driver.findElement(By.xpath("//*[@value='1997']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='1997']")).isSelected());

        // Month
        driver.findElement(By.xpath("//*[@placeholder='Month']")).click();
        driver.findElement(By.xpath("//*[@value='April']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='April']")).isSelected());

        // Day
        driver.findElement(By.xpath("//*[@placeholder='Day']")).click();
        driver.findElement(By.xpath("//*[@value='1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='1']")).isSelected());

        // password
        driver.findElement(By.xpath("//*[@ng-model='Password']")).sendKeys("Qaacademyteste");
        driver.findElement(By.xpath("//*[@ng-model='CPassword']")).sendKeys("Qaacademyteste");

        // Submit
        driver.findElement(By.xpath("//*[@id='submitbtn']")).click();

        String msgErroTelefone = "Portuguese";
        Assert.assertTrue("Linguagem", driver.getPageSource().contains(msgErroTelefone));

    }

    @AfterClass
    public static void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
