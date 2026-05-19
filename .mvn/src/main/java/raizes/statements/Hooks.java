package raizes.statements;

import io.cucumber.java.Before;
import raizes.Conexao;

public class Hooks {

    private static boolean pastaLimpa = false;

    @Before
    public void antesDoCenario() {
        if (!pastaLimpa) {
            Conexao.limparPrintsAntigos();
            pastaLimpa = true;
        }
    }
}