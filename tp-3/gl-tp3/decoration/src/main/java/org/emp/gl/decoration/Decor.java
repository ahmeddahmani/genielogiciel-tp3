/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.decoration;

import org.emp.gl.messages.IMessage;

/**
 *
 * @author ahmed
 */
public abstract class Decor implements IMessage{
 
     protected IMessage message;
        public Decor(IMessage m)
        {
            this.message=m;
        }
        @Override
    public String toString() {
        return new StringBuilder()
                .append("sender : ")
                .append(getSender())
                .append("\n")
                .append("title : ")
                .append(getTitle())
                .append("\n")
                .append("message : ")
                .append(getMessage())
                .toString() ;
    }
    
    
}
