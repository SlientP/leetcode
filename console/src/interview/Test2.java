package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2020/3/17 0017.
 */
public class Test2 {

    public int result = 0;
    private int target = 5;
    private int num = 0;
    private int imax=0;
    private int jmax=0;
    public static void main(String[] args) {
        Test2 test = new Test2();
       // System.out.println(test.reserve("a-bC-dEf-ghIj"));

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node7 = new Node(7);
        node5.left = node3;
        node5.right = node9;
        node3.left = node2;
        node3.right = node4;
        node9.left = node7;
        node9.right = node10;
        test.SearchNode(node5);
        //System.out.println(test.result);
        int[][] land=new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        test.isLand(land);
        System.out.println(test.num);
    }

    public String reserve(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
        List<Character> result = new ArrayList<Character>();

        for (int i = n - 1; i >= 0; i--) {
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                result.add(s.charAt(i));
            } else {
                map.put(i, s.charAt(i));
            }
        }
        for (Integer key : map.keySet()) {
            result.add(key, map.get(key));
        }
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            s1.append(result.get(i));
        }
        return s1.toString();
    }


    public void SearchNode(Node node) {
        if (node == null) return;
        SearchNode(node.left);
        if (node.value > target && result < target) {
            this.result = node.value;
            return;
        }
        SearchNode(node.right);
    }

    static class Node {
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public void isLand(int[][] lands) {
        imax=lands.length-1;
        jmax=lands[0].length-1;
        for (int i = 0; i < lands.length; i++) {
            for (int j = 0; j < lands[0].length ; j++) {
                if(lands[i][j]==0) continue;
                else if(lands[i][j]==1){
                    num++;
                    landtowater(lands,i-1,j);
                    landtowater(lands,i+1,j);
                    landtowater(lands,i,j-1);
                    landtowater(lands,i,j+1);
                }
            }
        }

    }

    public void landtowater(int[][] lands,int i,int j){
        if(i>imax||j>jmax||i<0||j<0) return;
        if(lands[i][j]==1) {
            lands[i][j]=0;
            landtowater(lands, i - 1, j);
            landtowater(lands, i + 1, j);
            landtowater(lands, i, j - 1);
            landtowater(lands, i, j + 1);
        }

    }
}


