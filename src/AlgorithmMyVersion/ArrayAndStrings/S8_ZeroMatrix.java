package AlgorithmMyVersion.ArrayAndStrings;

import java.util.HashSet;

/**
 * Created by Shiyi on 11/11/2016.
 */
public class S8_ZeroMatrix {
    // M * N matrix
    public static void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> rowsOfZeros = new HashSet<>();
        HashSet<Integer> colsOfZeros = new HashSet<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (matrix[i][j] == 0) {
                    rowsOfZeros.add(i);
                    colsOfZeros.add(j);
                }
            }
        }

        for(Integer i: rowsOfZeros)
            for(int j=0;j<n;j++)
                matrix[i][j] = 0;

        /*
        //not cache efficient
        for(Integer j: colsOfZeros)
            for(int i=0;i<m;i++)
                matrix[i][j] = 0;
                */
        for(int i=0;i<m;i++)
            for(Integer j: colsOfZeros)
                matrix[i][j] = 0;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,2,0},
                {4,0,6},
                {7,8,9}
        };
        setZeros(matrix);
        S7_RotateMatrix.printMatrix(matrix);
    }
}
