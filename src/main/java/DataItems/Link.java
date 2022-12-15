/*
 * Copyright 2022 Victor Malone.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package DataItems;

import java.io.Serializable;

/**
 *This is an object for storage of links between nodes. Used to draw the connections in the DragAndDrop panel.
 * 
 * @author Victor Malone
 * 
 */
public class Link implements Serializable {
    
   /**
    * IDs of connected nodes. from = start, to = destination.
    */
    public String from, to;
    
    /**
     * Constructor that creates a Link from page with ID 'from' to page with ID 'to'.
     * 
     * @param from ID of start page
     * @param to ID of destination
     */
    public Link(String from, String to)
    {
      this.from = from;
      this.to = to;
    }
    
    
    // Getters and Setters
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
    
    /**
     * Compares two links to see if they have the same start and destination.
     * 
     * @param l Link to compare to.
     * @return True if links are the same, false if not.
     */
    public boolean isSameLink(Link l) {
        
        if (l.from == this.from && l.to == this.to) {
            return true;
        }
        else {
            return false;
        }

    }
}
