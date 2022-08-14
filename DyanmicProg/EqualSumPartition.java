/*      Equal Sum Partition

BASED ON KNAPSACK

https://youtu.be/UmMh7xp07kY
https://www.geeksforgeeks.org/partition-problem-dp-18/
 */

package DynamicProg;
public class EqualSumPartition {

    static boolean findPart(int[] nums, int n){
        int sum=0;
        for(int i: nums)
            sum +=i;
        if (sum % 2 != 0)
            return false;    
        boolean dp[][] = new boolean [n+1][(sum/2)+1];
        return isSubset(nums, n, sum/2, dp);
    }
    
    static boolean isSubset(int[] nums, int n,int sum, boolean[][]dp){
        if (sum==0)
            return true;
        if (n==0 && sum!=0)
            return false;
        if(dp[n][sum] == true)
            return true;
        
        if( nums[n-1] > sum)
            return isSubset(nums, n-1, sum, dp);
        if(isSubset(nums, n-1, sum, dp) || isSubset(nums, n-1, sum - nums[n-1], dp)) 
            return true;
        
        return false;

    }
    public static void main(String[] args) {
        int nums[] ={1, 5, 21, 5};
        int n = nums.length;

        if(findPart(nums, n)){
            System.out.println("Yes");
        }
        else{
            System.out.println("no");
        }
    }
}
