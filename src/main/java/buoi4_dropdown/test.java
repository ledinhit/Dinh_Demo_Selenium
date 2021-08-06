package buoi4_dropdown;

import Initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class test extends Init {
    public static final String url = "https://dinh-tester-sapo.mysapogo.com/";

    static void Login(String user, String pass) {
        driver.navigate().to(url);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(user);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        btnLogin.click();
    }

    public static void main(String[] args) throws InterruptedException {
        OpenBrowser();
        Login("0978871423", "dinh@123");
        driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng')]")).click();
//WebElement listOrder = driver.findElement(By.xpath(""));
        WebElement creatOrder = driver.findElement(By.xpath("//a[@href='/admin/orders/create']"));
        creatOrder.click();
//        WebElement payment = driver.findElement(By.id("payment_3"));
//        WebElement payment2 = driver.findElement(By.id("payment_2"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payment);
//        Thread.sleep(500);
//        if (payment.isSelected() == false) {
////            System.out.println(());
//            payment2.click();
//        }

//        driver.findElement(By.xpath("//*[@id=\"box-order-prepayment\"]/div/div/div[2]/div/div/label[1]/span/input")).isSelected();
//        System.out.println(driver.findElement(By.xpath("//*[@id=\"box-order-prepayment\"]/div/div/div[2]/div/div/label[1]/span/input")).isSelected());
//        if (driver.findElement(By.xpath("//*[@id=\"box-order-prepayment\"]/div/div/div[2]/div/div/label[1]/span/input")).isSelected() == false){
//            driver.findElement(By.xpath("//body/div[@id='container']/div[4]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]")).click();
//        }

//        driver.findElement(By.xpath("//span[@id='select2-locationId-container']")).click();
//        Select select = new Select(driver.findElement(By.id("locationId]")));
//        select.selectByVisibleText("Chi nhánh mặc định");
        Select select = new Select(driver.findElement(By.id("locationId")));
        select.selectByIndex(1);


//        CloseBrowser();
    }
}
