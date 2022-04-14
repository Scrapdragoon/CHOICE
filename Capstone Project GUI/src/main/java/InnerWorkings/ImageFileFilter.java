/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Victor Malone (vm19171)
 */
public class ImageFileFilter extends FileFilter {
    
    String[] acceptedExts = new String[] {".jpeg", ".jpg", ".png", ".gif"};
    
    
    @Override
    public boolean accept(File f)
    {        
        boolean ok = false;
        
        for (String extension : acceptedExts)
        {
            if (f.getName().toLowerCase().endsWith(extension))
            {
                ok = true;
            }
            else if (f.isDirectory())
            {
                ok = true;
             }
        } 
        return ok; 
    }
    
    
    @Override
    public String getDescription()
    {
        return "Image Files Only";
    }
    
}
