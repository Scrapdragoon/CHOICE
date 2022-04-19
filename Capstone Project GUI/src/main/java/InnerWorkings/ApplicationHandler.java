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

package InnerWorkings;

import DataItems.ProjectFile;
import DataItems.NodeRectangle;
import WindowsAndPanels.DragAndDrop;
import DataItems.Node;
import WindowsAndPanels.CreatePageFrame;
import WindowsAndPanels.PageEditorFrame;
import com.google.common.base.CharMatcher;
import com.google.common.collect.Multimap;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;


/**
 * This class stores and enacts the main methods the application uses. <p>
 * This includes saving, loading, modifying the ProjectFile, etc. <p>
 * This is the Controller in the MVC pattern.
 * 
 * @author Victor Malone (vm19171)
 * 
 */


public class ApplicationHandler {
    
    /**
     * Project file containing all project-specific data. The Model in the MVC pattern..
     */
    private ProjectFile project;
    
    /**
     * DragAndDrop panel that displays the node data from the project variable. The View in the MVC pattern.
     */
    private DragAndDrop view;
    
    /**
     * Frame that contains this object.
     */
    public JFrame frame;
    
    /**
     * Page editor frame to pass node data to when editing.
     */
     PageEditorFrame pageEditorFrame = new PageEditorFrame();
     
     /**
      * Create page frame to receive data from, used to create new nodes.
      */
     CreatePageFrame createPageFrame = new CreatePageFrame();
   
    /**
     * Dimensions for NodeRectangles.
     */
    public static Dimension nodeDimensions = new Dimension(75, 100);
    
    /**
     * File extension for CHOICE projects.
     */
    public final String extension = ".choice";
    
    /**
     * Value that determines whether the JFrame is enabled or not.
     */
    public boolean enabled = true;
    
    //------------------------------------------------

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    
    /**
     * No-argument constructor for NetBeans' GUI Builder. Creates a new ProjectFile.
     */
    public ApplicationHandler() {
        project = new ProjectFile();        
    }
    
    //</editor-fold> 
    
    //------------------------------------------------

    //<editor-fold defaultstate="collapsed" desc="Creation, Loading, Saving, etc.">
    // Operations that affect the project as a whole.
    
    /**
     * Replaces project with a new ProjectFile.
     */
    public void createProject()
    {
        project = new ProjectFile();    
    }
    
    /**
     * Loads file passed to it, and assigns the results to its ProjectFile. Verification of file is performed before this step.
     * 
     * @param f The file to be loaded.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void loadProject(File f) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        // load project data from a file and assign to project.

        // create streams
        FileInputStream fileInStream = new FileInputStream(f);
        ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);

        // read from file
        project = (ProjectFile) objectInStream.readObject();
        
        // close streams
        fileInStream.close();
        objectInStream.close();                   
    }
    
    /**
     * Writes the ProjectFile object to a file.
     * 
     * @param f The file to save.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveProject(File f) throws FileNotFoundException, IOException
    {
        // save project's data to a file.  
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
    
   /**
    * Syncs the ProjectFile's nodes with those of DragAndDrop.
    */
    public void updateProject()
    {
        project.setNodes(view.getNodes());
    }
           
    //</editor-fold>
    
    
   // ------------------------------------------------
    
    
    //<editor-fold defaultstate="collapsed" desc="Node-Specific">  
    
    /**
     * Creates a new node, and opens the page editor. <p>
     * The node's ID is created here, based off of the title.
     * 
     * @param title title of node
     */
    public void createNewPage(String title)
    {
        String ID = autoGenerateID(title);
        Node n = new Node(title, "", ID);
        NodeRectangle newNode = new NodeRectangle(n);
        project.getNodes().add(newNode);
        openPageEditor(newNode);
    }   
    
    /**
     * Opens the frame used for creating new nodes.
     */
    public void openCreatePage()
    {
        System.out.println("AppHandler's openCreatePage method called.");
        createPageFrame = new CreatePageFrame();    // reset frame
        createPageFrame.setVisible(true);
        createPageFrame.setApplicationHandler(this);
        enableFrame(false);
        
        createPageFrame.revalidate();
        createPageFrame.repaint();
    }
    
    /**
 * Opens the frame used to edit nodes.
 * 
 * @param n The node to be edited.
 */
    public void openPageEditor(NodeRectangle n)
    {
        System.out.println("Opening page editor...");
        pageEditorFrame.setVisible(true);
        pageEditorFrame.setWindowData(n, this);
        pageEditorFrame.revalidate();
        pageEditorFrame.repaint();
        
        //while page frame is open, disable main frame
        enableFrame(false);   
    }
    
    /**
     *  Replaces all nodes in the ProjectFile that match the one passed as a parameter.
     * 
     * @param n The edited node to be saved/updated.
     */
    public void saveNode(Node n)
    {
        // takes input from editor window and saves the node with its new parameters.
        
        String replaceID = n.getID();   // ID that program needs to search for
        
        for (NodeRectangle node : project.getNodes())
        {
            if (node.getNode().getID().equalsIgnoreCase(replaceID))
            {
                node.setNode(n);
            }
        }
        
        project.updateLinks();
        
        view.updateViewNodes(project.getNodes());
        view.revalidate();
        view.repaint();
    }
    
        /**
         * Removes all nodes containing originalID, and replaces them with new Node n. <p>
         * This method also verifies Node n's ID, and alters it if not sufficient.
         * 
         * @param n The new node that will replace the ones containing originalID.
         * @param originalID The ID of the node to be replaced.
         */
    public void removeAndSaveNode(Node n, String originalID)
    {
        n.setID(autoGenerateID(n.getID()));

        // replaces nodes that have had IDs that were edited.
        String replaceID = originalID;
        
        for (NodeRectangle node : project.getNodes())
        {
            System.out.println("Current node ID: " + node.getNode().getID());
            System.out.println("Replacement ID: " + replaceID);
            if(node.getNode().getID().equalsIgnoreCase(replaceID))
            {
                System.out.println("Node will be replaced.");
                node.setNode(n);
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
               
                
                System.out.println("-");
                System.out.println("Links after inserting new ID:" + links.toString());
                links.removeAll(replaceID);
                System.out.println("Links after removing old ID:" + links.toString());
                System.out.println("-");

                nodeRect.getNode().setLinks(links);
                System.out.println("Node " + node.getID() + "'s new links: ");
                System.out.println(links.toString());
            }
            System.out.println("-");
        }
        
        project.updateLinks();
        System.out.println("Nodes in this file:" + project.getNodes().toString());
    }
    
  
    /**
     * Automatically generates a starting ID based on the entered title/phrase. <p>
     * Uses Guava's CharMatcher.
     * 
     * @param enteredID The ID that needs to be determined/changed.
     * @return The new ID, after alteration.
     */
    public String autoGenerateID(String enteredID)
    {
        System.out.println("--");
        System.out.println("AutoGenerateID called.");
        
        // first, clean string by removing unnecessary whitespace
        // and non alphanumeric characters (except for underscores)
        String newID = CharMatcher.breakingWhitespace().replaceFrom(enteredID, '_');
        newID = CharMatcher.whitespace().trimFrom(newID);
        newID = CharMatcher.javaLetterOrDigit().or(CharMatcher.is('_')).retainFrom(newID);
        System.out.println("Cleaned string: " + newID);
        
        // if ID is empty or null, replace with "default_ID"
        if (newID == null || newID.equals(""))
        {
            newID = "default_ID";
        }
        
        String originalReturnID = newID; // to use as a base
        int i = 1;
        
        ArrayList<String> IDs = getAllIDs();
        boolean taken;
        
        do
        {
            taken = false;
            for (String ID : IDs)   // for each ID in the project
            {
               if (newID.equalsIgnoreCase(ID)) // if this ID already exists
               {
                   System.out.println("This ID is taken.");
                   taken = true;
                   newID = originalReturnID + "_" + i; // new ID is returnID_[number].
                    i++;
                   System.out.println("New ID: " + newID);
                   System.out.println("Beginning search again.");
                   break;
               }
            }
        } while (taken == true);
        
        System.out.println("ID found!");
        System.out.println("Auto-generated ID: " + newID);
        System.out.println("--");
        return newID;
    }
    
    /**
     * Removes a node entirely, using its ID. <p>
     * Then updates the other nodes, removing links if they would now lead to the "dead" ID.
     * 
     * @param ID ID of node to be deleted.
     */
    public void deleteNode(String ID)
    {
        ArrayList<NodeRectangle> toRemove = new ArrayList<>();
        
        System.out.println("--");
        System.out.println("Deleting node with ID: " + ID);
        for (NodeRectangle n : project.getNodes())
        {
            // if this is the node to be deleted, add to list of nodes to delete.
            if (n.getNode().getID().equalsIgnoreCase(ID))
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
    
    /**
     * Updates the links within the ProjectFile.
     */
    public void updateProjectFileLinks()
    {
        project.updateLinks();
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

   /**
    *  Returns a list of all of the IDs in project.
    * 
    * @return List of IDs of all of the nodes in the ProjectFile.
    */
    public ArrayList<String> getAllIDs()
    {
        ArrayList<String> IDsArrayList = new ArrayList<>();
        
        for (NodeRectangle n : project.getNodes())
        {
            IDsArrayList.add(n.getNode().getID());
        }
        return IDsArrayList;
    }
    
    /**
     * Enables/disables frame. For use when other windows open/close.
     * 
     * @param e Enable/disable frame.
     */
    public void enableFrame(boolean e)
    {
        if (e == true) frame.setEnabled(true);
        else frame.setEnabled(false);
    }
        
    /**
     * Gets user default directory using JFileChooser.
     * 
     * @return String of user's default directory.
     */
    public static String getUserDefaultDirectory()
    {
        FileSystemView fsv = new JFileChooser().getFileSystemView();
        return fsv.getDefaultDirectory().getPath();
    }
    
    //</editor-fold>
    
     // -----------------------------------------------

    
    //<editor-fold defaultstate="collapsed" desc="Methods for Testing">
    // Methods purely for testing. 
    
/*
    // tester method
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
    */
    
    /*
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


    public void testAutoGenerateID()
    {
       createNewPage("to!*&#&(*$;2,.,_*5)#@");
    }
    
    public void testNodes()
    {
        System.out.println("Project's nodes:");
        System.out.println(project.getNodes());
        System.out.println("DragAndDrop's nodes:");
        System.out.println(view.getNodes());
        
        System.out.println("Adding \"New\" NodeRectangle to DragAndDrop...");
        view.getNodes().add(new NodeRectangle("New"));
        System.out.println("Adding \"Genesis\" NodeRectangle to ProjectFile...");
        project.getNodes().add(new NodeRectangle("Genesis"));
        
        
        System.out.println("Project's new nodes:");
        System.out.println(project.getNodes());
        System.out.println("DragAndDrop's new nodes:");
        System.out.println(view.getNodes());
        
        // There's no need to update the other when one is changed. 
    }
    */
    
    //</editor-fold>
    
}
