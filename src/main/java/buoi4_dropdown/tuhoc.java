package buoi4_dropdown;

import Initialization.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class tuhoc extends Init {
    public static void main(String[] args) {
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

//        CloseBrowser();
    }
}
