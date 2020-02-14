package com.leetcode.array;

/**
 * @Author: lenovo
 * @Date: 2020/2/14 23:25
 * @Description:
 *
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 *
 *Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 *
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
public class LeetCode867 {
    public static int[][] transpose(int[][] A) {
        //如果在原来的数组上做处理，会比较麻烦。新建数组方便些。
        //数组转换后，长和宽会变换。
        int[][] B=new int[A[0].length][A.length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                B[j][i]=A[i][j];
            }
        }
        return B;
    }
}
