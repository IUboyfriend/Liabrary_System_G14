package Controller;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class EmailControll {

    public void SendLibraryEmail(String mail,String subject,String description){
        try {
            Properties prop = new Properties();
            prop.setProperty("mail.smtp.host", "smtp.mxhichina.com"); // SET MAIL SERVER
            prop.setProperty("mail.transport.protocol", "smtp"); // Mail sending protocol
            prop.setProperty("mail.smtp.auth", "true"); // You need to verify the user name and password

            prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.setProperty("mail.smtp.socketFactory.port", "465");
            prop.setProperty("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(prop);

            // After the Session debugger mode is enabled, you can view the running status of mail sending
            session.setDebug(true);

            // The transport object is obtained through the Session
            Transport transport = session.getTransport();

            // Connect to the email server with the email, user name and authorization code (login)
            transport.connect("smtp.mxhichina.com", "huhai@hantek.com", "hantek..123");

            // Write an email
            MimeMessage message = new MimeMessage(session);

            // Set the sender of the email
            message.setFrom(new InternetAddress("huhai@hantek.com"));

            // Set the recipient of the email
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));

            // Title
            message.setSubject(subject);

            // Description
            MimeBodyPart text = new MimeBodyPart();
            text.setContent(description, "text/html; charset=UTF-8");

            // Describe data relationship
            MimeMultipart mm = new MimeMultipart();
            mm.addBodyPart(text);

            // Save the edited message to the message, saving the changes
            message.setContent(mm);
            message.saveChanges();

            // Send the email
            transport.sendMessage(message, message.getAllRecipients());

            // close the connection
            transport.close();
        }
        catch (Exception ex)
        {
            printLog("Fail to send the email，"+ ex);
        }
    }
    public void printLog(String msg)
    {
        Date d = new Date();
        System.out.println(d);
        System.out.println("-------------------");
        System.out.println(msg);
        System.out.println("");
    }
}
