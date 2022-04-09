/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import com.google.common.collect.Multimap;
import static j2html.TagCreator.*;
import j2html.rendering.HtmlBuilder;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Victor Malone (vm19171)
 * 
 * This class is used to export the user's inputs into individual HTML pages with links. 
 */
public class ExportGame {
    
    
    // ProjectFile from the... well, project file.
    ProjectFile project;
    
    // TODO - folder to save all of these pages in. This will be changed later
    static String outputFolder = "src/main/java/InnerWorkings/Apr_7_Test";
    
            
        
    // IF YOU CHANGE THE NAMES OF THESE, YOU'LL HAVE TO CHANGE THE NAMES IN THE CSS AS WELL.
    static String titleClass = "pageTitle";
    static String contentClass = "content";
    static String projectName; // appended to the output folder to store the game's pages.
    static String imgSrc = "../resources/UofE.jpg";    
        
    
    
    
    
    public ExportGame(ProjectFile project)
    {
        this.project = project;
        export();
    }
    
    
    public void export()
    {
        // iterate through each node in the file, creating HTML for each one. Save all of them in a folder named after project's name.
        
        // create folder
        new File(outputFolder).mkdir();
        
        // for each node, process the page.
        for (NodeRectangle n : project.getNodes())
        {
            // name of file is based off of ID
            String filename = n.getNode().getID() + ".html";
            String HTML = processPage(n.getNode());      
            
            File page = new File("src/main/java/InnerWorkings/" + "Apr_7_Test/" + filename);
            PrintWriter w;
            
            try {
                w = new PrintWriter(page);
                w.write(HTML);    // write HTML to file
                w.flush();
                w.close();
            }
              catch (FileNotFoundException ex) {
                  System.out.println("Something went wrong with exporting your game.");
                  Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
                  System.exit(0);
              }        
          }
        
        System.out.println("Game successfully exported! I hope...!");
    }
    
    // for processing one page at a time.
    public static String processPage(Node n)
    {
        String title, ID, imagePath, paragraph;
        Map<String, Collection<String>> choices;
        
        // conditionals for showing/hiding elements of a page
        boolean showTitle, showImage, showParagraph, showChoices;
        
        // title
        title = n.getTitle();
        
        // ID
        ID = n.getID();
        
        // image
        imagePath = n.getImagePath();
        // paragraph
        paragraph = n.getParagraph();
        
        // choices
        choices = n.getLinks().asMap();
        
        
        
        // TODO - implement system that creates differrent HTML based on what and what should not be shown.
        // and possibly, change in stylesheet link.
        String stylesheet = "../pageStylesheetv2.css";
        

        // create HTML
        String HTML;
        
        HTML = html(
                // header of page; contains title and link to CSS
                head(
                        title(title),
                        link().withRel("stylesheet").withHref(stylesheet)
                ),
                
                body(
                        
                        div(
                                // title
                                h1(title).withClass(titleClass),
                                
                                // image
                                img().withSrc(imagePath).withClass("user-image"),
                                
                                // paragraph div
                                div(
                                        p(paragraph).withClass("paragraph"),
                                        
                                        // choices div
                                        div(
                                                p("What will you do?"),
                                                // for each choice, make hyperlink.
                                                each(choices, choice ->
                                                        div(attrs(".choices"),
                                                                
                                                                // choice = entry. Key = URL, Value = Collection<String>.
                                                                // for each String 'text' in getValue()
                                                                // make hyperlink(key, text)
                                                                each(choice.getValue(), text ->
                                                                        p(a(text).withHref(choice.getKey() + ".html"))
                                                                        
                                                                       ) // end of inner each loop
                                                                
                                                                ) // end of inner choices div
                                                        
                                                ) // end of outer each loop
                                                
                                        ) // end of outer choices div
                                        
                                ) // end of paragraph div
                                
                        ).withClass(contentClass) // end of body main div </div>
                
                ) // end of bady tag </body>
                
        ).renderFormatted();   // end of HTML tag </html>
        
        System.out.println(HTML);
        
        
        return HTML;        
    }
    
    
    
    
    public static void main(String[] args)
    {
        //<editor-fold defaultstate="collapsed" desc="Old test">
        /*
        

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
            w.write(
            html(
                
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
                
                
                
        ).render()
            );
            w.flush();
            w.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
        try {
            // try to open file in browser. just for testing at the moment
            Desktop.getDesktop().browse(result.toURI());
            

        }
        catch (IOException ex) {
            Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
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
                       
//</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="New Test (Apr 7)">
        /*
        Node n = new Node();
        n.addLink("testLink", "Link 1");
        n.addLink("secondTestLink", "Link 2");
        n.setImagePath("../resources/UofE.jpg");
        
        String HTML = ExportGame.processPage(n);

                
      new File(outputFolder).mkdir();
      File result = new File("src/main/java/InnerWorkings/output/index.html");
      
      PrintWriter w;
      try {
          w = new PrintWriter(result);
          w.write(HTML);    // write HTML to file
          w.flush();
          w.close();
          
      }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
      
      try {
          //try to open file
          Desktop.getDesktop().browse(result.toURI());
      }
        catch (IOException ex) {
            Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
//</editor-fold>
        
        //Even newer test (Apr 7 again)
        ProjectFile p = new ProjectFile();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        
        n1.setID("n1");
        n2.setID("n2");
        n3.setID("n3");
        
        n1.setTitle("This is Node 1!");
        n2.setTitle("This is Node 2!");
        n3.setTitle("This is Node 3!");
        
        n1.addLink("n2", "To Node 2");
        n1.addLink("n3", "To Node 3");
        
        n2.addLink("n1", "To Node 1");
        n2.addLink("n3", "To Node 3");
        
        n3.addLink("n1", "To Node 1");
        n3.addLink("n2", "To Node 2");
        
        
        NodeRectangle nr1 = new NodeRectangle(n1);
        NodeRectangle nr2 = new NodeRectangle(n2);
        NodeRectangle nr3 = new NodeRectangle(n3);
        
        ArrayList<NodeRectangle> nodes = p.getNodes();
        
        nodes.add(nr1);
        nodes.add(nr2);
        nodes.add(nr3);
        
        p.setNodes(nodes);
        
        ExportGame e = new ExportGame(p);
        
       
    }
    
}
