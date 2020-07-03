package com.sesshou.leetcode.Dynamic_Programming;

/**
 * @author wp41128
 * @date 2020/5/9 8:20
 * @description：正则表达式匹配
 */
public class Regular_Expression_Matching {
    public static void main(String[] args) {
        Regular_Expression_Matching test=new Regular_Expression_Matching();
        System.out.println(test.isMatch("ab",".*"));
    }
    public boolean isMatch(String s, String p) {
        System.out.println("-----------");
        System.out.println("s:"+s);
        System.out.println("p:"+p);
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean firstMath = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //0个或1到多个
            return isMatch(s, p.substring(2)) || (firstMath && isMatch(s.substring(1), p));
        } else {
            return firstMath && isMatch(s.substring(1), p.substring(1));
        }
    }
}
