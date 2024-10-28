package org.example.Backtracking;

public class WordSearch {
    public static void main(String[] args) {
        function(new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED");
    }
    private static void function(char[][] arr, String str) {
        recursionSolution(arr, str);
    }

    private static void recursionSolution(char[][] arr, String str) {
        int row = arr.length;
        int col = arr[0].length;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(str.charAt(0) == arr[i][j]) {
                    if(searchWord(arr, str, 0, i, j, row, col)) {
                        System.out.println("Word Present");
                        return;
                    }
                }
            }
        }
        System.out.println("Word Not Present");
    }

    private static boolean searchWord(char[][] arr, String word, int index, int i, int j, int row, int col) {
        if(index == word.length())
            return true;

        if(i < 0 || j < 0 ||
            i == row || j == col ||
            arr[i][j] == 'V' ||
            arr[i][j] != word.charAt(index)
        ) {
            return false;
        }

        char c = arr[i][j];
        arr[i][j] = 'V';

        boolean top = searchWord(arr, word, index+1, i-1, j, row, col);
        boolean left = searchWord(arr, word, index+1, i, j-1, row, col);
        boolean bottom = searchWord(arr, word, index+1, i+1, j, row, col);
        boolean right = searchWord(arr, word, index+1, i, j+1, row, col);

        arr[i][j] = c;

        return top || left || bottom || right;
    }
}
