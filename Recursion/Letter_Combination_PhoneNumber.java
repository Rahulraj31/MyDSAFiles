/*                  ===Letter Combination of PhoneNumber==
Google Question 
video link- https://www.youtube.com/watch?v=9ByWqPzfXDU&list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&index=9
leet code-  https://leetcode.com/problems/letter-combinations-of-a-phone-number/

As in the leetcode Question; abc maps from digit 2 
the range would be [ (digit-2)*3 , (digit-1)*3 )       (digit-1)*3 being excluded

if abc maps from digit 1 
the range would be [ (digit-1)*3 , digit*3 )       digit*3 being excluded


*/
package Recursion;
public class Letter_Combination_PhoneNumber {

    public static void main(String[] args) {
        pad("","12");
    }

    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0)-'0'; // this will convert '2' to 2

        for(int i=(digit-1)*3; i<digit*3; i++){

            char ch = (char)('a'+ i);    // char to add
            pad(p+ ch, up.substring(1));
        }
    }
}