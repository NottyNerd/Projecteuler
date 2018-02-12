/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author NottyNerd
 */
public class RepeatedCharacters {
    //Given a string - "str", find the repeated character present first in the string.
    	public static void main (String[] args) throws Exception {
		Scanner  sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for(int times = 0; times < N; times++) {
                     String sentence = reader.readLine();
                     int sentence_length = sentence.length();
                     char[] charArray = sentence.toCharArray();
                     int i=0;
                     StringBuilder result = new StringBuilder();
                     HashMap<Character,Integer> hashmap = new HashMap<>();
                     for (Character charat: charArray) {
                         if(hashmap.containsKey(charat))
                         {
                         
                         hashmap.put(charat,hashmap.get(charat)+1);
                         
                         }
                         else
                         {
                         hashmap.put(charat,1);
                         }
                       
                    }
                     
                     for(; i<sentence_length; i++)
                     {
                         if(hashmap.get(charArray[i])>1)
                         {
                          System.out.println(charArray[i]);
                          break;
                         }
                        if(i == (sentence_length-1) )
                         {
                          System.out.println("-1");
                         }
                     }
		    }
		}
    
}
