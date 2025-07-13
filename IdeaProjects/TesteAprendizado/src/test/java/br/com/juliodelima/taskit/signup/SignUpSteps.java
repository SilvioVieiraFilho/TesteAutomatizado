package br.com.juliodelima.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpSteps {

    private WebDriver navegador;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (navegador != null) {
            navegador.quit();
        }
    }

    @Dado("que o navegador está aberto")
    public void queONavegadorEstaAberto() {
        // Navegador já está aberto no Before
    }

    @Dado("o usuário acessa a URL {string}")
    public void oUsuarioAcessaAURL(String url) {
        navegador.get(url);
    }

    @Quando("o usuário clica no botão {string}")
    public void oUsuarioClicaNoBotao(String botaoId) {
        navegador.findElement(By.id(botaoId.toLowerCase())).click();
    }

    @Quando("preenche o campo de e-mail com {string}")
    public void preencheOCampoDeEmailCom(String email) {
        navegador.findElement(By.xpath("//input[@ng-model='Email']")).sendKeys(email);
    }

    @Quando("preenche o campo de senha com {string}")
    public void preencheOCampoDeSenhaCom(String senha) {
        navegador.findElement(By.xpath("//input[@ng-model='Password']")).sendKeys(senha);
    }

    @Quando("clica no botão {string}")
    public void clicaNoBotao(String botaoId) {
        navegador.findElement(By.id(botaoId.toLowerCase())).click();
    }

    @Então("uma mensagem de erro {string} deve ser exibida")
    public void umaMensagemDeErroDeveSerExibida(String mensagemEsperada) {
        WebElement mensagemDeErro = navegador.findElement(By.id("errormsg"));
        String textoErro = mensagemDeErro.getText();
        Assert.assertEquals(mensagemEsperada, textoErro);
    }
}
