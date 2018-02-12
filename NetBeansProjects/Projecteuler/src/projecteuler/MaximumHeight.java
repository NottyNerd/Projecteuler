/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author NottyNerd
 */
public class MaximumHeight {

    public static void main(String[] args) {
//        int[] arr = {79358759};
//
//        for (int i = 0; i < arr.length; i++) {
//            int arg = arr[i];
//            System.out.println("" + Math.sqrt(2 * arg));
//            int res = ((int) (Math.sqrt(8 * arg + 1)) - 1) / 2;
//            System.out.println(res);
//        }
//        
        
        System.out.print(runEncodingLength("1111GGGGGGrrrrrrttt"));
    }

    public static int countPairs(int k, int[] a) {

        int size = a.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (hashMap.containsKey(a[i])) {
                int c = hashMap.get(a[i]);
                hashMap.put(a[i], c + 1);
            } else {
                hashMap.put(a[i], 1);
            }
        }
        int twiceCount = 0;

        for (int i = 0; i < size; i++) {
            if (hashMap.get(k - a[i]) != null) {
                twiceCount += hashMap.get(k - a[i]);
                if (k - a[i] == a[i]) {
                    twiceCount--;
                }
            }
        }

        return twiceCount / 2;

    }

    public static String runEncodingLength(String input) {

       char[] charArray = input.toCharArray();
       
       StringBuilder res = new StringBuilder();
            LinkedHashMap<Character,Integer> hashmap = new LinkedHashMap<>();
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

           for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            res.append(value).append(key);
           }
           return new String(res);
    }
}
