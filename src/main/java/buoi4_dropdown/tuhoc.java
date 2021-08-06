package buoi4_dropdown;

import Initialization.Init;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class tuhoc extends Init {
    public static void main(String[] args) throws InterruptedException {
        OpenBrowser();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //Click vào checkbox
//        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
//        checkbox1.click();

        //Kiểm tra check box đã được check hay chưa
        Boolean isSelected = driver.findElement(By.id("isAgeSelected")).isSelected();

        //Nếu chưa được check thì click vào ô check box đó
        if (isSelected == false) {
            System.out.println("Chưa được chọn");
            driver.findElement(By.id("isAgeSelected")).click();
//            System.out.println("vừa được chọn");
            WebElement msg = driver.findElement(By.id("txtAge"));
            if (msg.isDisplayed() == true){
                System.out.println("vừa được chọn");
                System.out.println(msg.getText());
            }
        }else {

            System.out.println("đã được chọn");
        }

        // check all
        // kiểm tra nút check all có text là 'check all'

        WebElement btnCheckAll = driver.findElement(By.xpath("//input[@id='check1']"));
//        Assert.assertFalse(btnCheckAll.isDisplayed());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnCheckAll);
        Thread.sleep(500);
        // toString chuyển về dạng chuỗi
        if (btnCheckAll.getAttribute("value").trim().toString().equals("Check All")){
            btnCheckAll.click();
        }else {
            System.out.println("không lấy được");
        }
        List<WebElement> listCheckbox = driver.findElements(By.xpath("//div[@id='easycont']/div[@class='row']/div[2]/div[2]//div[@class='checkbox']"));
             System.out.println(listCheckbox.size() );
             for (int i=1; i<= listCheckbox.size(); i++){
                 WebElement checkbox = driver.findElement(By.xpath("//div[@id='easycont']/div[1]/div[2]/div[2]/div[2]/div["+i+"]/label[1]/input[1]"));
                 if (checkbox.isSelected()==true){
                     System.out.println("Checkbox thứ "+i+" được chọn");
                 }
                 else {
                     System.out.println("Sai Checkbox thứ "+i+" chưa được chọn");
                 }
             }

             if(btnCheckAll.getAttribute("value").equals("Uncheck All")){
                 System.out.println("Đã chuyển sang Uncheck ");
             }else {
                 System.out.println("Chưa chuyển sang Uncheck");
             }
        CloseBrowser();
    }
}
