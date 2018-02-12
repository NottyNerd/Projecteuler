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
public class Hackerrank {
    
    public static void main(String[] args) {
        System.out.print(reverseString("Hello world"));
    }
    
      public static String reverseString(String stringToReverse){
          String res = "";
          String[] pp = stringToReverse.split(" ");
          int l = pp.length;
          
          for (String word : pp) {
                int size = word.length();
                char[] stringToReverseCharArray = word.toCharArray();
                char[] reversedStringCharArray = new char[size];
                for (int i = 0; i < size; i++) {
                    reversedStringCharArray[i] = stringToReverseCharArray[(size-1) - i]; 
                }
                res += new String( reversedStringCharArray) +" ";
          }
          
       

        return res.trim();
    }
      
      public static long getNumberOfPossibleWaysMath(int n) {
            if (n <= 0) return 0;
            if (n <= 2) return n;
            if (n == 3) return 4;

                long minus3 = 1;
                long minus2 = 2;
                long minus1 = 4;
                long curr = 0;
            for(int i = 4; i <= n; i++) {
                curr = minus3 + minus2 + minus1;
                minus3 = minus2;
                minus2 = minus1;
                minus1 = curr;
            }
              return curr;
}
}
