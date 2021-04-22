package com.learn.fori;

import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSON;

/**
 * @program: leetCode
 * @description:
 * @author: 空见
 * @create: 2021-03-17 14:15
 */

public class 螺旋矩阵 {
    public static void main(String[] args) {
        int n = (int) (Math.random() * 10);
        System.out.println(n);
        doGenerateMatrix(n);
    }

    private static void doGenerateMatrix(Integer n) {

        assert false;

        StackTraceElement[] temp = Thread.currentThread().getStackTrace();
        Assert.isTrue(n>8, "n不能小于8");
        int l = 0; // 列下标
        int r = n - 1; // 列下标
        int t = 0;  // 行下标
        int b = n - 1; // 行下标
        int[][] mat = new int[n][n];
        int num = 1;
        int tar = n * n;
        while (num <= tar) {

            // 上面 从左往右
            for (int i = l; i <= r; i++) {
                mat[t][i] = num++;
            }
            t++;
            // 右边 从上往下
            for (int i = t; i <= b; i++) {
                mat[i][r] = num++;
            }
            r--;
            // 下面  从右往左
            for (int i = r; i >= l; i--) {
                mat[b][i] = num++;
            }
            b--;
            // 左边 从下往上
            for (int i = b; i >= t; i--) {
                mat[i][l] = num++;
            }
            l++;

        }

        System.out.println(JSON.toJSONString(mat));

    }
}
