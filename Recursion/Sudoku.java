/*                 === Sudoku Solver ===

same concept as n queens just this time we will be inserting all numbers 
1-9 instead of queen and there will be diff in isSafe function.

we will be checking horizontal, vertical and the 3x3 blocks of sudoku as
numbers can't repeat in them
*/



package Recursion;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(board)) {
            display(board);
        } 
        else {
            System.out.println("Cannot solve");
        }
    }

    //solve method , return false if fully solved or not solveable 
    static boolean solve(int[][] board){
        
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        // founding empty row,col and replacing row, col passing as func argument
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                if( board[i][j]==0 ){    // found empty item
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if you found some empty element in row, then break;
            if(emptyLeft == false){
                break; 
            }
        }
        
        if(emptyLeft==true){
            return true;
            // sudoku solved
        }

        // inserting numbers
        for (int num = 1; num <= 9; num++) {
            if( isSafe(board, row, col, num) ){
                board[row][col] = num;
                if( solve(board)){
                    // found ans 
                    return true;
                }
                else{
                    board[row][col] = 0;   //backtrack
                }

            }
        }
        
        return false;
    }


    // is Safe function
    static boolean isSafe(int[][] board, int row, int col, int num){
        //check row 

        for (int i = 0; i < board.length; i++) {
            // check if number in same row but diff col
            if(board[row][i]== num){
                return false;
            }
        }
        //check col 
        
        for (int[] rowEle : board) {
            // check if number in that same col but diff row   
            if(rowEle[col]== num){
                return false;
            }
        }
        // check in 3x3 blocks
        int sqrt = (int)Math.sqrt(board.length);
        int rstart = row - (row % sqrt);
        int cstart = col - (col % sqrt);

        for(int r= rstart; r< rstart + sqrt; r++){
            for (int c = cstart ; c< cstart + sqrt; c++) {
                
                if( board[r][c] == num ){
                    return false;
                }
            }
        }

        return true;
    }



    // display board
    static void display(int[][] board){
        for(int[] row : board){
            for(int ele : row){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
