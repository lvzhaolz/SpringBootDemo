package com.example.demo;

import com.example.demo.config.DemoConfig;
import com.example.demo.model.CustomBean;
import com.example.demo.model.MyBeanTest;
import com.example.demo.model.MyBeanTest2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {

    @Autowired
    @Qualifier("customBean555")
    public CustomBean customBean;

    @Test
    public void testCustomBean() {
        System.out.println(customBean);
    }

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        MyBeanTest myBeanTest1 = (MyBeanTest) context.getBean("MyBeanTest");
        MyBeanTest myBeanTest2 = (MyBeanTest) context.getBean("MyBeanTest2");
        MyBeanTest2 myBeanTest21 = context.getBean(MyBeanTest2.class);
        System.out.println(myBeanTest1 + "\n" + myBeanTest2 + "\n" + myBeanTest21);
    }

    public static void main(String[] arg) {
//        String s1= "mississippi";
//        String s2 ="mis*is*ip*.";

//        String s1 = "aaa";
//        String s2 = "a*a";

//        String s1 = "aaa";
//        String s2 = "aa";

//        String s1 = "aaa";
//        String s2 = "a*";

//        String s1 = "mississippi";
//        String s2 = "mis*is*p*.";

//        String s1 = "aab";
//        String s2 = "c*a*b*";
//
//        System.out.println("---------------------");
//        System.out.println(Solution.isMatch2(s1, s2));
//        System.out.println("---------------------");


        int[] arr = new int[]{5, 1, 1, 1, 7, 1, 8};
        quickSort(arr, 0, arr.length - 1);

    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static class Solution {
        public static boolean isMatch2(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }

        public static boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }


        private static boolean isMatchChild(String s1, String s2) {
            char c1 = s1.charAt(s1.length() - 1);
            char c2 = s2.charAt(s2.length() - 1);
            boolean isStart = false;
            if (c2 == '*') {
                isStart = true;
                c2 = s2.charAt(s2.length() - 2);
            }

            if (c1 != c2) {
                return false;
            } else {
                return isMatchChild(s1.substring(0, s1.length()), s2);
            }


        }

        public static boolean isMatch(String s, String p) {
            if (p.length() < 2) {
                return s.equals(p) || (p.equals(".") && s.length() == 1);
            }
            if (p.length() == 2 && p.charAt(1) == '*') {
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c != p.charAt(0) && p.charAt(0) != '.') {
                        return false;
                    }
                }
                return true;
            }
            int index = 0;
            int pIndex = 0;
            while (index < s.length()) {
                char c = s.charAt(index);
                char pc = p.charAt(pIndex);

                if (c == pc || pc == '.') {
                    index++;
                    pIndex++;
                } else if (pc == '*') {
                    char pc2 = p.charAt(pIndex - 1);
                    if (c == pc2 || pc2 == '.') {
                        index++;
                        if (index == s.length()) {
                            pIndex++;
                        }
                    } else {
                        pIndex++;
                    }

                } else {
                    if (pIndex + 1 != p.length() && p.charAt(pIndex + 1) == '*') {
                        pIndex++;
                    } else {
                        return false;
                    }
                }

                if (pIndex == p.length() && pc != '*') {
                    break;
                }
            }

            if (pIndex != p.length() && p.charAt(pIndex) == '*') {
                char c = p.charAt(pIndex - 1);
                pIndex++;
                while (pIndex < p.length()) {
                    char cc = p.charAt(pIndex);
                    if (c == cc || c == '.') {
                        pIndex++;
                    } else {
                        break;
                    }
                }
            }

            return index == s.length() && pIndex == p.length();
        }
    }

}
