/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataItems;

import java.awt.Image;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Victor Malone (vm19171)
 *
 * This is a class representing a user-created passage. 
 * It includes a title, paragraph, ID, image, and list of links. This will be used to store the data used to create HTML pages based on user input.
 *
 */
public class Node implements Serializable {
    
    public static int passageNumber = 100;    // used to determine the IDs of new passages
    

    private String title = "New Node";    // name of node
    private String paragraph; // paragraph of text
    
    
    private String ID = "test";      // ID of node (used for searching and whatnot)
    
    public Image image;                      // accompanying image
    
    
    // List of links from this node to other nodes.
    // Key is the ID, value is the hyperlink text. This may be changed later.
    public Map<String, String> links = new TreeMap();

    
    public Node() {
        title = "defaultTitle";
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
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

    
    
   /* 
    //get list of choices
    public ArrayList<Node> getChoices() {
        return choices;
    }

    
    // add link to list of choices
    public void addLink(Node choice) {
        choices.add(choice);
    }

    */
    
    
    public static void autoSetID()
    {
        
    }
    
    @Override
    public String toString()
    {
        return "Page title: " + this.title 
                + "\n Paragraph: " + this.paragraph
                ;
    }
}
