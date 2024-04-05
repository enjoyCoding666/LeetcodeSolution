package com.leetcode.string;

public class LeetCode415Better {

    public String addStrings(String num1, String num2) {
        if (num1==null ) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        //相加后，进位就是1，不进位就是0
        int add = 0;
        int length1 = num1.length();
        int length2 = num2.length();

        StringBuilder  sb = new StringBuilder();
        //从个位数开始相加
        //最高的一位，有可能需要进位，所以判断条件得加上 add>0
        for (int i= length1-1, j= length2-1;
             i>=0 || j>=0 || add>0; i--, j--) {
            int first = 0;
            if (i>=0 && i< length1) {
                //将数字字符转换为数字
                first = num1.charAt(i) - '0';
            }
            int second = 0;
            if (j>=0 && j< length2) {
                second = num2.charAt(j) - '0';
            }

            int result = first + second + add;
            add = result/10;
            sb.append(result%10);
        }
        //由于是从高到低添加到 StringBuilder 的，所以需要反转一下。
        return sb.reverse().toString();


    }

}
