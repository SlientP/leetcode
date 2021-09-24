package com.newStart2;



public class Q243 {

    public static void main(String[] args) {
        String[] wordsDict=new String[]{"a","b","c","d","d"};
        Q243 test=new Q243();
        test.shortestDistance(wordsDict,"a","d");
    }
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
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

    public int shortestDistanceV2(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        int currentDistance;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }

}
