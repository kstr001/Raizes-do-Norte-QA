package raizes.statements;

import io.cucumber.java.pt.E;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import raizes.Conexao;

import java.time.Duration;

public class entao {

    public String gerarTextoAleatorioCurto() {
        return java.util.UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 8);
    }

    public String gerarEmailAleatorio() {
        String sufixoAleatorio = java.util.UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 8);
        return "teste_" + sufixoAleatorio + "@mailinator.com";
    }

    public String gerarSenhaAleatoria() {
        return "Senha" + java.util.UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 6);
    }

    @E("que cadastro um novo usuario")
    public void cadastrarUsuario(){
        WebDriver driver = Conexao.getDriver();
        driver.findElement(By.xpath("//button[contains(.,'Novo Cadastro')]")).click();
        Conexao.tirarPrint("Click em [ Novo Cadastro ]");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String nome = "User_"+gerarTextoAleatorioCurto();
        Conexao.salvarDado("nomeUser", nome);
        driver.findElement(By.xpath("//input[@placeholder='Nome Completo']")).sendKeys(nome);
        Conexao.tirarPrint("Seta o Nome Completo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String email = gerarEmailAleatorio();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        Conexao.tirarPrint("Seta email do usuario");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@placeholder='Escolha um Usuário']")).sendKeys(nome);
        Conexao.tirarPrint("Seta Nome do usuario");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String senha = gerarSenhaAleatoria();
        Conexao.salvarDado("senha", senha);
        driver.findElement(By.xpath("//input[@placeholder='Crie uma Senha']")).sendKeys(senha);
        Conexao.tirarPrint("Seta Senha do usuario");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[contains(.,'Finalizar Cadastro')]")).click();
        Conexao.tirarPrint("Click em [ Finalizar Cadastro ]");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
        Conexao.tirarPrint("Click em [ OK ]");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}