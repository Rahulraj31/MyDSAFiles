package DynamicProg;

import javax.lang.model.util.ElementScanner14;

public class knapSackProblem {
    public static void main(String[] args) {
        int bag_cap = 10;
        int w[] = {1,3,4,6};
        int v[] = {20,30,10,50};

        knap_sack(bag_cap,w,v);
    }
    public static void knap_sack(int bag_cap, int[] w, int[] v){
            int[][] mat= new int[v.length+1][w.length+1];

            for(int i=0; i<=mat.length-1; i++){
                for(int j=0; j<=mat[i].length-1; i++){
                    if(i==0 || j==0)
                        mat[i][j] = 0;
                    else if (w[i-1]<=j)
                        mat[i][j] = Math.max(v[i-1]+mat[i-1][j-w[i-1]], mat[i-1][j]);
                    else 
                        mat[i][j]  = mat[i-1][j];   
                }   
                 
            }
            System.out.println(mat[v.length+1][w.length+1]);
    }
}
