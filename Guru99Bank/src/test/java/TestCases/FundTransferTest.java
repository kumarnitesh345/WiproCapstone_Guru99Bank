package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.FundTransferPage;
import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.TestData;
import Utilities.WaitUtils;

public class FundTransferTest extends BaseTest {

    @Test
    public void fundTransferTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        Assert.assertNotNull(
                TestData.accountId1,
                "Account ID 1 is null");

        Assert.assertNotNull(
                TestData.accountId2,
                "Account ID 2 is null");

        System.out.println(
                "From Account = "
                        + TestData.accountId1);

        System.out.println(
                "To Account = "
                        + TestData.accountId2);

        FundTransferPage transfer =
                new FundTransferPage(driver);

        transfer.transferFunds(
                TestData.accountId1,
                TestData.accountId2,
                "2500");
        TestData.account1Balance =
                TestData.account1Balance - 2500;

        

        System.out.println(
                "Transfer Amount = 2500");

        System.out.println(
                "Sender Balance = "
                        + TestData.account1Balance);

        
        WaitUtils.waitForText(
                driver,
                "Fund Transfer Details");

        Assert.assertTrue(
                driver.getPageSource()
                        .contains(
                                "Fund Transfer Details"),
                "Fund Transfer Failed");
    }
}