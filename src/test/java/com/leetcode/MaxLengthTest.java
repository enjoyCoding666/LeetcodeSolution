package com.leetcode;

import java.util.ArrayList;
import java.util.List;

    public class MaxLengthTest {
        public static void main(String[] args) {
            System.out.println(getMaxLength("abcbac"));
        }

        public static int getMaxLength(String word) {
            if (word==null) {
                return 0;
            }
            char[] chars= word.toCharArray();
            int max = 0;
            //是否重复
            List<Character> charList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i=0;i< chars.length;i++) {
                sb.append(chars[i]);
                //不重复
                if(!charList.contains(chars[i])) {
                    charList.add(chars[i]);
                } else {
                    //重置
                    charList = new ArrayList<>();
                    sb = new StringBuilder();
                    if (sb.length()> max) {
                        max = sb.length();
                    }

                }

            }
            return max;
        }
    }

