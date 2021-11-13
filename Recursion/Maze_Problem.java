/*               === Maze Problem No Obstacle  ===


Right and Downward initally , Later on with Diagonal 

Reach a targeted cell from a cell and count no. of paths to reach it 

maze considerd 3x3  (3,2,1) 
Top leftmost is (3,3) and right bottom most is (1,1)

Problem taken here - count paths starting from (3,3)  to (1,1) and you can either move right or move downward
*/



package Recursion;

public class Maze_Problem {
 public static void main(String[] args) {

    System.out.println("No. of ways (Right nd Down): "+ count(3, 3) );   // provide dim of maze can also pass target value as parameter or set it as base condition
    System.out.println("Paths (Right nd Down) :--");
    Path("", 3, 3);

    System.out.println("\n\nNo. of ways (Diagonal also): "+ countDia(3, 3) );
    System.out.println("Paths (Diagonal also) X==Diagonal:--"); 
    PathDia("",3,3);
 }
 static int count(int r, int c){

     if(r==1 || c==1 ){     // replace 1 with target coordinates
         return 1;
     }
     int left = count(r-1, c);
     int right = count(r, c-1);

     return right+left;
 }

// printing path uses same processed and unprocessed concept of permutation / substring
 
 static void Path(String p, int r, int c){
    if(r==1 && c==1){
        System.out.print(p + " ");
        return;
    }
    // in col wise we move Right and row wise we move Down
    
    if(r>1){
        Path(p+'D', r-1, c);
    }

    if(c>1){
        Path(p+'R', r, c-1);
    }

 }
 
 /*                         === DIAGONAL MOVEMENT ===
 
 
 Now we move Diagonally also just do r-1 and c-1 together
 */

 static int countDia(int r, int c){

    if(r==1 || c==1 ){  
        return 1;
    }
    int left = countDia(r-1, c);
    int right = countDia(r, c-1);
    int dia = countDia(r-1,c-1);  
    return right+left+dia;
 }

 static void PathDia(String p, int r, int c){
    if(r==1 && c==1){
        System.out.print(p + " ");
        return;
    }
    // in col wise we move Right and row wise we move Down
    
    if(r>1){
        PathDia(p+'D', r-1, c);
    }

    if(c>1){
        PathDia(p+'R', r, c-1);
    }

    if(r>1 && c>1){
        PathDia(p+'X', r-1, c-1);
    }

 }

}