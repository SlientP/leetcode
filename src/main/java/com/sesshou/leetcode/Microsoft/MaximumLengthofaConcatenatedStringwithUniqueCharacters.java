package com.sesshou.leetcode.Microsoft;

import java.util.Arrays;
import java.util.List;

/**
 * @author wp41128
 * @date 2020/7/1 10:41
 * @description：字符数组中最大的数字组合
 */
public class MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    public static void main(String[] args) {
        MaximumLengthofaConcatenatedStringwithUniqueCharacters test=new MaximumLengthofaConcatenatedStringwithUniqueCharacters();
        List<String> arr= Arrays.asList("un","iq","ue");
        System.out.println(test.maxLength(arr));
    }
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;

        return maxLengthDFS(arr, 0, 0);
    }

    //此处函数的目的是为了返回串联字符的最大长度
    private int maxLengthDFS(List<String> arr, int start, int bitMask) {
        if (start == arr.size())
            return 0;

        int ans = 0;
        for (int i = start; i < arr.size(); i++) {
            int bit = getBitMask(arr.get(i));
            if (bit == 0 || (bitMask & bit) != 0) continue;
            //一。当前字符没有重复的
            //二。和之前没有重复的
            //满足上述两个条件才进入一下层递归。
            ans = Math.max(ans, maxLengthDFS(arr, i + 1, bitMask | bit) + arr.get(i).length());
        }
        return ans;
    }

    private int getBitMask(String s) {
        int bitMask = 0;
        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((bit & bitMask) != 0) return 0;
            bitMask |= bit;
        }
        return bitMask;
    }

}
