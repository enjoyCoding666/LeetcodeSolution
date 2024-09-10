package com.leetcode.string;

public class LeetCode165 {

    /**
     * 比较版本号。 格式类似 "1.2", "1.10"
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        if (version1 == null) {
            return -1;
        }
        if (version2 == null) {
            return 1;
        }
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        //下标小于其中一个即可，就会有数据。
        for (int i = 0; i < v1Arr.length || i < v2Arr.length; i++) {
            //默认值为0.
            int x = 0;
            int y = 0;
            if (i < v1Arr.length) {
                x = Integer.parseInt(v1Arr[i]);
            }
            if (i < v2Arr.length) {
                y = Integer.parseInt(v2Arr[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }

        }
        return 0;

    }

}
