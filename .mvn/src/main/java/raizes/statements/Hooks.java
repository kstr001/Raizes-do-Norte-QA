package raizes.statements;

import io.cucumber.java.Before;
import raizes.Utils;

public class Hooks {

    private static boolean pastaLimpa = false;

    @Before
    public void antesDoCenario() {
        if (!pastaLimpa) {
            Utils.limparPrintsAntigos();
            pastaLimpa = true;
        }
    }
}