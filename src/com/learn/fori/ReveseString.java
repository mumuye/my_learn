package com.learn.fori;

import com.alibaba.fastjson.JSON;

/**
 * @program: leetCode
 * @description: 翻转字符数组
 * @author: 空见
 * @create: 2020-12-07 12:32
 */

public class ReveseString {

    public static void main(String[] args) {


        String[] nums = new String[]{"1","2", "3", "4", "5","6"};
        // 分配了额外的空间
     //   buildReverseString (nums);

        // 不分配空间
        buildReverseString("12345");

    }

    private static void buildReverseString(String[] nums) {
        String[] num2 = new String[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {

            num2[ nums.length -i-1] = nums[i];
            System.out.println(nums[i]);
        }

        System.out.println(JSON.toJSONString(num2));
    }


    private static void buildReverseString(String nums) {
        StringBuilder sb = new StringBuilder(nums);
        StringBuilder reverse = sb.reverse();
        System.out.println(JSON.toJSONString(reverse));

        for (int binCount = 0; ; ++binCount) {

                if (binCount >= 8 - 1){
                    break;
                } // -1 for 1st



        }
    }
}
