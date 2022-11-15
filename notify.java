import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class notify extends User {
    String receive_email = super.getEmail();
    String send_email = "bolu2710@gmail.com";
    String host = "localhost";

    Properties properties = new Properties();
    {
        properties.setProperty("smtp.gmail.com", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(send_email));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receive_email));
            message.setSubject("Due Date is Close");
            message.setText("Hi, your due date is close");

            Transport.send(message);
            System.out.println("It has Sent");

        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

    }

    public void sent() {
        LocalDate date = LocalDate.now();

        LocalDate due = date.minusDays(-21);

        if (due == due) {
            properties.setProperty("smtp.gmail.com", host);
            Session session = Session.getDefaultInstance(properties);

            try {
                MimeMessage message = new MimeMessage(session);

                message.setFrom(new InternetAddress(send_email));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(receive_email));
                message.setSubject("Due Date is Close");
                message.setText("Hi, your due date is close");

                Transport.send(message);
                System.out.println("It has Sent");

            } catch (MessagingException ex) {
                ex.printStackTrace();
            }

        }
    }
}
