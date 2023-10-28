/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * @author lql
 * @date 2023/10/28
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 使用m+n的空间标记
        int[] icount = new int[m];
        int[] jcount = new int[n];
        // 先标记
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    icount[i] = 1;
                    jcount[j] = 1;
                }
            }
        }
        // 再转为0
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(icount[i] == 1 || jcount[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}