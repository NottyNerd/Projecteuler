/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

    import java.util.Scanner;
/**
 *
 * @author NottyNerd
 */
public class BruteForceClass {
   
    

    public static void main(String[] args){
     
        String result="";
    Scanner user_input = new Scanner (System.in);
    String ciphertext;
    
    // receive cipher text input
    
    System.out.print("Enter cipher text: ");
    ciphertext = user_input.nextLine();
    
    // print out cipher text input
    System.out.println("Ciphertext is "+ciphertext);
    
    // next request the key to be used in the decryption scheme
    System.out.print("Enter the key to be used: ");
    
    //find a way to get ur shifter value
    //hint use your scanner
    int shifter =3;
    
          char charArray[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
   
          //abc24 + 3 -25
          for(int i=0;i<ciphertext.length();i++)
          {
          char characterToBeManipulated = ciphertext.toCharArray()[i];
          for(int j=0;j<charArray.length;j++)
          {
          if (charArray[j]== characterToBeManipulated)
          {
          //add shifter to the index of characterToBeManipulated's index and record new value
              int kk = j+shifter;
             
              if(kk>charArray.length-1)
              {
              result =result+ charArray[kk-charArray.length+1];
              }
              else
              {
                result =result+ charArray[kk];
              }
               
          }
          }
          
          }
          System.out.println("Resulting cipher text: " + result);
   
    }

}
