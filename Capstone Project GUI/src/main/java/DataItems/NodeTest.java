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
            System.out.println(nodeArray.get(0).toString());
        }
        else
        {
            System.out.println("Oh. Okay.");
        }
        
        
    }
    
}
