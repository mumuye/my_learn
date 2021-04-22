package com.learn.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @program: leetCode
 * @description: 跳跃表
 * @author: 空见
 * @create: 2021-03-13 21:35
 */

public class ConcurrentSkipListMapLearn {
    /*
    * 1.跳跃表长什么样子
    * 2.跳跃表如何查找指定key的数据？
    * 3.跳跃表如何添加指定key_value的数据呢？
    * 4.跳跃表如何删除指定key数据额呢？
    * */


    //   * Head nodes          Index nodes
    //     * +-+    right        +-+                      +-+
    //     * |2|---------------->| |--------------------->| |->null
    //     * +-+                 +-+                      +-+
    //     *  | down              |                        |
    //     *  v                   v                        v
    //     * +-+            +-+  +-+       +-+            +-+       +-+
    //     * |1|----------->| |->| |------>| |----------->| |------>| |->null
    //     * +-+            +-+  +-+       +-+            +-+       +-+
    //     *  v              |    |         |              |         |
    //     * Nodes  next     v    v         v              v         v
    //     * +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+
    //     * | |->|A|->|B|->|C|->|D|->|E|->|F|->|G|->|H|->|I|->|J|->|K|->null
    //     * +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+  +-+
    //     *

    // 原则 ：1.最底层数据节点按照关键字升序排列
    //        2.包含多级索引，每个级别索引节点按照其关联数据节点的关键字升序排列
    //        3.高级别索引是低级别索引的子集
    //        4.如果关键字key在级别level=i的索引中出现，则级别level<i的所有索引中都包含key


    public static void main(String[] args) {
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        concurrentSkipListMap.put("5","测试");
        Map<String ,String> map = new HashMap<String, String>();
        concurrentSkipListMap.get("5");
    }




}
