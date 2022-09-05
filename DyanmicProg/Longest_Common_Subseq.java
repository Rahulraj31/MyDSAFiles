/*                          === Longest Common Subsequence ===

https://youtu.be/hR3s9rGlMTU
https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 

For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.

This is Bottom Up - Tabulated Method

Top Down - Recursive -Memoization in the end 
*/

package DynamicProg;
public class Longest_Common_Subseq {

    public static void LCSubseq(String s1, String s2){

        int n1=s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        
        // Initialization will be if i==0 or j==0 we have 0 common characters

        for (int i = 0; i < n1+1; i++) {
            for (int j = 0; j < n2+1; j++) {
                if( i==0 || j==0)
                    dp[i][j] = 0;

                else if ( s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                
                else 
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1]);    
            }
        }
        System.out.println( dp[n1][n2]);
    }
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        LCSubseq(s1,s2);
    }
}


/*
static int lcs(String X,String Y,int m,int n,int[][] dp){
 
    if (m == 0 || n == 0)
      return 0;
 
    if (dp[m][n] != -1)
      return dp[m][n];
 
    if(X.charAt(m - 1) == Y.charAt(n - 1)){
      dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
      return dp[m][n];
    }
 
    dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp),lcs(X, Y, m - 1, n, dp));
    return dp[m][n];
  }

public static void main(String args[]){
 
    String X = "AGGTAB";
    String Y = "GXTXAYB";
 
    int m = X.length();
    int n = Y.length();
    int[][] dp = new int[m + 1][n + 1];

    for(int i=0;i<m + 1;i++){
      for(int j=0;j<n + 1;j++){
        dp[i][j] = -1;
      }
    }
 
    System.out.println(lcs(X, Y, m, n, dp));
 
  }
}

*/
