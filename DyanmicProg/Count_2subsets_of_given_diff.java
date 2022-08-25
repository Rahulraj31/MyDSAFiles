/*      === Count the number of subset with a given difference ===

Based on kanpsack
https://youtu.be/ot_XBHyqpFc

Given an array Arr[] and a difference diff, find the number of subsets that array can be divided so that 
each the difference between the two subset is the given diff.

Example1:
Input:
Arr[] : 1,1,2,3
diff: 1
Output: 3 . [(1,1,2),(3)], [(1,2),(1,3)], [(1,2),(1,3)]

we know s1 -s2 = diff and s1 + s2 = total_sum
hence  s1 = (diff + total_sum)/2
So we will get value of s1. Now only thing left is to find the count of subset
with given sum which we already did earlier.
*/

package DynamicProg;

public class Count_2subsets_of_given_diff {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        int diff = 1;
        int n = nums.length;
        System.out.println( countSubset( nums, diff, n));
    }
    public static int countSubset( int[] nums, int diff, int n){
        int total_sum = 0, count;
        for(int i: nums){
            total_sum += i;
        }
        
        int s1_sum = (diff + total_sum)/2;
        count = subset_with_sum(nums, n, s1_sum);
        return count;
    }
    public static int subset_with_sum(int[] nums, int n, int sum){
        int dp[][] = new int[n+1][sum+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int j=1; j<=sum; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=n;i++){
            for(int j=1; j<=sum;j++){
                if(nums[i-1] <= j) 
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                else    
                    dp[i][j]  = dp[i-1][j];    
            }
        }
        return dp[n][sum];
    }
}
