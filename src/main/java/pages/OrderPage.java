package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void placeOrder() {

        WebElement placeOrder = driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]"));
        placeOrder.click();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
        WebElement countryInput = driver.findElement(By.id("country"));
        WebElement cityInput = driver.findElement(By.id("city"));
        WebElement cardInput = driver.findElement(By.id("card"));
        WebElement monthInput = driver.findElement(By.id("month"));
        WebElement yearInput = driver.findElement(By.id("year"));

        nameInput.sendKeys("Juan Perez");
        countryInput.sendKeys("Bolivia");
        cityInput.sendKeys("La Paz");
        cardInput.sendKeys("1234 5678");
        monthInput.sendKeys("12");
        yearInput.sendKeys("2023");

        WebElement purchase = driver.findElement(By.xpath("//button[contains(text(), 'Purchase')]"));
        purchase.click();
    }

    public WebElement verifyPurchase() {

        WebElement textoValidacion = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]"));
        return textoValidacion;
    }

    public void okPurchase() {
        WebElement ok = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
        ok.click();
    }
}