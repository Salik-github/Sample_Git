package Email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class First {

    @BeforeClass
    public void Beforemethod()
    {
        System.out.println("Test Before");
    }

    @Test
    public void TestMethod()
    {
        int a =10; int b = 20 ;
        Assert.assertEquals(a, b);
       
    }
    @AfterMethod
    public void SendEmail(ITestResult result) throws EmailException {
        if(result.getStatus() ==ITestResult.FAILURE)
        {
        System.out.println("start");
        Email em = new SimpleEmail();
        em.setHostName("smtp.gmail.com");
        em.setSmtpPort(465);
        em.setAuthenticator(new DefaultAuthenticator("saliktestqa@gmail.com", "epllztnzsfwzeuqh"));
        em.setSSLOnConnect(true);
        em.setFrom("saliktestqa@gmail.com");    
        em.setSubject("Nothing is test");
        em.setMsg("test");
        em.addTo("mohammadsalikcse@gmail.com");
        em.send();
        System.out.println("sended");
        }
    }
}
