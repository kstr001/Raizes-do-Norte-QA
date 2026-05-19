package raizes.statements;

import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import raizes.Conexao;

import java.time.Duration;

public class quando {

    @Quando("faco o login no sistema")
    public void facoLoginNoSistema(){
        WebDriver driver = Conexao.getDriver();
        String user = Conexao.pegarDado("nomeUser");
        driver.findElement(By.xpath("//input[@placeholder='Usuário']")).sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String senha = Conexao.pegarDado("senha");
        driver.findElement(By.xpath("//input[@placeholder='Senha']")).sendKeys(senha);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement campoSelect = driver.findElement(By.xpath("//select[@id='unidade']"));
        Select dropdown = new Select(campoSelect);
        dropdown.selectByVisibleText("Curitiba");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[contains(.,'Entrar')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
