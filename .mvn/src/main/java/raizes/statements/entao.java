package raizes.statements;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.opentelemetry.semconv.UrlAttributes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    @E("entro no cardapio")
    public void entrarCardapio() throws InterruptedException {
        WebDriver driver = Utils.getDriver();
        driver.findElement(By.xpath("//button[@onclick='abrirCardapio()'][contains(.,'Cardápio')]")).click();
        Utils.tirarPrint("Click em [ Cardapio ]");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[contains(.,'Ver Cardápio Completo')])[2]")).click();
        Utils.tirarPrint("Click em [ Ver Cardapio ]");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(.,'Bebidas')]")).click();
        Utils.tirarPrint("Click em [ Bebidas ]");
        Thread.sleep(1000);
        Utils.tirarPrint("Print da seleção de Bebidas");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(.,'Especiais')]")).click();
        Utils.tirarPrint("Click em [ Especiais ]");
        Thread.sleep(1000);
        Utils.tirarPrint("Print da seleção de Especiais");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(.,'Comidas')]")).click();
        Utils.tirarPrint("Click em [ Comidas ]");
        Thread.sleep(1000);
        Utils.tirarPrint("Print da seleção de Comidas");
        Thread.sleep(1000);
    }

    @E("escolho 2 tapiocas")
    public void escolho2Tapiocas() throws InterruptedException {
        WebDriver driver = Utils.getDriver();
        for (int i = 0; i < 2; i++){
            driver.findElement(By.xpath("//div[@class='produto'][contains(.,'Tapioca ')]")).click();
            Utils.tirarPrint("Click no produto [ Tapioca ]");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@onclick='adicionarCarrinho()'][contains(.,'Adicionar ao Carrinho')]")).click();
            Utils.tirarPrint("Click em adicionar ao Carrinho");
            Thread.sleep(3000);
            if (i == 0){
                driver.findElement(By.xpath("(//button[contains(.,'Voltar')])[2]")).click();
                Utils.tirarPrint("Click em Voltar");
                Thread.sleep(3000);
            }
        }
    }

    @E("escolho o endereco {string} {string}")
    public void escolhoOEndereco(String cep, String numero) throws InterruptedException {
        WebDriver driver = Utils.getDriver();
        driver.findElement(By.xpath("//button[contains(.,'Ir para definir o endereço')]")).click();
        Utils.tirarPrint("Click em [ Ir para o definir endereço ]");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@placeholder,'CEP')]")).sendKeys(cep);
        Utils.tirarPrint("Digitando CEP >> " + cep);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Número')]")).sendKeys(numero);
        Utils.tirarPrint("Digitando numero >> " + numero);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(.,'Continuar')]")).click();
        Utils.tirarPrint("Click para ir ao pagamento");
        Thread.sleep(3000);
    }

    @Entao("solicio a atulizacao do status de pagamente externo sucesso")
    public void solicioAatulizacaoDoStatusDePagamentoSucesso() throws InterruptedException {
        WebDriver driver = Utils.getDriver();
        for (int i = 0; i < 5; i++){
            driver.findElement(By.xpath("//button[contains(.,'Pagar')]")).click();
            Utils.tirarPrint("Click em [ Pagar ]");
            Thread.sleep(5000);
            java.util.List<WebElement> mensagens = driver.findElements(By.xpath("(//div[contains(.,'Pedido #1')])[1]"));
            Utils.tirarPrint("Resultasdo do Status do pagamento");
            if (!mensagens.isEmpty()){
                System.out.println("Pagamento sucesso");
                System.out.println("Seguindo para a tela de prepara/entrega");
                break;
        }
            System.out.println("Erro ao consultar pagamento tentando novamente");
        }
    }
}