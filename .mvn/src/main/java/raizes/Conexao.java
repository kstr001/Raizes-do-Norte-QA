package raizes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;

public class Conexao {

    private static WebDriver driver;

    private static final Map<String, Object> contexto = new HashMap<>();

    public static WebDriver getDriver() {
        if (driver == null) {
            String chromeDriver = "drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            driver = new ChromeDriver();
        }
        return driver;
    }

    // Método para SALVAR qualquer dado passando um nome (chave) e o valor
    public static void salvarDado(String chave, Object valor) {
        contexto.put(chave, valor);
    }

    // Método para BUSCAR o dado de volta usando o nome (chave)
    @SuppressWarnings("unchecked")
    public static <T> T pegarDado(String chave) {
        return (T) contexto.get(chave);
    }


    public static void limparContexto() {
        contexto.clear();
    }

    public static void fecharDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}