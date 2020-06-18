package com.sesshou.leetcode.Dynamic_Programming;


import com.google.common.hash.Hashing;


import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author wp41128
 * @date 2020/5/28 8:51
 * @description：除数博弈
 */
public class Divisor_Game {
    public static void main(String[] args) {
        Divisor_Game test=new Divisor_Game();
        System.out.println(test.divisorGame(2));
        String a=Hashing.murmur3_128().hashString("jobnum=1041128;panelid=697;timestamp=1590060906580;secret=JclBooeh", Charset.forName("UTF-8")).toString();
        System.out.println(a);


    }

    public boolean divisorGame(int N) {
        boolean[] res=new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if(res[i]) break;
                if(i%j==0) res[i] = res[i] || !res[i - j];

            }
        }
        return res[N];
    }
}
