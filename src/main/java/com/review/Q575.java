package com.review;

import java.util.HashSet;
import java.util.Set;

//575. Distribute Candies
public class Q575 {
    public int distributeCandies(int[] candyType) {
        int len=candyType.length;
        int L=0;
        Set<Integer> set=new HashSet<>();
        while(L<len){
            if(set.isEmpty()||!set.contains(candyType[L])){
                set.add(candyType[L]);
            }
            L++;
        }
        return set.size()>len/2?len/2:set.size();
    }
}
