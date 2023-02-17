package parallel;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest1 {
    @BeforeTest
    public void startDockerScale() throws IOException, InterruptedException {
        File fi = new File("output.txt");
        if (fi.delete()) {
            System.out.println("file deleted successfully");
        }
        new StartDocker().startFile();
    }

    @AfterTest
    public void stopDockerScale() throws IOException, InterruptedException {
        new StopDocker().stopFile();
    }

    @Test
    public void test1() throws MalformedURLException {
        URL url = new URL("http://localhost:4444/wd/hub");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        options.addArguments("--ignore-ssl-errors=yes");
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--disable-dev-shm-usage");

        RemoteWebDriver driver = new RemoteWebDriver(url, options);

        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
    }
}
