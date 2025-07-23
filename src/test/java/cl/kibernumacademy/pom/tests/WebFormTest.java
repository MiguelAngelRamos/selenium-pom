package cl.kibernumacademy.pom.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    /**
     *  ¿Qué hace WebDriverManager.chromedriver().setup()?
        ✅ Descarga y configura automáticamente el ejecutable del ChromeDriver que sea compatible con la versión de Google Chrome instalada en tu máquina.
        ✅ Establece la ruta del ejecutable en el PATH del sistema (o en una propiedad del sistema) para que cuando tú crees una instancia de new ChromeDriver(), funcione sin que tengas que preocuparte por tener el driver ni por su ubicación.
     */
  }

  @BeforeEach
  void setupTest() {
    driver = new ChromeDriver(); // Abre el navegador Chrome
    /*
     * Aunque ya configuraste en @BeforeAll qué driver se usará y dónde está,
      cada vez que abres un ChromeDriver() creas un navegador nuevo y limpio.

      En otras palabras:

      @BeforeAll → solo descarga y configura el ejecutable de chromedriver.exe y deja el sistema listo.

      new ChromeDriver() → abre una ventana nueva de Chrome controlada por Selenium.
     */

     /*
      *  lo habitual (y recomendable) en pruebas automáticas es que cada test tenga su propio navegador independiente.
      Así:
      ✅ Si un test falla, no afecta al estado de otro.
      ✅ Cada prueba empieza con un navegador limpio, sin cookies, sin sesión previa, sin datos de otro test.

      */
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

  @Test
  void testSelectMenu() {
   webFormPage.selectOption("Two");
   assertEquals("Two", webFormPage.getSelectedOption());
  }

  @Test
  void testCheckBox() {
    webFormPage.checkCheckBox(); // Marca el checkbox
    assertTrue(webFormPage.isCheckBoxChecked());
  }

  @Test
  void testRadioButton() {
    webFormPage.selectRadioButton(); // Selecciona el botón de radio
    // Verifica que el botón de radio esté seleccionado
    assertTrue(webFormPage.isRadioButtonSelected());
  }

  // Ingresar una fecha y validar el valor ingresado
  @Test
  void testDateInput() {
    webFormPage.setDateInput("2025-07-22");
    // Verifica que la fecha ingresada sea la correcta
    assertEquals("2025-07-22", webFormPage.getDateInput());
  }

  // Ingresar una contraseña y validar el valor ingresado
  @Test
  void testPasswordInput() {
    String password = "mySecretPassword";
    webFormPage.setPasswordInput(password);
    // Verifica que la contraseña ingresada sea la correcta
    assertEquals(password, webFormPage.getPasswordInput()); 
  }

}
