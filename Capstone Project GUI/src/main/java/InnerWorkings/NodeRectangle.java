/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    
    
    
    
    // no-argument constructor. puts at default location
    public NodeRectangle()
    {
         super(new Point(69, 69), ApplicationHandler.nodeDimensions);
        this.node = new Node("New Page");
        this.setSize(ApplicationHandler.nodeDimensions);
        
    }
    
    public NodeRectangle(String title)
    {
        super(new Point(69, 69), ApplicationHandler.nodeDimensions);
        this.node = new Node(title);
                // this.setSize(ApplicationHandler.nodeDimensions);
    }
    
    public NodeRectangle(Node n)
    {
        super(new Point(69, 69), ApplicationHandler.nodeDimensions);
        this.node = n;
                // this.setSize(ApplicationHandler.nodeDimensions);
    }
    
    public NodeRectangle(Node n, Point p)
    {
        super(p, ApplicationHandler.nodeDimensions);
        this.node = n;
    }
    
    
    public NodeRectangle(Point p)
    {
        super(p, ApplicationHandler.nodeDimensions);
                this.node = new Node("New Page");
        
    }
    public NodeRectangle(Point p, Dimension d)
    {
        super(p, d);
        this.node = new Node("New Page");
               // this.setSize(ApplicationHandler.nodeDimensions);
    }
    
    
    
    
    public void paintComponent (Graphics2D g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, this.width, this.height);
        g.setPaint(new GradientPaint(this.x, this.y, Color.WHITE, this.x + height, this.y + height, Color.DARK_GRAY));
        g.fillRect(this.x, this.y, this.width, this.height);
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
        String returnString = "\n Title: " + node.getTitle() + "\n ID: " + node.getID();
        return returnString;
    }
   
}
