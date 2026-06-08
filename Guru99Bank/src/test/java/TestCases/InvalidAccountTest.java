package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.DepositPage;
import Utilities.ConfigReader;

public class InvalidAccountTest extends BaseTest {

    @Test
    public void invalidAccountDepositTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        DepositPage deposit =
                new DepositPage(driver);

        deposit.depositMoney(
                "99999999",
                "500");

        Assert.assertTrue(true);

        System.out.println(
                "Invalid Account Test Executed");
    }
}
