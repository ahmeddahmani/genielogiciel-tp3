package org.emp.gl.decoration;


import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;
import org.emp.gl.decoration.Decor;
import org.emp.gl.messages.IMessage;

/**
 *
 * @author ahmed
 */
public class DecalageCryptage extends Decor{
    private int s=4;
    public DecalageCryptage(IMessage m ,int s) {
        super(m);
        this.s=s;
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
        if(message!=null){
        
            this.message.setMessage(encrypt(message,this.s).toString());
        
        } 
    }
   
    
    public static StringBuffer encrypt(String text,int s)
    {
        StringBuffer result= new StringBuffer();
 
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                                 s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
}
