package raizes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    // --- NOVO MÉTODO PARA TIRAR PRINT ---
    public static void tirarPrint(String nomeDoPasso) {
        if (driver != null) {

            File arquivoOriginal = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());

            String nomeLimpo = nomeDoPasso.replaceAll("[^a-zA-Z0-9_-]", "_");
            String caminhoDestino = "run_results/" + timestamp + "_" + nomeLimpo + ".png";

            try {
                java.nio.file.Files.createDirectories(java.nio.file.Paths.get("run_results"));


                java.nio.file.Files.copy(
                        arquivoOriginal.toPath(),
                        java.nio.file.Paths.get(caminhoDestino),
                        java.nio.file.StandardCopyOption.REPLACE_EXISTING
                );
                System.out.println("Print salvo em: " + caminhoDestino);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o print: " + e.getMessage());
            }
        }
    }

    public static void limparPrintsAntigos() {
        java.io.File pasta = new java.io.File("run_results");

        System.out.println("[DEBUG] Tentando limpar a pasta run_results...");

        if (pasta.exists() && pasta.isDirectory()) {
            java.io.File[] arquivos = pasta.listFiles();
            if (arquivos != null && arquivos.length > 0) {
                for (java.io.File arquivo : arquivos) {
                    boolean deletado = arquivo.delete();
                    if (!deletado) {
                        System.out.println("[AVISO] Não foi possível deletar o arquivo (pode estar aberto ou travado): " + arquivo.getName());
                    }
                }
                System.out.println("[SUCESSO] Todos os prints antigos possíveis foram apagados!");
            } else {
                System.out.println("[INFO] A pasta run_results já estava vazia.");
            }
        } else {
            System.out.println("[INFO] Pasta run_results não encontrada. Ela será criada no primeiro print.");
        }
    }


    // Método para forçar a tela em Full HD (1080p)
    public static void mudarTelaPara1080p() {
        if (driver != null) {
            driver.manage().window().setSize(new Dimension(1920, 1080));
            System.out.println("Tela ajustada para Full HD (1920x1080)");
        }
    }

    // Método para forçar a tela no tamanho do iPhone 12 Pro Max
    public static void mudarTelaParaIphone12ProMax() {
        if (driver != null) {
            driver.manage().window().setSize(new Dimension(428, 926));
            System.out.println("Tela ajustada para formato iPhone 12 Pro Max (428x926)");
        }
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