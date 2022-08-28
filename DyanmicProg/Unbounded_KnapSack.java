/*          === UNBOUNDED KNAPSACK ===  

https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
https://youtu.be/aycn9KO8_Ls

* In this Repetition of items allowed unlike 0/1 knapsack

Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate minimum amount that could make up this quantity exactly. This is different from classical Knapsack problem, here we are allowed to use unlimited number  of instances of an item.
Examples:

Input : W = 100
       val[]  = {1, 30}
       wt[] = {1, 50}
Output : 100

There are many ways to fill knapsack.
1) 2 instances of 50 unit weight item.
2) 100 instances of 1 unit weight item.
3) 1 instance of 50 unit weight item and 50
   instances of 1 unit weight items.

We get maximum value with option 2.

*/

package DynamicProg;

public class Unbounded_KnapSack {
    public static void main(String[] args) {
        int W = 100;
        int wt[] = { 5, 10, 15 };;
        int val[] = { 10, 30, 20 };
        unbounded_knapSack(W, wt, val);
    }
    public static void unbounded_knapSack(int W, int[] wt, int[] val){
        int[][] mat= new int[wt.length+1][W+1];

        for(int i=0; i<wt.length+1; i++){
            for(int j=0; j<W+1; j++){
                if(i==0 || j==0)
                    mat[i][j] = 0;
                else if (wt[i-1]<=j)
                    mat[i][j] = Math.max(val[i-1] + mat[i][j-wt[i-1]], mat[i-1][j]);
                else 
                    mat[i][j]  = mat[i-1][j];   
            }   
             
        }
        System.out.println(mat[val.length][W]);
}
}
