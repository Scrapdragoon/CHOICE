/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import EditorWindowPackage.LinkPanel;
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
public class PageEditorData {
    
    
    private String title, ID, paragraph;
    
    // NOTE: if ID is edited, the rest of the project file will need to be updated in order to avoid dead links.
    // Only do this if data is successfully integrated into main program (i.e., the user chooses "OK").
    
    
    // List of other nodes that can be connected to from this node Should be just about any node in the project file.
    private ArrayList<String> otherNodes = new ArrayList<>(); 
    
    
    // Map of the user's created links.
    // Key is the page's ID/URL, and value is the hyperlink text that will be displayed on the page. Change this if you need to.
    private Map<String, String> links = new TreeMap();
    
    // and a record of the panels added, so the last one can be removed when you hit the '-' button.
    public ArrayList<LinkPanel> linkPanels = new ArrayList<>();

    
    // no-arg constructor
    public PageEditorData()
    {
        
    }
    
    // Constructor.
    public PageEditorData(String title, String ID, String paragraph) {
        this.title = title;
        this.ID = ID;
        this.paragraph = paragraph;
    }

    
    
    public void save()
    {
        // a method to "export" the data to the main program? This is only used when the user hits "OK". Else, just discard the data.
    }
    
    // used to remove link panels from the editor. 
    public LinkPanel removeLinkPanel()
    {
        
        if (!linkPanels.isEmpty())
        {
            // get last panel, delete from list
            LinkPanel p = linkPanels.get(linkPanels.size() - 1);
            linkPanels.remove(p);

            // return last panel
            return p;
        }
        else
        {
            // return nothing!
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

    public ArrayList<String> getOtherNodes() {
        return otherNodes;
    }

    public void setOtherNodes(ArrayList<String> otherNodes) {
        this.otherNodes = otherNodes;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }
   // </editor-fold> 
    
    // for testing
   public static void main(String[] args)
   {
       
   }
    
}
