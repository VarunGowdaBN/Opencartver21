# Opencart Automation Testing Framework

## 📌 Project Overview

This project is an Automation Testing Framework developed using Selenium WebDriver, Java, TestNG, and Maven.
The framework is designed using Page Object Model (POM) to automate the OpenCart web application.

The automation covers major e-commerce functionalities like login, product search, cart, and checkout.

Application under test: https://tutorialsninja.com/demo

---

## 🛠 Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Git & GitHub
* Docker Selenium Grid
* Chrome & Firefox Browser
* Rest Assured (API Testing – optional)

---

## 📂 Project Structure


| Folder / File                        | Description                                       |
| ------------------------------------ | ------------------------------------------------- |
| src/test/java/pageObjects            | Page Object Model classes                         |
| src/test/java/TestCases              | Test case classes                                 |
| src/test/java/Testbase               | Base class for setup & teardown                   |
| src/test/java/Utilities              | Utility classes (Excel, Wait, Helpers)            |
| src/test/resources/config.properties | Configuration file                                |
| src/test/resources/log4j2.xml        | Log file configuration                            |
| Testdata                             | Test data files used for Data Driven Testing      |
| Testdata/Opencart_LoginData.xlsx     | Excel test data                                   |
| Reports                              | Extent / TestNG reports generated after execution |
| Screenshots                          | Failure test screenshots automatically saved here |
| Logs                                 | Execution logs                                    |
| test-output                          | TestNG default reports                            |
| docker-compose.yaml                  | Docker Selenium Grid setup file                   |
| pom.xml                              | Maven dependencies                                |
| master.xml                           | TestNG master suite                               |
| grouping.xml                         | TestNG grouping suite                             |
| Main.xml                             | TestNG execution file                             |
| run.bat                              | Batch file to run tests                           |
| target                               | Maven build folder                                |


---

## ✅ Features Implemented

* Page Object Model Framework
* Cross Browser Testing
* Parallel Execution using TestNG
* Selenium Grid with Docker
* Login Test
* Registration Test
* Product Search Test
* Add to Cart Test
* Checkout Test
* HTML Report Generation

---

## ▶ How to Run Project

1. Clone the repository

git clone https://github.com/VarunGowdaBN/Opencartver21.git

2. Open project in Eclipse / IntelliJ

3. Update Maven dependencies

4. Run Main.xml or click on ran.bat file or Right click on POM.xml then run as Maven Test

---

## 🧪 Test Execution

Run using TestNG suite file

testng.xml

Supports:

* Chrome
* Firefox
* Parallel execution

---

## 👨‍💻 Author

Varun Gowda B N
Automation Test Engineer
Experience: 2 Years
Skills: Selenium | Java | TestNG | API Testing | Manual Testing | Git | Docker | Jenkins

