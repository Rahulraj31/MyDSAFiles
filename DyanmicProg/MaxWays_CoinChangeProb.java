/*          === MAXIMUM NUMBER OF WAYS : COIN CHANGE PROBLEM ===

https://youtu.be/I4UR2T6Ro3w
https://www.geeksforgeeks.org/coin-change-dp-7/

Coin Change Problem Maximum Number of ways
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
how many ways can we make the change? The order of coins doesn’t matter.

Example:
for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.

For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
So the output should be 5.
*/


package DynamicProg;

public class MaxWays_CoinChangeProb {
    public static void main(String[] args) {
        
        int coins[] = {2, 5, 3, 6};
        int N = 10;
        
        maxways_coin(coins,N);
    }
    static void maxways_coin(int[] coins, int value){
        int[][] dp = new int[coins.length+1][value+1];

        // if we have no coins then we can't get the required value
        for(int i=0; i<value+1; i++){
            dp[0][i] = 0;
        }
        // if we have any number of coin then we can get 0 sum as we can have null set
        for(int i=0; i<coins.length+1; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j<value+1;j++){
                if( j >=coins[i-1])
                    dp[i][j] = dp[i][ j - coins[i-1]] + dp[i-1][j];
                else
                    dp[i][j]= dp[i-1][j];
            }
        }
        System.out.println(dp[coins.length][value]);
    }
}
