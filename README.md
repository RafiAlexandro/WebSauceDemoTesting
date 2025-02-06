![image](https://github.com/user-attachments/assets/55b657b3-53c2-4a9e-b07d-bea99b607f96)

# Sauce Demo Testing

Sauce Demo Web Automation Testing With Selenium Java Cucumber

## Getting Started

### Project Structure

* Base Project: Java
* Build System: Maven
* JDK Version: Oracle OpenJDK 23.0.1
* IDE: Intellij IDEA Community Edition 2024.3.2
* OS Used: Windows 11

### Dependencies

* Cucumber JVM: Java: Version 7.20.1 https://mvnrepository.com/artifact/io.cucumber/cucumber-java
* JUnit: Version 4.13.2 https://mvnrepository.com/artifact/junit/junit
* Cucumber JVM JUnit 4: Version 7.20.1 https://mvnrepository.com/artifact/io.cucumber/cucumber-junit
* Selenium Java: Version 4.28.0 https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
* Cucumber Reporting: Version 5.8.4 https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting
* WebDriverManager: Version 5.9.2 https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager

### Plugins

* Cucumber for Java
* Gherkin

### Installing

* Clone this project
* In 'pom.xml', make sure to reload or sync tha maven project

  ![Screenshot 2025-02-06 131624](https://github.com/user-attachments/assets/59c8d3ee-e93d-4406-80cf-d2981fb0242c)
  ![Screenshot 2025-02-06 131639](https://github.com/user-attachments/assets/b4ed56a2-50c3-49ac-99bf-b9891906e3f4)

### Executing program

* Open terminal
* Run all test (current file)
* After all tests are complete, run this command to generate result
```
mvn verify -DskipTests
```
* Open folder target/cucumber-report-html
* Open file feature-overview.html in Browser
* Overview will be displayed

![Screenshot 2025-02-06 141500](https://github.com/user-attachments/assets/5efc6489-40fb-4865-ad1f-fad33bbcae5d)

## Authors

[Muhammad Rafi Alexandro](https://www.linkedin.com/in/muhammad-rafi-alexandro/)
