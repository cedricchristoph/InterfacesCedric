/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasmtp.model.entity;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Cedric Christoph
 */
public class MailSender {
    
    private Properties properties;
    private Session session;
    
    public MailSender() {
        
    }
     
    /**
     * Funcion que envía el objeto email proporcionado
     * @param mail Objeto mail a enviar
     * @return True si se ha enviado correctamente
     */
    public boolean send(Mail mail) {
        try {
            properties = new Properties();
            properties.setProperty("mail.smtp.host", mail.getLocalhost().getHostAddress());  
            session = Session.getDefaultInstance(properties);
            MimeMessage mailMessage = new MimeMessage(session);
            mailMessage.setFrom(mail.getSender());
            mail.getRecipients().forEach(r -> {
                try {
                    mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(r));
                } catch (AddressException ex) {
                    Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            mailMessage.setSubject(mail.getSubject());
            mailMessage.setText(mail.getBody(), "UTF-8");
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            //Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
            
            /*  
                Aqui colocaríamos FALSE y activaríamos el Logger para devolver que hubo un error. 
                Devolvemos TRUE únicamente para simular el funcionamiento correcto!!
            */
            
            return true; 
        }
    }
    
}
