package br.com.restassured.automation.test.login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:/features/login"},
        glue = {"br.com.restassured.automation.test.login"},
        plugin = {"pretty", "json:target/cucumber/login.json"}
)
public class LoginRunner {

}
