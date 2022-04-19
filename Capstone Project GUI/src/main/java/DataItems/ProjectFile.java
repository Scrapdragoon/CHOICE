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

import com.google.common.collect.Multiset;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is intended to hold all of the data used in a project. User-input data, settings, all of that. <p>
 * The Model in the MVC pattern.
 * 
 * @author Victor Malone (vm19171)
 * @serial
 */
public class ProjectFile implements Serializable {
    
    /**
     * Title of the project.
     */
    String projectTitle = "New Project Title";
    
    /**
     * Author of the project.
     */
    String authorName;
        
    /**
     * The main meat of the tool. An ArrayList of all of the nodes/pages in the current file.
     */
    ArrayList<NodeRectangle> nodes; 
    
    /**
     * An ArrayList of links between the nodes in the file. This is mainly for the View to use.
     */
    ArrayList<Link> visualLinks;    

    
    /**
     * No-arg constructor, used for initializing new projects.
     */
    public ProjectFile()
    {
        projectTitle = "New Project Title";
        authorName = "Author";
        nodes = new ArrayList<>(); 
        
        visualLinks = new ArrayList<>();
        
        //<editor-fold defaultstate="collapsed" desc="For Testing">
        /*
        Node n = new Node("Title", "Content", "from");
        n.addLink("to", "Click here!");
        n.setImagePath("C:/Users/rolep/Desktop/BEST FRIENDS AA.png");
        //n.addLink("to2", "And click here too!");
        
        Node t = new Node("Title2", "Content2", "to");
        
        //Node t2 = new Node("to2", "Content", "to2");
        
        NodeRectangle from = new NodeRectangle(n, new Point(300, 300));
        NodeRectangle to = new NodeRectangle(t, new Point(500, 500));
        //NodeRectangle to2 = new NodeRectangle(t2, new Point(300, 500));
        
        nodes.add(from);
        nodes.add(to);
        //nodes.add(to2);
        
        updateLinks();
        */
        //</editor-fold>
    }
    
    /**
     * Updates the visualLinks variable.
     */
    public void updateLinks()
    {
        // clear links
        
        // if nodes is not empty,
        // for every node n in nodes
        // and for every other node m in nodes
        // iterate through n's links' keys and compare key to m's ID
        // if they match, add Link(n.ID, m.ID) to visualLinks
        
        visualLinks.clear();
        
        if (!(nodes.isEmpty()))
        {
            
            for (NodeRectangle n : nodes)
            {
               Multiset<String> nKeys = n.getNode().getLinks().keys();
                for (NodeRectangle m : nodes)
                {
                    if (!(n.getNode().getLinks().isEmpty())) // if there are links from n to something else
                    {
                        for (String destination : nKeys)
                        {
                            if (destination.equals(m.getNode().getID())) // if n is linked to m
                            {
                                visualLinks.add(new Link(n.getNode().getID(), m.getNode().getID()));
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Deletes a node, given its position in the nodes ArrayList. 
     * 
     * @param i index of the node to delete
     */
    public void deleteNode(int i)
    {
        nodes.remove(i);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Old updateLinks()">
    

    /*
    // update list of visual links between nodes. This is for the View to use.
    public void updateLinks()
    {
        System.out.println("Links update starting.");
        links.clear();
        
        // go through node list, check all nodes against each other. 
        // If a link between two nodes found, add to links.
        for (NodeRectangle n : nodes)
        {
            // NodeRectangle current = n;
            System.out.println("Node n ID:" + n.getNode().getID());
            
            for (NodeRectangle m : nodes)
            {
              System.out.println("Node m ID:" + m.getNode().getID());
                if (!(n.getNode().getID() == m.getNode().getID()))
                {
                    System.out.println("Node n does not equal m.");
                        // for each ID in n's links
                        for (Map.Entry<String, String> entry : n.getNode().getLinks().entrySet())
                        {
                            System.out.println("n's link: " + entry.getKey());
                            // compare to the ID of m, add if matches
                            if (entry.getKey().equals(m.getNode().getID()))
                            {
                                System.out.println("Link added.");
                                links.add(new Link(n.getNode().getID(), m.getNode().getID()));
                            }
                            else
                            {
                                System.out.println("Link not added.");
                        }
                        }
                }
                else
                {
                    System.out.println("Node n equals m.");
                }
            }
        }
        System.out.println("Links update finished.");
        System.out.println("");
    }
*/
    //</editor-fold>

    // Getters and Setters
    
    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public ArrayList<NodeRectangle> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<NodeRectangle> nodes) {
        this.nodes = nodes;
    }
    
    // returns the Node at index i.
    public Node getNode(int i)
    {
        return nodes.get(i).getNode();
    }
    
    // sets the node at index i
    public void setNode(int i, Node n)
    {
        nodes.get(i).setNode(n);
    }

    public ArrayList<Link> getVisualLinks() {
        return visualLinks;
    }

    public void setVisualLinks(ArrayList<Link> links) {
        this.visualLinks = links;
    }
            
}
