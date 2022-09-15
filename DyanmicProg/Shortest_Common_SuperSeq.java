/*                              === Shortest Common SuperSequence ===

Related to LCS

https://youtu.be/823Grn4_dCQ
https://www.geeksforgeeks.org/shortest-common-supersequence/


Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2 as subsequences.

Input:   str1 = "geek",  str2 = "eke"
Output: 5
Explanation: 
String "geeke" has both string "geek" 
and "eke" as subsequences.

Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
Output:  9
Explanation: 
String "AGXGTXAYB" has both string 
"AGGTAB" and "GXTXAYB" as subsequences.

---------------------
We need to find a string that has both strings as subsequences and is shortest such string. If both strings have all characters different, then result is sum of 
lengths of two given strings. If there are common characters, then we don’t want them multiple times as the task is to minimize length. Therefore, we first find 
the longest common subsequence, take one occurrence of this subsequence and add extra characters. 

Length of the shortest supersequence  = (Sum of lengths of given two strings) - (Length of LCS of two given strings) 
*/


package DynamicProg;

public class Shortest_Common_SuperSeq {
    
    static int superseq( String x, String y){

        int n = x.length();
        int m = y.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if( i==0 || j==0)
                    dp[i][j] = 0;

                else if ( x.charAt(i-1) == y.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                
                else 
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1]);
            }
        }
        return n + m - dp[n][m];
    }

    public static void main(String[] args) {
        String x = "AGGTB";
        String y = "GXTXAYB";

        System.out.println( superseq( x, y) );
    }
}
