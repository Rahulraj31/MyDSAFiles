/*                   === Find Unique Number in Array where Every element occure twice except One === 

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Apply XOR in all the array. Duplicates will give 0 and non duplicates will give 1, 
Order doesn't matter as in the end duplicates will give 1 . Time Complexity O(N)

https://leetcode.com/problems/single-number/

*/

package BITWISE;

public class Find_Unique_inArray2 {
    public static void main(String[] args) {
        
        int[] arr = {2,3,4,2,3,6,4}; // 6 is unique 
       // int[] arr = {2,2,3,1,1}; can be used for odd occurance of a element where rest are appearing in even numbers
        System.err.println(unique_element(arr));
        
    }

    static int unique_element(int[] arr){

        int unique=0;

        for (int n:arr){
            unique^=n;
        }
        return unique;
    }
}
