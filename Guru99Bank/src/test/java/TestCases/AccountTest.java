package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.NewAccountPage;
import Utilities.ConfigReader;
import Utilities.TestData;

public class AccountTest extends BaseTest {

    @Test
    public void createAccountTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        Assert.assertNotNull(
                TestData.customerId,
                "Customer ID is null");

        NewAccountPage account =
                new NewAccountPage(driver);

        account.createAccount(
                TestData.customerId);

        account.createAccount(
                TestData.customerId);

        Assert.assertNotNull(
                TestData.accountId1);

        Assert.assertNotNull(
                TestData.accountId2);

        System.out.println(
                "Account 1 = "
                        + TestData.accountId1);

        System.out.println(
                "Account 2 = "
                        + TestData.accountId2);
    }
}