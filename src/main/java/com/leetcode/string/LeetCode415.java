package com.leetcode.string;

/**
 *
 *  两个长字符串数字相加求和
 *
 *  String str1 = "123123312123123123123123131233132123123123131231233123131231231231231";
 *  String str2 = "111111111111111111111111"
 *
 *
 */
public class LeetCode415 {



    public String addStrings(String num1, String num2) {
        if (num1==null || num2==null) {
            return null;
        }
        int i=num1.length()-1;
        int j= num2.length()-1;
        int plus=0;

        StringBuilder result = new StringBuilder();
        //从后往前相加，大于等于10就进位。
        while (i>=0 || j>=0 || plus!=0) {
            //数字字符，减去'0'，就能得到对应的数字
            int first =  i>=0? num1.charAt(i) - '0': 0;
            int second = j>=0? num2.charAt(j) -'0': 0;
            int sum = first+second+ plus;
            //余数为当前位的结果
            result.append(sum%10);
            //进位取整
            plus = sum/10;
            i--;
            j--;
        }
        //倒序
        return result.reverse().toString();
    }


}
