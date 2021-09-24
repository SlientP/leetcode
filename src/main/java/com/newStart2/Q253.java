package com.newStart2;

import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;
import java.util.Comparator;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        Integer[] start=new Integer[intervals.length];
        Integer[] end=new Integer[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(
                start,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });
        Arrays.sort(end, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        int startP=0;
        int endP=0;
        int room=0;
        for (int i = 0; i < intervals.length; i++) {
            if(start[startP]<end[endP]){
                room++;
                startP++;
            }else{
                endP++;
                room--;
            }
        }
        return room;
    }
}
