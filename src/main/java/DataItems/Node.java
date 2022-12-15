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

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.io.Serializable;

/**
 * Represents a user-created passage. <p>
 * Includes a title, paragraph, ID, image, and list of links. This will be used to store the data used to create HTML pages based on user input.
 * 
 * @author Victor Malone
 * @serial 
 */
public class Node implements Serializable {
    
/**
 * Title of the node. Shown at the top of the screen in the finished page.
 */
    private String title = "New Page";    // name of node
    
    /**
     * Paragraph of the node. Put the main "meat" of the page's text here.
     */
    private String paragraph; // paragraph of text
    
    /**
     * ID of the node. This will be the filename of the page upon creation, and is used for linking.
     */
    private String ID = "default_ID"; 
    
    /**
     * The path to the image to display on this page.
     */
    private String imagePath;               // path to image
        
    /**
     * Multimap to hold links to other nodes. <p>
     * Key is the ID, value is the hyperlink text.
     */
    Multimap<String, String> links = ArrayListMultimap.create();

    /**
     * No-argument constructor.
     */
    public Node() {
    }
    
    /**
     *  Constructor that creates a node containing the title entered.
     * 
     * @param title Title of node, shown at the top of the created page.
     */
    public Node(String title)
    {
        this.title = title;
    }
    
   /**
     * Constructor that creates a node containing the title and paragraph entered.
     * 
     * @param title Title of node, shown at the top of the created page.
     * @param paragraph Main content of the node.
     */
    public Node(String title, String paragraph)
    {
        this.title = title;
        this.paragraph = paragraph;
    }
    
    /**
     * Constructor that creates a node containing the title, paragraph, and ID entered.
     * 
     * @param title Title of node, shown at the top of the created page.
     * @param paragraph Main content of the node.
     * @param ID String used for linking and identification.
     */
    public Node(String title, String paragraph, String ID)
    {
        this.title = title;
        this.paragraph = paragraph;
        this.ID = ID;
    }
    
    /**
     * Constructor that creates a node containing the title, paragraph, ID, and links entered.
     * 
     * @param title Title of node, shown at the top of the created page.
     * @param paragraph Main content of the node.
     * @param ID String used for linking and identification.
     * @param links List of hyperlinks to other nodes.
     */
    public Node(String title, String paragraph, String ID, Multimap<String, String> links)
    {
        this.title = title;
        this.paragraph = paragraph;
        this.ID = ID;
        this.links = links;
    }
    

    // Getters and Setters
    
    /**
     * 
     * @return Title of node.
     */
    public String getTitle() {
        return title;
    }

/**
 * 
 * @param newTitle New title of node.
 */    
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    
    /**
     * 
     * @return Paragraph of node.
     */
        public String getParagraph() {
        return paragraph;
    }

    /**
     * 
     * @param paragraph New paragraph of node.
     */
    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

/**
 * 
 * @return ID of node.
 */
    public String getID() {
        return ID;
    }

    /**
     * 
     * @param newID New ID of node.
     */
    public void setID(String newID) {
        ID = newID;
    }

    /**
     * 
     * @return Path to node's image.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 
     * @param imagePath New path to node's image.
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 
     * @return Map of links from this node to others.
     */
    public Multimap<String, String> getLinks() {
        return links;
    }

    /**
     * 
     * @param links New map of links from this node to others.
     */
    public void setLinks(Multimap<String, String> links) {
        this.links = links;
    }
    
    
    /**
     * 
     * @param ID ID of destination page.
     * @param text Hypertext to be shown.
     */
    public void addLink(String ID, String text)
    {
        links.put(ID, text);
    }
    
     /**
     * 
     * @param ID ID of destination page.
     * @param text Hypertext of link.
     */
    public void removeLink(String ID, String text)
    {
        links.remove(ID, text);
    }

    @Override
    public String toString()
    {
        return "Page \"" + this.title + "\"\n"
                + "----------\n"
                + "Paragraph: " + this.paragraph + "\n"
                + "ID: " + this.ID + "\n";
    }
}
