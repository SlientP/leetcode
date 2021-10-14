package com.review;

import java.util.HashMap;

//36. Valid Sudoku
public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        
        HashMap<Character,Integer>[] maps=new HashMap[9];
        HashMap<Character,Integer>[] cols=new HashMap[9];
        HashMap<Character,Integer>[] rows=new HashMap[9];
        for (int i = 0; i < 9; i++) {
            maps[i]=new HashMap<Character,Integer>();
            rows[i]=new HashMap<Character,Integer>();
            cols[i]=new HashMap<Character,Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c=board[i][j];
                if(c!='.'){
                    Character cc=c;
                    //关键的每一个数组
                    int index= (i/3)*3+j/3;
                    // keep the current cell value
                    rows[i].put(cc, rows[i].getOrDefault(cc, 0) + 1);
                    cols[j].put(cc, cols[j].getOrDefault(cc, 0) + 1);
                    maps[index].put(cc, maps[index].getOrDefault(cc, 0) + 1);
                    if(rows[i].get(cc)>1||cols[j].get(cc)>1||maps[index].get(cc)>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
