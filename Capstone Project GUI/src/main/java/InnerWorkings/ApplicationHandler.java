/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import EditorWindowPackage.PageEditorFrame;
import EditorWindowPackage.PageEditorPanel;
import com.google.common.collect.Multimap;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;


/**
 *
 * @author Victor Malone (vm19171)
 * 
 * This class is meant to be used to handle the methods the application will use. 
 * This includes saving, loading, modifying the ProjectFile, etc.
 * 
 * This is the Controller in the MVC pattern.
 */


public class ApplicationHandler {
    
    // Project file containing all project-specific data. Model.
    private static ProjectFile project;
    
    // DragAndDrop panel. View.
    private DragAndDrop view;
    public JFrame frame;
    
    // Page editor.
     PageEditorFrame pageEditorFrame = new PageEditorFrame();
    private static PageEditorPanel pageEditor = new PageEditorPanel();
   
    // dimension for visual representation of nodes
    public static Dimension nodeDimensions = new Dimension(100, 50);
    
    // custom file extension
    public final String extension = ".choice";
    
    
    public boolean enabled = true;
    
    //------------------------------------------------

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    

    public ApplicationHandler(ProjectFile p, DragAndDrop d)
    {
        project = p;
        view = d;
        // view.setNodes(project.getNodes());
       //frame = (JFrame)SwingUtilities.getWindowAncestor(view);
    }

    public ApplicationHandler() {
        // no-argument
        // for testing
        System.out.println("AppHan no arg");
        project = new ProjectFile();
        //view = new DragAndDrop();

        // updateView();
        // view.revalidate();
        //view.repaint();
        
    }
    
    //</editor-fold> 
    
    //------------------------------------------------

    //<editor-fold defaultstate="collapsed" desc="Entire Project Operations">
    // Operations that affect the project as a whole.
    
    public void createProject()
    {
        // create new project (at directory?)
        project = new ProjectFile();
               
    }
    
    public void loadProject(File f) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        // load project data from a file and assign to project.

        // create streams
        FileInputStream fileInStream = new FileInputStream(f);
        ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);

        // read from file
        project = (ProjectFile) objectInStream.readObject();
        //System.out.println("Data loaded? Project name: " + project.getProjectTitle());
        
        // close streams
        fileInStream.close();
        objectInStream.close();                   
    }
    
    public void saveProject(File f) throws FileNotFoundException, IOException
    {
        // save project's data to a file.
        // if file.exists(), ask to overwrite- or perhaps handle that in the JFileChooser itself. See here: https://stackoverflow.com/questions/3651494/jfilechooser-with-confirmation-dialog
              
        // main code already checks for extension.
        
        // create streams
        FileOutputStream fileOutStream = new FileOutputStream(f);
        ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
            
        // write to file
        objectOutStream.writeObject(project);
            
        // close streams
        fileOutStream.close();
        objectOutStream.close();
    }
    
    
   
    public void updateProject()
    {
        // to sync the ProjectFile's node data with DragAndDrop's.
        project.setNodes(view.getNodes());
        
        // is this more of a "link"? Does it only need to be done once?
    }
    
    /*
    // to sync DragAndDrop's data with ProjectFile's.
    public void updateView()
    {
        //System.out.println("Updating view...");
        view.clearNodes();
        
        for (NodeRectangle r : project.getNodes())
        {
            System.out.println("Adding project nodes to view...");
            view.addNode(r);
        }
    }
*/
    
    
    public void export()
    {
        // export project so it can be made into HTML pages.
    }
    
    //</editor-fold>
    
   // ------------------------------------------------
    
    
    // returns a list of all IDs in the project
        public ArrayList<String> getAllIDs()
    {
        ArrayList<String> IDsArrayList = new ArrayList<>();
        
        for (NodeRectangle n : project.getNodes())
        {
            IDsArrayList.add(n.getNode().getID());
        }
        return IDsArrayList;
    }
        
        
    
    public void openPageEditor(NodeRectangle n)
    {
        pageEditorFrame.setVisible(true);
        pageEditorFrame.setWindowData(n, this);
        pageEditorFrame.revalidate();
        pageEditorFrame.repaint();
        
        //while page frame is open, disable main frame
        enableFrame(false);   
    }
    
    public void enableFrame(boolean e)
    {
        if (e == true) frame.setEnabled(true);
        else frame.setEnabled(false);
    }
    
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Node-Specific">

    public void addNewNode(MouseEvent event)
    {
        // create new node and add to project's array. NOT for clicking on existing nodes.
        //if (event.getButton() == MouseEvent.BUTTON1 && currentNode < 0)
        {
            
        }
        
    }
    
    public void deleteLink(String ID1, String ID2)
    {
        // for deleting links between two nodes, i.e. when one node is deteted.
        // 
    }
    
       
    
    public void saveNode(Node n)
    {
        // takes input from editor window and saves the node with its new parameters.
        
        // Attempt 1: replaces node in projectFile entirely.
        String replaceID = n.getID();
        
        for (NodeRectangle node : project.getNodes())
        {
            if (node.getNode().getID().equals(replaceID))
            {
                node.setNode(n);
                //break;
            }
        }
        
        System.out.println("Node with ID " + replaceID + " replaced. Might need to update the view or something.");
        ///updateView();
        project.updateLinks();
        
        view.updateViewNodes(project.getNodes());
        view.revalidate();
        view.repaint();
        

    }
    
    // for removing a node entirely, using its ID.
    // it then updates the other nodes, removing links if they would now lead to the "dead" ID.
    public void deleteNode(String ID)
    {
        ArrayList<NodeRectangle> toRemove = new ArrayList<>();
        
        System.out.println("--");
        System.out.println("Deleting node with ID: " + ID);
        for (NodeRectangle n : project.getNodes())
        {
            // if this is the node to be deleted, add to list of nodes to delete.
            if (n.getNode().getID().equals(ID))
            {
                toRemove.add(n);
                System.out.println("Added a node to the list to be deleted.");
            }
            // else, if the current node contains links to the deleted node, then delete them.
            else if (n.getNode().getLinks().containsKey(ID))
            {
                n.getNode().getLinks().removeAll(ID);
                System.out.println("Removed all links to this node from node with ID: " + n.getNode().getID());
            }
        }    
        
        System.out.println("Removing all nodes in toRemove...");
        project.getNodes().removeAll(toRemove);
        System.out.println("Remaining nodes in file: " + project.getNodes().toString());
        System.out.println("--");
    }
    
    public void removeAndSaveNode(Node n, String originalID)
    {
        System.out.println("");
        System.out.println("Removing and saving node...");
        System.out.println("New node's ID: " + n.getID() + ". Original node's ID: " + originalID + ".");
        System.out.println("Checking nodes....");
        // replaces nodes that have had IDs that were edited.
        String replaceID = originalID;
        
        for (NodeRectangle node : project.getNodes())
        {
            System.out.println("Current node ID: " + node.getNode().getID());
            System.out.println("Replacement ID: " + replaceID);
            if(node.getNode().getID().equals(replaceID))
            {
                System.out.println("Node will be replaced.");
                node.setNode(n);
                //break;
            }
        }
        System.out.println("");
        
        
        // iterate through all nodes and update links with new ID.
        
        // for each node
        // if links contain originalID
        // store all associated values, delete key
        // putAll(newID, list/array of values)
        System.out.println("Updating links...");
        System.out.println("--");
        for (NodeRectangle nodeRect : project.getNodes())
        {

            Node node = nodeRect.getNode();
            Multimap<String, String> links = node.getLinks();   // copies the links multimap from Node. Key = ID, Value = hyperlink text
            System.out.println("Node ID: " + node.getID());
            System.out.println("Links: " + links.toString());
            System.out.println("Looking for occurrences of ID " + replaceID + "...");
            
            if (links.containsKey(replaceID))
            {
                System.out.println("ID that needs to be replaced found!");
                System.out.println("Replacing with ID: " + n.getID());
                List<String> values = (List<String>) links.get(replaceID);
                if (values.isEmpty())
                {
                    System.out.println("Values is empty. Returning function...");
                    return;
                }
                
                System.out.println("Values: " + values.toString());
                links.putAll(n.getID(), values);
                
                /*
                links.removeAll(replaceID);
                System.out.println("Links after removing old ID:" + links.toString());
                if (values.isEmpty())
                {
                    System.out.println("Values is empty.");
                    break;
                }
                */
                /*
                for(String hyperlinkText : values)
                {
                    System.out.println("put: " + n.getID() + ", " + hyperlinkText);
                    links.put(n.getID(), hyperlinkText);
                }
                */
                
                
                System.out.println("-");
                System.out.println("Links after inserting new ID:" + links.toString());
                links.removeAll(replaceID);
                System.out.println("Links after removing old ID:" + links.toString());
                System.out.println("-");
/*
                boolean put = links.put(n.getID(), "testing put method");
                System.out.println("Links after test put: " + links.toString());
                boolean putAll = links.putAll(n.getID(), values);
                
                if (putAll != true)
                {
                    System.out.println("--putAll method did not change the multimap. Breaking...--");
                    break;
                }
*/

                nodeRect.getNode().setLinks(links);
                System.out.println("Node " + node.getID() + "'s new links: ");
                System.out.println(links.toString());
            }
            System.out.println("-");
        }
        
        project.updateLinks();
        System.out.println("Nodes in this file:" + project.getNodes().toString());
    }
    
    public void updateProjectFileLinks()
    {
        project.updateLinks();
    }
    
    
    public void autoSetNodeID()
    {
        
    }
    
    //</editor-fold>
   
    // -----------------------------------------------
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public ProjectFile getProjectFile()
    {
        return project;
    }
    
    public void setProjectFile(ProjectFile projectFile)
    {
        project = projectFile;
    }
    
    public DragAndDrop getView() {
        return view;
    }

    public void setView(DragAndDrop view) {
        this.view = view;
    }
    
    public ArrayList<NodeRectangle> getNodes()
    {
        return project.getNodes();
    }
    
    
    public String getNodeTitle(int index)
    {
        return project.getNode(index).getTitle();
    }
    
    public void setNodeTitle(int index, String title)
    {
        project.getNode(index).setTitle(title);
    }
    
    public String getNodeParagraph(int index)
    {
                return project.getNode(index).getParagraph();
    }
    
    public String getNodeID(int index)
    {
        return project.getNode(index).getID();
    }   

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public static Dimension getNodeDimensions() {
        return nodeDimensions;
    }

    public static void setNodeDimensions(Dimension nodeDimensions) {
        ApplicationHandler.nodeDimensions = nodeDimensions;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    
    
    //</editor-fold>
    
    // -----------------------------------------------
    
    //<editor-fold defaultstate="collapsed" desc="Other Methods">
    // Misc/helper methods.

    // Gets user default directory using JFileChooser.
    public static String getUserDefaultDirectory()
    {
        FileSystemView fsv = new JFileChooser().getFileSystemView();
        return fsv.getDefaultDirectory().getPath();
    }
    //</editor-fold>
    
     // -----------------------------------------------

    
    //<editor-fold defaultstate="collapsed" desc="Testing Methods">
    

    // tester metho
    public static void testMethod() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        project = new ProjectFile();
        String folderPath = "./Projects";
        File projectFolder = new File(folderPath);
        projectFolder.mkdirs();
            

        File projectFile = new File(folderPath, "NewProject.choice");
         // projectFile.createNewFile();
            
       Scanner sc = new Scanner(System.in);
       System.out.println("Would you like to load the file?");
       String response = sc.nextLine();
       
       // if you say no, creates new file/overwrites old one.
        if (response.compareToIgnoreCase("no") == 0) {

            // default values
            project.setAuthorName("Author");
            project.setProjectTitle("New Project");
            

            System.out.println("Current directory: " + System.getProperty("user.dir"));
            
            FileOutputStream fileOutStream = new FileOutputStream(projectFile);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
            
            objectOutStream.writeObject(project);
            
            
            fileOutStream.close();
            objectOutStream.close();
            
        }
        else
        {
            // read objects from ProjectFile
            
            FileInputStream fileInStream = new FileInputStream(projectFile);
            ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);
            
            project = (ProjectFile) objectInStream.readObject();
            System.out.println("Data loaded? Project name: " + project.getProjectTitle());
            
        }
    }
    
    // tester method for saving in documents folder.
    public static void testSavingInDocuments() throws FileNotFoundException, IOException
    {
         // this code tests saving a default file in user's default directory (Documents).
         project = new ProjectFile();
         File projectFile = new File(getUserDefaultDirectory(), "NewProject.choice");

        FileOutputStream fileOutStream = new FileOutputStream(projectFile);
        ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
            
        objectOutStream.writeObject(project);
            
            
        
         fileOutStream.close();
        objectOutStream.close();
    }
            
    //</editor-fold>
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        // testMethod();
        
       
        
        
        //System.out.println("Current directory: " + System.getProperty("user.home"));
    }
}
