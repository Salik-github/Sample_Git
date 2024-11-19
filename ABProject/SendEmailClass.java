package ABProject;

import org.apache.commons.mail.*;

import java.io.File;

import static ABProject.Utils.ExtentReportFile;

public class SendEmailClass
{
    public void ExtentReportSendViaEmail () throws EmailException {

        HtmlEmail em = new HtmlEmail();
        DataProperites Obj = new DataProperites();
        em.setHostName(Obj.GetDataFromPropertiesFile("EmailHostName"));
        em.setSmtpPort( Integer.parseInt(Obj.GetDataFromPropertiesFile("SmtpPort")));

        em.setAuthenticator(new DefaultAuthenticator(Obj.GetDataFromPropertiesFile("SenderEmail"), ""));
        em.setSSLOnConnect(true);
        em.setFrom(Obj.GetDataFromPropertiesFile("SenderEmail"));
        em.setSubject(Obj.GetDataFromPropertiesFile("EmailSubject"));
        em.setMsg(Obj.GetDataFromPropertiesFile("EmailMessage"));
        em.addTo(Obj.GetDataFromPropertiesFile("ReceiverEmail1"));
       // em.addTo("mohammedsalik2511@gmail.com");
        em.attach(new File(ExtentReportFile));
        em.send();
        System.out.println("sended");
    }
}
