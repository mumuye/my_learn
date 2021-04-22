package com.learn.common;

/**
 * @program: leetCode
 * @description: 自定义链表
 * @author: 空见
 * @create: 2020-11-24 19:51
 */

public class ListNode {
    int val;
    ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(int x) {
        val = x;

    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }
}