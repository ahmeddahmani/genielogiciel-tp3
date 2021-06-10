/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AESCryptage extends Decor{

    public AESCryptage(IMessage m) {
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
        if(message!=null){
        try {
            this.message.setMessage(AEO(message));
        } catch (Exception ex) {
            Logger.getLogger(AESCryptage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        } 
    }
    private static final String AES
        = "AES";
  
    // We are using a Block cipher(CBC mode)
    private static final String AES_CIPHER_ALGORITHM
        = "AES/CBC/PKCS5PADDING";
  
    private static Scanner message1;
  
    // Function to create a
    // secret key
    public static SecretKey createAESKey()
        throws Exception
    {
        SecureRandom securerandom
            = new SecureRandom();
        KeyGenerator keygenerator
            = KeyGenerator.getInstance(AES);
  
        keygenerator.init(256, securerandom);
        SecretKey key
            = keygenerator.generateKey();
  
        return key;
    }
  
    // Function to initialize a vector
    // with an arbitrary value
    public static byte[] createInitializationVector()
    {
  
        // Used with encryption
        byte[] initializationVector
            = new byte[16];
        SecureRandom secureRandom
            = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }
  
    // This function takes plaintext,
    // the key with an initialization
    // vector to convert plainText
    // into CipherText.
    public static byte[] do_AESEncryption(
        String plainText,
        SecretKey secretKey,
        byte[] initializationVector)
        throws Exception
    {
        Cipher cipher
            = Cipher.getInstance(
                AES_CIPHER_ALGORITHM);
  
        IvParameterSpec ivParameterSpec
            = new IvParameterSpec(
                initializationVector);
  
        cipher.init(Cipher.ENCRYPT_MODE,
                    secretKey,
                    ivParameterSpec);
  
        return cipher.doFinal(
            plainText.getBytes());
    }
  
    // This function performs the
    // reverse operation of the
    // do_AESEncryption function.
    // It converts ciphertext to
    // the plaintext using the key.
    public static String do_AESDecryption(
        byte[] cipherText,
        SecretKey secretKey,
        byte[] initializationVector)
        throws Exception
    {
        Cipher cipher
            = Cipher.getInstance(
                AES_CIPHER_ALGORITHM);
  
        IvParameterSpec ivParameterSpec
            = new IvParameterSpec(
                initializationVector);
  
        cipher.init(
            Cipher.DECRYPT_MODE,
            secretKey,
            ivParameterSpec);
  
        byte[] result
            = cipher.doFinal(cipherText);
  
        return new String(result);
    }
    
    public static String AEO(String message)
        throws Exception
    {
        SecretKey Symmetrickey
            = createAESKey();
  
        
  
        byte[] initializationVector
            = createInitializationVector();
  
       
        // Encrypting the message
        // using the symmetric key
        byte[] cipherText
            = do_AESEncryption(
                message,
                Symmetrickey,
                initializationVector);
  
        
            return DatatypeConverter.printHexBinary(
                  cipherText);
      
    
}
}