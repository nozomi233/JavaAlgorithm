package offer;

/**
 * @Author zhulang
 * @Date 2023-05-16
 **/
public class Offer13_2 {
    public static class NumMatrix {

        int[][] numMatrix;

        public NumMatrix(int[][] matrix) {
            this.numMatrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = 0;
            for (int i = row1; i <= row2; i++){
                for (int j = col1; j <= col2; j++){
                    res += this.numMatrix[i][j];
                }
            }

            return res;
        }
    }

    class NumMatrix2 {
        int[][] sums;

        public NumMatrix2(int[][] matrix) {
            int m = matrix.length;
            if (m > 0) {
                int n = matrix[0].length;
                sums = new int[m][n + 1];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        sums[i][j + 1] = sums[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += sums[i][col2 + 1] - sums[i][col1];
            }
            return sum;
        }
    }


    public static void main(String[] args) {
        int[][] d = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix num = new NumMatrix(d);
        System.out.println(num.sumRegion(2,1,4,3));
    }
}
