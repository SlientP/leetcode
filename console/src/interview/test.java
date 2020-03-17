package interview;

import java.util.HashMap;


/**
 * Created by Administrator on 2020/3/16 0016.
 */
public class test {
    public static void main(String[] args) {

    }
    public String reserve(String s){
        int n=s.length();
        char[] newS=new char[n];
        HashMap<Integer,Character> index=new HashMap<Integer, Character>();
        for (int i = n-1; i >=0; i--) {
            if(s.charAt(i)>=65&&s.charAt(i)<=90) {
                newS[n-i-1]=s.charAt(i);
            }else{
                index.put(i,s.charAt(i));
            }
        }
        for (Integer i:index.keySet()) {
            newS[i]=index.get(i);
        }
        return new String(newS);
    }

    public int getNum(int[][] nums){
        int num=0;
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j <nums[i].length ; j++) {
                //如果是水不做处理
                if(nums[i][j]==0) {
                    continue;
                }
                if(nums[i][j]==1){
                    //每一个岛生成一个唯一的key
                    int key=i*10+j;
                    if(map.keySet().contains(key-1)){
                        //已存在岛的左侧
                        map.put(key-1,1);
                    }else if(map.keySet().contains(key+1)){
                        //已存在岛的右侧
                        map.put(key+1,1);
                    }else if(map.keySet().contains(key+nums[i].length)){
                        //已存在岛的下侧
                        map.put(key+1,1);
                    }else if(map.keySet().contains(key-nums[i].length)){
                        //已存在岛的上侧
                        map.put(key+1,1);
                    }else {
                        map.put(key, 1);
                        num++;
                    }
                }
            }
        }
        return num;
    }

}
