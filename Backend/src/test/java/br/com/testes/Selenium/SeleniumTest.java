package br.com.testes.Selenium;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver nav;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.operadriver().setup();
    }

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","/WebDrivers/bin/ChromeDriver.exe");
        nav = new ChromeDriver();
    }

    @Test
    void criaUmNovo() {
        nav.get("http://localhost:3000/");
                nav.manage().window().maximize();
        nav.findElement(By.id("botao-insert")).click();
        nav.findElement(By.name("InputName")).sendKeys("Gabriel Pensador");
        nav.findElement(By.name("InputEmail")).sendKeys("ta_no_osso@mail.com");
        nav.findElement(By.name("InputTelefone")).sendKeys("9346578");
        nav.findElement(By.name("botao-form-confirmar")).click();

        Assertions.assertThat(nav.findElement(By.id("alert")).isDisplayed());
    }
}
