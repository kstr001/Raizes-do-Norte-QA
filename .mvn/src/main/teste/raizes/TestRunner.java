package raizes;

import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/resources",
        glue = {"raizes.statements"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"}
//        ,
//        tags = "@TS0001-Cadastro"
)
public class TestRunner {
        @AfterAll
        public static void finalizarTestes() {
                Utils.fecharDriver();
        }
}