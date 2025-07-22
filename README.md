# Selenium Web Form Automation (POM)

Este proyecto automatiza pruebas sobre [Selenium Web Form](https://www.selenium.dev/selenium/web/web-form.html) usando Java, Selenium WebDriver, JUnit 5 y WebDriverManager, aplicando el patrón Page Object Model (POM).

## Estructura del proyecto

```
selenium-web-form/
├── pom.xml
├── README.md
└── src/
    └── test/
        └── java/
            ├── pages/
            │   └── WebFormPage.java
            └── tests/
                └── WebFormTest.java
```

## Dependencias principales
- selenium-java: 4.21.0
- junit-jupiter: 5.10.2
- webdrivermanager: 5.8.0
- maven-surefire-plugin: 3.2.5

## Beneficios del patrón Page Object Model (POM)
- Separación clara entre lógica de pruebas y manipulación de la UI.
- Mejor mantenibilidad y reutilización de código.
- Facilita la escalabilidad de los tests.

## Uso
1. Ejecuta `mvn test` para correr los tests.
2. Modifica los datos de ejemplo en `WebFormTest.java` según tus necesidades.

## Estructura de clases
- `WebFormPage`: Encapsula los elementos y acciones de la web.
- `WebFormTest`: Define los tests usando JUnit 5.

## Pruebas automatizadas incluidas

Se implementaron los siguientes tests sobre el formulario web:

- **Llenar el campo de texto**: Ingresa texto en el campo "Text input" y valida que el valor se refleje correctamente.
- **Seleccionar opción del menú desplegable**: Elige una opción del menú "Select" y verifica que la selección sea la esperada.
- **Marcar el checkbox**: Marca el checkbox y valida que quede seleccionado.
- **Seleccionar radio button**: Selecciona un radio button y comprueba que está activo.
- **Ingresar una fecha**: Escribe una fecha en el campo "Date" y valida el valor ingresado.
- **Llenar el campo de contraseña**: Ingresa una contraseña y verifica que se acepte el valor.
- **Enviar el formulario correctamente**: Llena todos los campos y envía el formulario, validando que aparezca el mensaje de éxito.
- **Enviar el formulario vacío**: Envía el formulario sin completar campos y valida que el test no falle si no aparece mensaje de éxito o error.

Cada test automatiza una acción y su respectiva validación, asegurando el correcto funcionamiento de los elementos del formulario.

## ¿Qué es el Page Object Model (POM)?

El **Page Object Model (POM)** es un patrón de diseño ampliamente utilizado en la automatización de pruebas de interfaces gráficas de usuario (GUI), especialmente en aplicaciones web. Su objetivo principal es mejorar la mantenibilidad, legibilidad y escalabilidad de los scripts de prueba, separando la lógica de interacción con la interfaz de usuario de la lógica de los tests propiamente dichos.

En POM, cada página o componente significativo de la aplicación web se representa mediante una clase Java (o del lenguaje que se utilice). Esta clase, llamada "Page Object", encapsula todos los elementos web (campos, botones, menús, etc.) y las acciones que se pueden realizar sobre ellos (como hacer clic, escribir texto, seleccionar opciones, etc.). De esta manera, los tests no interactúan directamente con los selectores o localizadores de los elementos, sino que llaman a métodos descriptivos definidos en los Page Objects.

### Ventajas del uso de POM

- **Mantenibilidad:** Si la estructura o los selectores de la página cambian, solo es necesario actualizar la clase Page Object correspondiente, sin tener que modificar todos los tests que interactúan con esa página.
- **Reutilización:** Los métodos y localizadores definidos en los Page Objects pueden ser reutilizados en múltiples tests, evitando duplicidad de código.
- **Legibilidad:** Los tests escritos con POM son más fáciles de leer y entender, ya que utilizan métodos descriptivos como `login()`, `fillForm()`, `submit()`, en lugar de secuencias de comandos con localizadores y acciones directas.
- **Escalabilidad:** Permite que los proyectos de automatización crezcan de manera ordenada, facilitando la incorporación de nuevas páginas y funcionalidades sin afectar la estructura existente.

### Estructura típica de POM

- **Clases Page Object:** Cada clase representa una página o componente de la aplicación. Contiene los localizadores de los elementos y los métodos para interactuar con ellos.
- **Clases de Test:** Utilizan los Page Objects para realizar acciones y validaciones, manteniendo la lógica de prueba separada de la lógica de interacción con la UI.

Por ejemplo, en este proyecto, la clase `WebFormPage` encapsula todos los elementos y acciones del formulario web, mientras que la clase `WebFormTest` contiene los tests que validan el comportamiento del formulario. Así, si el formulario cambia, solo se modifica `WebFormPage`, manteniendo los tests limpios y robustos.

El uso de POM es considerado una buena práctica en la automatización de pruebas, ya que facilita el trabajo en equipo, la colaboración y el mantenimiento a largo plazo de los proyectos de testing automatizado.
