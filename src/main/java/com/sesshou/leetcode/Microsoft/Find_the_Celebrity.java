package com.sesshou.leetcode.Microsoft;

/**
 * @author wp41128
 * @date 2020/6/22 14:11
 * @description：搜索名人
 */
public class Find_the_Celebrity {
    public static void main(String[] args) {
        Find_the_Celebrity test=new Find_the_Celebrity();
        System.out.println(test.findCelebrity(3));
    }
    private int[][] knowsArray=new int[][] {{1,1,0},{0,1,0},{1,1,1}};//{{1,1},{1,1}};
    public int findCelebrity(int n) {
        for (int i = 0; i < n ; i++) {
            int count=0;
            for (int j = 0; j < n ; j++) {
                if(!knows(j,i)||(knows(i,j)&&i!=j)) break;
                else count++;
            }
            if(count==n) return i;
        }
        return -1;
    }
    private boolean knows(int a,int b){
        return knowsArray[a][b]==1;
    }
    public int findCelebrityV2(int n) {
        int result=0;
        for (int i = 1; i < n ; i++) {
            //如果A认识B 那么A不是名人
            //如果A不认识B 那么B不是名人
           if(knows(result,i)){
               result=i;
           }
        }
        //验证result位名人
        for (int i = 0; i < n ; i++) {
            if(result==i) continue;
            //有i不认识result 或者result认识i
            else if(!knows(i,result)||knows(result,i)) return -1;
        }
        return -1;
    }
}

