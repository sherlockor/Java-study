package testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import unitTest.SubtractionUnit;
import unitTest.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SubtractionUnit.class, 
    SumUnit.class
})
public class TestSuit {

}
