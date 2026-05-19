package raizes.statements;

import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import raizes.Conexao;

import java.time.Duration;

public class quando {

    @Quando("faco o login no sistema na filial de {string}")
    public void facoLoginNoSistema(String unidade){
        WebDriver driver = Conexao.getDriver();
        String user = Conexao.pegarDado("nomeUser");
        driver.findElement(By.xpath("//input[@placeholder='Usuário']")).sendKeys(user);
        Conexao.tirarPrint("Define o usuario >>" + user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String senha = Conexao.pegarDado("senha");
        driver.findElement(By.xpath("//input[@placeholder='Senha']")).sendKeys(senha);
        Conexao.tirarPrint("Click em senha >> " + senha);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement campoSelect = driver.findElement(By.xpath("//select[@id='unidade']"));
        Select dropdown = new Select(campoSelect);
        dropdown.selectByVisibleText(unidade);
        Conexao.tirarPrint("Seleciona a unidade >>" + unidade);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
        Conexao.tirarPrint("Click em logar");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
