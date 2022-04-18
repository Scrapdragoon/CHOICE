/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 

*/
package WindowsAndPanels;

import InnerWorkings.ApplicationHandler;
import InnerWorkings.ConnectionTriangle;
import InnerWorkings.Link;
import InnerWorkings.NodeRectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.RenderingHints;

/**
 *
 * @author Victor Malone (vm19171)
 * Code referenced from https://examples.javacodegeeks.com/desktop-java/awt/event/draw-and-drag-rectangles/
 * 
 * This is the View in the MVC pattern.
 */
public class DragAndDrop extends JPanel implements MouseMotionListener, Serializable {
    
    // Controller.
    ApplicationHandler controller;
    
    // ArrayList of all nodes on screen. Should be linked to list from controller
   private ArrayList<NodeRectangle> nodes = new ArrayList<>();
    
   // current selected node
    private int currentNode = -1;
    
    
    public DragAndDrop() {
        
        nodes = new ArrayList<>();
        
        
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
                n.paintComponent((Graphics2D)g);
                g.setColor(Color.BLACK);
                
                // if title is long, abbreviate
                String title = n.getNode().getTitle();
                if (title.length() > 10)
                {
                    title = title.substring(0, 10);
                    title += "...";
                }
                ((Graphics2D)g).drawString(title, n.x, n.y - 3);
            }
        }
        this.repaint();
    }
    
    // used to draw lines between connected pages
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
    
    
    // returns node clicked on, given position
    public int getNodeClicked(int x, int y)
    {
        // by default, start with index that does not exist
        int nodeNum = -1;
        
        
            for (Rectangle n : nodes)
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
    
    public void clearNodes()
    {
        nodes.clear();
    }
      
    
    public void showControllerNodeStats()
    {
        repaint();
        for (NodeRectangle n : controller.getNodes())
        {
        System.out.println(n);
        }
    }
    
    public void updateViewNodes(ArrayList<NodeRectangle> n)
    {
        nodes = n;
    }
        
}
