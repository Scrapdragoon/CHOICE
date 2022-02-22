/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 

*/
package InnerWorkings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

/**
 *
 * @author Victor Malone (vm19171)
 * Code referenced from https://examples.javacodegeeks.com/desktop-java/awt/event/draw-and-drag-rectangles/
 * 
 * This is the View in the MVC pattern.
 */
public class DragAndDrop extends JPanel implements MouseMotionListener, Serializable {
    
    ApplicationHandler controller;
    
    // ArrayList of all nodes on screen. Should be linked to list from controller
   private ArrayList<NodeRectangle> nodes;
    
    // size of rectangle used to represent nodes
   // private Dimension nodeDimensions = new Dimension(100, 50);
   
   // current selected node
    private int currentNode = -1;
    
    
    
    public DragAndDrop() {
      
        //<editor-fold defaultstate="collapsed" desc="Mouse Listeners">
        
        nodes = new ArrayList<>();
       

        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent event)
            {
                // select the node the user click, assign to currentNode
               currentNode = getNodeClicked(event.getX(), event.getY());
               System.out.println("Pressed node " + currentNode);
            }
            
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                // if empty space clicked, add new node
                if (event.getButton() == MouseEvent.BUTTON1 && currentNode < 0)
                {
                    addNode(event.getX(), event.getY());
                    return;
                }
                 if (event.getButton() == MouseEvent.BUTTON3)   // if node is right clicked
                {
                     System.out.println("Right click detected. Current node: " + currentNode);
                    removeNode(currentNode);
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
            NodeRectangle n = nodes.get(currentNode);
            Graphics g = getGraphics();
            
            // set up graphics
            g.setColor(Color.RED);
            ((Graphics2D)g).setStroke(new java.awt.BasicStroke(3));
            
            
            nodes.get(currentNode).x = event.getX() - (controller.nodeDimensions.width/2);
            nodes.get(currentNode).y = event.getY() - (controller.nodeDimensions.height/2);
            
           ((Graphics2D)g).draw(n);
           ((Graphics2D)g).drawString(n.getNode().getTitle(), n.x, n.y);
           
            // g.dispose(); // get rid of graphics object after using
            repaint();
        }
    }
    //</editor-fold>
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
       g.setColor(Color.RED);
       ((Graphics2D)g).setStroke(new java.awt.BasicStroke(3));
        
        if (!(nodes.isEmpty()))
        {
            // draw every node
            for (NodeRectangle n : nodes)
            {
                ((Graphics2D)g).draw(n);
                ((Graphics2D)g).drawString(n.getNode().getTitle() + " " + nodes.indexOf(n), n.x, n.y);
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
        controller.update();
        
        repaint();
    }
    
    public void addNode(int x, int y, String title)
    {
        // for adding nodes with a title
        
        controller.update();
    }
    
   
    public void removeNode(int i)
    {
        // if i is within nodes's range
        if (!(i < 0 || i >= nodes.size()))
        {
            System.out.println("Removing rectangle at index : " + i);
               nodes.remove(i); // remove rectangle at index
               
               if (currentNode == i)
               {
               currentNode = -1;
               }
        }
        else
        {
            return;
        }
        
        controller.update();
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
    
    
    public void showControllerNodeStats()
    {
        for (NodeRectangle n : controller.getNodes())
        {
        System.out.println(n);
        }
    }
    
    
            /*
    public static void main(String[] args)
    {

        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(new DragAndDrop());
        frame.setVisible(true);
     
        
        
    }
       */
    
}
