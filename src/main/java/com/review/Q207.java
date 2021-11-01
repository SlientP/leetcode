package com.review;

import java.util.*;

public class Q207 {
    private List<List<Integer>> edges;
    private int[] visited;
    private boolean vaild=true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited=new int[numCourses];
        //need focus
        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(visited[i]==0){
                dfs(i);
            }
        }
        return vaild;
    }
    private void dfs(int i){
        visited[i]=1;
        for (Integer item : edges.get(i)) {
            if(visited[item]==0){
                dfs(item);
                if(!vaild) return;
            }else if(visited[item]==1){
                vaild=false;
                return;
            }
        }
        visited[i]=2;
    }
    //BFS
    private List<List<Integer>> edges2;
    private int[] indeg;
    public boolean canFinishV2(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        indeg=new int[numCourses];
        int visited=0;
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        //学习p[1]之前需要学习p[0]
        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
            ++indeg[p[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges2.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited==numCourses;
    }
}
