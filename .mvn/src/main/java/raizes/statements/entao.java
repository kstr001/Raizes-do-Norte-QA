package raizes.statements;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import raizes.Utils;

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
        WebDriver driver = Utils.getDriver();
        driver.findElement(By.xpath("//button[contains(.,'Novo Cadastro')]")).click();
        Utils.tirarPrint("Click em [ Novo Cadastro ]");
        Thread.sleep(3000);
        String nome = "User_"+gerarTextoAleatorioCurto();
        Utils.salvarDado("nomeUser", nome);
        driver.findElement(By.xpath("//input[@placeholder='Nome Completo']")).sendKeys(nome);
        Utils.tirarPrint("Seta o Nome Completo");
        Thread.sleep(1000);
        String email = gerarEmailAleatorio();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
        Utils.tirarPrint("Seta email do usuario");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Escolha um Usuário']")).sendKeys(nome);
        Utils.tirarPrint("Seta Nome do usuario");
        Thread.sleep(1000);
        String senha = gerarSenhaAleatoria();
        Utils.salvarDado("senha", senha);
        driver.findElement(By.xpath("//input[@placeholder='Crie uma Senha']")).sendKeys(senha);
        Utils.tirarPrint("Seta Senha do usuario");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@type,'checkbox')]")).click();
        Utils.tirarPrint("Click em [ Aceitar termos de uso ]");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(.,'Finalizar Cadastro')]")).click();
        Utils.tirarPrint("Click em [ Finalizar Cadastro ]");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
        Utils.tirarPrint("Click em [ OK ]");
        Thread.sleep(3000);
    }
    @Entao("verifico se o usuario esta logado")
    public void verificarUsuarioLogado() throws InterruptedException {
        WebDriver driver = Utils.getDriver();
        String nome = Utils.pegarDado("nomeUser");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h1[contains(.,'Bem-vindo, " + nome + "')]"));
        Utils.tirarPrint("O usuario " + nome + " esta logado");
    }
}