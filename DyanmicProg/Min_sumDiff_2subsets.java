/*                      === Minimum Sum Difference of 2 subsets==

https://youtu.be/-GtpxG6l_Mc
https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

Given a set of integers, the task is to divide it into two sets S1 and S2 such that the 
absolute difference between their sums is minimum. 

Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11 

we will always take sum of s1 less than the half of total sum array always.

Recursive is better
*/

package DynamicProg;

public class Min_sumDiff_2subsets {
    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 5};
        int n = arr.length;
        System.out.println( findMin(arr, n));
    }
    static int findMin(int arr[], int n)
    {
        // Calculate sum of all elements
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
 
        boolean dp[][] = new boolean[n + 1][sum + 1];
 
        // Initialize first column as true.
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
 
        // Initialize top row, except dp[0][0], as false. 
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
 
        // Fill the partition table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]]; //included
                else
                    dp[i][j] = dp[i - 1][j]; //excluded
            }
        }
 
        int diff = Integer.MAX_VALUE;
 
        // Find the largest j such that dp[n][j] is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }
}
