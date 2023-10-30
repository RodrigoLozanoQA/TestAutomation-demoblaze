package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends BasePage {

    private final By laptopsBtn = By.linkText("Laptops");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLaptopsCategory() {
        WebElement laptop = driver.findElement(laptopsBtn);
        laptop.click();
    }

    public void selectSpecificLaptop(String laptopName) {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement specificLaptop = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(laptopName)));
        specificLaptop.click();
    }
}