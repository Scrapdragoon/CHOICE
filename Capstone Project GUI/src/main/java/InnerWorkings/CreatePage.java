/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import static j2html.TagCreator.*;
import j2html.tags.Tag;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/**
 *
 * @author Victor Malone (vm19171)
 */
public class CreatePage {
    
    /*
    String nodeTitle;
    String paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, \n"
            + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
            + "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
            + " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    String choicesList = "choice 1 \n choice 2 \n choice 3";
*/
    
    
    public static void main(String[] args)
    {
        String nodeTitle = "testing";
        String paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, \n"
            + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
            + "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
            + " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    String choicesList = "choice 1 choice 2 choice 3";
    
        // conditional system for showing/hiding certain elements of a page
            boolean showChoices = true;
            
            if (!showChoices)
            {
                choicesList = "";
            }
            
            String styleSheetLink = "../pageStylesheet.css";
            
    
        String html;  
        html = html(
                
                head(
                        
                link().withRel("stylesheet").withHref(styleSheetLink)
                ),
                
                
                h1(nodeTitle),
                // img().withSrc("jksdkj")
                p(),
                div(
                        p(paragraph),
                        p(choicesList)
                ).withClass("content")
                
                
                
        ).render();  // last tag must not have a comma after it for this to work.
    
      System.out.print(html);
      
      new File("./src/main/java/InnerWorkings/output").mkdir();
      File result = new File("./src/main/java/InnerWorkings/output/index.html");
      
      PrintWriter w;
        try {
            w = new PrintWriter(result);
            w.write(html);
            w.flush();
            w.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(CreatePage.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }

      
      /*
      JFrame fr = new JFrame();
      JPanel contentPanel = new JPanel();
      contentPanel.setLayout(new BorderLayout());
      JLabel e = new JLabel(html);
      
      contentPanel.add(e, BorderLayout.NORTH);
      fr.add(contentPanel);
      fr.setVisible(true);
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fr.setSize(500, 500);
       */
    }
    
}
