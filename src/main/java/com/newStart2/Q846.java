package com.newStart2;

import java.util.*;

public class Q846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n =hand.length;
        if(n%groupSize!=0) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i], 0)+1);
        }
        for(int i=0;i<hand.length;i++){
            if(!map.containsKey(hand[i])) continue;
            for(int j=0;j<groupSize;j++){
                int temp=hand[i]+j;
                if(!map.containsKey(temp)) return false;
                else{
                    map.put(temp,map.get(temp)-1);
                }
                if(map.get(temp)==0) map.remove(temp);
            }
        }
        return true;
    }
}
