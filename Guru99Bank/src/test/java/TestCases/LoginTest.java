package TestCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.ExcelUtils;
import Utilities.RetryAnalyzer;

public class LoginTest extends BaseTest {

	String excelPath =
			System.getProperty("user.dir")
			+ "/src/test/resources/Guru99Data.xlsx";

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validLoginTest() throws Exception {

        String username =
                ExcelUtils.getData(excelPath, 0, 1);

        String password =
                ExcelUtils.getData(excelPath, 1, 1);

        System.out.println("Username : " + username);
        System.out.println("Password : " + password);

        LoginPage login =
                new LoginPage(driver);

        login.login(username, password);

        Thread.sleep(2000);

        System.out.println("Current URL : "
                + driver.getCurrentUrl());

        System.out.println("Page Title : "
                + driver.getTitle());

        System.out.println("Contains Manager : "
                + driver.getPageSource().contains("Manager"));

        System.out.println("Contains Manger : "
                + driver.getPageSource().contains("Manger"));

        HomePage home =
                new HomePage(driver);

        boolean status =
                home.verifyManagerHomePage();

        System.out.println(
                "Manager Home Page Status : "
                        + status);

        Assert.assertTrue(
                status,
                "Valid Login Failed");
    }

    @Test
    public void invalidLoginTest() {

        LoginPage login =
                new LoginPage(driver);

        login.login(
                "wrongUser",
                "wrongPass");

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10));

        Alert alert =
                wait.until(
                        ExpectedConditions.alertIsPresent());

        String alertText =
                alert.getText();

        Assert.assertTrue(
                alertText.contains(
                        "User or Password is not valid"),
                "Invalid Login Validation Failed");

        alert.accept();
    }

    @Test
    public void emptyLoginTest() {

        LoginPage login =
                new LoginPage(driver);

        login.login("", "");

        try {

            WebDriverWait wait =
                    new WebDriverWait(
                            driver,
                            Duration.ofSeconds(5));

            Alert alert =
                    wait.until(
                            ExpectedConditions.alertIsPresent());

            String alertText =
                    alert.getText();

            System.out.println(
                    "Alert Message : "
                    + alertText);

            Assert.assertTrue(
                    alertText.contains(
                            "User or Password is not valid"));

            alert.accept();

        } catch (Exception e) {

            System.out.println(
                    "No alert displayed for empty login.");

            // Validate user remains on login page

            Assert.assertTrue(
                    driver.getCurrentUrl()
                          .contains("V4"),
                    "User unexpectedly logged in with empty credentials");

            System.out.println(
                    "Empty Login Validation Successful");
        }
    }
}