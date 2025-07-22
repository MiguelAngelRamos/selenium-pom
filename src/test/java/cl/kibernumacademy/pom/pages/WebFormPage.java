package cl.kibernumacademy.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class WebFormPage {
  private WebDriver driver;
  // Localizador para el campo de texto usando selector
  // id=my-text-id
  private By textInput = By.id("my-text-id");
  // Localizador para el menu desplegable
  // name=my-select
  private By selectMenu = By.name("my-select");
  // Localizador para checkbox
  // id=my-check-1
  private By checkBox = By.id("my-check-1");
  // Localizador para el botón de radio
  // id=my-radio-2
  private By radioButton = By.id("my-radio-2");

  /*Constructor: recibe el webdriver para interactuar con la página */
  public WebFormPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setTextInput(String text) {
    driver.findElement(textInput).clear();
    driver.findElement(textInput).sendKeys(text);
  }

  public String getTextInput() {
    return driver.findElement(textInput).getAttribute("value");
  }

  public void selectOption(String value) {
    new Select(driver.findElement(selectMenu)).selectByVisibleText(value);
  }

  public String getSelectedOption() {
    return new Select(driver.findElement(selectMenu)).getFirstSelectedOption().getText();
  }

  // Marca el checkbox si no está marcado

  public void checkCheckBox() {
    WebElement checkBoxElement = driver.findElement(checkBox);
    if (!checkBoxElement.isSelected()) {
      checkBoxElement.click();
    }
  }

  // Verifica si el checkbox está marcado
  public boolean isCheckBoxChecked() {
    return driver.findElement(checkBox).isSelected();
  }

  // Selecciona el radio button si no está seleccionado
  public void selectRadioButton() {
    WebElement radioButtonElement = driver.findElement(radioButton);
    // if (!radioButtonElement.isSelected()) radioButtonElement.click();
    if (!radioButtonElement.isSelected()) {
      radioButtonElement.click();
    } 
  }
  // Verifica si el radio button está seleccionado
  public boolean isRadioButtonSelected() {
    return driver.findElement(radioButton).isSelected();
  }



}
