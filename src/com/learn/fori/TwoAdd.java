package com.learn.fori;

import com.alibaba.fastjson.JSON;
import com.learn.common.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: leetCode
 * @description: 两数相加
 * @author: 空见
 * @create: 2020-11-24 19:05
 * 解题思路：创建一个临时数 0 用作于区分两个数相加后计算的十位数值，这个用 相加再除10  ，个位值用相加取余逇方法获取
 *  三个数相加，得到实际相加结果
 *   最后就是地址值变更赋值，把计算扭转到下一轮
 */

public class TwoAdd {

    public static void main(String[] args) {

        ListNode p = new ListNode(1);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(5);
        ListNode p4 = new ListNode(7);
        p.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);

        ListNode q = new ListNode(8);
        ListNode q2 = new ListNode(6);
        ListNode q3 = new ListNode(4);
        ListNode q4 = new ListNode(5);
        q.setNext(q2);
        q2.setNext(q3);
        q3.setNext(q4);


        ListNode dummyHead = new ListNode(0);
        ListNode  curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.getVal() : 0;
            int y = (q != null) ? q.getVal() : 0;
            int sum = carry + x + y;
            // 计算十位
            carry = sum / 10;
            // 利用取余算个位，并且赋值给新的链表
            curr.setNext( new ListNode(sum % 10));;
            curr = curr.getNext();
            if (p != null){ p = p.getNext();}
            if (q != null) {q = q.getNext();}
        }
        if (carry > 0) {
            curr.setNext(new ListNode(carry));
        }

        System.out.println(JSON.toJSONString(dummyHead.getNext()));

        // 1.hash的理解-将任意长度的输入，转化为固定的长度的输出 -会产生hash冲突，无法避免
        // 好的hash算法特点：1效率高 2不能逆推 3分布均匀
        // 数组+链表+红黑树  都是Node结构，包括key，value，hash，next 四个元素
        // 创建是懒加载机制，只有在put元素的时候才会触发初始化
        // hash 字段存储的是key的hashcode值加工后得到的值。这里是一个扰动函数，将高16位和低16位 异或操作后和和size-1的值按位与操作后得到
        // 扰动的原因是：1让高16位也参与运算，使其能够均匀分布，然后再与size-1 与操作，使其得的的slot的下标不超过table的size
        HashMap<Long, String> longStringHashMap = new HashMap<Long, String>(16, 0.75F);
        longStringHashMap.put(9L,"测试");
        HashMap<Long, String> longStringHashMap1 = new HashMap<Long, String>(16);


       ConcurrentHashMap<Long,String>  cmap =new ConcurrentHashMap<Long, String>(12,0.8F);

        ConcurrentHashMap<Long,String>  cmap2 =new ConcurrentHashMap<Long, String>(12);

        LinkedHashMap<Long, String> longStringLinkedHashMap = new LinkedHashMap<Long, String>(16);
        // 1 看是否初始化， 没有的话触发初始化 resize操作
        // 2 看slot是否为null，如果是null，直接new node操作
        // 3 如果一个节点key相等 直接替换
        // 4 如果已经树化，执行树的put操作
                // - 红黑树写入操作  treeNode 结构继承node结构 包含 左节点，右节点，父节点，上一个节点，和是否red  以及final的root节点等信息
                // 二分查找的思想，从root节点出发，找到插入点的父节点，将该节点放在插入点的左子树或者右子树 （根据父节点的hash值和插入节点的hash值决定左右）
               //  插入节点会打破红黑树的平衡 ，需要通过红黑树的平衡算法来重新计算是红黑树平衡，这里主要用到了左旋，右旋，和变色
               //  如果遇到key相等的节点那就是替换操作

        // 5 一个节点且key不相等（包含单节点和链化节点） - 这里需要判断是否满足树化条件，链表长度大于8
        // 6 执行afterNodeAccess操作，判断是否需要移除老的元素
        // 7 然后老的元素的值

        //            Node<K,V> e; K k;
                      // 当扎到相同节点的时候，替换即可
        //            if (p.hash == hash &&
        //                ((k = p.key) == key || (key != null && key.equals(k))))
        //                e = p;
        //            else if (p instanceof TreeNode)
        //                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        //            else {
                           // ++ 在前，先加 那么从0开始计数，当7的时候就相当于8条记录了，因此下面用了8-1
        //                for (int binCount = 0; ; ++binCount) {

        //                    if ((e = p.next) == null) {
                                // 当下一个节点为空的时候 -说明找不到节点了 那么就是最后一轮
        //                        p.next = newNode(hash, key, value, null);
                                // 判断是否可以需要树化
        //                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
        //                            treeifyBin(tab, hash);
        //                        break;
        //                    }

        //                    if (e.hash == hash &&
        //                        ((k = e.key) == key || (key != null && key.equals(k))))
                            // 当找到该节点的时候  替换，退出循环
        //                        break;
                             // 这里是想下一个节点赋值
        //                    p = e;
        //                }
        //            }

        //            if (e != null) {
                            // existing mapping for key
        //                 // 将老的节点value替换掉
        //                V oldValue = e.value;
        //                if (!onlyIfAbsent || oldValue == null)
        //                    e.value = value;
        //                afterNodeAccess(e);
        //                return oldValue;
        //            }
        longStringHashMap.put(1L,"ceshi");

        //  get操作可以分为两步
        //  Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        //        if ((tab = table) != null && (n = tab.length) > 0 &&
        //            (first = tab[(n - 1) & hash]) != null) {
        //            if (first.hash == hash && // always check first node
        //                ((k = first.key) == key || (key != null && key.equals(k))))
        //                return first;
        //            if ((e = first.next) != null) {
        //                if (first instanceof TreeNode)
        //                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
        //                do {
        //                    if (e.hash == hash &&
        //                        ((k = e.key) == key || (key != null && key.equals(k))))
        //                        return e;
        //                } while ((e = e.next) != null);
        //            }
        //        }
        //        return null;
        //  1 如果当前节点的key值相等，那么就返回该节点
        //  2 如果值不相等且有下一个节点，又分为两种情况，一种树化的，一种链表的
        //   链表用dowhile循环遍历依次按，树化的执行树化的获取方法，核心是红黑树的二分查找 ，从root节点开始找
        longStringHashMap.get(1L);

        // Node<K,V>[] tab; Node<K,V> p; int n, index;
        //        if ((tab = table) != null && (n = tab.length) > 0 &&
        //            (p = tab[index = (n - 1) & hash]) != null) {
        //            Node<K,V> node = null, e; K k; V v;
        //            if (p.hash == hash &&
        //                ((k = p.key) == key || (key != null && key.equals(k))))
        //                node = p;
        //            else if ((e = p.next) != null) {
        //                if (p instanceof TreeNode)
        //                    node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
        //                else {
        //                    do {
        //                        if (e.hash == hash &&
        //                            ((k = e.key) == key ||
        //                             (key != null && key.equals(k)))) {
        //                            node = e;
        //                            break;
        //                        }
        //                        p = e;
        //                    } while ((e = e.next) != null);
        //                }
        //            }
        //            if (node != null && (!matchValue || (v = node.value) == value ||
        //                                 (value != null && value.equals(v)))) {
        //                if (node instanceof TreeNode)
        //                    ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
        //                else if (node == p)
        //                    tab[index] = node.next;
        //                else
        //                    p.next = node.next;
        //                ++modCount;
        //                --size;
        //                afterNodeRemoval(node);
        //                return node;
        //            }
        //        }
        //        return null;

        // 这里就和get有相关了，知道数据以后，基于不同的模式去做地址值得赋值操作了 树化的还会再次出发平衡相关的算法
        //  size 也要做一定的扣减
        longStringHashMap.remove(1L);

        // 红黑树特性
        // 1 非红即黑
        // 2 根节点黑
        // 3 叶子节（NIL）点黑
        // 4 形同颜色不能连续
        // 5 从任何一个节点出发，到叶子节点，黑色的节点数形同 比红色多（黑高红插）

        // 红黑树扩容
        // treeNode 里面仍然有next字段，就是说树化以后，这个链表任然存在，红黑树增删元素仍然会维护这个链表，
        // 那么红黑是的扩容就和普通的链表有相同的扩容机制（根据高低位进行拆分），
        // 不同的点在于，拆分后的链表需要关注链表长度，如果拆分后的链表还是大于6个结点，仍然需要将链表升级为红黑树

    }
}
