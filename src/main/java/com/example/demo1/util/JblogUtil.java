package com.example.demo1.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

 /**
  * @Description:  对密码进行MD5加密的工具类
  */
public class JblogUtil {
    public static Map<String,String> categoryMap;
    static {
        categoryMap = new HashMap<>();
        categoryMap.put("Java","Java");
        categoryMap.put("Web","Web");
        categoryMap.put("Linux","Linux");
        categoryMap.put("分布式系统","Distributed");
        categoryMap.put("数据库","Database");
        categoryMap.put("算法","Algorithm");
        categoryMap.put("其它","Other");
    }
    private static final Logger logger = LoggerFactory.getLogger(JblogUtil.class);

    public static String[] categorys = {"Java","Web","Linux","分布式系统","数据库","算法","其它"};
    public static int ANONYMOUS_USER_ID = 3;


    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            logger.error("生成MD5失败", e);
            return null;
        }
    }
}