/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
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
    
    public static ProjectFile project;
    
    
    //------------------------------------------------

    //<editor-fold defaultstate="collapsed" desc="Entire Project Operations">
    // Operations that affect the project as a whole.
    
    public void createProject()
    {
        // create new project at directory.
        project = new ProjectFile();
               
    }
    
    public void loadProject()
    {
        // load project data from a file and assign to project.
    }
    
    public void saveProject()
    {
        // save project's data to a file.
    }
    
    
    public void export()
    {
        // export project so it can be made into HTML pages.
    }
    
    //</editor-fold>
    
   // ------------------------------------------------
    
    //<editor-fold defaultstate="collapsed" desc="Node-Specific">

    public void addNewNode()
    {
        // create new node and add to project's array.
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
    
    
    //<editor-fold defaultstate="collapsed" desc="Other Methods">
    // Misc/helper methods.

    // Gets user default directory using JFileChooser.
    public String getUserDefaultDirectory()
    {
        FileSystemView fsv = new JFileChooser().getFileSystemView();
        return fsv.getDefaultDirectory().getPath();
    }
    //</editor-fold>
    
    
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
            project.setProjectName("New Project");
            

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
            System.out.println("Data loaded? Project name: " + project.getProjectName());
            
        }
    }
    
    // for testing purposes
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        // testMethod();
        

        
        //System.out.println("Current directory: " + System.getProperty("user.home"));
    }
}
