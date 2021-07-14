import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buoi1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\dinh_demo_selenium\\tool\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String urlAdminMarrket = "http://192.168.12.21:9080/admin/sign-in";
        String username = "dinhlt@sapo.vn";
        String pass = "121212";
        String usernameTxt = "//input[@id='email']";
        String passTxt = "//input[@id='password']";
        String loginBtn = "//span[contains(text(),'Sign In')]";
        String account = "//span[@class='MuiButton-label']";

        //mo trang Market Admin
        driver.get(urlAdminMarrket);

        //Dang nhap vao admin
        driver.findElement(By.xpath(usernameTxt)).sendKeys(username);
        driver.findElement(By.xpath(passTxt)).sendKeys(pass);
        driver.findElement(By.xpath(loginBtn)).click();

        //lay title
        String titleAct = driver.getTitle();
        String titleEXp = "Market admin";

        //kiem tra title
        Assert.assertEquals(titleEXp, titleAct);
        System.out.println("Pass");

        //Tao dơn
//        driver.findElement(By.xpath("//div[@id='root']//span[contains(text(),'Đơn hàng')]")).click();

    }
}
