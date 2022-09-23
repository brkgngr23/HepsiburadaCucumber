# HepsiburadaCucumber

## Introduction


- **integration-test** is the Java-based automation project which is testing Hepsiburada using Selenium and Cucumber.

## Pre-conditions

#### What you need

- Java JDK 11 installed and configured (with _JAVA_HOME_ and _PATH_ configured)
- Allure installed and configured
### Languages & Environments & Tools

![Open JDK](https://img.shields.io/github/v/tag/openjdk/jdk11u?color=%23ff9800&label=openjdk%2011&logo=java&logoColor=%23ff9800&style=for-the-badge) ![Maven](https://img.shields.io/github/v/tag/apache/maven?color=ff5733&label=apache&logo=apache&logoColor=ff5733&style=for-the-badge)

Make sure you have installed all the following prerequisites on your development machine:

| OS      | OpenJDK 11                        | Maven                 |
| ------- | --------------------------------- | --------------------- |
| Windows | `choco install openjdk11`         | `choco install maven` | 
| Ubuntu  | `sudo apt install openjdk-11-jdk` | `sdk install maven`   | 
| macOS   | `brew install openjdk@11`         | `brew install maven`  | 

- [Homebrew](https://brew.sh) is highly recommended to installed required packages on Mac OS or Linux.
- [Snap](https://snapcraft.io/store) is an alternative application to installing and managing the Linux packages.
- [Chocolatey](https://chocolatey.org) is highly recommended to installed required packages on Windows.

### Libraries & Dependencies

- Integration Test

- [Selenium Webdriver](https://selenium.dev) : Web UI test automation framework
- [Cucumber](https://cucumber.io) : Tool that supports Behaviour Driven Development
- [Junit Vintage Engine](https://junit.org/junit5) : The engine of the testing framework that provides to executing the cucumber features
- [AssertJ Core](https://assertj.github.io/doc) : Fluent assertion library
- [Allure](https://docs.qameta.io/allure) : Reporting framework to monitoring test suite results
- [Log4j2](https://logging.apache.org/log4j/2.x) : Logging library

### Test Executions

- Integration Test

- Navigate to the project directory:

- Run the test below command:

```sh
mvn clean test -P 'environment' -Dbrowser='browserName' -Dheadless='true or false' -Dremote='true or false'
```

You can specify which browser to use by using one of the following on the command line. The parameter is optional. If the default value is used, the project will be executed using a Chrome browser.

- `-Dbrowser=chrome` (default)
- `-Dbrowser=FIREFOX`

You can specify whether headless mode will be used or not following on the command line. The parameter is optional. If the default value is used, the project will be executed using a browser with a graphical user interface.

- `-Dheadless=false` (default)
- `-Dheadless=true`

