package com.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 3Sum
// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Example 2:
// Input: nums = []
// Output: []

// Example 3:
// Input: nums = [0]
// Output: []
// 我没有做出来
public class Q15 {
    public static void main(String[] args) {
        Q15 test=new Q15();
        test.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                // b之后最小的都大于target 所以不可能存在解
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    // 超出时间限制
    public void dfs(List<List<Integer>> result,List<Integer> temp,int start,int sum,int[] array){
        if(sum==0&&temp.size()==3) result.add(new ArrayList<>(temp));
        if(sum>0||temp.size()>3) return;
        for (int i = start; i < array.length; i++) {
            if(i>start&&array[i]==array[i-1]) continue;
            sum+=array[i];
            temp.add(array[i]);
            dfs(result,temp,i+1,sum,array);
            sum-=array[i];
            temp.remove(temp.size()-1);
        }
    }
}
