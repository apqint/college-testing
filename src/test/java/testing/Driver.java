package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

public class Driver {
    public static WebDriver getLocalDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static RemoteWebDriver getRemoteDriver() {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("sessionTimeout", "15m");
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("name", "Test badge");
        selenoidOptions.put("enableVideo", true);
        
        options.setCapability("selenoid:options", selenoidOptions);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}