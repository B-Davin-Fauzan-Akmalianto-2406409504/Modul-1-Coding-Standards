package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testStepCreateProduct() {
        driver.get("http://localhost:" + serverPort + "/product/list");

        WebElement checkInput = driver.findElement(By.id("tombolCreate"));
        checkInput.click();

        WebElement inputNama = driver.findElement(By.id("nameInput"));
        inputNama.clear();

        String namaProduct = "Bola";
        inputNama.sendKeys(namaProduct);

        WebElement inputQuantity = driver.findElement(By.id("quantityInput"));
        inputQuantity.clear();

        int quantityProduk = 100;
        inputQuantity.sendKeys(String.valueOf(quantityProduk));

        String dataNama = inputNama.getAttribute("value");
        String dataQuantity = inputQuantity.getAttribute("value");
        assertEquals(dataNama, namaProduct);
        assertEquals(dataQuantity, String.valueOf(quantityProduk));

        WebElement buttonSubmit = driver.findElement(By.id("tombolSubmit"));
        buttonSubmit.click();

        List<WebElement> listNamaProduk = driver.findElements(By.className("product-name"));
        boolean ketemu = false;
        for (WebElement element: listNamaProduk) {
            if (element.getText().equals(namaProduct)) {
                ketemu = true;
                break;
            }
        }
        assertTrue(ketemu);
    }
}