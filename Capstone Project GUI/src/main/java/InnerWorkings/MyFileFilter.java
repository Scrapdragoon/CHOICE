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
public class MyFileFilter extends FileFilter {

    private final String extension = ".choice";
    
    
    
    @Override
    public boolean accept(File f) {
        
        boolean ok = false;
        
        if (f.getName().toLowerCase().endsWith(extension))
        {
            ok = true;
        }
        else if (f.isDirectory())
        {
            ok = true;
         }
        
        return ok;

    }

    @Override
    public String getDescription() {
        
        return "CHOICE Files";
    }
    
    
    
}
