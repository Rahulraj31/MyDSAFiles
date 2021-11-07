//              === No of DiceRolls with Target Sum ===
/*
Amazon Question-
Dynamic Prog. is also used
Possible way of getting sum of 4 in dice throw
*/

package Recursion;

public class No_DiceRolls_withTargetSum {
    public static void main(String[] args) {
     
         dice("",4);
        System.out.println("Ways are : "+ countways("",4) );
    }

    static void dice(String p, int target){
        if(target==0){
            System.out.println(p+ " ");
            return;
        }

        for(int i=1; i<=6 && i<=target; i++){
            dice( p+i , target-i);
        }
    }

    static int countways(String p, int target){
        if(target==0){
            return 1;
        }
        int count=0;
        for(int i=1; i<=6 && i<=target; i++){
           count=count + countways( p+i , target-i);
        }

        return count;
    }
}