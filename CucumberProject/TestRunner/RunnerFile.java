package CucumberProject.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
    features = {"src/test/java/CucumberProject/FeatureFiles/login.feature"},
    dryRun = !true,
    glue="CucumberProject.StepDef",
    snippets = SnippetType.CAMELCASE,
    monochrome =true
)
public class RunnerFile extends AbstractTestNGCucumberTests {
    
}
