/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


/**
 *
 * @author Victor Malone (vm19171)
 */


public class ApplicationHandler {
    
    static ProjectFile currentProject;
    
    
    
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
      

        currentProject = new ProjectFile();
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

            
            currentProject.setAuthorName("author");
            currentProject.setProjectName("New Project");
            

            System.out.println("Current directory: " + System.getProperty("user.dir"));
            
            FileOutputStream fileOutStream = new FileOutputStream(projectFile);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);
            
            objectOutStream.writeObject(currentProject);
            
            
            fileOutStream.close();
            objectOutStream.close();
            
        }
        else
        {
            // read objects from ProjectFile
            
            FileInputStream fileInStream = new FileInputStream(projectFile);
            ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);
            
            currentProject = (ProjectFile) objectInStream.readObject();
            System.out.println("Data loaded? Project name: " + currentProject.getProjectName());
            
        }
        
        
        

    }
}
