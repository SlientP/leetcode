package com.newStart2;

public class Q245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int len=wordsDict.length;
        int cuur=0;
        int res=len;
        while (cuur<len) {
            while (cuur<len&&!wordsDict[cuur].equals(word1)) cuur++;
            if(cuur<len&&wordsDict[cuur].equals(word1)) {
                int i = 1;
                while ((cuur + i < len || cuur - i >= 0) && i < res) {
                    if (cuur + i < len && wordsDict[cuur + i].equals(word2)) res = Math.min(i, res);
                    if (cuur - i >= 0 && wordsDict[cuur - i].equals(word2)) res = Math.min(i, res);
                    i++;
                }
            }
            cuur++;
        }
        return res;
    }
}
