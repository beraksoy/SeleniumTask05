package task05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task05 extends TestBase {



    @Test
    public void test01(){

        //    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //            -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement clickbutton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        clickbutton.click();
        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        String textalert = driver.switchTo().alert().getText();
        System.out.println("textalert = " + textalert);
        bekle(2);
        alertAccept();
        bekle(2);


        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        WebElement alertclick = driver.findElement(By.xpath("(//*[@class='analystic'])[2]"));
        alertclick.click();
        bekle(2);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        bekle(2);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        //            -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        WebElement textbox = driver.findElement(By.xpath("(//*[@class='analystic'])[3]"));
        textbox.click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Bilal");
        bekle(2);
        driver.switchTo().alert().accept();
        //-Çıkan mesajı konsola yazdırınız
       String isim =  driver.findElement(By.id("demo1")).getText();
        System.out.println("isim = " + isim);

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello Bilal How are you today",driver.findElement(By.id("demo1")).getText());
    }


}
