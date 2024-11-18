package ABProject;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import static ABProject.FileGetData.*;

public class RetryAnalyser implements IRetryAnalyzer {
    int startcount =0;
    int maxcount;
    @Override
    public boolean retry(ITestResult result) {
        String a =  result.getMethod().getMethodName();
        int index = TestCases.indexOf(a);
        this.maxcount = retry.get(index);
        if (!result.isSuccess()&& startcount < maxcount) {
            startcount++;
            return true;
        }
        return false;
    }
}
