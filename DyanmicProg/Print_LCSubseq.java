/*          === Printing Longest Common Sub-Sequence ===
 
https://www.geeksforgeeks.org/printing-longest-common-subsequence/
https://youtu.be/x5hQvnUcjiM

Given two sequences, print the longest subsequence present in both of them.

Examples: 

LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3. 
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

First  we make the DP matrix of LCS and then we start from the bottom most part of
the matrix if at that index the characters are equal we add that to our string and if not 
then we check if  dp(i-1, j) or dp(i, j-1) is greater, if former is greater then do i-- else do j--
and then we will be getting a string which is reversed of what we need to we will return the string
after reversing  

*/

package DynamicProg;

public class Print_LCSubseq {

    static void print_lcs(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1+1][n2+1];

        //now as we know arrays are passed by reference so we pass it into void func where we will fill the LCS matrix
        lcs( s1, s2, dp);

        // now we start from the bottom of matrix
        int i = n1;
        int j = n2;
        String ans ="";
        while(i > 0 && j > 0){
            if( s1.charAt(i-1) == s2.charAt(j-1)){
                ans += s1.charAt(i-1);
                i--;
                j--;
            }
            else{
                if ( dp[i-1][j] > dp[i][j-1] )
                    i--;
                else  //   dp[i][j-1] > dp[i-1][j]
                    j--;    
            }
        }
        for (int k = ans.length()-1; k >= 0; k--) {
            System.out.print( ans.charAt(k));
        }
    }

    static void lcs(String s1, String s2, int[][] dp){
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if( i==0 || j==0)
                    dp[i][j] = 0;

                else if ( s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                
                else 
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1]);    
            }
        }
    }
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        print_lcs(s1,s2);
    }
}
