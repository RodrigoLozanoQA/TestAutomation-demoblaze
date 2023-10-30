package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage {

    private final By cartBtn = By.id("cartur");
    private final By success = By.className("success");
    private final By tableCols = By.tagName("td");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyCartContents(String nombre, String precio) {
        WebElement cart = driver.findElement(cartBtn);
        cart.click();
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.presenceOfElementLocated(success));
        WebElement table = driver.findElement(success);
        List<WebElement> td = table.findElements(tableCols);
        String precioSel = td.get(2).getText();
        String nombreProd = td.get(1).getText();

        return precioSel.equals(precio) && nombreProd.equals(nombre);
    }
}