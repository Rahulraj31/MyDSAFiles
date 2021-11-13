/*               === Maze with Backtrack (All 4 direction) ===

If we move in all 4 direction(up down left right) there comes a situtation where we will be again at starting
point. This will cause stackoverflow. To prevent this we have 2 ways

1. Either mark all the visited cell as False (Like in obstactle problem)
2. Backtracking

But when a path will be covered making cell false , for a new call the cells will also be false causing problem
which is solved in bracktack i.e. while moving back make cells true/restore the maze for the next call
*/

package Recursion;

public class Maze_withBacktrack {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},   //0
            {true, true, true},   //1
            {true, true, true}    //2
        };

        System.out.println("No. of Paths : " + allCount(board, 0, 0) );

        System.out.print("Paths : \n");
        allPath("", board, 0, 0) ;
    }
    static void allPath(String p, boolean[][] maze, int r, int c){

        if( r== maze.length-1 && c== maze[0].length-1){
            System.out.println(p );
            return;
        }

        if(maze[r][c] == false){     // for visited cell
            return;
        }

        // if considering this block in path
        maze[r][c] = false;

        if(r < maze.length-1){
            allPath( p+ 'D', maze, r+1, c);
        }
        if(c < maze[0].length-1 ){
            allPath(p+'R', maze, r, c+1);
        }

        if(r > 0){
            allPath( p+ 'U', maze, r-1, c);
        }

        if(c > 0 ){
            allPath(p+'L', maze, r, c-1);
        }

        // This line is where the function will be over 
        // so before the function gets removed, also remove the changes made by function
        
        maze[r][c] = true ;     // backtrack;
    }

    static int allCount(boolean[][] maze, int r, int c){
        
        if( r== maze.length-1 && c== maze[0].length-1){
            return 1;
        }
        if(maze[r][c] == false){  
            return 0;
        }
        maze[r][c] = false;
        int left=0,down=0,up=0,right=0;

        if(r < maze.length-1){
          down=  allCount( maze, r+1, c);
        }
        if(c < maze[0].length-1 ){
          right=  allCount( maze, r, c+1);
        }

        if(r > 0){
           up= allCount(  maze, r-1, c);
        }

        if(c > 0 ){
           left= allCount( maze, r, c-1);
        }

        maze[r][c] = true ;  

        return up + down + right + left;
    }
}
