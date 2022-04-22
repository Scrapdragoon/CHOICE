/*
 * Copyright 2022 Victor Malone (vm19171).
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

import DataItems.ProjectFile;
import DataItems.NodeRectangle;
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
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *This program exports the user's inputs into individual HTML pages, connected by hyperlinks.
 * 
 * @author Victor Malone (vm19171)
 */
public class ExportGame {
    
    /**
     * ProjectFile to read nodes from.
     */
    ProjectFile project = new ProjectFile();
    
   /**
    * Folder to save the finished HTML files in.
    */
    String outputFolder = "!ERROR - NO OUTPUT FOLDER SET!";
    
    /**
     * Path to the user's resource folder, which will be created upon export.
     */
    Path pathToUserResources = null;
    
    /**
     * Value that determines whether or not the 'book' background image will be copied to the user's resource folder.
     */
    public boolean copyBGImage = true;
    

    // IF YOU CHANGE THE NAMES OF THESE, YOU'LL HAVE TO CHANGE THE NAMES IN THE CSS AS WELL.
    
    /**
     * Name of the CSS file to copy.
     */
    static String cssName = "StandardPageStylesheet.css";
    
    /**
     * Name of the background image to copy.
     */
    static String backgroundImageName = "bgImage_fade2.png";
    
    /**
     * Class names to be used in HTML generation. If changed, the CSS file will need to be edited as well.
     */
    static String titleClass = "pageTitle", contentClass = "content";
    
    /**
     * Appended to the output folder to store the game's pages.
     */
    static String projectName; // appended to the output folder to store the game's pages.
    
    /**
     * A default image source. 
     */
    static String imgSrc = "../resources/UofE.jpg";    
        
    
    /**
     * For instantiation via NetBeans' GUI Builder
     */
    public ExportGame()
    {
        
    }
    
    /**
     * Constructor that stores the given project file.
     * 
     * @param project project file to be exported
     */
    public ExportGame(ProjectFile project)
    {
        this.project = project;
    }
    
    /**
     * Creates a folder and exports the nodes in the ProjectFile to individual HTML pages. <p>
     * Also, copies any resources needed for the game into a separate folder.
     */
    public void export()
    {
        // iterate through each node in the file, creating HTML for each one. Save all of them in a folder named after project's name.
        
        // create output folder and resource folder
        new File(outputFolder).mkdir();
        System.out.println("Made output folder at: " + outputFolder);
        
        // for user resources
        String userResourcesFolderPathString = outputFolder + "/resources";
        File userResourcesFolderPathFile = new File(userResourcesFolderPathString);
        boolean madeResourceFolder = userResourcesFolderPathFile.mkdir();
        if (madeResourceFolder)
        {
            System.out.println("Successfully made user resources folder at:" + userResourcesFolderPathString);
        }
        this.pathToUserResources = Path.of(userResourcesFolderPathFile.getAbsolutePath());  // assign variable so it can be used in other methods

        // copy images and whatnot into resource folder.
        // "Master" resource folder will be in install location. Locate stylesheet, make path to it.
        // Either that, or keep the data for the basic stylesheet as a variable or whatever somewhere within the program. Write to an actual file in the resource location.
        
        File masterStylesheetFile = new File("master_resources/" + cssName);
        System.out.println("Stylesheet file at: " + masterStylesheetFile.getAbsolutePath());
        
        // if the stylesheet is still in the master_resources folder, copy to new destination.
        if (masterStylesheetFile.exists())
                {
                    
                    System.out.println("Stylesheet does exist.");
                    // make path from master stylesheet
                    Path masterStylesheetPath = Path.of(masterStylesheetFile.getAbsolutePath());
                    System.out.println("Stylesheet path: " + masterStylesheetPath);
                    
                    // create path to new stylesheet
                    String userStylesheetPathString = userResourcesFolderPathString + "/" + cssName;
                    Path userStylesheetPath = Path.of(userStylesheetPathString);
                    
                    // try to copy master stylesheet to user's folder
                    try {
                            Files.copy(masterStylesheetPath, userStylesheetPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                    catch (IOException ex) {
                        System.out.println("There was an issue with copying the master stylesheet to the user's resource folder.");
                            Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // try to copy other required files as well
                    if(copyBGImage == true)
                    {
                        try {
                                System.out.println("Attempting to copy " + backgroundImageName + "...");
                                // get path of master BG, user BG, copy
                                Path masterBGImagePath = Path.of(new File("master_resources/" + backgroundImageName).getAbsolutePath());
                                Path userBGPath = Path.of(pathToUserResources.toString() + "/" + backgroundImageName);
                                Files.copy(masterBGImagePath, userBGPath, StandardCopyOption.REPLACE_EXISTING);

                        }
                            catch (IOException ex) {
                                System.out.println("There was an issue with copying the BG image to the user's resource folder.");
                                Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }
                }
        else
        {
            System.out.println("Master stylesheet not found at: " + masterStylesheetFile.getAbsolutePath());
        }        
               
        // for each node, process the page and write to a file.
        for (NodeRectangle n : project.getNodes())
        {
            // name of page file is based off of ID
            String filename = n.getNode().getID() + ".html";
            String HTML = processPage(n.getNode());      
            
            File page = new File(outputFolder + "/" + filename);
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
    
  /**
   * Generates HTML for a page based off of its title, paragraph, image, and links.
   * 
   * @param n the node to be processed
   * @return HTML for this node/page as a formatted String.
   * 
   * @see <a href = https://j2html.com/examples.html >J2HTML</a>
   */
    public String processPage(Node n)
    {
        String title, ID, imagePathString, paragraph;
        Map<String, Collection<String>> choices;
        
        
        // conditionals for showing/hiding elements of a page
        boolean showTitle = false, showImage = false, showParagraph = false, showChoices = false;
        
        // title
        title = n.getTitle();
        if (title != null)
        {
            showTitle = true;
        }
        
        // ID
        ID = n.getID();
        
        // image- if not null, copy to resources folder
        imagePathString = n.getImagePath();
         if (imagePathString != null)
        {
            try {
                imagePathString = copyToResources(imagePathString);
                if (imagePathString != null)
                {
                    showImage = true;
                }
            }
            catch (IOException ex) {
                System.out.println("Could not copy image to user resource folder.");
                Logger.getLogger(ExportGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // paragraph
        paragraph = n.getParagraph();
        if (paragraph != null)
        {
            showParagraph = true;
        }
        
        // choices
        choices = n.getLinks().asMap();
        if (choices != null)
        {
            showChoices = true;
        }
        
        
        
        // TODO - implement system that creates differrent HTML based on what and what should not be shown.
        // and possibly, change in stylesheet link.
        String stylesheet = "./resources/" + cssName;
        
         
        
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
                                div(
                                img().withSrc(imagePathString).withClass(iffElse(showImage, "user-image", "no-image"))
                                ),
                                        
                                // paragraph div
                                div(
                                        p(paragraph).withClass("paragraph"),
                                        
                                        // choices div
                                        div(

                                                // for each choice, make hyperlink.
                                                each(choices, choice ->
                                                        div(attrs(".choices"),
                                                                
                                                                // choice = entry. Key = URL, Value = Collection<String>.
                                                                // for each String 'text' in getValue(),
                                                                // make hyperlink(key, text)
                                                                each(choice.getValue(), text ->
                                                                        p(a(text).withHref(choice.getKey() + ".html"))
                                                                        
                                                                       ) // end of inner each loop
                                                                
                                                                ) // end of inner choices div
                                                        
                                                ) // end of outer each loop
                                                
                                        ) // end of outer choices div
                                        
                                ) // end of paragraph div
                                
                        ).withClass(contentClass) // end of body main div </div>
                
                ) // end of body tag </body>
                
        ).renderFormatted();   // end of HTML tag </html>
        
        System.out.println(HTML);
        
        
        return HTML;        
    }


    /**
     * Copies image from source to user's resource folder.
     * 
     * @param source path to image
     * @return Relative path to image in resource folder
     * @throws IOException if no folder or image found
     */
    public String copyToResources(String source) throws IOException
    {
        System.out.println("Copying image at " + source + " to user resource folder...");
        // if image exists at location, copy to resources folder and return true. Else, return false
        File img = new File(source);
        
        if (img.exists())
        {
            Path copyTo = Path.of(pathToUserResources.toString() + "/"+ img.getName());  // create path to resources/imagename.png
            
            Files.copy(Path.of(source), copyTo, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copied image to: " + copyTo);
            img = copyTo.toFile();
        }
        else
        {
            System.out.println("Image no longer exists at designated path. Image was not copied.");
            return null;
        }
        
        String relativePath = "./resources/" + img.getName();
        
        return relativePath;
    }


/**
 * Cleans the project's name, to prevent creating folders with invalid characters
 * 
 * @param projectName name of the project
 * @return altered name of project
 */
    public String cleanProjectName(String projectName)
    {             
        String cleaned = CharMatcher.breakingWhitespace().replaceFrom(projectName, '_') ;
        cleaned = CharMatcher.whitespace().trimFrom(cleaned);
        cleaned = CharMatcher.javaLetterOrDigit().or(CharMatcher.is('_')).retainFrom(cleaned);
        cleaned += " - CHOICE";
        System.out.println("Output folder name: " + cleaned);
        
        return cleaned;
    }
    
    /**
     * Sets the theme of the exported game. <p>
     * If Storybook theme, the standard CSS sheet will be used. If Dark theme, a darker, more simplistic CSS sheet will be used.
     * 
     * @param theme desired theme
     */
   public void setTheme(String theme) {
        if (theme.equalsIgnoreCase("book"))
        {
           cssName =  "StandardPageStylesheet.css";
           copyBGImage = true;
        }
        else if (theme.equalsIgnoreCase("dark"))
        {
            cssName = "DarkPageStylesheet.css";
            copyBGImage = false;
        }
        else
        {
            System.out.println("Something went wrong. The theme will be \"book\".");
            copyBGImage = true;
        }
    }
    
    
    // Getters and Setters
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

    /**
     * Unused. For testing only
     * @param args Unused.
     */
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
            String styleSheetLink = "../" + cssName;
            
    
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

        //<editor-fold defaultstate="collapsed" desc="Apr 7 Test 2">
                /*
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
      //</editor-fold>  
       */
       
        //<editor-fold defaultstate="collapsed" desc="Yet Another Test"> 
/*
        String absolutePathToResourceString = "C:/Users/rolep/Documents/Apr_13_Test - CHOICE/resources/bigfeel.png";
        String baseString = "C:/Users/rolep/Documents/Apr_13_Test - CHOICE";
        String relative = new File(baseString).toURI().relativize(new File(absolutePathToResourceString).toURI()).getPath();
        
        System.out.println("Relative using URI: " + relative);
        
        Path absPath = Paths.get("C:/Users/rolep/Documents/Apr_13_Test - CHOICE/resources/bigfeel.png");
        Path basePath = Paths.get("C:/Users/rolep/Documents/Apr_13_Test - CHOICE");
        relative = basePath.relativize(absPath).toString();
        System.out.println("Relative using Path: " + relative);
        */
        //</editor-fold>
    }
    
}
