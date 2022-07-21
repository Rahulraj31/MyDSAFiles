package DynamicProg;

public class LongestCommonSubSeq_TabulationMethod {
    public static void main(String[] args) {
        String s1 = "ABCAB";
        String s2 = "AECB";

        int ans  = lcs_tab(s1,s2);
        System.out.println(ans);
    }

    static int lcs_tab(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int tab[][] =  new int[n+1][m+1]; // by default array is inialised with value 0 in java
        for(int i=0;i<=n;i++){
            for(int j=0; j<=m;j++){
                if(i==0 || j==0) 
                    tab[i][j] =0;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                    tab[i][j] = tab[i-1][j-1]+1;
                else{
                    tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
                }        
            }
        }
        return tab[n][m];
    }
}
