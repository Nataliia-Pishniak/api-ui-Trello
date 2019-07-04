package junk;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendEmail {

    @Test

        public void asdasd() throws Exception {
        Email email = new SimpleEmail(); // Create Object
        email.setHostName("smtp.googlemail.com"); // Set SMTP hostname
        email.setSmtpPort(465); // Set port
        email.setAuthenticator(new DefaultAuthenticator("npishnyak123@gmail.com", "npishnyak12345")); // Set email/password
        email.setSSLOnConnect(true); // SSL true
        email.setFrom("npishnyak123@gmail.com"); // set FROM
        email.setSubject("TestMail"); // set Subject
        email.setMsg("This is a test mail ... :-)"); // Set message
        email.addTo("npishnyak123@gmail.com"); // Set recipients
        email.send(); // Send Email
    }

}
