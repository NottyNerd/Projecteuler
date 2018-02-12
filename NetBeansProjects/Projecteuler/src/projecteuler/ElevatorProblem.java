/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NottyNerd
 */
public class ElevatorProblem {
    
    static ArrayList<Integer> floors = new ArrayList<>(12);
    static ArrayList<Integer> upfloor = new ArrayList<>(8);
    static ArrayList<Integer> downfloor = new ArrayList<>(5);
    
    
    public static void main(String[] args) {
        
        for (int i = 1; i < 13; i++) {
            floors.add(i);
        }
        
        upfloor = new ElevatorProblem().generateUpArray(floors);
        downfloor = new ElevatorProblem().generateDownArray(floors);
        Collections.sort(floors);
         System.out.println("Floors: " + floors.toString());
          System.out.println("####");
         System.out.println("Up Floors: " +upfloor.toString());
          System.out.println("####");
          System.out.println("Down Floors: " +downfloor.toString());
          
         System.out.println(" Sorting ####");
         System.out.println("Ascending Up Floors: " +new ElevatorProblem().sortAscending(upfloor).toString());
          System.out.println("####");
          System.out.println("Descending Down Floors: " +new ElevatorProblem().sortDescending(downfloor).toString());
    }
    
     ArrayList<Integer> generateUpArray(ArrayList<Integer> arr)
    {
        Collections.shuffle(arr);
        ArrayList<Integer> uf = new ArrayList<>(8);
    
        for (int i = 0; i < 8; i++) {
            uf.add(arr.get(i));
        }
      return uf;
    }
    
     ArrayList<Integer> generateDownArray(ArrayList<Integer> arr)
    {
        Collections.shuffle(arr);
     ArrayList<Integer> df = new ArrayList<>(5);
        for (int i = 11; i > 6; i--) {
            df.add(arr.get(i));
        }
        return df;
    }
     
     ArrayList<Integer> sortAscending(ArrayList<Integer> arr)
     {
       Collections.sort(arr);
      return arr;
     }
     
      ArrayList<Integer> sortDescending(ArrayList<Integer> arr)
     {
       Collections.sort(arr, Collections.reverseOrder());
      // Collections.sort(arr);
     //  Collections.reverse(arr);
      
      return arr;
      
      
     }
}
