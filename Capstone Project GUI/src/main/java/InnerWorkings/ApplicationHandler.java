/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import EditorWindowPackage.PageEditorFrame;
import EditorWindowPackage.PageEditorPanel;
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
    
       
    
    public void saveNode()
    {
        // takes input from editor window and saves the node with its new parameters.
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
