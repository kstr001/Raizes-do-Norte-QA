package raizes.statements;

import io.cucumber.java.pt.Dado;
import org.openqa.selenium.WebDriver;
import raizes.Conexao;

public class dado {

    @Dado("que logo no sistema")
    public void que_logo_no_sistema(){
        WebDriver driver = Conexao.getDriver();
        driver.get("https://raizes-do-norte.vercel.app/");
    }
}