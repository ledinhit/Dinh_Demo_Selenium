package buoi3_webelement;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BtBuoi3 {

    static WebDriver driver;
    public static final String url = "https://dinh-tester-sapo.mysapogo.com/";

    static void OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\dinh_demo_selenium\\tool\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    static void CloseBrowser() {
        driver.quit();

    }

    static void Login(String user, String pass) {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(user);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        btnLogin.click();
    }

    static void Testcase1() throws InterruptedException {
        OpenBrowser();
        Login("0978871423", "dinh@123");

        //Tắt popup quảng cáo khi mới đăng nhập thành công ( bỏ comment nếu chạy có popup)
        //driver.getWindowHandle();
        //driver.findElement(By.xpath("//span[@class='button-close-dialog']")).click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng')]")).click();
        WebElement creatOrder = driver.findElement(By.xpath("//a[@href='/admin/orders/create']"));
        creatOrder.click();

        WebElement customer = driver.findElement(By.xpath("//input[@id='search-customer']"));
        customer.click();

        // Lấy ra danh sách khách hàng và chọn khách hàng đầu tiên
        List<WebElement> listCustomer = driver.findElements(By.xpath("//div[starts-with(@id,'item-suggest-customers')]"));
        listCustomer.get(0).click();
        WebElement product = driver.findElement(By.xpath("//input[@id='search-product']"));
        product.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement newProd = driver.findElement(By.xpath("//p[contains(text(),'Thêm mới sản phẩm')]"));
        newProd.click();

        int randomNum = ThreadLocalRandom.current().nextInt(99, 999 + 1);
        System.out.println(randomNum);
        //Data test tạo sản phẩm
        String dataName = "Sản phảm test " + randomNum;
        String dataSKU = "sku-" + randomNum;
        String dataPrice = "50000";

        //Tạo sản phẩm mới
        WebElement nameProd = driver.findElement(By.xpath("//input[@id='Name']"));
        nameProd.sendKeys(dataName);
        WebElement skuProd = driver.findElement(By.xpath("//input[@id='sku']"));
        skuProd.sendKeys(dataSKU);
        List<WebElement> priceProd = driver.findElements(By.xpath("//div[@id='sapo-modal-container']//input[@context = 'numberInput']"));
        priceProd.get(0).sendKeys(dataPrice);
        WebElement btnCreateProd = driver.findElement(By.xpath("//a[@id='btn-create-product']"));
        btnCreateProd.click();

        //Bấm tạo đơn
        WebElement btnCreateOrder = driver.findElement(By.xpath("//div[@id='content']/div[1]//a[contains(text(),'Tạo đơn và duyệt (F1)')]"));
        btnCreateOrder.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

//        Thread.sleep(5000);
//        String noti = driver.findElement(By.xpath("//span[@class='ajax-notification-message']")).getText();
//        System.out.println(noti);
//        assertEquals("Tạo đơn hàng thành công",noti);

        List<WebElement> orderLineItem = driver.findElements(By.xpath("//tbody[@id='line_item_rows']/tr/td"));
        String sku = orderLineItem.get(0).getText();
        Assert.assertEquals(dataSKU, sku);
        String name = driver.findElement(By.xpath("//tbody[@id='line_item_rows']/tr/td[2]/div/span")).getText();
        Assert.assertEquals(dataName, name);
        String price = orderLineItem.get(3).getText();
        System.out.println(price);
        Assert.assertEquals(dataPrice, price);
        CloseBrowser();

    }

    static void Testcase2() throws InterruptedException {
        OpenBrowser();
        Login("0978871423", "dinh@123");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //Tắt popup quảng cáo khi mới đăng nhập thành công ( bỏ comment nếu chạy có popup)
        //driver.getWindowHandle();
        //driver.findElement(By.xpath("//span[@class='button-close-dialog']")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng')]")).click();
        WebElement creatOrder = driver.findElement(By.xpath("//a[@href='/admin/orders/create']"));
        creatOrder.click();

        WebElement customer = driver.findElement(By.xpath("//input[@id='search-customer']"));
        customer.click();
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        // Lấy ra danh sách khách hàng và chọn khách hàng đầu tiên
        List<WebElement> listCustomer = driver.findElements(By.xpath("//div[starts-with(@id,'item-suggest-customers')]"));
        listCustomer.get(0).click();

        //Bấm tạo đơn
        WebElement btnCreateOrder = driver.findElement(By.xpath("//div[@id='content']/div[1]//a[contains(text(),'Tạo đơn và duyệt (F1)')]"));
        btnCreateOrder.click();
        Thread.sleep(1000);
        String noti = driver.findElement(By.xpath("//span[@class='ajax-notification-message']")).getText();
        System.out.println(noti);
        assertEquals("Vui lòng chọn sản phẩm vào đơn hàng!", noti);
        CloseBrowser();

    }

    static void Testcase3() throws InterruptedException {
        OpenBrowser();
        Login("0978871423", "dinh@123");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement facebook = driver.findElement(By.xpath("//span[contains(text(),'Kênh Facebook')]"));
        facebook.click();
        driver.switchTo().frame("app-iframe");
        WebElement btnNext = driver.findElement(By.xpath("//button[contains(text(),'Tiếp theo')]"));
        btnNext.click();
        btnNext.click();
        WebElement btnNext1 = driver.findElement(By.xpath("//button[contains(text(),'Tôi đã hiểu')]"));
        btnNext1.click();
        WebElement btnConnect = driver.findElement(By.xpath("//button[contains(text(),'Kết nối với facebook')]"));
        btnConnect.click();

        Thread.sleep(3000);
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!currentWindow.equals(window)) {
                driver.switchTo().window(window);
                break;
            }
        }
        WebElement emailFace = driver.findElement(By.xpath("//input[@id='email']"));
        emailFace.sendKeys("dinhlt20@gmail.com");
        WebElement passFace = driver.findElement(By.xpath("//input[@id='pass']"));
        passFace.sendKeys("ledinh94");
        Thread.sleep(2000);
        WebElement loginFace = driver.findElement(By.xpath("//input[@value='Đăng nhập']"));
        loginFace.click();
        WebElement connect = driver.findElement(By.xpath("//div[@aria-label='Tiếp tục dưới tên Iris Lê']"));
        connect.click();
        WebElement nextConnect = driver.findElement(By.xpath("//span[contains(text(),'Tiếp')]"));
        nextConnect.click();
        WebElement doneConnect = driver.findElement(By.xpath("//span[contains(text(),'Xong')]"));
        doneConnect.click();

        WebElement btnOk = driver.findElement(By.xpath("//span[contains(text(),'OK')]"));
        btnOk.click();

//        CloseBrowser();
    }

    public static void main(String[] args) throws InterruptedException {
        Testcase2();
        Testcase1();
        Testcase3();

    }

}
