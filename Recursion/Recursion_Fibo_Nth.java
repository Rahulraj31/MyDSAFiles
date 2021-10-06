
//                                      ==== Printing Nth fibo Number ===


package Recursion;


public class Recursion_Fibo_Nth {
    public static void main(String[] args) {
        int n=7;
      System.out.println(fibo(n));
    }
    static int fibo(int n)
    {
        if(n<=1)
        {
         
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
