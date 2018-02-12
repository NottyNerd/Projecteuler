/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author NottyNerd
 * 
 * 
 * Given a sequence of strings, the task is to find out the second most repeated (or frequent) 
 * string in the given sequence.
Note: No two strings are the second most repeated, there will be always a single string.
 */
public class SecondMostRepeatedString {

        public static void main (String[] args) throws Exception {
		Scanner  sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for(int times = 0; times < N; times++) {
                    int kk = Integer.parseInt(reader.readLine());
                     String[] sentence = reader.readLine().split(" ");
                     int sentence_length = kk;
                     int i=0;
                     int max=0; 
                     StringBuilder result = new StringBuilder();
                     HashMap<String,Integer> hashmap = new HashMap<>();
                     for (String charat: sentence) {
                         if(hashmap.containsKey(charat))
                         {
                         
                         hashmap.put(charat,hashmap.get(charat)+1);
                         
                         }
                         else
                         {
                         hashmap.put(charat,1);
                         }
                       
                    }
                     
                     List<Integer> values = new ArrayList<Integer>(hashmap.values());
                     Collections.sort(values);
                     if(values.size()>2){
                     max = values.get(values.size()-2);
                     }
                     else
                     {
                     max = values.get(0);
                     }
                     
                     System.out.println(max);
                     
                     for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        if(value == max)
                         {
                          System.out.println(key);
                          break;
                         }
                    }
                     
               
		    }
		}
    
}
