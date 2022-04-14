/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import EditorWindowPackage.LinkPanel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Victor Malone (vm19171)
 * 
 * This class is meant to hold the data from the page editor popup in a central location for easy access. 
 * The data will remain here until the user has selected 'OK', at which point the main project file will be updated.
 * If 'Cancel' is chosen, the main project file will not be updated.
 */
public class PageEditorData implements Serializable {
    
    
    private String title, ID, paragraph;
    
    // NOTE: if ID is edited, the rest of the project file will need to be updated in order to avoid dead links.
    // Only do this if data is successfully integrated into main program (i.e., the user chooses "OK").
    
    
    // List of other nodes that can be connected to from this node Should be just about any node in the project file.
    // Links from a node to itself are allowed.
    private ArrayList<NodeRectangle> otherNodes = new ArrayList<>(); 
    
    
    // Map of the user's created links.
    // Key is the page's ID/URL, and value is the hyperlink text that will be displayed on the page. Change this if you need to.
    // use this to create a combo box model??
   // private Map<String, String> links = new TreeMap()
    
    // and a record of the panels added, so the last one can be removed when you hit the '-' button.
    public ArrayList<LinkPanel> linkPanels = new ArrayList<>();

    
    // no-arg constructor
    public PageEditorData()
    {
        title = "Page Title";
       // ID = 
       paragraph = "Write your story here...";
    }
    
    // Constructor.
    public PageEditorData(String title, String ID, String paragraph) {
        this.title = title;
        this.ID = ID;
        this.paragraph = paragraph;
    }

    
    
    public Node save()
    {
        // TODO 
        Node n = new Node();
        // a method to "export" the data to the main program? This is only used when the user hits "OK". Else, just discard the data.
        
        // create node from data and return.
        return n;
    }
    
    public void addLinkPanel()
    {
        // TODO - nothing yet!
    }
    
    
    
    // used to remove link panels from the editor. 
    public LinkPanel removeLinkPanel()
    {
        if (!linkPanels.isEmpty())
        {
            // get last panel, delete from list
            LinkPanel p = linkPanels.get(linkPanels.size() - 1);
            linkPanels.remove(p);

            // return last panel that was removed
            return p;
        }
        else
        {
            // return nothing! do nothing!
            return null;
        }       
    }
    

    
 // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public ArrayList<NodeRectangle> getOtherNodes() {
        return otherNodes;
    }

    public void setOtherNodes(ArrayList<NodeRectangle> otherNodes) {
        this.otherNodes = otherNodes;
    }
/*
    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }
*/
    public ArrayList<LinkPanel> getLinkPanels() {
        return linkPanels;
    }

    public void setLinkPanels(ArrayList<LinkPanel> linkPanels) {
        this.linkPanels = linkPanels;
    }
    
    
   // </editor-fold> 
    
    // for testing purposes
   public static void main(String[] args)
   {
       
   }
    
}
