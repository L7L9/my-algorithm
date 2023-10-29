/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author lql
 * @date 2023/10/29
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        int amount = m * n;
        int left = 0;
        int high = 0;
        while(result.size() < amount){
            // 将上排加入
            for(int i = left;i < n;i++){
                result.add(matrix[high][i]);
            }
            ++high;
            // 右边列加入
            for(int i = high;i < m;i++){
                result.add(matrix[i][n - 1]);
            }
            --n;
            if(result.size() == amount) break;
            // 下排加入
            for(int i = n - 1;i >= left;i--){
                result.add(matrix[m - 1][i]);
            }
            --m;
            // 左列加入
            for(int i = m - 1;i >= high;i--){
                result.add(matrix[i][left]);
            }
            ++left;
        }
        return result;
    }
}