/*                  === Pyramid Pattern 1 ===

    ****
    ***
    **
    *

*/

public class Recursion_Pattern_1Pyramid {
    public static void main(String[] args) {
      int  rows = 5;
      int col=0;
      triangle(rows,col);
    }

    public static void triangle(int r,int c){

        if(r==0){
            return;
        }
        if(c < r){
            System.out.print("*");
            triangle(r,c=c+1);     // increase col for a line
        }
        else{
            System.out.println();
            triangle(r=r-1,0);    // decrease row i.e change line
        }
      }

}

/*         === Alternate Solution ===

public class Recursion_Pattern_1Pyramid {
  public static void main(String[] args) {
    int  rows = 5;
    
    triangle(rows);
  }

  public static void triangle(int r){
    int c=1;
    if(r==0){
        return;
    }
    while(c<=r){
        System.out.print("*");
        c=c+1;
    }
    System.out.println();
    triangle(r=r-1);
  }
}

*/
