package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String result;
        result = "pwwkew";
//        result = "bbbbbb";
//        result = "abcabdac";

//        System.out.println(lengthOfLongestSubstring(result));

//        int size = 1;
//        for (int size = 2; size < result.length(); size++) {
//
//            for (int i = 0; i + size <= result.length(); i++) {
//                String s1 = result.substring(i, i + size);
//                System.out.println("1----" + s1);
//                boolean flag = true;
//                for (int j = i + 1; j + size <= result.length(); j++) {
//                    String s2 = result.substring(j, j + size);
//                    if (s1.equals(s2)) {
//                        flag = false;
//                    }
//                    System.out.println("2----" + s2);
//                }
//                if (flag) {
//                    System.out.println("result - " + s1 + " - " + s1.length());
//                }
//            }
//        }

        boolean flag = false;
        String target = "";
        for (int z = result.length(); z >1; z++) {
            target = result.substring(0,z);
            for (int i = 0; i < result.length(); i++) {
                String s1 = result.substring(i, i + 1);
                for (int j = 0; j < result.length(); j++) {
                    if (j == i) {
                        continue;
                    }
                    String s2 = result.substring(j, j + 1);
                    flag = s1.equals(s2);
                }
            }
        }



//        //截取长度
//        int index = result.length();
//        //遍历起始点
//        int i2 = 0;
//        //字符串截取起始点
//        int i = i2;
//        //字符串截取中止点
//        int j = i + index;
//        //目标字符串
//        String t1 = "";
//        //对比字符串
//        String t2 = "";
//        //结果字符串
//        String t3 = "";
//
//        while (index >0) {
//            while (i < result.length() && j <= result.length()) {
//                if (Strings.isEmpty(t1)) {
//                    //获取标目字符串
//                    t1 = result.substring(i, j);
//                    t3 = t1;
//                } else {
//                    //获取对比字符串并对比
//                    t2 = result.substring(i,j);
//                    if (!t1.equals(t2)) {
//                        return;
//                    }
//                    System.out.println(t1);
//                }
//
//                i++;
//                j++;
//            }
//            //重置目标字符串
//            t1 = "";
//            //截取长度递减
//            index--;
//            //起始点递增
//            i2 ++;
//            i = i2;
//            j = i + index;
//        }
//        System.out.println("r -- "+t3);

//        for (int z = 1; z < result.length(); z++) {
//            for (int i = 0, j = i + z; i < result.length() && j <= result.length(); i++, j++) {
//                System.out.println(result.substring(i, j));
//            }
//        }


    }

    public static int lengthOfLongestSubstring(String s) {
        String result = "";
//        for (int i = s.length()-1; i > 0; i--) {
//            String s1=s.substring(i);
//
//        }
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(0, i);
            for (int j = i; j < s.length() && j + i < s.length(); j += i) {
                String t2 = s.substring(i, j);
//                if ()
            }
        }
        return result.length();
    }
}
