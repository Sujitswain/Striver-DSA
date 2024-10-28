package org.example.Backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        function(new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }
    private static void function(char[][] arr) {
        if (recursionSolution(arr)) {
            printSolution(arr);
        } else {
            System.out.println("No solution exists.");
        }
    }
    private static boolean recursionSolution(char[][] arr) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(arr[i][j] == '.') {
                    for(int k=1; k<=9; k++) {
                        if(isSafe(arr, i, j, k)) {
                            arr[i][j] = (char)(k+48);
                            if(recursionSolution(arr)) {
                                return true;
                            }
                            arr[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isSafe(char[][] arr, int row, int col, int num) {
        // row check
        for(int i=0; i<9; i++) {
            if(arr[row][i] == (char)(num+48)) {
                return false;
            }
        }

        // column check
        for(int i=0; i<9; i++) {
            if(arr[i][col] == (char)(num+48)) {
                return false;
            }
        }

        // for 3x3 block
        for(int i=0; i<9; i++) {
            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;
            char temp = arr[r][c];

            if(temp == (char)(num+48)) {
                return false;
            }
        }

        return true;
    }
    private static void printSolution(char[][] arr) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}