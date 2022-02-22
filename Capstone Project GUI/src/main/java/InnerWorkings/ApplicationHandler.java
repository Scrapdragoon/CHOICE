/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

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
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


/**
 *
 * @author Victor Malone (vm19171)
 * 
 * This class is meant to be used to handle the methods the application will use. 
 * This includes saving, loading, modifying the ProjectFile, 
 */


public class ApplicationHandler {
    
    // Project file containing all project-specific data
    private static ProjectFile project;
    private DragAndDrop view;
    
   
    // dimension for visual representation of nodes
    private Dimension nodeDimensions = new Dimension(100, 50);
    
    
    
    
    // Constructors
    public ApplicationHandler(ProjectFile p, DragAndDrop d)
    {
        project = p;
        view = d;
    }

    public ApplicationHandler() {
    }
    
    
    
    
    //------------------------------------------------

    //<editor-fold defaultstate="collapsed" desc="Entire Project Operations">
    // Operations that affect the project as a whole.
    
    public void createProject()
    {
        // create new project (at directory?)
        project = new ProjectFile();
               
    }
    
    public void loadProject(File f)
    {
        // load project data from a file and assign to project.
                
    }
    
    public void saveProject(File f)
    {
        // save project's data to a file.
        // if file.exists(), ask to overwrite- or perhaps handle that in the JFileChooser itself. See here: https://stackoverflow.com/questions/3651494/jfilechooser-with-confirmation-dialog
        
        
    }
    
    
   
    public void update(DragAndDrop DDPanel)
    {
        // to sync the ProjectFile's node data with DragAndDrop's.
        this.project.setNodes(DDPanel.getnodeArrayCopy());
        
        // is this more of a "link"? Does it only need to be done once?
    }
    
    
    public void export()
    {
        // export project so it can be made into HTML pages.
    }
    
    //</editor-fold>
    
   // ------------------------------------------------
    
    //<editor-fold defaultstate="collapsed" desc="Node-Specific">

    public void addNewNode(MouseEvent event)
    {
        // create new node and add to project's array. NOT for clicking on existing nodes.
        //if (event.getButton() == MouseEvent.BUTTON1 && currentNode < 0)
        {
            
        }
        
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
