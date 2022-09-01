package com.leetcode.interview;

import java.util.Arrays;

/**
 * 快速排序的核心思想是分治和递归，可以平均达到类似二分查找的时间复杂度
 * 解题思路：
 * 1）递归的终止条件 l >= r
 * 2) 选定一个靶向值，然后进行调整，大于靶向值的都移到该值右边，小于靶向值的都移到左边，靶向值移到分割位置
 * 3）然后在分隔位置左右分别进行递归
 * https://blog.csdn.net/tala_cai/article/details/120699636
 */

public class QuickSort {

    public static void sort(int[] array, int left, int right) {
        //1、递归的终止条件
        if (left >= right) {
            return;
        }

        //2、选定靶向值进行调整
        int x = array[right];
        int target = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= x) {
                //顺序进行调整，不容易出错,统一小的都移动到左边
                swap(array, ++target, j);
            }
        }
        //靶向值放到正确位置
        swap(array, target + 1, right);

        //3、递归
        //左递归
        sort(array, left, target);
        //右递归
        sort(array, target + 1, right);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,8,7,9,1};
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}

