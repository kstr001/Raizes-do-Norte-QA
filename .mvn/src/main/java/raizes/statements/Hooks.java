package raizes.statements;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import raizes.Utils;

import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    private static boolean pastaLimpa = false;


    public static AndroidDriver driver;

    @Before
    public void antesDoCenario() throws MalformedURLException {
        if (!pastaLimpa) {
            Utils.limparPrintsAntigos();
            pastaLimpa = true;
        }


        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Pixel 10 API 37.0");
        options.setCapability("browserName", "Chrome");
        options.setCapability("appium:chromedriverExecutable", "C:/Chromedriver/chromedriver.exe");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        Utils.setDriver(driver);
    }

    @After
    public void depoisDoCenario() {
        Utils.fecharDriver();
    }
}