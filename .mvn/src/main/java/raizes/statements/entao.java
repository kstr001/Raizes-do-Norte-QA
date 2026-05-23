package raizes.statements;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
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
    public void cadastrarUsuario() throws InterruptedException {
        WebDriver driver = Conexao.getDriver();
        driver.findElement(By.xpath("//button[contains(.,'Novo Cadastro')]")).click();
        Conexao.tirarPrint("Click em [ Novo Cadastro ]");
        Thread.sleep(3000);
        String nome = "User_"+gerarTextoAleatorioCurto();
        Conexao.salvarDado("nomeUser", nome);
        driver.findElement(By.xpath("//input[@placeholder='Nome Completo']")).sendKeys(nome);
        Conexao.tirarPrint("Seta o Nome Completo");
        Thread.sleep(2000);
        String email = gerarEmailAleatorio();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        Conexao.tirarPrint("Seta email do usuario");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Escolha um Usuário']")).sendKeys(nome);
        Conexao.tirarPrint("Seta Nome do usuario");
        Thread.sleep(2000);
        String senha = gerarSenhaAleatoria();
        Conexao.salvarDado("senha", senha);
        driver.findElement(By.xpath("//input[@placeholder='Crie uma Senha']")).sendKeys(senha);
        Conexao.tirarPrint("Seta Senha do usuario");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,'Finalizar Cadastro')]")).click();
        Conexao.tirarPrint("Click em [ Finalizar Cadastro ]");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
        Conexao.tirarPrint("Click em [ OK ]");
        Thread.sleep(3000);
    }
    @Entao("verifico se o usuario esta logado")
    public void verificarUsuarioLogado() throws InterruptedException {
        WebDriver driver = Conexao.getDriver();
        String nome = Conexao.pegarDado("nomeUser");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//h1[contains(.,'Bem-vindo, " + nome + "')]"));
        Conexao.tirarPrint("O usuario " + nome + " esta logado");
    }
}