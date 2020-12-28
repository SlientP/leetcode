package com.newStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//排序后，遍历一遍，利用list添加的有序性来扩展整个表
public class Q56 {

    public int[][] merge(int[][] intervals) {
        int m=intervals.length;
        if(m==0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> result=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L=intervals[i][0],R=intervals[i][1];
            if(result.size()==0||result.get(result.size()-1)[1]<L){
                result.add(new int[]{L,R});
            }else{
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],R);
            }
        }
        return  result.toArray(new int[result.size()][]);
    }

}
