package com.leetcode.interview;

/**
 *
 *  两个长字符串数字相加求和
 *
 *  String str1 = "123123312123123123123123131233132123123123131231233123131231231231231";
 *  String str2 = "111111111111111111111111"
 *
 *
 */
public class TwoStringAdd {


    /**
     *  主要思路是： 倒序，求和，再排序
     *
     *  注意点：两个位数相加，>=10要进一位。
     *
     *
     */
    public static String twoStringAdd(String num1, String num2) {
        if (num1 == null || num2 ==null) {
            return null;
        }
        StringBuilder sb1 = new StringBuilder(num1);
        //倒序
        sb1.reverse();
        StringBuilder sb2 = new StringBuilder(num2);
        sb2.reverse();

        StringBuilder sb3 = new StringBuilder();
        //取字符串最大长度
        int length = Math.max(sb1.length(), sb2.length());
        //进位
        int plus = 0;
        for (int i = 0; i < length; i++) {
            //如果追求健壮性，还需要校验一下字符是否数字
            char c = (i < sb1.length())? sb1.charAt(i):'0';
            char c2 = (i < sb2.length())? sb2.charAt(i):'0';
            int sum = c - '0' + c2 - '0' + plus;
            //进位就加1
            if (sum >= 10) {
                plus = 1;
                sum -= 10;
            } else {
                plus = 0;
            }
            sb3.append(sum);
        }
        //倒序
        return sb3.reverse().toString();

    }


}
