package br.com.restassured.automation.test.product;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:/features/product"},
        glue = {"br.com.restassured.automation.test.product"},
        plugin = {"pretty", "json:target/cucumber/product"}
)
public class ProductRunner {

}
