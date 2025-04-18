# Testing Automation - Proyecto Final QA Icaro

Este proyecto implementa pruebas automatizadas para validar la funcionalidad del formulario de registro en el sitio web [Buggy Cars Rating](https://buggy.justtestit.org). Utiliza herramientas modernas como Selenium, Cucumber y JUnit para escribir y ejecutar pruebas funcionales.

##  Funcionalidades probadas

### Escenarios de prueba implementados:

1. **Registro exitoso con datos válidos**
   - Verifica que los usuarios puedan registrarse correctamente cuando ingresan datos válidos.
   - Se espera que el mensaje de éxito sea: `Registration is successful`.

2. **Registro con datos inválidos**
   - Prueba varios casos de errores al intentar registrarse con datos incorrectos o incompletos. Los mensajes de error esperados incluyen:
     - `Username already exists`
     - `Passwords do not match`
---

##  Tecnologías y herramientas utilizadas

- **Java 17**
- **Maven** para la gestión de dependencias.
- **Selenium WebDriver** para la automatización del navegador.
- **Cucumber** para la escritura de pruebas basadas en Gherkin.
- **JUnit** para la ejecución de pruebas.
- **Google Chrome** (a través de ChromeDriver).

---

##  Configuración y ejecución

### 1. Requisitos previos
- Instalar **Java 17** o superior.
- Instalar **Maven** (versión 3.6 o superior).
- Tener **Google Chrome** instalado y su versión correspondiente de **ChromeDriver** disponible.

### 2. Clonar el repositorio
```bash
git clone https://github.com/annitx/TestingAutomationIcaro.git
cd TestingAutomationIcaro
```

### 3. Configurar el proyecto
- Asegúrate de tener el archivo `chromedriver.exe` ubicado en la ruta:
  ```
  src/main/driver/chromedriver.exe
  ```
- Verifica que la versión de `chromedriver` sea compatible con tu versión de Google Chrome.

### 4. Ejecutar las pruebas
Para ejecutar las pruebas, usa el siguiente comando:
```bash
mvn test
```

### 5. Resultados
- Los resultados de las pruebas aparecerán en la consola.

---


##  Detalles de las pruebas

### Archivos `.feature`
- Localizados en `src/test/resources/features`.
- Contienen escenarios escritos en **Gherkin** que describen los pasos de las pruebas.

### Clases de Step Definitions
- Localizadas en `src/test/java/com/qaautomation/stepdefinitions`.
- Implementan los pasos definidos en los archivos `.feature`.

### Clases de página (Page Object Model)
- Localizadas en `src/main/java/Page`.
- Manejan la interacción con los elementos de la página.

---

##  Notas importantes

- Este proyecto requiere que el servidor de Buggy Cars Rating esté operativo antes de ejecutar las pruebas.

---

##  Contacto

Si tenes preguntas o comentarios sobre este proyecto, no dudes en contactarme:

- **GitHub:** [annitx](https://github.com/annitx)
