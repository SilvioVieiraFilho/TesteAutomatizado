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

        //Dado que o navegador está aberto

        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        //E o usuário acessa a URL "https://demo.automationtesting.in/Index.html"
        navegador.get("https://demo.automationtesting.in/Index.html");
        //Quando o usuário clica no botão "Sign In"
        navegador.findElement(By.id("btn1")).click();
        // E preenche o campo de e-mail com "nino_silvio@hotmail.com"
        navegador.findElement(By.xpath("//input[@ng-model='Email']")).sendKeys("nino_silvio@hotmail.com");
        // E preenche o campo de senha com "12345"
        navegador.findElement(By.xpath("//input[@ng-model='Password']")).sendKeys("12345");
        //E clica no botão "Enter"
        navegador.findElement(By.id("enterbtn")).click();
        //Então uma mensagem de erro "Invalid User Name or PassWord" deve ser exibida
        WebElement mensagemDeErro = navegador.findElement(By.id("errormsg"));
        String textErro = mensagemDeErro.getText();
        System.out.println("Texto retornado: " + textErro);
        Assert.assertEquals("Invalid User Name or PassWord", textErro);


    }
}
