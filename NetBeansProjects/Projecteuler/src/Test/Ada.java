/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

    import java.util.Scanner;
/**
import scanner to receive input
 */
class Ada {

   /**
    First declare variable and request input from user.
     */
    public static void main(String[] args) {
        String result="";
        Scanner user_input = new Scanner (System.in);
        String cipher_input; //character string without paragraphs.
        System.out.println("Type in the text to be parsed: ");
        cipher_input = user_input.nextLine();
        cipher_input = cipher_input.toLowerCase();
        
        String texttentative = "";
        
        char charArray[] = {'p','e','l','z','s','y','d','t','c','o','w','f','h','x','n','r','q','j','a','m','g','v','i','u','b','k'};
        char charArray3[] = {'e','t','a','o','i','n','s','h','r','d','l','c','u','m','w','f','g','y','p','b','v','k','j','x','q','z'};
         System.out.println("array 1: "+charArray.length);
           System.out.println("array 2: "+charArray3.length);
         //O(n**2)
        for(int i=0;i<cipher_input.length();i++){
         char cipherchar = cipher_input.toCharArray()[i];
         //first u check in CHARARRAY
         for(int j=0;j<charArray.length;j++){
             if(charArray[j]==cipherchar){
                 result = result+charArray3[j];
             }   
         }
        }
        System.out.println("The tentative plaintext is:"+result);
        
       
        
      }    
        
            
    }
