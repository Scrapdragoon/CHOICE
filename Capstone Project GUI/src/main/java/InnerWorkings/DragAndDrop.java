/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 

*/
package InnerWorkings;

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
    
    // size of rectangle used to represent nodes
   // private Dimension nodeDimensions = new Dimension(100, 50);
   
   // current selected node
    private int currentNode = -1;
    
    
    
    public DragAndDrop() {
        
        //nodes = new ArrayList<>();
        //nodes = controller.getProjectFile().getNodes();
        
        //<editor-fold defaultstate="collapsed" desc="Mouse Listeners">


        this.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent event)
            {
                // select the node the user clicks, assign to currentNode
               currentNode = getNodeClicked(event.getX(), event.getY());
               System.out.println("Pressed node " + currentNode);
                // System.out.println("Node ID: " + nodes.get(currentNode).getNode().getID());
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
            NodeRectangle n = nodes.get(currentNode);
            Graphics g = getGraphics();
            
            // set up graphics
            g.setColor(Color.RED);
            ((Graphics2D)g).setStroke(new java.awt.BasicStroke(3));
            
            
            nodes.get(currentNode).x = event.getX() - (controller.nodeDimensions.width/2);
            nodes.get(currentNode).y = event.getY() - (controller.nodeDimensions.height/2);
            
           //((Graphics2D)g).draw(n);
           //((Graphics2D)g).drawString(n.getNode().getTitle(), n.x, n.y);
           
            // g.dispose(); // get rid of graphics object after using
            repaint();
        }
 
    //</editor-fold>
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
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
                ((Graphics2D)g).drawString(n.getNode().getTitle() + " " + nodes.indexOf(n), n.x, n.y);
            }
        }
        this.repaint();
    }
    
    // used to draw lines between connected pages
    public void drawLines(Graphics2D g)
    {
        
        //System.out.println("Drawing lines...");
        
        /*
        if (!(controller.getProjectFile().links.isEmpty()) && !(nodes.isEmpty()))
        {
            for(Link l : controller.getProjectFile().links)
            {
                System.out.println("Link: ID " + l.from + " to ID " + l.to);
                Point start = null, finish = null;
                
                for (NodeRectangle r : nodes)
                {
                    System.out.println("Current r: " + r.getNode().getID());
                    if (r.getNode().getID().equals(l.getFrom()))
                    {
                        System.out.println("Start assigned!");
                        start = new Point(r.getUpperLeft().x + controller.nodeDimensions.width/2, r.getUpperLeft().y + controller.nodeDimensions.height/2);
                    }
                    else if(r.getNode().getID().equals(l.getTo()))
                    {
                        System.out.println("Finish assigned!");
                        finish = new Point(r.getUpperLeft().x + controller.nodeDimensions.width/2, r.getUpperLeft().y + controller.nodeDimensions.height/2);
                    }
                }
                
                if (start != null && finish != null)
                {
                    g.drawLine(start.x, start.y, finish.x, finish.y);
                }
                else
                {
                    System.out.println("Start and/or finish are null.");
                }
            }
        }
        else
        {
            System.out.println("'Links' is empty!");
        }
        
        System.out.println("Lines have been drawn.");
        */

        
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
                    // connect centers
                    // TODO - change to path/other thing that makes it easier to tell which node is going to which
                g.drawLine(s.x + controller.nodeDimensions.width/2, s.y + controller.nodeDimensions.height/2, f.x+ controller.nodeDimensions.width/2, f.y + controller.nodeDimensions.height/2);
                //g.drawLine(s.x + controller.nodeDimensions.width/2 + 10, s.y + controller.nodeDimensions.height/2 + 5, f.x+ controller.nodeDimensions.width/2, f.y + controller.nodeDimensions.height/2);
            }
        }
                
        /*
        // Draws lines between consecutive nodes. For testing.
             if (!(nodes.isEmpty()))
        {
            for (int index = 0; index < nodes.size() -1; index++)
            {
                // draw lines from middle of nodes
               ((Graphics2D)g).drawLine(nodes.get(index).x + controller.nodeDimensions.width/2, nodes.get(index).y + controller.nodeDimensions.height/2, nodes.get(index + 1).x 
                       + controller.nodeDimensions.width/2, nodes.get(index + 1).y + controller.nodeDimensions.height/2);
               
               
           }
        }
        */

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
    
    public void addNode(int x, int y, String title)
    {
        // for adding nodes with a title. see above
        
        controller.updateProject();
    }
    
   
    public void removeNode(int i)
    {
        // if i is within nodes's range
        if (!(i < 0 || i >= nodes.size()))
        {
            System.out.println("Removing rectangle at index  " + i + " with ID: " + nodes.get(i).getNode().getID());
               controller.deleteNode(nodes.get(i).getNode().getID());
               //nodes.remove(i); // remove rectangle at index
               
               if (currentNode == i)
               {
               currentNode = -1;
               }
        }
        else
        {
            return;
        }
        
        // get nodes from project
        this.nodes = controller.getNodes();
        //controller.updateProject();
        System.out.println("");
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
