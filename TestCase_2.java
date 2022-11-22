import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCase_2 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement addToCart_eBook = driver.findElement(By.xpath("//h4[text()='Demo eBook']/following-sibling::button"));
        addToCart_eBook.click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
       wait.until(ExpectedConditions.visibilityOf(iframe));
        driver.switchTo().frame(iframe);

        WebElement payUsingDebitCard = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOf(payUsingDebitCard));
        payUsingDebitCard.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(iframe);
        WebElement payButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        wait.until(ExpectedConditions.invisibilityOf(payUsingDebitCard));
        payButton.click();

        WebElement invalid = driver.findElement(By.xpath("//div[@id='SnackBar']//span"));
        String invalidTexts = invalid.getText();

        if(invalidTexts.contains("Invalid Email")&&invalidTexts.contains("Invalid Email")&&invalidTexts.contains("Invalid Billing Name"))
            System.out.println("you got the \"" + invalidTexts + "\" message" );
        else
            System.out.println("your text is not matching with " + invalidTexts);
       BekleKapat();
    }
}
