package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.NewCustomerPage;
import Utilities.ConfigReader;
import Utilities.WaitUtils;

public class CustomerTest extends BaseTest {

    @Test
    public void createCustomerTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        NewCustomerPage customer =
                new NewCustomerPage(driver);

        customer.addCustomer();
        WaitUtils.waitForText(
                driver,
                "Customer Registered Successfully");

        Assert.assertTrue(
                driver.getPageSource()
                      .contains(
                              "Customer Registered Successfully"));
    }
}

