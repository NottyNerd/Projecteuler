/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 *
 * @author NottyNerd
 */
public class EquityOrderMatching {
    
    private static final Pattern DOUBLE_PATTERN = Pattern.compile(
    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
    static HashMap<String,String[]> hashmap = new HashMap<>();

    static int t_s=0;
    
   static String[] processQueries(String[] queries) {
        // Write your code here.
        
        int size = queries.length;
        ArrayList<String> res = new ArrayList<>();
       
        for (int i = 0; i<size; i++) {
            String s =match(queries[i]);
           if(s != null && s.length() > 0){
            res.add(s);
           }
        }
 
        return res.toArray(new String[res.size()]);
    }


    private static final Scanner scan = new Scanner(System.in);


    public static boolean isInteger(String str) {
           if (str == null) {
               return false;
           }
           int length = str.length();
           if (length == 0) {
               return false;
           }
           int i = 0;
           if (str.charAt(0) == '-') {
                   return false;
           }
           for (; i < length; i++) {
               char c = str.charAt(i);
               if (c < '0' || c > '9') {
                   return false;
               }
           }
           return true;
    }

    public static String match(String q)
       {
           String split[]= q.split(",");
           
           switch(split[0])
           {
           case "N": 
               //<Action>, <Order ID>, <timestamp>, <symbol>, <orderType>, <side>, <price>, <quantity>
               // Validate fields then perform insert to map
               if(split.length == 8){
               String orderId = split[1];
               String timestamp = split[2];
                String symbol = split[3];
               String ordertype = split[4];
                String side = split[5];
               String price = split[6];
               String quantity = split[7];
               
               
               if(!isInteger(timestamp)||!isInteger(quantity) || !isInteger(orderId) || !(ordertype.equals("M") || ordertype.equals("L") ||ordertype.equals("I")) || !(side.equals("B")|| side.equals("S")) || !isDouble(quantity) )
               {
               return orderId + " - Reject - " + "303 - Invalid order details";
               }
    
               else
               {
                   
                   if(Long.parseLong(quantity)<1 || Long.parseLong(quantity)>Long.MAX_VALUE)
                   {
                   return orderId + Long.parseLong(quantity)+ " - Reject - " + "303 - Invalid order details";
                   }
                   if(t_s<=Integer.parseInt(timestamp))
               {
               t_s = Integer.parseInt(timestamp);
               }
               else{
                return orderId + " - Reject - " + "303 - Invalid order details";
               }
               if( !hashmap.containsKey(orderId))
                         {
                         
                         hashmap.put(orderId,split);
                         return orderId + " - Accept";
                         }
                         else
                         {
                         return orderId + " - Reject - " + "303 - Invalid order details";
                         }
               }
               
               }                              
               ;
               
            case "A": 
                if(split.length == 8){
                    String orderId = split[1];
               String timestamp = split[2];
                String symbol = split[3];
               String ordertype = split[4];
                String side = split[5];
               String price = split[6];
               String quantity = split[7];
               if(!isInteger(quantity) || !isInteger(orderId) || !(ordertype.equals("M") || ordertype.equals("L") ||ordertype.equals("I")) || !(side.equals("B")|| side.equals("S")) || !isDouble(quantity) )
               {
               return orderId + " - AmendReject - " + "303 - Invalid order details";
               }
               else
               {
                       if(t_s<Integer.parseInt(timestamp))
               {
               t_s = Integer.parseInt(timestamp);
               }
               else{
                return orderId + " - Reject - " + "303 - Invalid order details";
               }
               if( hashmap.containsKey(orderId))
                         {
                         String[] temp = hashmap.get(orderId);
                         int temp_qty =Integer.parseInt(temp[7]);
                         double temp_price =Double.parseDouble(temp[6]);
                         int new_qty =Integer.parseInt(quantity);
                          double new_price =Double.parseDouble(price);
                         if(!temp[3].equals(symbol) || !temp[4].equals(ordertype) || !temp[5].equals(side))
                         {
                            return orderId + " - AmendReject- " + "101 - Invalid amendment details";
                         }
                         if((temp_qty >= new_qty && temp_price>=new_price) || (temp_qty <= new_qty && temp_price<=new_price) ){
                         //    System.out.println(""+price);
                         hashmap.remove(orderId);
                         hashmap.put(orderId,split);
//                         System.out.println("");
                         return orderId + " - AmendAccept";
                         }
                         else
                         {
                          return orderId + " - AmendReject- " + "101 - Invalid amendment details";
                         }
                         }

                         else
                         {
                         return orderId + " - Reject - " + "404 - Order does not exist";
                         }
               }
           }
             ;
           case "M": 
               if(split.length==2)
               {
              
               String timestamp = split[1];
               //check constraint
                LinkedHashMap<String,String> linkedhashmap = new LinkedHashMap<>();
                   for (Map.Entry<String, String[]> entry : hashmap.entrySet()) {
                       
                       String key = entry.getKey();
                       String[] value = entry.getValue();
                  
                       //System.out.println(" kkk"+value[3]+"#"+value[5]+"#"+value[1] 
                       //+"$$"+value[0] +"%%" +value[6]);
                       if("N".equals(value[0]) || "A".equals(value[0]))
                       {
                       
                           if(!linkedhashmap.containsKey(value[3]+"#"+value[5]+"#"+value[1])){
                               if(value[5].equals("B")){
                       linkedhashmap.put(value[3]+"#"+value[5]+"#"+value[1],value[1]+","+value[4]+","+value[7]+","+value[6]);
                               }
                              if(value[5].equals("S"))
                               {
                      linkedhashmap.put(value[3]+"#"+value[5]+"#"+value[1],value[6]+","+value[7]+","+value[4]+","+value[1]);
                          }
                           }
                           else
                           {
                           //do nothing
                           }
                       }
                   }
                   
                   String previousSide="";
                   String startAppending="";
                   String ress="";
                   String previousKey="";
                   Map<String, String> treeMap = new TreeMap<>(linkedhashmap);
//                   System.out.println("lsssshm "+treeMap.size());
//                   System.out.println("hshm "+treeMap.toString());
               for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                   String key = entry.getKey();
                   String value = entry.getValue();
                   String xx = key.split("#")[0];
                   if(previousSide.isEmpty() && startAppending.isEmpty()){
                       previousSide = key.split("#")[1];
                       startAppending = xx+"|"+value;
                       previousKey = xx;
                       
                   }
                   if(previousKey.equals(xx)){
                   if( (!previousSide.equals(key.split("#")[1]) && previousSide.equals("B")) && (Double.parseDouble(startAppending.split(",")[3])>=Double.parseDouble(value.split(",")[0])))
                   {
                         System.out.println(""+(Double.parseDouble(startAppending.split(",")[3])>=Double.parseDouble(value.split(",")[0])));

                       ress += startAppending + "|"+value +"\n";
                   }
                   else if(previousSide.equals("S") &&!previousSide.equals(key.split("#")[1]) )
                   {
                       startAppending = xx+"|"+value;
                   }
                   }
                   else{
                   startAppending = xx+"|"+value;
                       previousKey = xx;
                   }
                   
               }
               return ress.trim();
               }
               else if (split.length==3)
               {
               String timestamp = split[1];
               String symbol = split[2];
               
               LinkedHashMap<String,String> linkedhashmap = new LinkedHashMap<>();
                   for (Map.Entry<String, String[]> entry : hashmap.entrySet()) {
                       
                       String key = entry.getKey();
                       String[] value = entry.getValue();
                  
                       //System.out.println(" kkk"+value[3]+"#"+value[5]+"#"+value[1] 
                       //+"$$"+value[0] +"%%" +value[6]);
                       if("N".equals(value[0]) || "A".equals(value[0]))
                       {
                       
                           if(!linkedhashmap.containsKey(value[3]+"#"+value[5]+"#"+value[1])){
                               if(value[5].equals("B")){
                       linkedhashmap.put(value[3]+"#"+value[5]+"#"+value[1],value[1]+","+value[4]+","+value[7]+","+value[6]);
                               }
                              if(value[5].equals("S"))
                               {
                      linkedhashmap.put(value[3]+"#"+value[5]+"#"+value[1],value[6]+","+value[7]+","+value[4]+","+value[1]);
                          }
                           }
                           else
                           {
                           //do nothing
                           }
                       }
                   }
                   
                   String previousSide="";
                   String startAppending="";
                   String ress="";
                   String previousKey=symbol;
                   Map<String, String> treeMap = new TreeMap<>(linkedhashmap);
//                   System.out.println("lsssshm "+treeMap.size());
//                   System.out.println("hshm "+treeMap.toString());
               for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                   String key = entry.getKey();
                   String value = entry.getValue();
                   String xx = key.split("#")[0];
                   if(xx.equals(symbol)){
                   if(previousSide.isEmpty() && startAppending.isEmpty()){
                       previousSide = key.split("#")[1];
                       startAppending = xx+"|"+value;
                       previousKey = xx;
                       
                   }
                   if(previousKey.equals(xx)){
                   if( (!previousSide.equals(key.split("#")[1]) && previousSide.equals("B")) && (Double.parseDouble(startAppending.split(",")[3])>=Double.parseDouble(value.split(",")[0])))
                   {
                       System.out.println(""+(Double.parseDouble(startAppending.split(",")[3])>=Double.parseDouble(value.split(",")[0])));
                       ress += startAppending + "|"+value +"\n";
                   }
                   else if((previousSide.equals("S") &&!previousSide.equals(key.split("#")[1])))
                   {
                       startAppending = xx+"|"+value;
                   }
                   }
                   
//                           10
//N,1,0000001,AB,L,B,104.53,100
//N,2,0000002,AB,L,S,105.53,100
//N,3,0000003,AB,L,B,104.53,90
//M,0000004
//N,4,0000005,AB,L,S,104.43,80
//A,2,0000006,AB,L,S,104.42,100
//M,0000008
//N,5,0000009,AB,L,S,105.53,120
//X,3,0000010
//N,6,0000011,XYZ,L,B,1214.82,2
               }
               }
               return ress.trim();
               }
               
               ;
           case "Q": 
               
               ;
         
           case "X": 
               if(split.length ==3)
               {
               String orderId = split[1];
               String timestamp = split[2].trim();
               if(t_s<Integer.parseInt(timestamp))
               {
               t_s = Integer.parseInt(timestamp);
               }
               else{
                return orderId + " - Reject - " + "303 - Invalid order details";
               }
              if( hashmap.containsKey(orderId))
              {
                  String[] temp = hashmap.get(orderId);
                  if(temp[0].equals("M") || temp[0].equals("X"))
                  {
                         return orderId + " - CancelReject - " + "404 - Order does not exist";
                         }
                  else{
                      hashmap.replace(orderId, temp);
                     return orderId + " - CancelAccept";
                  }
              }
              else
                         {
                         return orderId + " - CancelReject - " + "404 - Order does not exist";
                         }
              
               }
               ;
           }
       return "";
       }

    private static boolean isDouble(String quantity) {
       return  DOUBLE_PATTERN.matcher(quantity).matches();
       //To change body of generated methods, choose Tools | Templates.
    }
    
    
        public static void main(String[] args) throws IOException {
       

        int queriesSize = Integer.parseInt(scan.nextLine().trim());

        String[] queries = new String[queriesSize];

        for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
            String queriesItem = scan.nextLine();
            queries[queriesItr] = queriesItem;

        }

        String[] response = processQueries(queries);

        for (int responseItr = 0; responseItr < response.length; responseItr++) {
            

            System.out.println(response[responseItr]);
        }

        
    }

        





        

        
//7
//N,1,0000001,ALN,L,B,60.90,100
//N,11,0000002,XYZ,L,B,60.90,200
//N,110,0000003,XYZ,L,S,60.90,100
//N,112,0000003,XYZ,L,S,60.90,120
//N,10,0000006,ALN,L,S,60.90,100
//M,00010
//M,00010,ALN
}
