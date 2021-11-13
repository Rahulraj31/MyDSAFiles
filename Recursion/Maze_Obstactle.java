/*        === Maze with Obstacle  ===

Consider in a 3x3 (0,1,2) maze if the 1,1 oe middle block
has an obstacle instead of calling from that middle cell we willstop recursion of that path on that point

Problem:- u are at 0,0 go to 2,2 with obstacle in 1,1

Consider a boolean matrix with False value at the obstactle i.e. middle cell
So when u land on new cell check if it is obstacle or not.
 */

package Recursion;

public class Maze_Obstactle {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},   //0
            {true,false, true},   //1
            {true, true, true}    //2
        };

        System.out.println("No. of Paths : " + CountRes(board, 0, 0) );

        System.out.print("Paths : ");
        pathRes("", board, 0, 0) ;
    }

    static int CountRes(boolean[][] maze, int r, int c){

        if( r== maze.length-1 || c== maze[0].length-1){
            return 1;
        }

        if(maze[r][c] == false){     // for obstactle
            return 0;
        }

        int down = CountRes( maze, r+1, c);
        int right =  CountRes( maze, r, c+1);

        return down+right;
    }

    static void pathRes(String p,boolean[][] maze, int r, int c){
        if( r== maze.length-1 && c== maze[0].length-1){
            System.out.print(p + " ");
            return;
        }

        if(maze[r][c] == false){     // for obstactle
            return;
        }

        if(r < maze.length-1){
            pathRes( p+ 'D', maze, r+1, c);
        }
        if(c < maze[0].length-1 ){
            pathRes(p+'R', maze, r, c+1);
        }
    }
}
