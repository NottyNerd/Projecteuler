/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.util.*;
import java.lang.*;
import java.io.*;
/**
 *
 * @author NottyNerd
 */
public class MergeWords {
    



	public static void main (String[] args) throws Exception {
		Scanner  sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for(int times = 0; times < N; times++) {
                String[] sentence = reader.readLine().split(" ");
		    String n = sentence[0];
		    String k = sentence[1];
                   StringBuilder result = new StringBuilder();
                    
                    int i =0;
		    int nlength = n.length();
		    int klength = k.length();
		    for(; i<nlength; ++i )
                    {
                        
                        result.append(n.charAt(i));
                        
                        if(i < klength){
                        result.append(k.charAt(i));
                                    }
                    }
                    
                    if(i < klength){
                        for(; i<klength; ++i){           
                            result.append(k.charAt(i));
                        }
                    }
                    System.out.println(result);
		    }
		}
        
        
}