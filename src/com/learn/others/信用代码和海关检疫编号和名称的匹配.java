package com.learn.others;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: leetCode
 * @description:
 * @author: 空见
 * @create: 2021-03-26 14:54
 */

public class 信用代码和海关检疫编号和名称的匹配 {

    public static void main(String[] args) {
        String   s = "浙江达柏林阀门有限公司 9133102169125878XA";
        HashMap<String, String> nameAnd18And10Map = getNameAnd18And10Map(s);
        System.out.println(JSON.toJSONString(nameAnd18And10Map));
    }



    public static HashMap<String, String> getNameAnd18And10Map(String str) {
        HashMap<String, String> resultMap = new HashMap<String, String>(16);
        resultMap.put("newCode", "");
        resultMap.put("code", "");
        resultMap.put("name", "");

        String temp = "";
        String regNewCode = "[0-9A-Za-z]{18}?"; // 18位数字或字母
        String regCode = "(?=.*\\d)[a-zA-Z\\d]{10}"; // 10位数字或字母
        String regName = "([\\u4e00-\\u9fa5\\s\\(\\)]{2,})|([a-zA-Z\\s]{10,})"; // 中文或英文（允许出现空格
        //攀 升 服 装 宁 波 有 限 公司 APPAREL NINGBO
        Pattern regNewPattern = Pattern.compile(regNewCode);
        Matcher regNewMatcher = regNewPattern.matcher(str);
        if (regNewMatcher.find()) {
            temp = regNewMatcher.group().trim();
            resultMap.put("newCode", temp.replaceAll(" ", "").toUpperCase());
        }
        str = str.replaceAll(temp, "");

        Pattern codePattern = Pattern.compile(regCode);
        Matcher codeMatcher = codePattern.matcher(str);
        if (codeMatcher.find()) {
            temp = codeMatcher.group().trim();
            resultMap.put("code", temp.replaceAll(" ", "").toUpperCase());
        }
        str = str.replaceAll(temp, "");

        Pattern namePattern = Pattern.compile(regName);
        Matcher nameMatcher = namePattern.matcher(str);
        if (nameMatcher.find()) {
            temp = nameMatcher.group().trim();
            resultMap.put("name", temp);
        }
        return resultMap;
    }

}
