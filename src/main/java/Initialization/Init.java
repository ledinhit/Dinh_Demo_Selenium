package Initialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Init {
   public static WebDriver driver = null;

    public static void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\dinh_demo_selenium\\tool\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //nếu có mở page mới thì chờ page mới mở ra tối đa 30s
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void CloseBrowser() {
        driver.quit();

    }
}
