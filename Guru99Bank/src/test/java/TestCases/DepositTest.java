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

	    try {

	        ConfigReader config =
	                new ConfigReader();

	        LoginPage login =
	                new LoginPage(driver);

	        login.login(
	                config.getUsername(),
	                config.getPassword());

	        System.out.println(
	                "Account ID Used = "
	                + TestData.accountId1);

	        DepositPage deposit =
	                new DepositPage(driver);

	        deposit.depositMoney(
	                TestData.accountId1,
	                "5000");

	        System.out.println(
	                driver.findElement(By.tagName("body"))
	                      .getText());

	    } catch (Exception e) {

	        e.printStackTrace();
	        throw e;
	    }
	}
}
