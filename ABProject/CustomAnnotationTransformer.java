package ABProject;


import org.testng.IAnnotationTransformer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

    public class CustomAnnotationTransformer implements IAnnotationTransformer {

      //  private ItestListenerClass listener = new ItestListenerClass();

        @Override
        public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

            System.out.println("Checking RetryAnalyzer for method: " + testMethod.getName());

            if(annotation.getRetryAnalyzerClass()==null)
            {
                System.out.println("this issssss");
                annotation.setRetryAnalyzer(RetryAnalyser.class);
            }
        }

    }

