/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @author lql
 * @date 2023/10/30
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 遍历
        // 当遇到某一行的数值大于target就break
        // 接着遍历下一行
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == target){
                    return true;
                }
                if(j + 1 < n && matrix[i][j + 1] > target){
                    break;
                }
            }
        }
        // 题解思路：
        // 从右上角开始判断
        // 相等返回true
        // 小于则列数减一
        // 大于则行数加一

        return false;
    }
}