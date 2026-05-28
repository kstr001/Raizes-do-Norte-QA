package raizes.statements;

import io.cucumber.java.pt.Dado;
import org.openqa.selenium.WebDriver;
import raizes.Utils;

import static raizes.statements.Hooks.driver;

public class dado {

    @Dado("que acesso o sistema")
    public void que_acesso_o_sistema(){
        WebDriver driver = Utils.getDriver();
        driver.manage().window().maximize();
        driver.get("https://raizes-do-norte.vercel.app/");
    }

    @Dado("que acesso o sistema pelo celular")
    public void acessoMobile(){

        driver.get("https://raizes-do-norte.vercel.app/");

        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
}