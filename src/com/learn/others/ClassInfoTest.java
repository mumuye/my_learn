package com.learn.others;

import com.alibaba.fastjson.JSON;
import com.learn.common.User;

import java.lang.reflect.Field;

/**
 * @program: leetCode
 * @description: 类测试
 * @author: 空见
 * @create: 2021-03-01 23:14
 */

public class ClassInfoTest {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUserName("测试");
        user.setLike("codeing");

        Field[] declaredFields = user.getClass().getDeclaredFields();
        StringBuffer s = new StringBuffer("测试");
        for (Field declaredField : declaredFields) {
            s.append("一个");
            declaredField.setAccessible(Boolean.TRUE);
            try {
                if(Long.class.equals(declaredField.getType())){
                    continue;
                }
                declaredField.set(user,s.toString());
            } catch (IllegalAccessException e) {
                System.out.println("异常了");
                e.printStackTrace();
            }
        }

        System.out.println(JSON.toJSONString(user));
    }
}
