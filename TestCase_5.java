import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCase_5 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://shopdemo.e-junkie.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement contactUs = driver.findElement(By.cssSelector("a[href='/contact']"));
        contactUs.click();

        WebElement name = driver.findElement(By.id("sender_name"));
         wait.until(ExpectedConditions.visibilityOf(name));
        name.sendKeys("Monica");

        WebElement email = driver.findElement(By.id("sender_email"));
        email.sendKeys("test@email.com");

        WebElement subject = driver.findElement(By.id("sender_subject"));
        subject.sendKeys("order tracking");

        WebElement message = driver.findElement(By.id("sender_message"));
        message.sendKeys("Hello! Could you please send the tracking number to my email address? Thank you!");

        WebElement sendButton = driver.findElement(By.id("send_message_button"));
        sendButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        BekleKapat();
    }
}
