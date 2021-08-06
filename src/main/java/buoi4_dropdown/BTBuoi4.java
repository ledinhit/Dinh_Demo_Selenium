package buoi4_dropdown;

import Initialization.Init;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BTBuoi4 extends Init {

    public static final String url = "https://tester-sapo-2.mysapogo.com/";

    static void Login(String user, String pass) {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(user);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        btnLogin.click();
    }

    public static void main(String[] args) throws InterruptedException, AWTException {
        OpenBrowser();
        driver.navigate().to(url);
        Login("0978871423", "dinh@123");

        Actions action = new Actions(driver);
        /**
        driver.findElement(By.xpath("//span[contains(text(),'Sản phẩm')]")).click();
        WebElement listOrder = driver.findElement(By.xpath("//a[@href='/admin/products']"));
        listOrder.click();

        //============Action================
        WebElement iconSetting = driver.findElement(By.xpath("//thead/tr[1]/th[1]/a[1]/img[1]"));
        iconSetting.click();
        WebElement image = driver.findElement(By.xpath("//div[@id='sapo-modal-container']//div[@name-column='Ảnh']"));
        WebElement status = driver.findElement(By.xpath("//div[@id='sapo-modal-container']//div[@name-column='Trạng thái']"));
        // dragAndDrop () : Kéo phần tử từ một điểm và thả xuống một điểm khác
        action.dragAndDrop(image, status).build().perform();
        Thread.sleep(2000);
        WebElement btnSave = driver.findElement(By.xpath("//a[contains(text(),'Lưu')]"));
        btnSave.click();
        Thread.sleep(2000);
        WebElement noti = driver.findElement(By.xpath("//span[@class='ajax-notification-message']"));
        System.out.println(noti.getText());
        Assert.assertEquals("Cài đặt thiết lập thành công", noti.getText());

        //============CheckBox================
        //Chọn tất cả sản phẩm
        List<WebElement> listProduct = driver.findElements(By.xpath("//tbody/tr"));
        listProduct.size();
        //In ra tổng số sản phẩm
        System.out.println("Tổng sản phẩm: " + listProduct.size());
        WebElement selectCheckboxProd = driver.findElement(By.xpath("//thead/tr[1]/th[2]/div[1]/div[1]/div[1]/input[1]"));
        WebElement text = driver.findElement(By.xpath("//div[@id='bulk-actions-all']/a[1]"));
        //Checkbox
        if (selectCheckboxProd.isSelected() == false) {
            System.out.println("Chưa tích chọn sản phẩm");
            Thread.sleep(2000);
            selectCheckboxProd.click();
            System.out.println(text.getText());
            Assert.assertEquals("Đã chọn (" + listProduct.size() + " sản phẩm)", text.getText());
        } else {
            System.out.println(text.getText());
        }

        //============ Robot ===============
        //Dùng Robot tạo sản phẩm bằng file
        WebElement btnUploadFile = driver.findElement(By.xpath("//header/div[1]/div[2]/div[2]/button[2]"));
        btnUploadFile.click();
        WebElement btnSelectFile = driver.findElement(By.xpath("//span[contains(text(),'Kéo thả file vào đây hoặc tải lên từ thiết bị')]"));
        btnSelectFile.click();
        StringSelection fileProduct = new StringSelection("D:\\selenium\\dinh_demo_selenium\\tool\\sapo_mau_nhap_san_pham_25022021.xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileProduct, null);

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

        Thread.sleep(2000);

        WebElement btnImport = driver.findElement(By.xpath("//button[@id='importproducts']"));
        btnImport.click();
        Thread.sleep(2000);

        WebElement btnExit = driver.findElement(By.xpath("//button[contains(text(),'Thoát')]"));
        btnExit.click();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);
        WebElement nameProd = driver.findElement(By.xpath("//tbody/tr[1]/td[@nametd='product_name']"));
        System.out.println("Sản phẩm mới tạo: "+nameProd.getText());
        Assert.assertEquals("Iphone",nameProd.getText() );

**/
        WebElement listCustomer = driver.findElement(By.xpath("//span[contains(text(),'Khách hàng')]"));
        listCustomer.click();

        WebElement btnCreateCustomer = driver.findElement(By.xpath("//div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/button[1]/span[1]"));
        btnCreateCustomer.click();

        int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println(randomNum);
        //Data test tạo khách hàng
        String dataName = "Sản phảm test " + randomNum;
        String dataCode = "KH-" + randomNum;
        String dataEmail = "dinhlt"+randomNum+"@sapo.vn";
        String dataPhone = "0376595423";

        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Nhập tên khách hàng']"));
        name.sendKeys(dataName);
        WebElement code = driver.findElement(By.xpath("//input[@placeholder='Nhập mã khách hàng']"));
        code.sendKeys(dataCode);
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Nhập số điện thoại']"));
        phone.sendKeys(dataPhone);
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Nhập địa chỉ email']"));
        email.sendKeys(dataEmail);
        WebElement district = driver.findElement(By.xpath("//p[contains(text(),'Chọn Tỉnh/Thành phố - Quận/Huyện')]"));
        district.click();
        WebElement searchDistrict= driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm khu vực']"));
        searchDistrict.sendKeys("Cầu Giấy");
        Thread.sleep(3000);
        action.sendKeys(Keys.ENTER).build().perform();

        WebElement ward = driver.findElement(By.xpath("//p[contains(text(),'Chọn Phường/Xã')]"));
        ward.click();


    }
}
