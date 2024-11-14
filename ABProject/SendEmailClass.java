package ABProject;

import org.apache.commons.mail.*;

import java.io.File;

import static ABProject.Utils.ExtentReportFile;

public class SendEmailClass
{
    public void ExtentReportSendViaEmail () throws EmailException {
        HtmlEmail em = new HtmlEmail();
        em.setHostName("smtp.gmail.com");
        em.setSmtpPort(465);

        em.setAuthenticator(new DefaultAuthenticator("saliktestqa@gmail.com", ""));
        em.setSSLOnConnect(true);
        em.setFrom("saliktestqa@gmail.com");
        em.setSubject("Salik AB Project Report ");
        em.setMsg("We Shared the My Test extent report ");
        em.addTo("mohammadsalikcse@gmail.com");
        em.addTo("mohammedsalik2511@gmail.com");
        em.attach(new File(ExtentReportFile));
        em.send();
        System.out.println("sended");
    }
}
