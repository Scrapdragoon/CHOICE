/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 

Code referenced from https://examples.javacodegeeks.com/desktop-java/awt/event/draw-and-drag-rectangles/

*/
package InnerWorkings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
 */
public class DragAndDrop extends JPanel implements MouseMotionListener{
    
    // ArrayList of all nodes on screen
    private ArrayList<Rectangle> nodes = new ArrayList<>();
    private int currentNode = -1;
    
    public DragAndDrop() {
        
        
        
        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent event)
            {
                // select the node the user clicks
               currentNode = getNode(event.getX(), event.getY());
            }
            
            
            @Override
            public void mouseClicked(MouseEvent event)
            {
                 if (event.getButton() == MouseEvent.BUTTON3)   // if rectangle is right clicked
                {
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
        if (nodes.isEmpty())
        {
            nodes.add(new Rectangle(50, 50, 100, 50));
        }
        
        // draw every node
        for (Rectangle n : nodes)
        {
            ((Graphics2D)g).draw(n);
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
    

    
    @Override
    public void remove(int i)
    {
        // if i is within nodes' range
        if (!(i < 0 || i >= nodes.size() - 1))
        {
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
        
    }
    
    
    @Override
    public void mouseDragged(MouseEvent event)
    {
        if (currentNode >= 0)
        {
            Graphics g = getGraphics();
            g.setXORMode(getBackground());   // get rid of original rectangle?
            ((Graphics2D)g).draw(nodes.get(currentNode));
            
            nodes.get(currentNode).x = event.getX() - 50;
            nodes.get(currentNode).y = event.getY() - 25;
            
            ((Graphics2D)g).draw(nodes.get(currentNode));
            
            g.dispose(); // get rid of graphics object after using
            repaint();
        }
    }
    
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(new DragAndDrop());
        frame.setVisible(true);
        
        
    }
    
    
}
