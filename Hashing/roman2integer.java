/*                               === Roman to Integer ===

https://leetcode.com/problems/roman-to-integer/

Make Hashmap of the charcters to numerical value.
Then we will start converting from the back of string as it is hangle to values like IV and IX or XC. 
Hence assign ans to last character. Then start from 2nd last character and in the if statement check 
if the i+1 > i because of condition IV and if it is true subtract the value of i from ans else add it.

If you start calculating from the start first you will have problem in handling 2 char long string 
and then you will have to handle the condition IX,IV and in the end it will give a calculation error 
of 6 or 10 value

*/
package Hashing;
import java.util.*;

public class roman2integer {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int ans = Convert(s);

        System.out.println(ans);
    }

    public static int Convert(String s){
        Map<Character,Integer> arr=new HashMap<>();
        arr.put('I',1);
        arr.put('V',5);
        arr.put('X',10);
        arr.put('L',50);
        arr.put('C',100);
        arr.put('D',500);
        arr.put('M',1000);

        int n = s.length();
        int ans = arr.get(s.charAt(n-1));
        
        if(n==1){
            return ans;
        }
        
        for(int i=n-2;i>=0;i--){           
            int v1= arr.get(s.charAt(i));
            int v2=arr.get(s.charAt(i+1));
            
            if(v1<v2){
                ans = ans-v1;
            }
            else{
                ans=ans+v1;
            }  
        }
           
        return ans;
    }
}


