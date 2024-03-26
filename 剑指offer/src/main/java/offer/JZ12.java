package offer;

public class JZ12 {

    public boolean hasPath (char[][] matrix, String word) {
        if (matrix.length == 0){
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (dfs(matrix, n, m, i, j, word, 0, flag)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] matrix, int n, int m, int i, int j, String word, int k, boolean[][] flag){
        if (i < 0 || i >= n || j < 0 || j >= m || matrix[i][j] != word.charAt(k) || flag[i][j] == true){
            return false;
        }

        if (k == word.length() - 1){
            return true;
        }

        flag[i][j] = true;
        if (dfs(matrix, n, m, i - 1, j, word, k + 1, flag)
        || dfs(matrix, n, m, i + 1, j, word, k + 1, flag)
        || dfs(matrix, n, m, i, j - 1, word, k + 1, flag)
        || dfs(matrix, n, m, i, j + 1, word, k + 1, flag)){
            return true;
        }
        flag[i][j] = false;
        return false;
    }
}
