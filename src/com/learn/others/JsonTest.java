package com.learn.others;

import com.alibaba.fastjson.JSON;
import com.learn.common.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetCode
 * @description: json测试
 * @author: 空见
 * @create: 2021-04-08 14:54
 */

public class JsonTest {
    public static void main(String[] args) {


        String gmodel = "3|0|390PCS,坐具|铁制|可调节|SONGMICS";

        System.out.println(gmodel.contains(gmodel));
        User user = new User();

        user.setLike("play");
        user.setUserName("测试");
        user.setId(1L);

        System.out.println(JSON.toJSONString(user));

        String s = "{\"id\":1,\"like\":\"play\",\"userName\":\"测试\",\"grade\":\"1\"}";

        User user1 = JSON.parseObject(s, User.class);
        System.out.println(user1);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(5, 9);
        System.out.println(map.get(6));
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(10);
        list.add(17);
        list.add(18);
        list.add(20);
        list.add(21);
        list.add(26);
        list.add(27);
        list.add(28);
        list.add(29);
        StringBuffer stringBuffer = buildSorter(list);
        System.out.println(stringBuffer.toString());
    }

    private static StringBuffer buildSorter(List<Integer> gNoList) {
        StringBuffer sb = new StringBuffer();
        if (gNoList.size() == 1) {
            sb.append(gNoList.get(0));
            return sb;
        }
        // a 当前值 ，b 下一个值 c 临时存储当前值
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int count = 0;


        for (int i = 0; i < gNoList.size(); i++) {
            // 第一次进来，赋值为基础 什么不做
            a = gNoList.get(i);
            if (0 == i) {
                c = a;
                d = a;
                b = a + 1;
                continue;
            } else if (i == gNoList.size() - 1) {
                // 最后一个
                if (b == a) {
                    // 和上一轮连续
                    d = a;
                    sb.append(c).append("-").append(d);
                } else {
                    if (c == d) {
                        sb.append(c).append("、");
                        sb.append(a);
                    } else {
                        sb.append(c).append("-").append(d).append("、");
                        sb.append(a);
                    }
                }

                continue;
            }

            // 第二次或者第N次进来
            a = gNoList.get(i);
            if (b == a) {
                // 值是连续的

                d = a;
                count++;
            } else {
                // 不连续的 -触发存储
                if (0 == count) {
                    sb.append(c).append("、");
                    c = a;
                    d = a;
                } else {
                    // c ！=d
                    sb.append(c).append("-").append(d).append("、");
                    c = a;
                }
                count = 0;

            }
            b = a + 1;

        }

        return sb;
    }
}
