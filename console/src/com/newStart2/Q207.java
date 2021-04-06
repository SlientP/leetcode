package com.newStart2;

import java.util.HashMap;
import java.util.List;

public class Q207 {
    public static void main(String[] args) {
        Q207 test=new Q207();
        int[][] p=new int[][]{{0,1},{1,2},{0,2},{1,0}};
        System.out.println(test.canFinish(3,p));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        int m=prerequisites.length;
        int n=prerequisites[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        return true;
    }
}
