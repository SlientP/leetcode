package com.review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

//349. Intersection of Two Arrays
public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        List<Integer> result=new ArrayList<>();
        if(len1==0||len2==0) return new int[]{};
        Set<Integer> set=new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if(set.contains(nums1[i])){
                result.add(nums1[i]);
                set.remove(nums1[i]);
            }
        }
        int[] resultarray=new int[result.size()];
       for (int i = 0; i < resultarray.length; i++) {
           resultarray[i]=result.get(i);
       }
       return resultarray;
    }
}
