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
 */
public class NodeRectangle extends Rectangle{
    
    /*
    
    Currently does not use the Node data item.
    
    */
    
    public String title = "test";
    public Node node;
    
    public NodeRectangle()
    {
        title = "test";
    }
    
    public NodeRectangle(String title)
    {
        this.title = title;
    }
    
    public NodeRectangle(Point p, Dimension d)
    {
        super(p, d);
    }
    
   
}
