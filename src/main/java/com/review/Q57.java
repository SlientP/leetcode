package com.review;

import java.util.LinkedList;
import java.util.List;

//57. Insert Interval
public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m=intervals.length;
        if(m==0) return new int[][]{{newInterval[0],newInterval[1]}};
        List<int[]> result=new LinkedList<>();
        result.add(new int[]{newInterval[0],newInterval[1]});
        for (int i = 0; i < intervals.length; i++) {
            int L=intervals[i][0],R=intervals[i][1];
            if(L>result.get(result.size()-1)[1]){
                result.add(new int[]{L,R});
            }else if(R<result.get(result.size()-1)[0]){
                result.add(result.size()-1,new int[]{L,R});
            }else{
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],R);
                result.get(result.size()-1)[0]=Math.min(result.get(result.size()-1)[0],L);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
