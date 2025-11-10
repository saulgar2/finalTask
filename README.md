# finalTask — SauceDemo BDD (JUnit + Maven)

Casos pedidos:
- UC-1: Username is required
- UC-2: Password is required
- UC-3: Login con usuarios aceptados (pwd: `secret_sauce`) y validación de “Swag Labs”

## Stack
Selenium WebDriver, Cucumber + JUnit 5, Maven, XPath, Chrome/Edge, Paralelismo (JUnit), Logging (SLF4J+Logback).

## Ejecutar
```bash
mvn clean test                  # Chrome
mvn clean test -Dbrowser=edge   # Edge
```

## Ejecutar desde IntelliJ (feature)
- Plugins: **Gherkin** y **Cucumber for Java**.
- Usa la run config incluida: **Run Login Feature** (carpeta `.run/`).

Estructura:
```
finalTask/
 ├─ pom.xml
 └─ src/test/...
```