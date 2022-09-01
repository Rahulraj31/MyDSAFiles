/*          === MINIMUM NUMBER OF COINS NEEDED: COIN CHANGE PROBLEM ===

https://youtu.be/I-l6PBeERuc
https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

Coin Change Problem Minimum Numbers of coins
Given a value V, if we want to make change for V cents, and we have infinite supply of each of 
C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change ?
Example:

Input: coins[] = { 1, 3, 5, 7 }, V = 15
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 
 
*/



package DynamicProg;

public class MinCoins_CoinChangeProb {

    static void mincoins(int[] coins, int n, int target){
        int dp[][] = new int[n+1][target+1];
        for(int i=0; i<target+1; i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=1; i<n+1; i++){
            dp[i][0] = 0;
        }
        for(int j=1; j<target+1; j++){
            if ( j % coins[0] == 0)
                dp[1][j] = j/coins[0];
            else
                dp[1][j] =  Integer.MAX_VALUE-1;    
        }
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < target+1; j++) {
                if( coins[i-1] <= j)
                    dp[i][j] = Math.min( 1 + dp[i][ j - coins[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];    
            }
        }
        System.out.println(dp[n][target]);
    }
    public static void main(String[] args) {
        int coins[] = { 1, 3, 5, 7 };
        int n = coins.length;
        int target = 15;

        mincoins( coins, n, target);
    }
}
