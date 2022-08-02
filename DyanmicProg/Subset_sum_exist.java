/*      === Subset Sum Problem ===

Based on kanpsack

Given a set of non-negative integers, and a value sum, determine if there is a 
subset of the given set with sum equal to given sum. 

https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
https://youtu.be/_gPcYovP7wc

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Solving using memoization or recurstion

tabulation method in the end
 */

package DynamicProg;
import java.util.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class Subset_sum_exist {
    
    public static int subset(int[] nums,int sum, int n){
        int tab[][] = new int[n+1][sum+1];
        for(int[] row : tab){
        Arrays.fill(row, -1);
        }
        for(int j=0; j<sum+1;j++){
            tab[0][j] = 0;
        }
        for(int i=0; i<n+1;i++){
            tab[i][0] = 1;
        }
        if(sum == 0)
            return 1;
        if(n<=0) 
            return 0;

        if(tab[n][sum] !=-1)
            return tab[n][sum];
        
        if (nums[n-1] >sum)
            return tab[n][sum] = subset(nums, sum, n-1);
        
        return tab[n][sum] = Math.max(subset(nums,sum-nums[n-1],n-1), subset(nums,sum,n-1));    
    }




    public static void main(String[] args) {
        int nums[] ={1, 2, 3, 4, 5};
        int sum = 10;
        int n = nums.length;

        if(subset(nums, sum, n) == 1){
            System.out.println("Yes");
        }
        else{
            System.out.println("no");
        }
    }

}
/*      TABULATION METHOD 
static boolean isSubsetSum(int set[],
                               int n, int sum)
    {
 
        int subset[][] = new boolean[sum + 1][n + 1];
  
        for (int i = 0; i <= n; i++)
            subset[0][i] = 0;
  
        for (int i = 1; i <= sum; i++)
            subset[i][0] = 1;
  
        // Fill the subset table in bottom up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                
                if (i >= set[j - 1])
                    subset[i][j] = Math.max(subset[i-1][j],subset[i - set[j - 1]][j - 1]);
                else
                    subset[i][j] = subset[i][j - 1];    
            }
        }
  
        return subset[sum][n];
    }
 */