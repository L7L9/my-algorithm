/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * @author lql
 * @date 2023/10/29
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 用于临时存储数值
        int temp = 0;
        // 将n × n的矩阵划分为四个大整体
        // 则旋转次数为一个大整体所占的面积,当n为奇数时,忽略中心
        // i相当于大整体里的纵向偏移;j相当于大整体中的横向偏移
        // 则旋转次数为 (n/2) * ((n + 1)/2) = 整体面积
        for(int i = 0;i < n / 2;i++){
            for(int j = 0;j < (n + 1) / 2;j++){
                // 记录初始点的原数值
                temp = matrix[i][j];

                // 开始旋转 => 逆时针赋值
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - 1 - j];
                matrix[n - i - 1][n - 1 - j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}