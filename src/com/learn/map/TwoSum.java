package com.learn.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetCode
 * @description: 两数之和
 * @author: 空见
 * @create: 2020-11-24 19:05
 * 解题思路：将值和下标构建成map，然后利用map的containsKey方法来获取 target-当前值的 下标
 */

public class TwoSum {

    public static void main(String[] args) {
        Integer target = 11;
        Integer[] nums = new Integer[]{5, 2, 7, 9, 1};

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println(i);
                System.out.println(map.get(complement));
                break;

            }
        }
    }
}
