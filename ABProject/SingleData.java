package ABProject;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import static ABProject.Utils.JsonFile;
import static ABProject.Utils.TestDate_Path;

public class SingleData {
    String Excelpath = TestDate_Path;
    String SheetName = "Sheet1";
    XSSFSheet sheet;
    XSSFWorkbook workbook;
    JSONArray jsonArray;
    public void  ExternalObject() throws Exception {
        File file = new File(Excelpath);
        FileInputStream fileInputStream = new FileInputStream(file);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(SheetName);
        ReadData1();
        ExcelDataWriteIntotheJsonFile();
    }
    public  void ExcelDataWriteIntotheJsonFile() throws IOException {

        FileWriter fileWriter = new FileWriter(JsonFile);
        fileWriter.write(jsonArray.toString(4));
        fileWriter.close();
    }
    public void ReadData1() throws Exception {
      jsonArray = new JSONArray();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            JSONObject jsonObject1 = new JSONObject();
            XSSFRow row = sheet.getRow(i);
            jsonObject1.put("testCaseStatus", row.getCell(1).getStringCellValue());
            jsonObject1.put("testCaseName", row.getCell(0).getStringCellValue());
            jsonObject1.put("retry", row.getCell(2).getNumericCellValue());
            jsonArray.put(jsonObject1);
        }

        workbook.close();
    }
}





