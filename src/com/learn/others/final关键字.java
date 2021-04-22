package com.learn.others;

import com.alibaba.fastjson.JSON;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetCode
 * @description:
 * @author: 空见
 * @create: 2021-03-22 14:27
 */

public class final关键字 {
    public static void main(String[] args) {
        String a = "a";
        final String s = a;
        System.out.println(s);
        a = "5";
        System.out.println(s);
        System.out.println(a);

        String number = "10.00.0";
        String s1 = number.trim().toUpperCase();

        String[] split = s1.split("");
        int count = 0;
        for (int i = split.length - 1; i > 0; i--) {
            if ("0".equals(split[i]) || ".".equals(split[i])) {
                count++;
            }else {
                break;
            }

        }

        String substring = number.substring(0, number.length() - count);
        System.out.println(substring);

        // 处理尾数为0 ，且包含小数点的数据  2.000
        if (number.endsWith("0") && number.contains(".")) {
            //  如果值中包含0 和 .
            int zeroCount = 0;
            for (int i = number.length() - 1; i > 0; i--) {
                if (number.substring(i, i + 1).equals("0") || ".".equals(number.substring(i,i+1))) {
                    zeroCount++;
                } else {
                    break;
                }
            }
            // 计算尾部开始的0的总个数，然后截取尾数非0的数据部分
            number = number.substring(0, number.length() - zeroCount);
            System.out.println("-----"+number);
        }



        System.out.println("---------------------------------------");





        String gModel = "0|2|光面||无型号||无品牌|无型号||";
        String mainfactor = "0:品牌类型;1:出口享惠情况;2:外观（板、片、带等）;3:是否海绵橡胶;4:规格尺寸;5:材质;6:品牌（中文及外文名称）;7:型号;8:GTIN;9:CAS";

        String[] mainFactorArr = mainfactor.split(";");
        String[] gModelArr = gModel.split("\\|");
        System.out.println(JSON.toJSONString(mainFactorArr));
        System.out.println(JSON.toJSONString(gModelArr));
        if ((mainFactorArr.length > gModelArr.length + 2) || gModel.contains("||||")) {
            //如果传入的字符串为很少,相差的长度大于等于3,那么也有必填字段为空
            //如果传入的字符串为0|2|23616PCS/带外壳||无品牌|无型号||||。那么将也有必填字段为空
            System.out.println(JSON.toJSONString("命中"));
            return;
        }


        for (int j = 0; j < gModel.length(); j++) {
            int one = j;
            int anotherOne = j + 1;
            int thridOne = j + 2;
            if ((anotherOne >= gModel.length()) || (thridOne >= gModel.length())) {
                break;
            }
            //传入的字符串存在||xx字符串
            if ("|".equals(String.valueOf(gModel.charAt(j))) && "|".equals(String.valueOf(gModel.charAt(anotherOne))) && !"|".equals(String.valueOf(gModel.charAt(thridOne)))) {
                //证明后面还有GTIN/CAS/其他等非必填字段
                String otherStr = gModel.substring(thridOne, gModel.length());
                Pattern pattern = Pattern.compile(".*?\\|.*?\\|");
                Matcher matcher = pattern.matcher(otherStr);
                if (matcher.find()) {
                    System.out.println(JSON.toJSONString("命中"));
                    break;
                }
            }
        }
        // todo 这里有个小BUG,需要在上面进行一个熔断参数申明
        for (int j = 0; (j < gModelArr.length && j < mainFactorArr.length); j++) {
            if (mainFactorArr[j].contains("GTIN")) {
                break;
            }
            if ("".equals(gModelArr[j].trim())) {
                System.out.println(JSON.toJSONString("命中"));
                break;
            }
        }
    }

}
