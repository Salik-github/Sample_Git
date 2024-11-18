package ABProject;

import java.io.FileInputStream;
import java.util.Properties;
import static ABProject.Utils.PropertiesFile;
public class DataProperites
{
    public  String GetDataFromPropertiesFile(String Key)
    {
        Properties  propertiesData = new Properties();
        try {
            propertiesData.load(new FileInputStream(PropertiesFile));

        }
        catch (Exception e)
        {
            System.out.println(e +"This Exception throw from property file");
        }

        return propertiesData.getProperty(Key);
    }

}
