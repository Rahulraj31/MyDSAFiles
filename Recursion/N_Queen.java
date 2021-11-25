/*                  === N Queens Problem ===

Concepts -  Recursion and BackTracking.

Problem Statement- 
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/


Queen can move in all 4 direction and Diagonal.

The idea is to place queens one by one in different columns, starting from the leftmost column. When we place 
a queen in a column, we check for clashes with already placed queens. In the current column, if we find a row 
for which there is no clash, we mark this row and column as part of the solution. If we do not find such a row 
due to clashes then we backtrack and return false.

in matrix at possible position we store value 1 or True . 
Matrix start from 0 to N-1

*/


package Recursion;

public class N_Queen {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[n][n];

        System.out.println("Ways - "+ waysQueens(board, 0) ); 
    }

    static int waysQueens(boolean[][] board,int row){ // no sense in passinf col as we will be starting col from 0 everytime

        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count=0;
        // placing the queen and checking for every row n col

        for (int col = 0; col < board.length; col++) {

            // place the queen if its safe

            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += waysQueens(board, row+1);
                board[row][col] = false;    // backtracking
            }
        }

        return count;
    }
    
    static boolean isSafe(boolean[][] board, int row, int col){
        
        //check vertical row 
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        
        return true;
    }

    // To display matrix  
    static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean ele : row){
                if(ele){
                    System.out.print("Q" + " ");
                }
                else{
                    System.out.print("X" + " ");
                }
            }
            System.out.println();
        }
    }
}
