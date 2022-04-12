/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InnerWorkings;

import DataItems.Node;
import com.google.common.base.CharMatcher;
import static j2html.TagCreator.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
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
    String outputFolder = "NO OUTPUT FOLDER SET";
    String resourcesFolder = "NO RESOURCE FOLDER SET";
    
            
        
    // IF YOU CHANGE THE NAMES OF THESE, YOU'LL HAVE TO CHANGE THE NAMES IN THE CSS AS WELL.
    static String titleClass = "pageTitle";
    static String contentClass = "content";
    static String projectName; // appended to the output folder to store the game's pages.
    static String imgSrc = "../resources/UofE.jpg";    
        
    
    
    public ExportGame()
    {
        //e. for instantiation via netbeans' gui builder
    }
    
    public ExportGame(ProjectFile project)
    {
        this.project = project;
    }
    
    
    public void export()
    {
        // iterate through each node in the file, creating HTML for each one. Save all of them in a folder named after project's name.
        
        // create output folder and resource folder
        new File(outputFolder).mkdir();
        System.out.println("Made folder at: " + outputFolder);
        
        // for user resources
        String userResourcesFolderPathString = outputFolder + "\\resources";
        File userResourcesFolderPathFile = new File(userResourcesFolderPathString);
        boolean madeResourceFolder = userResourcesFolderPathFile.mkdir();
        if (madeResourceFolder)
        {
            System.out.println("Made folder at:" + userResourcesFolderPathString);
        }
        
       
        // for each node, process the page.
        for (NodeRectangle n : project.getNodes())
        {
            // name of page file is based off of ID
            String filename = n.getNode().getID() + ".html";
            String HTML = processPage(n.getNode());      
            
            File page = new File(outputFolder + "\\" + filename);
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
        
        
        // TODO - copy images and whatnot into resource folder.
        // "Master" resource folder will be in install location. Locate stylesheet, make path to it.
        // 
        // Either that, or keep the data for the basic stylesheet as a variable or whatever somewhere within the program. Write to an actual file in the resource location.
        
                
        File masterStylesheetFile = new File("master_resources\\pageStylesheetv2.css");
        System.out.println("Stylesheet file at: " + masterStylesheetFile.getAbsolutePath());
        
        // if the stylesheet is still in the master_resources folder, copy to new destination.
        if (masterStylesheetFile.exists())
                {
                    
                    System.out.println("Stylesheet does exist.");
                    // make path from master stylesheet
                    Path masterStylesheetPath = Path.of(masterStylesheetFile.getAbsolutePath());
                    System.out.println("Stylesheet path: " + masterStylesheetPath);
                    
                    // create path to new stylesheet
                    String userStylesheetPathString = userResourcesFolderPathString + "\\pageStylesheetv2.css";
                    Path userStylesheetPath = Path.of(userStylesheetPathString);
                    
                    // try to copy master stylesheet to user's folder
                    try {
                            // copy master stylesheet to user's folder
                            Files.copy(masterStylesheetPath, userStylesheetPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                    catch (IOException ex) {
                            Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
                    }

        
                }
        else
        {
            System.out.println("Master stylesheet not found at: " + masterStylesheetFile.getAbsolutePath());
        }
        
        //System.out.println("Game successfully exported! I hope...!");
    }
    
    // for processing one page at a time.
    public static String processPage(Node n)
    {
        String title, ID, imagePathString, paragraph;
        Map<String, Collection<String>> choices;
        
        // conditionals for showing/hiding elements of a page
        boolean showTitle, showImage, showParagraph, showChoices;
        
        // title
        title = n.getTitle();
        
        // ID
        ID = n.getID();
        
        // image
        imagePathString = n.getImagePath();
        // paragraph
        paragraph = n.getParagraph();
        
        // choices
        choices = n.getLinks().asMap();
        
        
        
        // TODO - implement system that creates differrent HTML based on what and what should not be shown.
        // and possibly, change in stylesheet link.
        String stylesheet = "./resources/pageStylesheetv2.css";
        

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
                                img().withSrc(imagePathString).withClass("user-image"),
                                
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

    /*
    // used for copying images to resources folder
    public boolean copyToLocation(Path source, Path dest)
    {
        
        
        return 
    }
    */
    
    
    
    
    
    // make project's name 
    public String cleanProjectName(String projectName)
    {             
        String cleaned = CharMatcher.breakingWhitespace().replaceFrom(projectName, '_') ;
        cleaned = CharMatcher.whitespace().trimFrom(cleaned);
        cleaned = CharMatcher.javaLetterOrDigit().or(CharMatcher.is('_')).retainFrom(cleaned);
        cleaned += " - CHOICE";
        System.out.println("Output folder name: " + cleaned);
        
        return cleaned;
    }
    
    public ProjectFile getProject() {
        return project;
    }

    public void setProject(ProjectFile project) {
        this.project = project;
    }

    public String getOutputFolder() {
        return outputFolder;
    }

    public void setOutputFolder(String outputFolder) {
        this.outputFolder = outputFolder;
    }

    public String getProjectName() {
        return projectName;
    }

    public static void setProjectName(String projectName) {
        ExportGame.projectName = projectName;
    }
    
//<editor-fold defaultstate="collapsed" desc="CSS as String">
    
    String css = "html {\n    \n    /* background-image: url(\"resources/bgImageEDIT.png\"); "
                + "*/\n    /* background-repeat: repeat; */\n   \n    min-width: 100%;\n\n    margin: 0;\n    "
                + "position: relative;\n\n    background-image: url(\"resources/bgImage_fade2.png\"), "
                + "url(\"resources/bgImage_fade2.png\");\n    background-position: left top, left top;\n   "
                + " background-repeat: repeat-y; \n    background-attachment: scroll;\n    background-origin: border-box;\n    "
                + "background-size: 100% auto;\n    background-position-y: 0px, 1100px;\n\n"
                + "/* CURRENTLY CONTAINS A VISUAL GLITCH WHEN THE WINDOW IS NOT FULL SIZE.*/\n   "
                + " \n    \n\n    \n    \n \n    margin-left: auto;\n    margin-right: auto;\n    padding-top: 100px;\n    "
                + "\n    font-family: sans-serif;\n    \n}\n\nbody {\n  max-width: 65%;\n  margin: auto;\n    \n}\n\n\n\n"
                + ".background-image {\n\n\n}\n\n\n.user-Image {\n    display: block;\n    \n    "
                + "max-width: 90%; /* 90% of the div it's in  */\n    height: auto;\n    margin-left: auto;\n    "
                + "margin-right: auto;\n    border-style: solid;\n    border-width: 3px;\n}\n\n.pageTitle {\n   "
                + " text-align: center;\n    text-decoration: underline;\n    font-family: DFPOP1-W9, sans-serif;\n   "
                + " font-size: 40px;\n\n}\n\n.content {\n\n}\n\n\n.paragraph {\n    display: block;\n    "
                + "width: 95%;\n    margin-left: auto;\n    margin-right: auto;\n    \n    "
                + "font-size: 20px;\n}\n\n.choices {\n    display: block;\n    width: 90%;\n    "
                + "margin-left: auto;\n    margin-right: auto;\n    \n    font-size: 20px;\n}\n\n"
                + "a:link {\n    color: #9999ff\n}\n\na:visited {\n    color: #9999ff\n}";    
                
    //</editor-fold>
    
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
