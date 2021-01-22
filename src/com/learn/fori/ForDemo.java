package com.learn.fori;

import lombok.Data;


/**
 * @program: leetCode
 * @description: test
 * @author: 空见
 * @create: 2021-01-12 11:25
 */

@Data
public class ForDemo {



    public static void main(String[] args) throws InterruptedException {

        for (;;) {
            Thread.sleep(1000);

            System.out.println(getInteger());
        }
    }

    private static double getInteger() {

        return Math.random();
    }

}
