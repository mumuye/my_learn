package com.learn.fori;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetCode
 * @description: 字符串的最长无重复子串
 * @author: 空见
 * @create: 2020-11-24 21:08
 * <p>
 * 思路：
 */

public class MaxLengthOfSubString {
    public static void main(String[] args) {
        String s = "acecbcabacbad";

        int i = getMaxLengthOfSubString(s);
        System.out.println("set " + i);

        int j = getMaxLengthOfSubStringUseShuZu(s);

        System.out.println("数组 " + j);

        int K = getMaxLengthStringUseMap(s);

        System.out.println("map " + K);


    }

    private static int getMaxLengthOfSubString(String s) {

        // 判断空值
        if (null == s || "" == s || " " == s || 0 == s.length()) {
            return 0;
        }
        // 去除前后空格影响
        String trim = s.trim();
        s = trim;

        // 将string拆成数组
        /*String[] strings = new String[s.length()];
        for (int i = 0;  i< s.length() ; i++) {

            strings[i] = s.substring(i,i+1);

        }*/

        // 字符串最大的长度
        int n = s.length();
        //
        Set<Character> set = new HashSet<Character>();
        // 子串最大长度，只会记录最大值
        int ans = 0;
        // string的下标， 数据从set中移除下标
        int i = 0;
        // string的下标，这个是从0开始的 数据获取下标
        int j = 0;

        while (i < n && j < n) {
            // s.charAt(1) - 返回指定索引处的char 值
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }

    private static int getMaxLengthOfSubStringUseShuZu(String s) {
        // 字符串长度
        int n = s.length();
        // 最大不重复的子串长度
        int ans = 0;
        // current index of character
        int[] index = new int[128];
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    private static int getMaxLengthStringUseMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            Character c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(c, j + 1);
        }
        return ans;
    }
}
