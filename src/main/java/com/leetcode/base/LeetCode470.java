package com.leetcode.base;

import java.util.Random;

public class LeetCode470 {


    public int rand10() {
        //两位数的七进制
        int left;
        int right;
        int num;

        do {
            //十位数
            left = rand7() ;
            //个位数
            right = rand7();
            //计算十位数和个位数的和
            num= right + (left-1)*7;
            //为了让每个数出现的概率一样，只取前40个数
        } while (num>40);
        //算出来的结果是0-40的数。对这个数做取余，也就是0-9，再加上1就是 rand10()
        return (num-1)%10+1;

    }

    private int rand7() {
        return new Random(7).nextInt();
    }


}
