/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import java.io.Serializable;

/**
 *
 * @author Victor Malone (vm19171)
 * 
 *  Object for storage of links between nodes
 */
public class Link implements Serializable {
    
    // IDs of connected nodes
    public String from, to;
    
    public Link(String from, String to)
    {
      this.from = from;
      this.to = to;
    }
    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    
    public boolean isSameLink(Link l) {
        
        if (l.from == this.from && l.to == this.to) {
            return true;
        }
        else {
            return false;
        }

    }
}
