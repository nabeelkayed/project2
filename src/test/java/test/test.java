package test;
import org.junit.runner.*;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.*;
@RunWith(Cucumber.class)
@CucumberOptions(features = "use_cases" ,
plugin = {"html:target/cucumber/wikipedia.html" } , 
monochrome = true,
snippets = SnippetType.CAMELCASE ,
glue = {"test"},
strict = true
)
public class test {

}
