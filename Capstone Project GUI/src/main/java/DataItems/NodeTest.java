/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataItems;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Victor Malone (vm19171)
 */
public class NodeTest {
      
    
    // arraylist of nodes
    static ArrayList nodeArray = new ArrayList<Node>();
    
    public static void main(String[] args)
    {

        
        // scanner for user input
        Scanner userInput = new Scanner(System.in);
        
        
        System.out.println("Please enter the new node's title:");
        String nodeTitle = userInput.nextLine();
        
        System.out.println("Please enter the new node's paragraph:");
        String nodeParagraph = userInput.nextLine();
        
        
        
        Node newNode = new Node(nodeTitle, nodeParagraph);
        
         System.out.println("Would you like to print the node's information and store it in the NodeArray?");
        if (userInput.nextLine().compareToIgnoreCase("yes") == 0)
        {
            nodeArray.add(newNode);
            System.out.println(newNode);
        }
        else
        {
            System.out.println("Oh. Okay.");
        }
        
        
    }
    
}
