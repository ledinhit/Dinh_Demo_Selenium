package buoi3_webelement;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BtBuoi2 {
    static void Login(String user, String pass) {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\dinh_demo_selenium\\tool\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String urlAdminMarrket = "https://dinh-tester-sapo.mysapogo.com/";
        driver.navigate().to(urlAdminMarrket);
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(user);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        btnLogin.click();
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\dinh_demo_selenium\\tool\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String urlAdminMarrket = "https://dinh-tester-sapo.mysapogo.com/";
        driver.navigate().to(urlAdminMarrket);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("0978871423");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("dinh@123");
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        btnLogin.click();

//        Login("0978871423","dinh@123");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //Tắt popup quảng cáo khi mới đăng nhập thành công
//        driver.getWindowHandle();
//        driver.findElement(By.xpath("//span[@class='button-close-dialog']")).click();

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

        //Data test tạo sản phẩm
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

        //Tạo sản phẩm mới
        //**********************************************************************************
        WebElement product1 = driver.findElement(By.xpath("//input[@id='search-product']"));
        product1.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement newProd1 = driver.findElement(By.xpath("//p[contains(text(),'Thêm mới sản phẩm')]"));
        newProd1.click();

        //Data test tạo sản phẩm
        int randomNum1 = ThreadLocalRandom.current().nextInt(99, 999 + 1);
        System.out.println(randomNum1);
        //Data test tạo sản phẩm
        String dataName1 = "Sản phảm test " + randomNum1;
        String dataSKU1 = "sku-" + randomNum1;
        String dataPrice1 = "50000";

        //Tạo sản phẩm mới
        WebElement nameProd1 = driver.findElement(By.xpath("//input[@id='Name']"));
        nameProd1.sendKeys(dataName1);
        WebElement skuProd1 = driver.findElement(By.xpath("//input[@id='sku']"));
        skuProd1.sendKeys(dataSKU1);
        List<WebElement> priceProd1 = driver.findElements(By.xpath("//div[@id='sapo-modal-container']//input[@context = 'numberInput']"));
        priceProd1.get(0).sendKeys(dataPrice1);
        WebElement btnCreateProd1 = driver.findElement(By.xpath("//a[@id='btn-create-product']"));
        btnCreateProd1.click();
        //**********************************************************************************

        //Bấm tạo đơn
        WebElement btnCreateOrder = driver.findElement(By.xpath("//div[@id='content']/div[1]//a[contains(text(),'Tạo đơn và duyệt (F1)')]"));
        btnCreateOrder.click();

//        Thread.sleep(10000);
//        String noti = driver.findElement(By.xpath("//span[@class='ajax-notification-message']")).getText();
//        System.out.println(noti);
//        assertEquals("Tạo đơn hàng thành công",noti);

        List<WebElement> orderLineItem = driver.findElements(By.xpath("//tbody[@id='line_item_rows']/tr/td"));
        String sku = orderLineItem.get(0).getText();
        System.out.println(sku);
        Assert.assertEquals(dataSKU1, sku);
        String name = driver.findElement(By.xpath("//tbody[@id='line_item_rows']/tr/td[2]/div/span")).getText();
        System.out.println(name);
        Assert.assertEquals(dataName1, name);
//        String price = orderLineItem.get(3).getText();
//       String priceElement = driver.findElement(By.xpath("//tbody[@id='line_item_rows']/tr[1]/td[4]")).getText();
        String valuePrice = driver.findElement(By.xpath("//tbody//tr[1]//td[4]")).getText();
        System.out.println(valuePrice);
        Assert.assertEquals(dataPrice1, valuePrice);

    }
}
