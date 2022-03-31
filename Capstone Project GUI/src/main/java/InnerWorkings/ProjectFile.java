/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import java.awt.Point;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Victor Malone (vm19171)
 * 
 * 
 * This file is intended to hold all of the data used in a project. User-input data, settings, all of that.
 * I believe this is the Model in the MVC pattern.
 */
public class ProjectFile implements Serializable {
    
    String projectTitle;     // project's title  
    String authorName;      // author's name
    
    Path filePath;                // path to access file
    Path outputPath;          // path to output exported game (do you even need to store this separately?)
    
    // used to auto-generate IDs
    //int nodeID
    
    
    ArrayList<NodeRectangle> nodes; // ArrayList of story nodes/pages
    ArrayList<Link> visualLinks;    // ArrayList of links between pages. This is just for the View to use.

    
    
    public ProjectFile()
    {
        projectTitle = "New Project";
        authorName = "Author";
        nodes = new ArrayList<>();  // should I start with one node placed?
        
        visualLinks = new ArrayList<Link>();
        
        // TODO -  for testing
        Node n = new Node("Title", "Content", "from");
        n.addLink("to", "Click here!");
        n.addLink("to2", "And click here too!");
        
        Node t = new Node("Title2", "Content2", "to");
        
        Node t2 = new Node("to2", "Content", "to2");
        
        NodeRectangle from = new NodeRectangle(n, new Point(300, 300));
        NodeRectangle to = new NodeRectangle(t, new Point(500, 500));
        NodeRectangle to2 = new NodeRectangle(t2, new Point(300, 500));
        
        nodes.add(from);
        nodes.add(to);
        nodes.add(to2);
        
        updateLinks();
    }
    
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

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

    public ArrayList<NodeRectangle> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<NodeRectangle> nodes) {
        this.nodes = nodes; // make a deep copy of the new arraylist instead?
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
    
    public void deleteNode(int i)
    {
        nodes.remove(i);
    }

    public ArrayList<Link> getVisualLinks() {
        return visualLinks;
    }

    public void setVisualLinks(ArrayList<Link> links) {
        this.visualLinks = links;
    }
            
}
