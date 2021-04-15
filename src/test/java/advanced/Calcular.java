package advanced;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertEquals;

public class Calcular {

    private AndroidDriver driver;
    private DesiredCapabilities desiredCapabilities;
    private URL remoteUrl;

    public Calcular() {
    }


    @Before
    public void setUp() throws MalformedURLException {
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("browserName", "");
        desiredCapabilities.setCapability("appiumVersion", "1.19.2");
        desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        remoteUrl = new URL("https://marisamendes:1e4b16f2-e25d-426f-98f9-1a7b6cbf7a83@ondemand.us-west-1.saucelabs.com:443/wd/hub");


    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("^abro a calculadora do Google no meu smartPhone$")
    public void abroACalculadoraDoGoogleNoMeuSmartPhone() {
        driver = new AndroidDriver(remoteUrl, desiredCapabilities); //Essas duas linhas abrem o aparelho
    }

    @When("^seleciono \"([^\"]*)\" mais \"([^\"]*)\" e pressiono o botao Igual$")
    public void selecionoMaisEPressionoOBotaoIgual(String num1, String num2)  {
        MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btn2.click();
        MobileElement btnSoma = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnSoma.click();
        MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        btn3.click();
        MobileElement btnIgual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnIgual.click();

    }

    @Then("^exibe o resultado como \"([^\"]*)\"$")
    public void exibeOResultadoComo(String resultadoEsperado)  {
        MobileElement lblResultadoAtual = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        assertEquals(resultadoEsperado, lblResultadoAtual.getText());

    }
}

