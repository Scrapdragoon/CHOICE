/*
 * Copyright 2022 Victor Malone (vm19171).
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

import WindowsAndPanels.LinkPanel;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is meant to hold the data from the page editor popup in a central location for easy access. <p>
 * The data will remain here until the user has selected 'OK', at which point the main project file will be updated. <p>
 * If 'Cancel' is chosen, the main project file will not be updated.
 * 
 * @author Victor Malone (vm19171)
 * 
 */
public class PageEditorData implements Serializable {
    
    /**
     * Fields for the title, ID, and paragraph of the node.
     */
    private String title, ID, paragraph;
    
    // NOTE: if ID is edited, the rest of the project file will need to be updated in order to avoid dead links.
    // Only do this if data is successfully integrated into main program (i.e., the user chooses "OK").

    /**
     * List of other nodes that can be connected to from this node Should be just about any node in the project file. <p>
     * Links from a node to itself are allowed.
     */
    private ArrayList<NodeRectangle> otherNodes = new ArrayList<>(); 
    
    /**
     * Record of the panels added, so the last one may be removed with the user presses the '-' button in the editor.
     */
    public ArrayList<LinkPanel> linkPanels = new ArrayList<>();

    
/**
 * No-arg constructor.
 */
    public PageEditorData()
    {
        title = "Page Title";
       // ID = 
       paragraph = "Write your story here...";
    }
    
/**
 * Constructor that sets the title, ID, and paragraph of the node.
 * 
 * @param title title of the node
 * @param ID ID of the node
 * @param paragraph main body of the node
 */
    public PageEditorData(String title, String ID, String paragraph) {
        this.title = title;
        this.ID = ID;
        this.paragraph = paragraph;
    }
    
    
    /**
     * Used to remove LinkPanels from the editor.
     * 
     * @return LinkPanel that was removed
     */
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

    public ArrayList<LinkPanel> getLinkPanels() {
        return linkPanels;
    }

    public void setLinkPanels(ArrayList<LinkPanel> linkPanels) {
        this.linkPanels = linkPanels;
    }
    
   // </editor-fold> 
    
}
