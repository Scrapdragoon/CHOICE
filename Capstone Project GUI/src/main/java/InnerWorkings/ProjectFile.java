/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Victor Malone (vm19171)
 * 
 * 
 * This file is intended to hold all of the data used in a project. User-input data, settings, all of that.
 */
public class ProjectFile implements Serializable {
    
    String projectName;
    String authorName;
    
    Path filePath;
    Path outputPath;
    
    ArrayList<NodeRectangle> nodes;
    
    
    public ProjectFile()
    {
        projectName = "New Project";
        authorName = "Author";
        nodes = new ArrayList<>();
    }
    
    

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
        this.nodes = nodes; // make a copy of the new arraylist instead?
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
    
       
}
