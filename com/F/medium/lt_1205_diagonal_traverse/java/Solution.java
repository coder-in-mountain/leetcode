public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] result = new int[rows * cols];
        int row = 0, col = 0, maxCount = Math.min(rows, cols);

        for (int i = 0; i < rows * cols; i++) {
            result[i] = matrix[row][col];
            if (col == 0) {
                row++;
            }else if (row == 0){
                col++;
            }else{
                if ((row+col) % 2 == 0) {
                    row++;col--;
                }else{
                    row--;col++;
                }
            }
        }
        return result;
    }
}