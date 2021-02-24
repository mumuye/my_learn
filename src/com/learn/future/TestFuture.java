package com.learn.future;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: leetCode
 * @description: testFuture
 * @author: 空见
 * @create: 2021-02-18 09:51
 */

public class TestFuture {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newScheduledThreadPool(5);
        List<Future> list=new ArrayList<Future>();

        for (int i = 0; i < 10; i++) {
            Future result1 = executor.submit( new Callable() {
                @Override
                public Integer call() throws Exception {
                    Integer  sum = 0;
                    Thread.sleep( 1000 );
                    System.out.println(sum +""+ new Date());
                    sum++;
                    System.out.println("多线程内部"+sum+Thread.currentThread().getName());
                    return sum;
                }

            });
            list.add( result1 );
        }

        Future result2 = executor.submit(new Callable() {

            @Override
            public Integer call() throws Exception {
                int sum = 1314;
                System.out.println(sum+Thread.currentThread().getName());
                Thread.sleep( 1000 );
                System.out.println(new Date());
                return sum;
            }

        });
        list.add(result2);
        System.out.println(result2.get());


        System.out.println(list.size());

      /*  for (int i = 0; i < 10; i++) {
            Future result1 = executor.submit( new Callable() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    Thread.sleep( 1000 );
                    System.out.println(sum+"333333"+Thread.currentThread().getName());
                    return sum;
                }

            });

        }*/
        for(Future f: list){
            System.out.println( "多线程结果集"+f.get()+Thread.currentThread().getName());
        }
        System.out.println(list.size());


        executor.shutdown();

       // System.out.println(result2.get());

    }


}
