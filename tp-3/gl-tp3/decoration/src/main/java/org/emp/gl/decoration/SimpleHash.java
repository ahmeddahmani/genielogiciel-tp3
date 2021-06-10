/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.decoration;

import org.emp.gl.decoration.Decor;
import org.emp.gl.messages.IMessage;

/**
 *
 * @author ahmed
 */
public class SimpleHash extends Decor{

    public SimpleHash(IMessage m) {
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
        this.message.setMessage(message.concat(String.valueOf(message.length())));
        
        
    }
    
    
}
