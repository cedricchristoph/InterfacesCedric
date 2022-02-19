/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareasmtp.model.entity;

/**
 * @author Cedric Christoph
 */
public interface IMail {
    
    void addRecipinents(String[] recipients);
    void addRecipient(String recipient);
    void setSender(String psender);
    void setSubject(String subject);
    void setBody(String pbody);
    
}
