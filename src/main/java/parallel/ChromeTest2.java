package parallel;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest2 {
    @Test
    public void test2() throws MalformedURLException {
        URL url = new URL("http://localhost:4444/wd/hub");

        ChromeOptions  options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        options.addArguments("--ignore-ssl-errors=yes");
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--disable-dev-shm-usage");

        RemoteWebDriver driver = new RemoteWebDriver(url, options);
        
        driver.get("http://www.yahoo.com");
        System.out.println(driver.getTitle());
    }
}
