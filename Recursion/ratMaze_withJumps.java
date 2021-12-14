/*                                                          === Rat in maze with N Jumps ===


problem statement - https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/
*/


package Recursion;
public class ratMaze_withJumps {
    public static void main(String[] args) {
        
        int maze[][] = {{2, 1, 0, 0},
                        {3, 0, 0, 1},
                        {0, 1, 0, 1},
                        {0, 0, 0, 1}};

        solve(maze);
    }

    static void solve(int maze[][]){
        int sol[][] = {{0, 0, 0, 0},
                       {0, 0, 0, 0},
                       {0, 0, 0, 0},
                       {0, 0, 0, 0}};
 
        if (solveable(maze, 0, 0, sol) == false)
        {
            System.out.printf("Solution doesn't exist");
            
        }
 
        display(sol);
    }

    static boolean solveable(int maze[][],int x, int y, int [][] sol){
        
        if(x==maze.length-1 && y== maze.length-1){
            sol[x][y]=1;
            return true;
        }

        if(isSafe(maze,x,y)==true){
            sol[x][y]=1;

            // for jump 
            
            for(int i=1;i<=maze[x][y] && i<maze.length;i++){

                if(solveable(maze,x+i,y,sol)==true){
                    return true;
                }
                if(solveable(maze,x,y+i,sol)==true){
                    return true;
                }
            }

            sol[x][y]=0;
            return false;
        } 
        return false;
    }

    static boolean isSafe(int[][] maze, int x, int y){

        if(x>=0 && x<maze.length && y>=0 && y<maze.length
           && maze[x][y] !=0 ){
               return true;
           }

           return false;
    }

    static void display(int sol[][])
    {
        for (int i = 0; i < sol.length; i++)
        {
            for (int j = 0; j < sol.length; j++)
            {
                System.out.print( sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
