//             === GCD/HCF and LCM using Euclidean Algo ===


public class GCD_LCM {
    public static void main(String[] args) {
        
        // gcd
        System.out.println("HCF/GCD is "+ gcd(5,10));

        // lcm
        System.out.println("LCM is " +lcm(5,10));
    }

    static int gcd(int a, int b){

        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }

    static int lcm(int a, int b){

        return a*b /gcd(a,b); 
    }
}
