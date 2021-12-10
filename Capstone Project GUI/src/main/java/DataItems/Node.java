/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataItems;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Victor Malone (vm19171)
 *
 * This is a class representing a user-created passage. It includes a name, ID, image, and list of links. This will be used to store the data used to create HTML pages based on user input.
 *
 */
public class Node {
    
    public static int passageNumber = 1000;    // used to determine the IDs of new passages
    

    private String title;    // name of node
    private String ID;      // ID of node (used for searching and whatnot)
    private URL url;        // URL used to access node
    
    public Image image;                      // accompanying image
    // public ArrayList<Node> choices;  // list of choices, that connect to other passages/nodes
    
    public Map<String, URL> choices2;

    public Node() {
        title = "defaultTitle";

    }

    // get/set methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    // get/set methods for ID
    public String getID() {
        return ID;
    }

    public void setID(String newID) {
        ID = newID;
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
}
