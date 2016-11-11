package AlgorithmMyVersion.ArrayAndStrings;

/**
 * Created by Shiyi on 11/10/2016.
 */
public class S7_RotateMatrix {
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++) {
            int firstIndex = layer;
            int lastIndex = n - 2 - layer;
            for (int i = firstIndex; i<=lastIndex; i++) {
                int temp = matrix[layer][i];
                //top = left
                matrix[layer][i] = matrix[n-1-i][layer];
                //left = bottom
                matrix[n-1-i][layer] = matrix[n-1-layer][n-1-i];
                //bottom = right
                matrix[n-1-layer][n-1-i] = matrix[i][n-1-layer];
                //right = top
                matrix[i][n-1-layer] = temp;
            }

        }
    }
    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateMatrix(matrix);
        printMatrix(matrix);

    }
}
