package cl.kibernumacademy.pom.pages;

import org.openqa.selenium.*;

public class WebFormPage {
  private WebDriver driver;
  // Localizador para el campo de texto usando selector
  // id=my-text-id
  private By textInput = By.id("my-text-id");
  // Localizador para el menu desplegable
  // name=my-select
  private By selectMenu = By.name("my-select");

  /*Constructor: recibe el webdriver para interactuar con la página */
  public WebFormPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setTextInput(String text) {
    driver.findElement(textInput).clear();
    driver.findElement(textInput).sendKeys(text);
  }



}
