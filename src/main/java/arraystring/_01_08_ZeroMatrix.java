package arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
class _01_08_ZeroMatrix {
    int[][] zero(int[][] matrix) {
        ArrayList<Integer> zCols = new ArrayList<Integer>();
        ArrayList<Integer> zRows = new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;

        //find zeros
        for (int c=0; c< n; c++){
            for (int r=0; r<m; r++){
                if(matrix[c][r] == 0){
                    zCols.add(c);
                    zRows.add(r);
                }
            }
        }

        for(int c: zCols){
            for (int i =0; i<m; i++) {
                matrix[c][i] = 0;
            }
        }

        for(int r: zRows){
            for (int i =0; i<n; i++){
                matrix[i][r] =0;
            }
        }

        return matrix;

    }
}
