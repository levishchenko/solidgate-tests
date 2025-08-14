# 🔍 Automation Framework: Web & API Testing

This project is an automation framework for **UI** and **API** testing using:
- [Selenide](https://selenide.org/) – for browser automation
- [RestAssured](https://rest-assured.io/) – for API testing
- [JUnit 5](https://junit.org/junit5/) – for test execution and structure
- [Gradle](https://gradle.org/) – as the build and dependency management tool

---

## ⚙️ Configuration

### `config.properties`

Located in `src/main/resources/config.properties`, this file contains project-wide test parameters.

#### Example content:

```properties
browser = chrome              # Browser to use (chrome, firefox, edge...)
headless = true               # Run tests in headless mode (true/false)
logging = false               # Enable API request/response logging
publicKey = YOUR_PUBLIC_KEY   # Insert your public API key
secretKey = YOUR_SECRET_KEY   # Insert your secret API key
```
> **Note**: ⚠️ Do not commit secretKey or publicKey to public repositories.

---

## 🧪 Running Tests
Run all tests:
```bash
./gradlew clean test
```
---

## 📑 Logging

- Logging is configured via logback.xml (located in src/main/resources)
- When logging = true, RestAssured logs API requests/responses

---

## 📁 Project Structure
```plaintext
src
├── main
│   ├── java
│   │ ├── api               # API clients classes
│   │ ├── web               # Page objects
│   │ └── utils             # Utils classes
│   └── resources
│      ├── config.properties
│      └── logback.xml
│
└── test
      └─ java
            └─ tests        # Tests classes

```