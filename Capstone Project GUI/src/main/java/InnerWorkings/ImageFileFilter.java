/*
 * Copyright 2022 Victor Malone.
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

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *File filter for accepted images. <p>
 * Includes JPEG, PNG, and GIF.
 * 
 * @author Victor Malone
 */
public class ImageFileFilter extends FileFilter {
    
    /**
     * Accepted extensions.
     */
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
