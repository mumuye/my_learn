package com.learn.list;

import com.alibaba.fastjson.JSON;
import com.learn.common.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @program: leetCode
 * @description: 翻转链表
 * @author: 空见
 * @create: 2021-04-22 17:53
 */

public class FlipListTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(JSON.toJSONString(list));

        ListNode node = flipList(list);

        System.out.println(JSON.toJSONString(node));

    }

    private static ListNode flipList(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        Integer a = null;
        Integer b = null;


        if(iterator.hasNext()){
            Integer next = iterator.next();
            if(a ==null){
                a = next;
            }else {

            }
        }

        return null;

    }

}
