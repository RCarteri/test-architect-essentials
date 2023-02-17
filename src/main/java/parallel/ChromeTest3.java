package parallel;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest3 {
    @Test
    public void test3() throws MalformedURLException {
        URL url = new URL("http://localhost:4444/wd/hub");
        ChromeOptions  options = new ChromeOptions();
        RemoteWebDriver driver = new RemoteWebDriver(url, options);
        
        driver.get("http://www.gmail.com");
        System.out.println(driver.getTitle());
    }
}
