package raizes.statements;

import io.cucumber.java.pt.Dado;
import org.openqa.selenium.WebDriver;
import raizes.Utils;

public class dado {

    @Dado("que acesso o sistema")
    public void que_acesso_o_sistema(){
        WebDriver driver = Utils.getDriver();
        driver.manage().window().maximize();
        driver.get("https://raizes-do-norte.vercel.app/");
    }

    @Dado("que acesso o sistema na versao desktop")
    public void acessoDesktop(){

        WebDriver driver = Utils.getDriver();
        driver.get("https://raizes-do-norte.vercel.app/");

        Utils.mudarTelaPara1080p();

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @Dado("que acesso o sistema pelo celular")
    public void acessoMobile(){

        WebDriver driver = Utils.getDriver();
        driver.get("https://raizes-do-norte.vercel.app/");

        Utils.mudarTelaParaIphone12ProMax();

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
}