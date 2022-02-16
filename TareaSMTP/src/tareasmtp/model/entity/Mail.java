/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasmtp.model.entity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Mail
 * @author Cedric Christoph
 */
public class Mail implements IMail {

    private InetAddress localhost;
    
    private String sender;
    private String subject;
    private String body;
    
    private ArrayList<String> recipients;
    
    public Mail() {
        try {
            localhost = InetAddress.getLocalHost();
            this.recipients = new ArrayList<>();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que añade un array de destinatarios a recipients
     * @param recipients destinatarios a añadir
     */
    @Override
    public void addRecipinents(String[] recipients) {
        Arrays.stream(recipients).forEach(r -> this.recipients.add(r));
    }

    /**
     * Metodo que añade un destinatario a recipients
     * @param recipient 
     */
    @Override
    public void addRecipient(String recipient) {
        this.recipients.add(recipient);
    }

    /**
     * Metodo que configura el origen
     * @param psender 
     */
    @Override
    public void setSender(String psender) {
        sender = psender;
    }

    
    // Getter & Setter
    
    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setBody(String pbody) {
        body = pbody;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public InetAddress getLocalhost() {
        return localhost;
    }

    public void setLocalhost(InetAddress localhost) {
        this.localhost = localhost;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }    
    
    @Override
    public String toString() {
        String destination = "";
        for (String s : recipients)
            destination += s + " ";
        return "======== BORRADOR =======================================\n\n" +
               " De: " + sender + "\n" +
               " Para: " + destination + "\n" +
               " Concepto: " + subject + "\n\n" +
               body + "\n" +
               "=========================================================";
    }
    
}
