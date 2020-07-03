package com.sesshou.leetcode.Dynamic_Programming;

import java.util.Arrays;

/**
 * @author wp41128
 * @date 2020/5/25 15:23
 * @description：视频拼接
 */
public class Video_Stitching {


    public static void main(String[] args) {
        Video_Stitching test=new Video_Stitching();
        int[][] nums=new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        System.out.println(test.videoStitchingV2(nums,10));
    }
    public int videoStitching(int[][] clips, int T) {
        int start=0;
        int end=0;
        int count=0;
        int len=clips.length;
        for(int j=0; j<=T; j++){
            for (int i = 0; i <len ; i++) {
                if(clips[i][0]<=start){
                    end=Math.max(end,clips[i][1]);
                }
            }
            count++;
            if(end >= T){
                return count;
            }
            start = end;
        }
        return -1;
    }
    public int videoStitchingV2(int[][] clips, int T) {
        int[] dp=new int[T+1];
        Arrays.fill(dp,1,T+1,clips.length+1);
        for (int i = 0; i <=T ; i++) {
            for (int j = 0; j < clips.length; j++) {
                if(clips[j][0]<=i&&clips[j][1]>=i){
                    dp[i]=Math.min(dp[i],dp[clips[j][0]]+1);
                }
            }
        }
        if(dp[T]==clips.length+1) return -1;
        else return dp[T];
    }
}
