/*                              				=== Print Characters Frequencies ===

1. in order of occurance of word 
2. without order

If we use Map interface it will directly consider the hashmap as MAP interface as hashmap, linked hashmap,Hashtable, Concurrent hasmap, treemap
within itself.

The Map contains unique key-pair values. But, the HashMap can hold duplicate values.

=== 1. In Order of Occurrence ===
https://www.geeksforgeeks.org/print-characters-frequencies-order-occurrence/

=== 2. occurrence Without order 

Only difference is how we print our result.
*/


package Hashing;
import java.util.*;

public class frequency_hashing {

    public static void Freq_Inorder(String s){

        Map<Character, Integer> hs =new HashMap<Character,Integer>();

        for(int i=0; i<s.length(); i++){

            // if the character is already present in the hashmap
            if(hs.containsKey( s.charAt(i))){
                hs.put(s.charAt(i), hs.get(s.charAt(i)) + 1); // recieve the count of value and add 1 to it
            }
            else{
                // character is not present
                hs.put( s.charAt(i), 1);
            }
        }
        // Printing In order
        System.out.print("In Order -");
        for(int j=0; j<s.length(); j++){
            // Print only if this character is not printed before

            if( hs.get(s.charAt(j)) !=0){
                System.out.print( s.charAt(j));
                System.out.print( hs.get(s.charAt(j))+ " ");

                hs.put(s.charAt(j), 0); // to avoid repetition of char
            }
        }
    }

    public static void Freq_orderless(String s){
        HashMap<Character, Integer> hs  = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            if(hs.containsKey( s.charAt(i))){
                hs.put(s.charAt(i), hs.get(s.charAt(i))+1);
            }
            else{
                hs.put( s.charAt(i), 1 );
            }
        }
        // Printing 
        for (Map.Entry entry : hs.entrySet()) {
            System.out.print(entry.getKey() +""+entry.getValue()+ " ");
        }   
        
    }
    public static void main(String[] args) {
        String s = "rahulraj";
        
        Freq_Inorder(s);
        System.out.print("\nNot in Order -");
        Freq_orderless(s);
    }
}
