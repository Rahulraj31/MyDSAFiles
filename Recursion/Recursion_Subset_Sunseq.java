/*               === Subset Subsequence === 

1. used when we need permuatation and combination
2. need subset (may/may not be adjacent) but  order does not change coz not permutation
3. Subset is for array and subseq for String 

p - processed string(ouput) up- unprocessed string (input)
*/

package Recursion;
import java.util.*;

public class Recursion_Subset_Sunseq {
    public static void main(String[] args) {
        ArrayList<String> ans =subseq("", "abc");

        System.out.println(ans);
    } 

    static ArrayList<String> subseq(String p, String up){
        
        if(up.isEmpty()){
            ArrayList<String> Ans = new ArrayList<>();
            Ans.add(p);
            return Ans;
        }
        char ch = up.charAt(0);

        // now we can either add it or ignore it 
        ArrayList<String> left= subseq(p+ch, up.substring(1));  // add
        ArrayList<String> right= subseq(p, up.substring(1));     // ignore
        
        left.addAll(right);
        return left ;  
        // return any coz both left right would be same after addAll
    }
}