package com.sesshou.leetcode.Microsoft;

import com.sun.scenario.effect.impl.HeapImage;

import java.util.*;

/**
 * @author wp41128
 * @date 2020/6/30 7:40
 * @description：会议室2
 */
public class Meeting_Rooms_II {
    public static void main(String[] args) {
        Meeting_Rooms_II test=new Meeting_Rooms_II();
        int[][] nums=new int[][]{{13,15},{1,13}};
        System.out.println(test.minMeetingRoomsV4(nums));
    }
    //超出时间限制
    public int minMeetingRooms(int[][] intervals) {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        int m=intervals.length;
        for (int i = 0; i < m ; i++) {
            fillMap(map,intervals[i][0],intervals[i][1]);
        }
        int max=0;
        for (Integer key: map.keySet()) {
            max=Math.max(max,map.get(key));
        }
        return max;
    }
    private void fillMap(Map<Integer,Integer> map,int start,int end){
        for (int i = start; i <end ; i++) {
            if(map.get(i)!=null){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
    }
    //优先队列（最小堆）
    public int minMeetingRoomsV2(int[][] intervals) {
        int m=intervals.length;
        if(m==0) return 0;

        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        queue.add(intervals[0][1]);
        for (int i = 1; i < m; i++) {
            if(intervals[i][0]>=queue.peek()){
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }
    //有序化
    public int minMeetingRoomsV3(int[][] intervals) {
        int m=intervals.length;
        if(m==0) return 0;

        Integer[] start=new Integer[m];
        Integer[] end=new Integer[m];
        for (int i = 0; i < m; i++) {
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Arrays.sort(end, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int startPoint=0;
        int endPoint=0;
        int rooms=0;
        while (startPoint<m){
            if(start[startPoint]>=end[endPoint]){
                rooms--;
                endPoint++;
            }
            startPoint++;
            rooms++;
        }
        return rooms;
    }

    //同一时间进行的最大数量
    public int minMeetingRoomsV4(int[][] intervals) {
        int m=intervals.length;
        if(m==0) return 0;
        int[][] times=new int[m*2][2];
        for (int i = 0; i < m; i++) {
            times[2*i][0]=intervals[i][0];
            times[2*i][1]=1;
            times[2*i+1][0]=intervals[i][1];
            times[2*i+1][1]=-1;
        }
        Arrays.sort(times, new Comparator<int[]>() {
           public int compare(int[] o1, int[] o2) {
               return o1[0]-o2[0]==0?o1[1]-o2[1]: o1[0]-o2[0];
           }
        });
        int cur=0;
        int rooms=0;
        for (int i = 0; i < m*2; i++) {
            cur+=times[i][1];
            rooms=Math.max(rooms,cur);
        }
        return rooms;
    }
}
