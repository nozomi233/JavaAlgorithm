package offer;

/**
 * @Author zhulang
 * @Date 2023-03-04
 **/
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int p = matrix.length - 1;
        int q = 0;
        while (p >= 0 && q <= matrix[0].length - 1){
            if(matrix[p][q] < target) {
                q++;
            } else if (matrix[p][q] > target){
                p--;
            }else {
                return true;
            }
        }
        return false;
    }
}
