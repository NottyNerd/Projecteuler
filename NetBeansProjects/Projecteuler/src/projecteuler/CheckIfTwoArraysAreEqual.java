/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author NottyNerd
 * 
 * Given two arrays of equal length, the task is to find if given arrays are equal or not. 
 * Two arrays are said to be equal if both of them contain same set of elements, arrangements 
 * (or permutation) of elements may be different though.


 * 
2
5
1 2 5 4 0
2 4 5 0 1
3
1 2 5
2 4 15
 */
public class CheckIfTwoArraysAreEqual {
    
   
            public static void main (String[] args) throws Exception {
		Scanner  sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for(int times = 0; times < N; times++) {
                    int kk = Integer.parseInt(reader.readLine());
                     int[] firstArray = stringArrToIntArr(reader.readLine().split(" "));
                     int[] secondArray = stringArrToIntArr(reader.readLine().split(" "));
                     Arrays.sort(firstArray);
                     Arrays.sort(secondArray);
                     if(Arrays.equals(firstArray, secondArray))
                     {
                         System.out.println("1");
                     }
                     else{
                         System.out.println("0");
                     }
                     
                }
            }
            
          public static int[] stringArrToIntArr(String[] s) {
           int[] result = new int[s.length];
           for (int i = 0; i < s.length; i++) {
              result[i] = Integer.parseInt(s[i]);
           }
           return result;
        }
}
