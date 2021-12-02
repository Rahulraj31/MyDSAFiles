/*                  === K Knights in M*N Problem ===

Concepts -  Recursion and BackTracking.

Problem Statement- 
The task is to place K knights on an M*N chessboard such that they don’t attack each other.


https://www.geeksforgeeks.org/place-k-knights-such-that-they-do-not-attack-each-other/

Same as Queens Problem

The knights are expected to be placed on different squares on the board. A knight can move 
two squares vertically and one square horizontally or two squares horizontally and one square vertically. 
The knights attack each other if one of them can reach the other in single move. There are 
multiple ways of placing K knights on an M*N board or sometimes, no way of placing

in matrix at possible position we store value 1 or True . 
Matrix start from 0 to N-1

*/


package Recursion;

public class N_Knight {
    static int count=0;
    public static void main(String[] args) {
        int n=3, m=3, k=3;
        boolean[][] board = new boolean[n][m];

        waysKnights(board, 0, 0, k);
        System.out.println("No. of ways: "+ count);
    }

    static void waysKnights(boolean[][] board,int row, int col, int knights ){ 

        if(knights == 0){
            display(board);
            count++;
            System.out.println();
            return;
        }
        if( row == board.length-1 && col == board.length){
            return;
        } 
        if(col == board.length){
            waysKnights(board, row+1 ,0 , knights);
            return;
        }
        // place the knight if its safe

        if(isSafe(board, row, col)){
            board[row][col] = true;
            waysKnights(board, row, col+1, knights-1);
            board[row][col] = false;    // backtracking
        }
        
        waysKnights(board, row, col+1, knights);
      
    }
    
    static boolean isSafe(boolean[][] board, int row, int col){

        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }

        if(isValid(board, row-1, col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }

        if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }

        return true;
    }


    // Just to make sure row and col are not index out of bound
    static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board.length){
            return true ;
        }
        return false;
    }

    // To display matrix  
    static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean ele : row){
                if(ele){
                    System.out.print("K" + " ");
                }
                else{
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }
}
