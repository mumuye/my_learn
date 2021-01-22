package threadLoacalTest;


import com.alibaba.fastjson.JSONObject;

import java.lang.ref.WeakReference;
import java.util.Set;

/**
 * @program: leetCodeS
 * @description: threadLocal学习
 * @author: 空见
 * @create: 2021-01-11 16:35
 */

public class ThreadLocalLearn {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
    private static ThreadLocal<JSONObject> threadLocal2 = new ThreadLocal<JSONObject>();



    public static void main(String[] args) {

        threadLocal.set("test");
        threadLocal2.set(new JSONObject());

        Thread thread = Thread.currentThread();
        String s = threadLocal.get();
        JSONObject object = threadLocal2.get();
        System.out.println(s);
        System.out.println(object);
        threadLocal.remove();


    }

    // 扩容resize()时候，如果发现有KEY为null的数据，将value也设置为null


}
