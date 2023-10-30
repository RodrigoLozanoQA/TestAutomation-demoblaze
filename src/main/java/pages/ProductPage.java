package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    private final By addToCartBtn = By.xpath("//a[contains(text(), 'Add to cart')]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addLaptopToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement addToCartButton = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartBtn));
        addToCartButton.click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}