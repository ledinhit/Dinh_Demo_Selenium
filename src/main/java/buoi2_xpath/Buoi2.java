package buoi2_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Buoi2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\dinh_demo_selenium\\tool\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String urlAdminMarrket = "https://tuannt-test.mysapogo.com";
        driver.get(urlAdminMarrket);
        driver.findElement(By.id("login")).sendKeys("tuannt@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.getWindowHandle();
        driver.findElement(By.xpath("//span[@class='button-close-dialog']")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng')]")).click();
        WebElement creatOrder = driver.findElement(By.xpath("//a[@href='/admin/orders/create']"));
        creatOrder.click();
        driver.findElement(By.xpath("//input[@id='search-customer']")).sendKeys("1213");

        driver.findElement(By.xpath("//div[@class='ui-breadcrumbs']//span[contains(text(),'Đơn hàng')]")).click();
        driver.switchTo().alert().accept();
        List<WebElement> list = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println(list.size());
        driver.findElement(By.xpath("//span[contains(text(),'Kênh Facebook')]")).click();
        driver.switchTo().frame("app-iframe");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//button[contains(text(),'Tiếp theo')]")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng')]")).click();

    }
}
