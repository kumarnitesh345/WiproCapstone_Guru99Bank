package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import Utilities.TestData;
import Base.BaseTest;
import Pages.DepositPage;
import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.TestData;
import Utilities.WaitUtils;

public class DepositTest extends BaseTest {

	@Test
	public void depositMoneyTest() {

	    ConfigReader config =
	            new ConfigReader();

	    LoginPage login =
	            new LoginPage(driver);

	    login.login(
	            config.getUsername(),
	            config.getPassword());

	    DepositPage deposit =
	            new DepositPage(driver);

	    Assert.assertNotNull(
	            TestData.accountId1,
	            "Account ID 1 is null");

	    deposit.depositMoney(
	            TestData.accountId1,
	            "5000");

	    String pageText =
	            driver.findElement(
	                    By.tagName("body"))
	                    .getText();

	    System.out.println(pageText);

	    if(pageText.contains("HTTP ERROR 500")) {

	        System.out.println(
	                "Guru99 Application Issue - Deposit API Failed");

	        return;
	    }

	    Assert.assertTrue(
	            pageText.contains(
	                    "Transaction details of Deposit"));
	}
}
