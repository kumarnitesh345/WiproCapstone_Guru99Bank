package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.WithdrawalPage;
import Utilities.ConfigReader;
import Utilities.TestData;
import Utilities.WaitUtils;

public class WithdrawalTest extends BaseTest {

	@Test
	public void withdrawalMoneyTest() {

	    ConfigReader config =
	            new ConfigReader();

	    LoginPage login =
	            new LoginPage(driver);

	    login.login(
	            config.getUsername(),
	            config.getPassword());

	    WithdrawalPage withdrawal =
	            new WithdrawalPage(driver);

	    Assert.assertNotNull(
	            TestData.accountId1,
	            "Account ID 1 is null");

	    withdrawal.withdrawMoney(
	            TestData.accountId1,
	            "1000");

	    WaitUtils.waitForText(
	            driver,
	            "Transaction details of Withdrawal");

	    Assert.assertTrue(
	            driver.getPageSource()
	                  .contains(
	                  "Transaction details of Withdrawal"));
	}
}
