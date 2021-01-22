package threadLoacalTest;

import lombok.Data;

/**
 * @program: leetCode
 * @description: test
 * @author: 空见
 * @create: 2021-01-12 11:25
 */


public class ThreadDemo2 {

    ThreadLocal<String> test = new ThreadLocal<String>();

    private String content;

    public String getContent() {

        return test.get();
    }

    public void setContent(String content) {
        test.set(content);
        this.content = test.get();
    }


    public static void main(String[] args) {

        final ThreadDemo2 demo = new ThreadDemo2();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println(Thread.currentThread().getName() + "------------------------");
                    System.out.println(Thread.currentThread().getName() + "---->" + demo.getContent());
                }
            });

            thread.setName("线程" + i);
            thread.start();
        }

        Thread thread = Thread.currentThread();
    }

}
