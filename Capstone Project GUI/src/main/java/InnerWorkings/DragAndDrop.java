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
 */
public class DragAndDrop extends JPanel implements MouseMotionListener, Serializable {
    
    // ArrayList of all nodes on screen
    private ArrayList<NodeRectangle> nodeArrayCopy = new ArrayList<>();

    // size of rectangle used to represent nodes
    private Dimension nodeDimensions = new Dimension(100, 50);
    private int currentNode = -1;
    
    
    
    public DragAndDrop() {
      
        //<editor-fold defaultstate="collapsed" desc="Mouse Listeners">
        

        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent event)
            {
                // select the node the user clicks
               currentNode = getNodeClicked(event.getX(), event.getY());
               System.out.println("Clicked on node " + currentNode);
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
                 if (event.getButton() == MouseEvent.BUTTON3)   // if rectangle is right clicked
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
            NodeRectangle n = nodeArrayCopy.get(currentNode);
            Graphics g = getGraphics();
            
            // set up graphics
            g.setColor(Color.RED);
            ((Graphics2D)g).setStroke(new java.awt.BasicStroke(3));
            
            
            nodeArrayCopy.get(currentNode).x = event.getX() - (nodeDimensions.width/2);
            nodeArrayCopy.get(currentNode).y = event.getY() - (nodeDimensions.height/2);
            
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
        
        
        // draw every node
        for (NodeRectangle n : nodeArrayCopy)
        {
            ((Graphics2D)g).draw(n);
            ((Graphics2D)g).drawString(n.getNode().getTitle() + " " + nodeArrayCopy.indexOf(n), n.x, n.y);
        }
        // g.dispose();
    }
    
    
    
    
    // returns node clicked on
    public int getNodeClicked(int x, int y)
    {
        // by default, start with index that does not exist
        int nodeNum = -1;
            for (Rectangle n : nodeArrayCopy)
            {
                // if x and y are within a node
                if (n.contains(x, y))
                {
                    nodeNum = nodeArrayCopy.indexOf(n);
                    break;
                }
            }
            return nodeNum;
    }
    
    
    public void addNode(int x, int y)
    {
        // create node with center at the passed values
        int newX = x - (nodeDimensions.width/2);
        int newY = y - (nodeDimensions.height/2);
        
        Point p = new Point(newX, newY);
        nodeArrayCopy.add(new NodeRectangle(p, nodeDimensions));
        
        // for debugging/log
        System.out.println("Added node " + (nodeArrayCopy.size() - 1) + "!");
        
        repaint();
    }
    
   
    public void removeNode(int i)
    {
        // if i is within nodeArrayCopy's range
        if (!(i < 0 || i >= nodeArrayCopy.size()))
        {
            System.out.println("Removing rectangle at index : " + i);
               nodeArrayCopy.remove(i); // remove rectangle at index
               
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
    
    // clones the contents of n to nodeArrayCopy
    public void setnodeArrayCopy(ArrayList<NodeRectangle> n)
    {
        this.nodeArrayCopy.clear();
        this.nodeArrayCopy = (ArrayList<NodeRectangle>)n.clone();
    }
    
    // returns nodeArrayCopy
    public ArrayList<NodeRectangle> getnodeArrayCopy()
    {
        return nodeArrayCopy;
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
