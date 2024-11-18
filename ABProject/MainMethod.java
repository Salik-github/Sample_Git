package ABProject;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ABProject.FileGetData.*;


public class MainMethod
{
   // public  static  void main(String [] args) throws Exception {
    @Test
    public  void testMethod() throws Exception {

        SingleData objectofSingledata = new SingleData();
        objectofSingledata.ExternalObject();

        FileGetData fileGetData = new FileGetData() ; // Compulsory for Creating This class object

        TestNG testNG = new TestNG();
        testNG.addListener((new ItestListenerClass()));


        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("SuiteOne");
        xmlSuite.setParallel(XmlSuite.ParallelMode.METHODS);    /*used for the parallel test run*/
        xmlSuite.setVerbose(4);

        XmlTest xmlTest = new XmlTest(xmlSuite);
        xmlTest.setName("RUNTestCase");

        XmlClass xmlClass = new XmlClass("ABProject.TestCaseClass");
        List<XmlInclude> listOFmethod = new ArrayList<XmlInclude>();

        List<String> testcasename = TestCases;
        List<String> runnerConditions = Runnercondition;

        for(String a :testcasename)
        {
           int index =  testcasename.indexOf(a);
           XmlInclude xmlInclude = new XmlInclude(a);
            if(runnerConditions.get(index).equalsIgnoreCase("Yes")){
                listOFmethod.add(xmlInclude);
            }else
            {
                Map<String, String> parameters = new HashMap<>();
                parameters.put("skipReason", "Skipped due to condition not met");
                System.out.println(a);
                xmlInclude.setParameters(parameters); // Pass the parameters
                listOFmethod.add(xmlInclude);
            }
        }
        xmlClass.setIncludedMethods(listOFmethod);

        xmlTest.setXmlClasses(List.of(xmlClass));
        testNG.setXmlSuites(List.of(xmlSuite));

        testNG.run();

    // Dynamically Create XML File
        FileWriter fileWriter ;
        try{
            fileWriter = new FileWriter(new File(    "NewFile.xml"));
            fileWriter.write(xmlSuite.toXml());
            fileWriter.flush();
            fileWriter.close();

        }catch(Exception e)
        {
            System.out.println("This is "+ e);
        }
    }
}
