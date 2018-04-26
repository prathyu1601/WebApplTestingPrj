package stepDefinition;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="OrangeHrm", glue= {"OrangeHrmLogInTest"})

public class TestRunner {

}
