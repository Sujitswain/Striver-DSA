package org.example.Arrays.Medium;

public class ValidSudukoOrNot {
    public static void main(String[] args) {
        function(new int[][] {});
    }
    private static void function(int[][] ints) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                int box_row = (i/3)*3;
                int box_col = (j/3);
                System.out.print(i+""+j+ "="+(box_row+box_col)+" ");
            }
            System.out.println();
        }
    }
}
