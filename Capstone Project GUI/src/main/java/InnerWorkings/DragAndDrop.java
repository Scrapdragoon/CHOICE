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
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Victor Malone (vm19171)
 * Code referenced from https://examples.javacodegeeks.com/desktop-java/awt/event/draw-and-drag-rectangles/
 */
public class DragAndDrop extends JPanel implements MouseMotionListener{
    
    // ArrayList of all nodes on screen
    private ArrayList<NodeRectangle> nodes = new ArrayList<>();

    // size of rectangle used to represent nodes
    private Dimension nodeDimensions = new Dimension(100, 50);
    private int currentNode = -1;
    
    public DragAndDrop() {
      
        
        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent event)
            {
                // select the node the user clicks
               currentNode = getNode(event.getX(), event.getY());
               System.out.println("Clicked on node " + currentNode);
            }
            
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                if (event.getButton() == MouseEvent.BUTTON1 && currentNode < 0)
                {
                    addNode(event.getX(), event.getY());
                    return;
                }
                 if (event.getButton() == MouseEvent.BUTTON3)   // if rectangle is right clicked
                {
                     System.out.println("Right click detected. Current node: " + currentNode);
                    remove(currentNode);
                }
            }
        });
        
        addMouseMotionListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
       g.setColor(Color.RED);
       ((Graphics2D)g).setStroke(new java.awt.BasicStroke(3));
        
        
        // draw every node
        for (NodeRectangle n : nodes)
        {
            ((Graphics2D)g).draw(n);
            ((Graphics2D)g).drawString(n.title, n.x, n.y);
        }
    }
    
    // returns node clicked on
    public int getNode(int x, int y)
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
        int newX = x - (nodeDimensions.width/2);
        int newY = y - (nodeDimensions.height/2);
        
        Point p = new Point(newX, newY);
        nodes.add(new NodeRectangle(p, nodeDimensions));
        repaint();
    }
    
    @Override
    public void remove(int i)
    {
        // if i is within nodes' range
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
        repaint();
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
            g.setXORMode(getBackground());  
            ((Graphics2D)g).draw(n);
            ((Graphics2D)g).drawString(n.title, n.x, n.y);
            
            nodes.get(currentNode).x = event.getX() - 50;
            nodes.get(currentNode).y = event.getY() - 25;
            
            ((Graphics2D)g).draw(n);
            ((Graphics2D)g).drawString(n.title, n.x, n.y);
            
            g.dispose(); // get rid of graphics object after using
            repaint();
        }
    }
    
    
    public static void main(String[] args)
    {
        /*
        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(new DragAndDrop());
        frame.setVisible(true);
        */
        
        
    }
    
    
}
