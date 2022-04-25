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

package WindowsAndPanels;

import InnerWorkings.ApplicationHandler;
import InnerWorkings.ConnectionTriangle;
import DataItems.Link;
import DataItems.NodeRectangle;
import static InnerWorkings.ApplicationHandler.nodeDimensions;
import com.google.common.collect.Lists;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * A panel that allows visual representations of nodes to be placed, dragged, and dropped where the user wishes. <p>
 * This is the View in the MVC pattern.
 * 
 * Code referenced from:
 * @see <a href = https://examples.javacodegeeks.com/desktop-java/awt/event/draw-and-drag-rectangles/>Source</a>
 * @author Victor Malone (vm19171)
 * @serial 
 */
public class DragAndDrop extends JPanel implements MouseMotionListener, Serializable {
    
   /**
    * The controller that contains the main elements of the program, including the project file.
    */
    ApplicationHandler controller;
    
    /**
     * ArrayList of all nodes on screen. Should be linked to list from controller
     */
   private ArrayList<NodeRectangle> nodes = new ArrayList<>();
    
   private Map<NodeRectangle, Image> visuals;
   
   /**
    * The currently selected node.
    */
    private int currentNode = -1;
        
        
   /**
     * Icon for page images.
     */
    Image pageIcon;
    
    /**
     * No-arg constructor. Initializes a new ArrayList of nodes and loads the GIF to represent pages.
     */
    public DragAndDrop() {
        
        this.setDoubleBuffered(true);
        
       nodes = new ArrayList<>();
       
        pageIcon = new ImageIcon(getClass().getResource("/pageAnim.gif")).getImage();
        pageIcon = pageIcon.getScaledInstance(nodeDimensions.width, nodeDimensions.height, Image.SCALE_DEFAULT);

        
        //<editor-fold defaultstate="collapsed" desc="Mouse Listeners">


        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent event)
            {
                // select the node the user clicks, assign to currentNode
               currentNode = getNodeClicked(event.getX(), event.getY());
               System.out.println("Pressed node " + currentNode);
            }
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                 if (event.getButton() == MouseEvent.BUTTON3)   // if node is right clicked
                {
                    System.out.println("Right click detected! Current node: " + currentNode);
                    removeNode(currentNode);
                    return;
                }
                 
                 // double click on node to open editor
                 if (event.getButton() == MouseEvent.BUTTON1 && event.getClickCount() == 2)
                {
                    System.out.println("Double click on node detected!");
                    controller.openPageEditor(nodes.get(currentNode));
                }
            }
        });
                
        addMouseMotionListener(this);
        

    }
    
     @Override
    public void mouseMoved(MouseEvent event)
    {
        //repaint();
    }
    
    
    @Override
    public void mouseDragged(MouseEvent event)
    {
        if (currentNode >= 0)
        {
            Graphics g = getGraphics();
            
            // set up graphics
            g.setColor(Color.RED);
            ((Graphics2D)g).setStroke(new java.awt.BasicStroke(3));
            
            nodes.get(currentNode).x = event.getX() - (controller.nodeDimensions.width/2);
            nodes.get(currentNode).y = event.getY() - (controller.nodeDimensions.height/2);
            
            repaint();
        }
 
    //</editor-fold>
    }
    
    @Override
    public void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setColor(Color.RED);
        
       ((Graphics2D)g).setStroke(new java.awt.BasicStroke(4));
       
        // draw lines between connected passages
        drawLines((Graphics2D)g);
        
       nodes = controller.getNodes();
        if (!(nodes.isEmpty()))
        {
            // draw every node
            for (NodeRectangle n : nodes)
            {
               //g.draw(n);
               
               // draw page images
               g.drawImage(pageIcon, n.x, n.y, this);
                
                g.setColor(Color.BLACK);
                
                // if title is long, abbreviate
                String title = n.getNode().getTitle();
                if (title.length() > 15)
                {
                    title = title.substring(0, 15);
                    title += "...";
                }
                ((Graphics2D)g).drawString(title, n.x-3, n.y-5);
            }
        }
    }
    
    /**
     * Draws the connections in between pages. 
     * 
     * @param g Graphics object.
     */
    public void drawLines(Graphics2D g)
    {
        if (!nodes.isEmpty())
        {
            // for each link in the project file
            for (Link l : controller.getProjectFile().getVisualLinks())
            {
                 Point s = null, f = null;
                // search the list of nodes for the points of the corresponding pair
                for (NodeRectangle n : nodes)
                {
                    if (n.getNode().getID().equals(l.from))
                    {
                        s = n.getLocation();
                    }
                    else if (n.getNode().getID().equals(l.to))
                    {
                        f = n.getLocation();
                    }
                }
                if (s != null && f != null)
                {
                    
                // fillPoly triangle. Makes it easier to see which node is the "start" and which is the "end". 
                    Point startCenter, finishCenter;
                    startCenter = new Point(s.x + (ApplicationHandler.nodeDimensions.width/2), s.y + (ApplicationHandler.nodeDimensions.height/2));
                    finishCenter = new Point(f.x + (ApplicationHandler.nodeDimensions.width/2), f.y + (ApplicationHandler.nodeDimensions.height/2));

                    ConnectionTriangle t = new ConnectionTriangle(startCenter, finishCenter);
                    g.setColor(new Color(66, 135, 245, 150));
                    g.fillPolygon(t);
                }
            }
        }            
    }
    
    
    /**
     * Returns the node that was clicked on.
     * 
     * @param x x-coordinate of click
     * @param y y-coordinate of click
     * @return Selected node.
     */
    public int getNodeClicked(int x, int y)
    {
        // by default, start with index that does not exist
        int nodeNum = -1;
        
        // start from the most forefront node
            for (Rectangle n : Lists.reverse(nodes))
            {
                // if x and y are within a node
                if (n.contains(x, y))
                {
                    nodeNum = nodes.indexOf(n);
                    break;
                }
            }
            return nodeNum;
    }
    
    /**
     * Adds a node to the collection.
     * 
     * @param x x-coordinate of new node
     * @param y y-coordinate of new node
     */
    public void addNode(int x, int y)
    {
        // create node with center at the passed values
        int newX = x - (controller.nodeDimensions.width/2);
        int newY = y - (controller.nodeDimensions.height/2);
        
        Point p = new Point(newX, newY);
        nodes.add(new NodeRectangle(p, controller.nodeDimensions));
        
        // for debugging/log
        System.out.println("Added node " + (nodes.size() - 1) + "!");
        
        // have controller update project file
        controller.updateProject();
        
        repaint();
    }
       
    /**
     * Removes a node based on its position in the array.
     * 
     * @param i index of the node to remove
     */
    public void removeNode(int i)
    {
        // if i is within nodes's range
        if (!(i < 0 || i >= nodes.size()))
        {            
            System.out.println("Removing rectangle at index  " + i + " with ID: " + nodes.get(i).getNode().getID());
               controller.deleteNode(nodes.get(i).getNode().getID());
               
               if (currentNode == i)
               {
               currentNode = -1;
               }
        }
        else
        {
            return;
        }
        repaint();
    }
    
    // Getters and Setters
    public void setController(ApplicationHandler c)
    {
        controller = c;
    }    
    
    // clones the contents of n to nodes
    public void setNodes(ArrayList<NodeRectangle> n)
    {
        this.nodes.clear();
        this.nodes = (ArrayList<NodeRectangle>)n.clone();
    }
    
    // returns nodes
    public ArrayList<NodeRectangle> getNodes()
    {
        return nodes;
    }
    /**
     * Clears all nodes from the array.
     */
    public void clearNodes()
    {
        nodes.clear();
    }
      
    /**
     * For testing purposes.
     */
    public void showControllerNodeStats()
    {
        repaint();
        for (NodeRectangle n : controller.getNodes())
        {
        System.out.println(n);
        }
    }
    
    /**
     * Assigns the nodes array to the entered one. 
     * 
     * @param n new nodes array
     */
    public void updateViewNodes(ArrayList<NodeRectangle> n)
    {
        nodes = n;
    }
        
}
