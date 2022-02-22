/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Victor Malone (vm19171)
 * 
 * This is a visual representation of the Node class, used for the visual editor.
 */
public class NodeRectangle extends Rectangle {
    
   
    private Node node;
    
    public Point upperLeft;
    
    
    // no-argument constructor
    public NodeRectangle()
    {
        this.node = new Node("New Node");
    }
    
    public NodeRectangle(String title)
    {
        this.node = new Node(title);
    }
    
    public NodeRectangle(Point p, Dimension d)
    {
        super(p, d);
        this.node = new Node("New Node");
    }
    
    // getters and setters
        public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }
    
    @Override
    public String toString()
    {
        String returnString = "Title: " + node.getTitle() + "\n Paragraph: " + node.getParagraph();
        return returnString;
    }
   
}
