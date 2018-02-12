/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

/**
 *
 * @author NottyNerd
 */

import java.util.*;
import java.lang.*;
import java.io.*;
class CountSubArrays
 {
	public static void main (String[] args) throws Exception {
		Scanner  sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for(int times = 0; times < N; times++) {

            String[] nk = reader.readLine().split(" ");
		    int n = Integer.parseInt(nk[0]);
		    long k = Long.parseLong(nk[1]);
		    
		    String[] a = reader.readLine().split(" ");
		    
		    long prod = 1;
	        int count = 0;
	        int j = 0;
		    for(int i = 0; i < n; i++) {
		         prod *= Integer.parseInt(a[i]);	        
                while (j<=i && prod > k) {
                    prod /= Integer.parseInt(a[j++]);
                }
               // System.out.println("prod: "+prod);
               // System.out.println("j: "+j);
                if (prod < k) {
                    count += 1 + (i -j);
                }
              //  System.out.println("count: "+count);
		    }
		    
		    System.out.println(count);
		    }
		}
}

