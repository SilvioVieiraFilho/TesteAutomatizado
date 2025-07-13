package br.com.juliodelima.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Testes automatizados da funcionalidade signup")

public class SignUpTests {


    @Test
    @DisplayName("registrar um novo usuario com dados validos")
    public void testRegistrarUmNovousuarioComDadosValidos() {

        //Dado que eu acesse o chrome

        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        //E entro na minha url
        navegador.get("https://demo.automationtesting.in/Index.html");
        //E  clico no botão
        navegador.findElement(By.id("btn1")).click();
        // E preencha o texto do email
        navegador.findElement(By.xpath("//input[@ng-model='Email']")).sendKeys("nino_silvio@hotmail.com");
        // E preencha a senha
        navegador.findElement(By.xpath("//input[@ng-model='Password']")).sendKeys("12345");
        //Quando clicar no botão
        navegador.findElement(By.id("enterbtn")).click();
        //Então me retornara uma mensagem invalida
        WebElement mensagemDeErro = navegador.findElement(By.id("errormsg"));
        String textErro = mensagemDeErro.getText();
        System.out.println("Texto retornado: " + textErro);
        Assert.assertEquals("Invalid User Name or PassWord", textErro);


    }
}
