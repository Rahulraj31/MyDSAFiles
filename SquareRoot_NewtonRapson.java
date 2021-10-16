/*              === Finding Square root Using Newton Rapson Method ===


Y = 1/2 * (X + N/X)  ;  Y => actual root    
.                   X => assumed root 
.                   N => Number

where Error would be => |Y-X|

*/


public class SquareRoot_NewtonRapson {
    public static void main(String[] args) {
        
    System.out.println(sqrt(40));    
    }

    static double sqrt(double n){

        double x=n;
        double root;
        while(true){
             root = 0.5*( x + (n/x));

            if(Math.abs(root-x)<0.05){   // for error
                break;
            }
            x=root;
        }
        return root;
    }
}
