package com.newStart.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q336 {
    public static void main(String[] args) {
        System.out.println("123");
    }
    //暴力解法  超时
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        int len= words.length;
        if(len<=1) return result;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len ; j++) {
                if(i!=j&&isPalindrome(words[i]+words[j])){
                    List<Integer> item=new ArrayList<Integer>();
                    item.add(i);
                    item.add(j);
                    result.add(item);
                }
            }
        }
        return result;
    }
    private boolean isPalindrome(String s){
        int len=s.length();
        int L=0;
        int R=len-1;
        while (L<R){
            if(s.charAt(L)!=s.charAt(R)) return false;
            L++;R--;
        }
        return true;
    }
    class Node {
        int[] ch = new int[26];
        int flag;

        public Node() {
            flag = -1;
        }
    }

    List<Node> tree = new ArrayList<Node>();

    public List<List<Integer>> palindromePairsV2(String[] words) {
        tree.add(new Node());
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(words[i], j, m - 1)) {
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = findWord(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public void insert(String s, int id) {
        int len = s.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                tree.add(new Node());
                tree.get(add).ch[x] = tree.size() - 1;
            }
            add = tree.get(add).ch[x];
        }
        tree.get(add).flag = id;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }

}
