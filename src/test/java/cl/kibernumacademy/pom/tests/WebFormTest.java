package cl.kibernumacademy.pom.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cl.kibernumacademy.pom.pages.WebFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebFormTest {
  private WebDriver driver;
  private WebFormPage webFormPage;
  private final String URL = "https://www.selenium.dev/selenium/web/web-form.html";

  @BeforeAll
  void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setupTest() {
    driver = new ChromeDriver(); // Abre el navegador Chrome
    driver.get(URL); // Navega a la URL del formulario web
    webFormPage = new WebFormPage(driver); // Inicializa nuestro Page Object
  }

  @AfterEach
  void tearDown() {
    if (driver != null) {
      driver.quit(); // Cierra el navegador después de cada prueba
    }
    // if(driver != null) driver.quit();
  }

  @Test
  void testTextInput() {
    String inputText = "Hello, Selenium!";
    webFormPage.setTextInput(inputText); // Interactúa con el campo de texto
    assertEquals(inputText, webFormPage.getTextInput());

  }

  
}
