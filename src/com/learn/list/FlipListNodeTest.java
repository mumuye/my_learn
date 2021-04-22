package com.learn.list;

import com.alibaba.fastjson.JSON;
import com.learn.common.ListNode;


/**
 * @program: leetCode
 * @description: 翻转链表
 * @author: 空见
 * @create: 2021-04-22 17:53
 */

public class FlipListNodeTest {

    public static void main(String[] args) {

        ListNode listNode1 = null;
        ListNode listNode2 = null;
        ListNode listNode3 = null;
        for (int i = 0; i < 10; i++) {
            ListNode listNodeA = new ListNode(i);
            ListNode listNodeB = new ListNode(i);
            ListNode listNodeC = new ListNode(i);
            if (null == listNode1) {
                listNode1 = listNodeA;
            } else {
                listNodeA.setNext(listNode1);
                listNode1 = listNodeA;
            }
            if (null == listNode2) {
                listNode2 = listNodeB;
            } else {
                listNodeB.setNext(listNode2);
                listNode2 = listNodeB;
            }
            if (null == listNode3) {
                listNode3 = listNodeC;
            } else {
                listNodeC.setNext(listNode3);
                listNode3 = listNodeC;
            }
        }

        System.out.println(JSON.toJSONString(listNode1));

        ListNode node = flipNode1(listNode1);
        ListNode node2 = flipNode2(listNode2);

        System.out.println(JSON.toJSONString(node));
        System.out.println(JSON.toJSONString(node2));

    }

    private static ListNode flipNode2(ListNode listNode2) {
        ListNode result = null;
        ListNode temp = null;
        ListNode head = listNode2;

        while (null != head) {
            // 把下一个值的地址放在temp上
            temp = head.getNext();
            // 把当前值的next属性设置好
            head.setNext(result);
            // 把当前值的地址放在result上
            result = head;
            // 把下一个值的地址放在head上，开启下一轮循环
            head = temp;

        }
        return result;

    }

    private static ListNode flipNode1(ListNode preListNode) {
        // 不能更换每一个node的地址值
        ListNode result = null;
        ListNode head = preListNode;
        Boolean FistFlag = Boolean.TRUE;

        while (null != head) {
            ListNode next = head.getNext();
            ListNode nextNext = next.getNext();
            if (FistFlag) {
                // 第一次
                FistFlag = Boolean.FALSE;
                preListNode.setNext(null);
                next.setNext(preListNode);
                result = next;
                head = nextNext;
                continue;
            }
            head.setNext(result);
            next.setNext(head);
            result = next;
            head = nextNext;
        }

        return result;
    }
}
