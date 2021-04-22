package com.learn.others;



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @program: leetCode
 * @description: 中文校验
 * @author: 空见
 * @create: 2021-02-23 16:33
 */

public class ChineseCheck {

    public static void main(String[] args) {
        String str = "-99.99我91";
      //  List<String> list = new ArrayList<String>();
       System.out.println("==> " + isContainChinese(str));
       // System.out.println(str.startsWith("R"));
    }


    /**
     * 字符串是否包含中文
     * @param str 待校验字符串
     * @return true 包含中文字符 false 不包含中文字符
     */
    public static boolean isContainChinese(String str) {


       String regix = "[\\u4e00-\\u9fa5]";
       return find(regix,str);
    }

    public static boolean find(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        return matcher.find();
    }

    public static boolean match(String regex, String value) {
        if (null==value) {
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(value).matches();
    }


    public static boolean matchLicenseNO(String value) {
        return match("(\\d|[A-Za-z]){2}-(\\d|[A-Za-z]){2}-(\\d|[A-Za-z])*", value);
    }
    public static boolean matchFee(String value){
        return match("^(0|[1-9][0-9]?)(\\.[0-9]{0,3}[1-9])?$", value);
    }
    public static boolean matchFeeTwo(String value){
        return match("^(0|[0-9][0-9]{0,9}?)(\\.[0-9]{0,3}[0-9])?$", value);
    }
    public static boolean matchThree(String value){
        return match("^(0|[1-9][0-9]?)(\\.[0-9]{0,3}[1-9])?$", value);
    }


    public static boolean matchPackNO(String value){
        return match( "^(0|[1-9][0-9]{0,8}?)", value);
    }

    private static boolean matchQty1(String value) {
         return match( "^(0|[1-9][0-9]{0,13}?)(\\.[0-9]{0,4}[0-9])?$", value);
    }


    public static boolean matchGrossWt(String value){
        return match( "^(0|[1-9][0-9]{0,13}?)(\\.[0-9]{0,4}[0-9])?$", value);
    }
    public static boolean matchGrossWtTwo(String value){
        return match(  "^(0)(\\.[0-9]{0,4}[1-9])?$", value);
    }


    public static boolean matchOtherOne(String value){
        return match("^(-)?(0|[1-9][0-9]?)(\\.[0-9]{0,3}[1-9])?$",value);
    }

}
