//                           === Permutation using Recursion ===

package Recursion;
import java.util.ArrayList;

public class Permutation_Recursion {
    public static void main(String[] args) {

        ArrayList<String> Ans = permutation("", "abc");
        
        System.out.println(Ans); 
    }
    static ArrayList<String> permutation(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {    
           // number of calls will be size of processed array + 1
           String f = p.substring(0, i); 
           String s = p.substring(i, p.length());  
           // 2nd argument is exclusive and not inclusive 
           
           ans.addAll( permutation(f + ch + s, up.substring(1)) );
        }
        return ans;
    }
}
