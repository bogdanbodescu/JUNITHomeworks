package ro.siit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorTests.class,
        ParameterizedTests.class,
})
public class SuiteTests {
}
