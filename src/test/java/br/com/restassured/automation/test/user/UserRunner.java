package br.com.restassured.automation.test.user;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:/features/user"},
        glue = {"br.com.restassured.automation.test.user"},
        plugin = {"pretty", "json:target/cucumber/user.json"}
)
public class UserRunner {

}
