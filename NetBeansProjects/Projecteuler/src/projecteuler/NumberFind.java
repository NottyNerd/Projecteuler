/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author NottyNerd
 */
public class NumberFind {
    
    public static void main (String[] args) {
		//code
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
		for (int i = 0; i < n; i++) {
                    
            int arg = s.nextInt();
            
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int k=0; k< arg; k++){
                int ix = s.nextInt();
                
                String x = ""+ix;
                   if( (!x.contains("1") && !x.contains("2"))&&!x.contains("3"))
                   {
                       temp.add(ix);
                   }
                   else
                   {
                       arr.add(ix);
                   }
                }
          
            
            if(!temp.isEmpty() && !arr.isEmpty()){
                Collections.sort(arr);
                
                int[] jj ={1,2,4};
                Arrays.copyOfRange(jj, 0, i);
                String xcx="";
                for (int j = 0; j < arr.size(); j++) {
                    String get =""+ arr.get(j);
                    xcx += " "+get;
                    
                }
                 System.out.println(arr.toString().replace("[", "").replace("]", "").replaceAll(",", " "));
            }
            else
            {
            System.out.println("-1");
            }
	}
}
}