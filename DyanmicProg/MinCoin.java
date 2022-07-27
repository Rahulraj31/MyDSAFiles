/*      === Find minimum number of coins that make a given value ===
https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
https://youtu.be/-NTaXJ7BBXs
 */
package DynamicProg;

public class MinCoin {
    public static void main(String[] args) {
        int n = 18;
        int coins[] = {7,5,1};
        int ans  = minCoins(n, coins);
        System.out.println(ans); 
    }
    static int minCoins(int n, int arr[]){
        if(n == 0 ) return 0;
        int ans= Integer.MAX_VALUE;
        
        for(int i = 0; i<arr.length; i++){
            if (n - arr[i] >= 0){
                int subAns = minCoins( n - arr[i], arr);
                if( subAns != Integer.MAX_VALUE && subAns + 1 <ans){
                    ans = subAns +1;   // +1 coz we have used a coin already
                }
            }
            
        }
        return ans;
    }
}
