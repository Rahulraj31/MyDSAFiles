//             ===FInding Prime by Seive Of Eratosthenes Method===


public class Prime_SeiveEratosthenes_method {
public static void main(String[] args) {
    
    int n=40;
    boolean[] prime = new boolean[n+1];   // if n is included also array is initalised as False 
    sieve(40,prime);
}   

// false in array means number is prime

static void sieve(int n,boolean[] prime){

    for (int i = 2; i*i <=n; i++) {
        if(!prime[i]){                  // prime[i]==False
            
            for (int j = i*2; j <=n; j+=i) {
                prime[j]=true;
            }
        }
    }

 for (int i = 2; i <=n; i++) {
     if(!prime[i]){
         System.out.print(i+ " ");
     }
 }
}
}