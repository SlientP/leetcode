package com.newStart2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Q220 {
    public static void main(String[] args) {
        Q220 test=new Q220();
        int[] nums=new int[]{2147483640,2147483641};
        test.containsNearbyAlmostDuplicateV2(nums,1,100);
    }
    //out of time limit
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len=nums.length;
        if(len==0) return false;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < len-i; j++) {
                if(Math.abs((long)nums[j]-(long)nums[j+i])<=t) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicateV2(int[] nums, int k, int t) {
        TreeSet<Long> tree=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //查找后面一个元素 即大于当前元素的最小值
            Long s=tree.ceiling((long)nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // 查找前面一个元素 即小于当前元素的最大值
            Long g = tree.floor((long)nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            tree.add((long)nums[i]);

            //保证树最小（即滑动窗口） 节约查找时间
            if (tree.size() > k) {
                tree.remove(nums[i - k]);
            }

        }
        return false;
    }

    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicateV3(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

}
