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

import InnerWorkings.ApplicationHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *This is a visual representation of the Node class, used for the visual editor.
 * 
 * @author Victor Malone (vm19171)
 * 
 */
public class NodeRectangle extends Rectangle {
    
   /**
    * The node that this rectangle represents.
    */
    private Node node;
    
    /**
     * The upper-left corner of the rectangle.
     */
    public Point upperLeft;

    

    /**
     * No-argument constructor. Places the rectangle at a default location.
     */
    public NodeRectangle()
    {
         super(new Point(70, 70), ApplicationHandler.nodeDimensions);
        this.node = new Node("New Page");
        this.setSize(ApplicationHandler.nodeDimensions);
        
    }
    
    
    /**
     * Constructor that also creates a node with the given title. 
     * 
     * @param title node title
     */
    public NodeRectangle(String title)
    {
        super(new Point(70, 70), ApplicationHandler.nodeDimensions);
        this.node = new Node(title);
    }
        /**
         * Constructor that stores the given node. 
         * 
         * @param n node that this rectangle will 'hold'
         */
    public NodeRectangle(Node n)
    {
        super(new Point(70, 70), ApplicationHandler.nodeDimensions);
        this.node = n;
                // this.setSize(ApplicationHandler.nodeDimensions);
    }
    
    /**
     * Constructor that stores the given node, and is placed at the given point.
     * 
     * @param n node that this rectangle will 'hold'
     * @param p point at which to place the rectangle
     */
    public NodeRectangle(Node n, Point p)
    {
        super(p, ApplicationHandler.nodeDimensions);
        this.node = n;
    }
    
    /**
     * Constructor that places the rectangle at the given point.
     * 
     * @param p point at which to place the rectangle
     */
    public NodeRectangle(Point p)
    {
        super(p, ApplicationHandler.nodeDimensions);
                this.node = new Node("New Page");
        
    }
    
    /**
     * Constructor that places the rectangle at the given point, with the given dimensions.
     * 
     * @param p point at which to place the rectangle
     * @param d dimensions of the rectangle
     */
    public NodeRectangle(Point p, Dimension d)
    {
        super(p, d);
        this.node = new Node("New Page");
               // this.setSize(ApplicationHandler.nodeDimensions);
    }
    
    public void paintComponent (Graphics2D g)
    {
        g.setPaint(new GradientPaint(this.x+ width/2, this.y, Color.WHITE, this.x + width + 15, this.y + height, Color.LIGHT_GRAY));
        g.fillRect(this.x, this.y, this.width, this.height);
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, this.width, this.height);
    }   
    
    
    // Getters and Setters
    
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
