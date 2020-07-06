package com.sesshou.leetcode.Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author wp41128
 * @date 2020/7/1 8:41
 * @description：函数独占的执行时间
 */
public class Exclusive_Time_of_Functions {
    public static void main(String[] args) {
        Exclusive_Time_of_Functions test=new Exclusive_Time_of_Functions();
        List<String> logs= Arrays.asList("0:start:0","1:start:5","2:start:6","3:start:9","4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96","2:end:100","1:end:102","2:start:105","2:end:109","0:end:114");
        //"0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5"
        //["0:start:0","1:start:2","1:end:5","0:end:6"]
        //["0:start:0","1:start:5","2:start:6","3:start:9",
        // "4:start:11","5:start:12","6:start:14",
        // "7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40",
        // "3:end:45","0:start:49","0:end:54","5:start:55",
        // "5:end:59","4:start:63","4:end:66","2:start:69",
        // "2:end:70","2:start:74","6:start:78","0:start:79",
        // "0:end:80","6:end:85","1:start:89","1:end:93","2:end:96",
        // "2:end:100","1:end:102","2:start:105","2:end:109","0:end:114"]

        int[] result=test.exclusiveTime(8,logs);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i+":" +result[i]);
        }
    }
    //1.开始为记为负
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        Stack<String> stack=new Stack<String>();
        stack.push(logs.get(0));
        for (int i = 1; i < logs.size(); i++) {
            String item=logs.get(i);
            if(item.split(":")[1].equals("end")){
                int value=Integer.valueOf(item.split(":")[2])-Integer.valueOf(stack.peek().split(":")[2])+1;
                result[Integer.valueOf(item.split(":")[0])]+=value;
                stack.pop();
                if(!stack.isEmpty()) {
                    result[Integer.valueOf(stack.peek().split(":")[0])] += -value;
                }
            }else{
                stack.push(item);
            }
        }
        return result;
    }
}
