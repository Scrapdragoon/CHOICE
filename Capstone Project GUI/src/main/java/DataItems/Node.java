/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataItems;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.io.Serializable;

/**
 *
 * @author Victor Malone (vm19171)
 *
 * This is a class representing a user-created passage. 
 * It includes a title, paragraph, ID, image, and list of links. This will be used to store the data used to create HTML pages based on user input.
 *
 */
public class Node implements Serializable {

    private String title = "New Page";    // name of node
    private String paragraph; // paragraph of text
    
    
    private String ID = "default_ID";      // ID of node (used for searching and whatnot)
    
    private String imagePath;               // path to image
    
    
    // List of links from this node to other nodes.
    // Key is the ID, value is the hyperlink text. This may be changed later.
    //public Map<String, String> links = new TreeMap();
    
    
    // Multimap to hold links to other nodes.
    // Key is the ID, value is the hyperlink text.
    Multimap<String, String> links = ArrayListMultimap.create();

    
    public Node() {
    }
    
    public Node(String title)
    {
        this.title = title;
    }
    
    
    public Node(String title, String paragraph)
    {
        this.title = title;
        this.paragraph = paragraph;
    }
    
    public Node(String title, String paragraph, String ID)
    {
        this.title = title;
        this.paragraph = paragraph;
        this.ID = ID;
    }
    
    public Node(String title, String paragraph, String ID, Multimap<String, String> links)
    {
        this.title = title;
        this.paragraph = paragraph;
        this.ID = ID;
        this.links = links;
    }
    

    // get/set methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }
    
        public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }


    // get/set methods for ID
    public String getID() {
        return ID;
    }

    public void setID(String newID) {
        ID = newID;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Multimap<String, String> getLinks() {
        return links;
    }

    public void setLinks(Multimap<String, String> links) {
        this.links = links;
    }
    
    
    
    public void addLink(String ID, String text)
    {
        links.put(ID, text);
    }
    
    public void removeLink(String ID, String text)
    {
        links.remove(ID, text);
    }

    @Override
    public String toString()
    {
        return "Page title: " + this.title + ","
                + "\n ID: " + this.ID;
    }
}
