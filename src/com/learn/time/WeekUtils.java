package com.learn.time;

import com.alibaba.fastjson.JSON;
import com.learn.common.PageData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: sport-code
 * @description: 周服务
 * @author: 空见
 * @create: 2021-05-18 20:34
 */

public class WeekUtils {


    public static void main(String[] args) throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        // 以周一作为本周的第一天
        Calendar cal1 = (Calendar) cal.clone();
        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date time = cal1.getTime();
        PageData pageData = new PageData();
        pageData.setPageNo(1);
        pageData.setPageSize(5);

        for (int i = 0; i < pageData.getPageSize(); i++) {
            // 拿几周数据 计算开始和介绍时间
            List<String> list = getDays(pageData, i, time);

            System.out.println(JSON.toJSONString(list));
            String month = getMonth(pageData, i, time);
            System.out.println(month);

            String nextDay = getNextDay(pageData, i, new Date());
            System.out.println(nextDay);


        }

    }

    public static List<String> getDays(PageData pageData, int i, Date time) {
        Integer pageSize = pageData.getPageSize();
        Integer pageNo = pageData.getPageNo();
        List<String> strings = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);

        // 先处pageNo
        calendar.add(Calendar.DAY_OF_WEEK, -(pageNo - 1) * pageSize * 7);

        if (i == 0) {
            for (int a = 0; a < 7; a++) {
                if (a == 0) {
                    calendar.add(Calendar.DAY_OF_WEEK, 0);
                    String format = sdf.format(calendar.getTime());
                    strings.add(format);
                } else {
                    calendar.add(Calendar.DAY_OF_WEEK, 1);
                    String format = sdf.format(calendar.getTime());
                    strings.add(format);
                }

            }
        } else {
            for (int a = 0; a < 7; a++) {

                if (a == 0) {
                    calendar.add(Calendar.DAY_OF_WEEK, -i * 7);
                    String format = sdf.format(calendar.getTime());
                    strings.add(format);
                } else {
                    calendar.add(Calendar.DAY_OF_WEEK, 1);
                    String format = sdf.format(calendar.getTime());
                    strings.add(format);
                }

            }

        }
        return strings;

    }

    public static String getMonth(PageData pageData, int i, Date time) {
        Integer pageSize = pageData.getPageSize();
        Integer pageNo = pageData.getPageNo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        // 先处pageNo
        calendar.add(Calendar.MONTH, -(pageNo - 1) * pageSize);
        calendar.add(Calendar.MONTH, -i);
        return sdf.format(calendar.getTime());
    }

    public static String getNextDay(PageData pageData, int i, Date time) {
        Integer pageNo = pageData.getPageNo();
        Integer pageSize = pageData.getPageSize();
        // 这个time是当期那时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);

        // 先处pageNo
        calendar.add(Calendar.DAY_OF_WEEK, -(pageNo - 1) * pageSize);

        // 该页开始的时间

        calendar.add(Calendar.DAY_OF_WEEK, -i);


        return sdf.format(calendar.getTime());

    }
}
