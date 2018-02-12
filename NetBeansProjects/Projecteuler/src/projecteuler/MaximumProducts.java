/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author NottyNerd
 */
public class MaximumProducts {
    

	public static void main (String[] args) throws Exception {
		Scanner  sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = 1;
                        //Integer.parseInt(reader.readLine());
		for(int times = 0; times < N; times++) {

            
		    int n = Integer.parseInt(reader.readLine());
		    int[] a = stringArrToIntArr(reader.readLine().split(" "));
		    long k = Long.parseLong(reader.readLine());
		    long sum = 0;
	        long count = 0;
	        int j = 0;
                  System.out.println("count: "+buyMaximumProducts(n, k, a)); 
                  /*
		for(int i = 1; i < n+1; i++) {
		         sum += i * a[i-1];	
                         count += i;    
                while (sum > k) {
                    sum -= a[i-1];
                    count--;
                }
                System.out.println("sum: "+sum); 
                if (sum < k) {
                   System.out.println(" less than k sum: "+sum);   
                }
                System.out.println("count: "+count);
		    }
                */
                 
		    
		//    System.out.println(count);
		    }
		}
        
        
        
          public static int[] stringArrToIntArr(String[] s) {
           int[] result = new int[s.length];
           for (int i = 0; i < s.length; i++) {
              result[i] = Integer.parseInt(s[i]);
           }
           return result;
        }
          
          
           static long buyMaximumProducts(int n, long k, int[] a) {
               
               //
               
               HashMap<Integer,Integer> hashmap = new HashMap<>();
                long count = 0;
                long wanBuy = 0;
                long sum = 0;
                long lastkey=k;
                 for (int i = 1; i < a.length+1; i++) {
                        hashmap.put( i,a[i-1]);
                    }
                 
                 
                 
                 Map<Integer, Integer> treeMap = sortByComparator(hashmap, true);
//                System.out.println("sum: "+treeMap); 
//                System.out.println("sum: "+treeMap.get(74)); 
                for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                   Integer uprice = entry.getValue();
                   Integer numstock = entry.getKey();
                   if(sum==0 && uprice>lastkey)
                    {
                        break;
                    }
                   if(lastkey>0){
                   sum = numstock * uprice;	
                         wanBuy = numstock;  
                
                while (sum > lastkey) {
                    wanBuy--;
                     sum =wanBuy* uprice;
                }
              lastkey -= wanBuy* uprice;
              count += wanBuy;
                   }
                   else
                   {
                   break;
                   }
                   
               }
               return count;
           }
           
           private static Map<Integer, Integer> sortByComparator(Map<Integer, Integer> unsortMap, final boolean order)
    {

        List<Entry<Integer, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, (Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) -> {
            if (order)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
            else
            {
                return o2.getValue().compareTo(o1.getValue());
                
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        list.stream().forEach((entry) -> {
            sortedMap.put(entry.getKey(), entry.getValue());
            });

        return sortedMap;
    }


}

