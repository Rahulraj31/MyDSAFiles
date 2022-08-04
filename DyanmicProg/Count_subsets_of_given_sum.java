/*      === Count of Subsets with given Sum ===

BASED ON KNAPSACK

https://youtu.be/F7wqWbqYn9g
https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

Count of subsets sum with a Given sum
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
Example:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},{1, 2, 3} and {3, 3}

Using tabulation method
*/

package DynamicProg;

public class Count_subsets_of_given_sum {
    public static void main(String[] args) {
        int nums[] = {2,3,5,6,8,10};
        int target = 10;
        int n = nums.length;
        System.out.println( count_subset_sum(nums, n, target));
    }
    static int count_subset_sum(int []nums, int n, int sum){
        int dp[][] = new int[n+1][sum+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        
        for(int j=1; j<=sum; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if (nums[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else    
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];    
            }
        }
        return dp[n][sum];
    }
}
