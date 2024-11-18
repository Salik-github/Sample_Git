package ABProject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static ABProject.Utils.JsonFile;


public class FileGetData {
    FileInputStream fileread;
    JSONTokener tokener;
    JSONArray jsonArray;
    static  List<String> Runnercondition;
    static  List<Integer> retry;
    static  List<String> TestCases;

    public FileGetData() throws FileNotFoundException {
        fileread = new FileInputStream(JsonFile);
        tokener = new JSONTokener(fileread);
        jsonArray = new JSONArray(tokener);
        GetTestCaseNAme();
    }

    public List<String> GetTestCaseNAme() {

        TestCases = new ArrayList<>();
        Runnercondition = new ArrayList<>();
        retry = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject getData = jsonArray.getJSONObject(i);
            TestCases.add(getData.getString("testCaseName"));
            Runnercondition.add(getData.getString("testCaseStatus"));
            retry.add(getData.getInt("retry"));
        }
        return TestCases;

    }

    public List<String> GetTestStatus() {

        Runnercondition = new ArrayList<>();
        retry = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject getData = jsonArray.getJSONObject(i);
            String testcaseName = getData.getString("testCaseName");
            Runnercondition.add(getData.getString("testCaseStatus"));
            retry.add(getData.getInt("retry"));

            TestCases.add(testcaseName);
            System.out.println(testcaseName);

        }
        return TestCases;

    }
}
