package com.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by xyfhy on 16/7/28.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloControllerTests.class,
        UserControllerTests.class,
        ProductDetailControllerTests.class,
        ProductDetailControllerTests2.class,
        ProductDetailControllerTests3.class,

})
public class AllTests {
}
