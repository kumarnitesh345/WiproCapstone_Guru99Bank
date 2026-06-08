package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.TestData;

public class CustomerValidationTest {

    @Test
    public void validateCustomerId() {

        System.out.println(
                "Customer ID = "
                + TestData.customerId);

        Assert.assertNotNull(
                TestData.customerId);
    }
}
