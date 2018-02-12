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
public class Projecteuler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Double doub = Double.parseDouble("2.00");
          System.out.print(doub);
         System.out.print(Integer.parseInt(""+doub.intValue())); 
    //    new Projecteuler().naturalNumbers(1000);
    }
    
    public void naturalNumbers(int number){

        int sum = 0;
        for(int i = 1; i< number;i++)
        {
            if(i%3 ==0 && i%5!=0){
             sum+=i;
            }
            if(i%5 ==0){
            sum+=i;
            }
        }
        System.out.print(sum);
        
    }
    
}
