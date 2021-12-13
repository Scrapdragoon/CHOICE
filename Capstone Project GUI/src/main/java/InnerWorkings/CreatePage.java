/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import static j2html.TagCreator.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Victor Malone (vm19171)
 */
public class CreatePage {
    
    
    // class to create page based on inputs
    public static void CreatePage()
    {
        
    }
    
    
    
    
    
    public static void main(String[] args)
    {
        // IF YOU CHANGE THESE, YOU'LL HAVE TO CHANGE THE NAMES IN THE CSS AS WELL.
        String titleClass = "pageTitle";
        String contentClass = "content";
        String outputFolderURI;
        String projectName;
        String imgSrc = "../resources/sunset.jpg";    
        
        
        // for testing purposes. Use j2html's "each" function to iterate through the list when generating HTML.
        Map<String, String> choices = new TreeMap<>();
        choices.put("Choice 1", "choice1.html");
        choices.put("Choice 2", "choice2.html");
        choices.put("Choice 3", "choice3.html");


        
        
        
        
        
        
        String nodeTitle = "Start!";
        
        // paragraph may have to be an arraylist, to allow the user to input line breaks. Parse this elsewhere.
        String paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "
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
            
            //String styleSheetLink = "../pageStylesheet.css";
            String styleSheetLink = "../pageStylesheetv2.css";
            
    
        String html;  
        html = html(
                
                // header
                head(
                        // tab title
                        title(nodeTitle),
                        // link to css
                        link().withRel("stylesheet").withHref(styleSheetLink)
                ),
                
               body(
                       // div( p("div is here!")).withClass("background-image"), // div for bg image
                // p(),    // blank line
                
                div(                                                            // content div
                        
                        // page title
                        h1(nodeTitle).withClass(titleClass),
                        
                        //page image
                        img().withSrc(imgSrc).withClass("user-image"),
                        
                        div(                                                        // paragraph div
                                
                                // user-input paragraph
                                p(paragraph + paragraph + paragraph + paragraph + paragraph),      
                                p(paragraph + paragraph + paragraph + paragraph + paragraph),  
                                p(paragraph + paragraph + paragraph + paragraph + paragraph),  
                                p(paragraph + paragraph + paragraph + paragraph + paragraph),  
                                p(paragraph + paragraph + paragraph + paragraph + paragraph),  
                                p(paragraph + paragraph + paragraph + paragraph + paragraph)
                                
                        ).withClass("paragraph"),
                        
                        div(                                                        // choices div
                                
                                // user-input choices
                                p("Choices List:"),
                                each(choices, choice -> 
                                        div(attrs(".choices"),
                                                p(a(choice.getKey()).withHref(choice.getValue()))
                                        
                                        
                                        )
                                )
                                
                        ).withClass("choices")
                        
                        
                ).withClass(contentClass) // </div>
               )    // </body>
                
                
                
        ).render();  // last tag must not have a comma after it for this to work.
    
      System.out.print(html);
      
      new File("src/main/java/InnerWorkings/output").mkdir();
      File result = new File("src/main/java/InnerWorkings/output/index.html");
      
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
        
        try {
            // try to open file in browser. just for testing at the moment
            Desktop.getDesktop().browse(result.toURI());
            

        }
        catch (IOException ex) {
            Logger.getLogger(CreatePage.class.getName()).log(Level.SEVERE, null, ex);
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
