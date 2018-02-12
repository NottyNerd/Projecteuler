/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author NottyNerd
 */

 public abstract class Node{
     private Node[] children;
 public Node(Node[] chiNodes)
 {
 this.children = chiNodes;
 }
 public int getNumChildren()
 {
 return children.length;
 }
 public Node getChild(int index)
 {
 return children[index];
 }
}
