package buoi4_dropdown;

import Initialization.Init;
import com.sun.org.apache.bcel.internal.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class SP_Dropdow extends Init {
    public static final String url = "https://dinh-tester-sapo.mysapogo.com/";

    static void Login(String user, String pass) {
//        driver.navigate().to("https://dinh-tester-sapo.mysapogo.com/admin/pos_v2/491315");
      driver.navigate().to(url);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(user);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        btnLogin.click();
    }

    public static void main(String[] args) throws InterruptedException, AWTException {
        OpenBrowser();
        Login("tuannt@gmail.com", "123456");
//        Login("0978871423", "dinh@123");
        driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng')]")).click();
//WebElement listOrder = driver.findElement(By.xpath(""));
        WebElement listOrder = driver.findElement(By.xpath("//a[@href='/admin/orders']"));
        listOrder.click();

        //        WebElement creatOrder = driver.findElement(By.xpath("//a[@href='/admin/orders/create']"));
//        creatOrder.click();
////        WebElement payment = driver.findElement(By.id("payment_3"));
////        WebElement payment2 = driver.findElement(By.id("payment_2"));
////        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payment);
////        Thread.sleep(500);
////        if (payment.isSelected() == false) {
//////            System.out.println(());
////            payment2.click();
////        }
//
//        driver.findElement(By.xpath("//*[@id=\"box-order-prepayment\"]/div/div/div[2]/div/div/label[1]/span/input")).isSelected();
//        System.out.println(driver.findElement(By.xpath("//*[@id=\"box-order-prepayment\"]/div/div/div[2]/div/div/label[1]/span/input")).isSelected());
//        if (driver.findElement(By.xpath("//*[@id=\"box-order-prepayment\"]/div/div/div[2]/div/div/label[1]/span/input")).isSelected() == false){
//            driver.findElement(By.xpath("//body/div[@id='container']/div[4]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/label[1]")).click();
//        }

//        driver.findElement(By.xpath("//span[@id='select2-locationId-container']")).click();
//        Select select = new Select(driver.findElement(By.id("locationId]")));
//        select.selectByVisibleText("Chi nhánh mặc định");
//        Select select = new Select(driver.findElement(By.id("locationId")));
//        select.selectByIndex(0);

        Actions action = new Actions(driver);
//        WebElement allClick = driver.findElement(By.xpath("//span[contains(text(),'Tất cả thao tác')]"));
//        allClick.click();
////        Thread.sleep(5000);
//        WebElement tuyChinh = driver.findElement(By.xpath("//h6[contains(text(),'Tùy chỉnh nút chức năng')]"));
////        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tuyChinh);
////        Thread.sleep(500);
//        tuyChinh.click();
//        WebElement discount = driver.findElement(By.xpath("//div[contains(text(),'Khuyến mại (F8)')]"));
//        WebElement target = driver.findElement(By.xpath("//div[contains(text(),'Đổi trả hàng')]"));
//        Point classname = target.getLocation();


//        action.dragAndDrop(discount,target).build().perform();
//        action.dragAndDropBy(discount, classname.getX(), classname.getY());
//        CloseBrowser();

        WebElement setting = driver.findElement(By.xpath("//thead/tr[1]/th[1]/a[1]/img[1]"));
        setting.click();
        WebElement id =driver.findElement(By.xpath("//div[@id='list-row-settings']/div[@name-column= 'Mã đơn hàng']"));
        WebElement dateConfirm =driver.findElement(By.xpath("//div[@id='list-row-settings']/div[@name-column= 'Ngày duyệt đơn']"));
        Point classname = dateConfirm.getLocation();
//        action.moveToElement(id, classname.getX(), classname.getY());
        action.dragAndDrop(id, dateConfirm).build().perform();

//        Robot robot =new Robot();
        //Robot
//        driver.navigate().to("https://tuannt-test.mysapogo.com/admin/products/create");
        //open upload window
        driver.findElement(By.xpath("//a[contains(text(),'Thêm ảnh')]")).click();

        //put path to your image in a clipboard
        String image ="D:\\selenium\\dinh_demo_selenium\\tool\\123.jpg";
        StringSelection imageProduct = new StringSelection(image);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imageProduct, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(90);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
