/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgv_tarea7cedric;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Cedric Christoph
 */
public class CryptoUtils {
    
    public static String algorithm = "Rijndael/ECB/PKCS5Padding";
    private static String saltString = "[B@4d7e1886";
    
    public static String encrypt(String input, String password) {
        byte[] crypted = null;
        try {
            SecretKeySpec skey = new SecretKeySpec(getKey(password), "AES");
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
            java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
            return encoder.encodeToString(crypted);
        } catch (Exception e) {

        }
        return null;
    }

    public static String decrypt(String input, String password) {
        byte[] output = null;
        try {
            java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
            SecretKeySpec skey = new SecretKeySpec(getKey(password), "AES");
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, skey);
            output = cipher.doFinal(decoder.decode(input));
        } catch (Exception e) {

        }
        return new String(output);
    }

    private static byte[] getKey(String password) {
        //SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        //random.nextBytes(salt);
        //System.out.println(salt);
        
        salt = saltString.getBytes();
        
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128); // AES-256
        SecretKeyFactory f = null;
        try {
            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CryptoUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        try {
            byte[] key = f.generateSecret(spec).getEncoded();
            return key;
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(CryptoUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        return null;
    }
    
}
