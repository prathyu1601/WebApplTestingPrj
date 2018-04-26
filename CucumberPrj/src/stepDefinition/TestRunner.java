package stepDefinition;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="NewTours",glue= {"newToursLogInTest"})
// parameter 1 - feature file folder name
// parameter 2 - package name where actual Junit Test functions are written


public class TestRunner 
{
	
}
