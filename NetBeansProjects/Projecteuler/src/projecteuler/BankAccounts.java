/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;
    import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 *
 * @author NottyNerd
 */
public class BankAccounts {

    static String[] res={"upfront","fee"};
    static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
        // Complete this function
        //max(k,x of p) or d
        String val="";
        double sumcharges=0.0;
        for(int i=0;i<n;i++)
        {
            double charges = Math.max(k, 0.01 * x * p[i]);
            sumcharges +=charges;
        }
       
          if(sumcharges>d)
            {
               val = res[0];
            }
            else{
                val = res[1];
            }
         return val;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            int[] p = new int[n];
            for(int p_i = 0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }
}



