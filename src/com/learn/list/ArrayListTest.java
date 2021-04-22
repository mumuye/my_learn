package com.learn.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetCode
 * @description:
 * @author: 空见
 * @create: 2021-02-03 15:11
 */

public class ArrayListTest {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>();
        list.add(1L);

        String s = "A34";
        String[] split = s.split("");
        System.out.println(JSON.toJSONString(Lists.newArrayList(split)));
    }

}
