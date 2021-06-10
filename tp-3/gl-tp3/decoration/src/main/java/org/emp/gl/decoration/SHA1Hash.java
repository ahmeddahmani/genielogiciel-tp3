/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.decoration;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.emp.gl.decoration.Decor;
import org.emp.gl.messages.IMessage;

/**
 *
 * @author ahmed
 */
public class SHA1Hash extends Decor{

    public SHA1Hash(IMessage m) {
        super(m);
        
        this.setMessage(this.getMessage());
        
    }

    
    @Override
    public String getTitle() {
       return this.message.getTitle();
    }

    @Override
    public String getSender() {
        return this.message.getSender();
    }

    @Override
    public String getMessage() {
        return this.message.getMessage();
    }

    @Override
    public void setTitle(String title) {
        this.message.setTitle(title);
    }

    @Override
    public void setSender(String sender) {
        this.message.setMessage(sender);
    }

    @Override
    public void setMessage(String message) {
        //System.out.println(message);
        if(message!=null)
        this.message.setMessage(message.concat(String.valueOf(getSha1(message))));
        
        
    }
    public static String getSha1(String input)
    {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");
  
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
  
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
  
            // return the HashText
            return hashtext;
        }
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
