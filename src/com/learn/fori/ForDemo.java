package com.learn.fori;

import lombok.Data;

import java.util.Date;


/**
 * @program: leetCode
 * @description: test
 * @author: 空见
 * @create: 2021-01-12 11:25
 */

@Data
public class ForDemo {



    public static void main(String[] args) throws InterruptedException {

     /*   for (;;) {
            Thread.sleep(1000);

            System.out.println(getInteger());
        }
*/

        Date date = new Date();
        int myyear =  date.getYear();
        int mymonth = date.getMonth()+1;
        int myweekday = date.getDate();
        if(mymonth < 10){
            mymonth = 0 + mymonth;
        }
        if(myweekday < 10){
            myweekday = 0 + myweekday;
        }

        System.out.println(myyear+"-"+mymonth + "-" + myweekday);
    }

    private static double getInteger() {

        return Math.random();
    }

}
