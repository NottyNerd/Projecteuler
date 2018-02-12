/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import org.w3c.dom.Node;



/**
 *
 * @author NottyNerd
 */

public class EtranzactTest {
    
    public static int treeHeight(Node n)
    {
        
        if (n== null)
     return 0; 
        return 1 + Math.max(treeHeight(n.getFirstChild()), treeHeight(n.getLastChild()));
    }
  
    public static void main(String[] args)
    {
    System.out.print(""+ treeHeight(null));
    }
    
}

 
 
