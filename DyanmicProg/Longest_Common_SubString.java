/*                          === Longest Common SubString ===

https://youtu.be/HrybPYpOvz0
https://www.geeksforgeeks.org/longest-common-substring-dp-29/

Longest Common Substring(Dynamic Programming)
Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
Examples:

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
The longest common substring is “Geeks” and is of length 5.

substring means continuous length. So when ever we find the diff character we make count equal to 0
*/


package DynamicProg;

public class Longest_Common_SubString {

    public static void LCSubStr(String s1, String s2){

        int n1=s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        int count = 0;
        
        // Initialization will be if i==0 or j==0 we have 0 common characters

        for (int i = 0; i < n1+1; i++) {
            for (int j = 0; j < n2+1; j++) {
                if( i==0 || j==0)
                    dp[i][j] = 0;

                else if ( s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;

                    count = Math.max(count, dp[i][j]);
                }    
                else 
                    dp[i][j] = 0;    
            }
        }
        System.out.println( count );
    }
    public static void main(String[] args) {
        String s1 = "GeeksforGeeks";
        String s2 = "GeeksQuiz";

        LCSubStr(s1,s2);
    }
}
