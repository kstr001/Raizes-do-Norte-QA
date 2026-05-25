package raizes.statements;

import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import raizes.Utils;

public class quando {

    @Quando("faco o login no sistema na filial de {string}")
    public void facoLoginNoSistema(String unidade) throws InterruptedException {
        WebDriver driver = Utils.getDriver();
        String user = Utils.pegarDado("nomeUser");
        driver.findElement(By.xpath("//input[@placeholder='Usuário']")).sendKeys(user);
        Utils.tirarPrint("Define o usuario >>" + user);
        Thread.sleep(1000);
        String senha = Utils.pegarDado("senha");
        driver.findElement(By.xpath("//input[@placeholder='Senha']")).sendKeys(senha);
        Utils.tirarPrint("Click em senha >> " + senha);
        Thread.sleep(1000);
        WebElement campoSelect = driver.findElement(By.xpath("//select[@id='unidade']"));
        Select dropdown = new Select(campoSelect);
        dropdown.selectByVisibleText(unidade);
        Utils.tirarPrint("Seleciona a unidade >>" + unidade);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
        Utils.tirarPrint("Click em logar");
        Thread.sleep(3000);
    }
}
