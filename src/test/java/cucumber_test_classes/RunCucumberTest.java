package cucumber_test_classes;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;  
import org.junit.runner.RunWith;  

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources", strict = true)

public class RunCucumberTest {

}
