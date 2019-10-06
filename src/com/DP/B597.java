package com.DP;

import java.io.*;
import java.util.Arrays;

public class B597 {
    static class Pair implements Comparable<Pair>{
        int a;
        int b;
        Pair(int a,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.a>o.a){
                return 1;
            }
            return -1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        Pair[] given = new Pair[size];
        for(int i=0;i<size;i++){
            String[] s1 = inp.readLine().split(" ");
            given[i] = new Pair(Integer.parseInt(s1[0]),Integer.parseInt(s1[1]));
        }
        int[] dp = new int[size];
        for(int i=0;i<size;i++){
            dp[i] = 1;
        }
        Arrays.sort(given);
        int max = 1;
        for (int i=1;i<size;i++){
            //System.out.println(given[i].a);
            for(int j=0;j<i;j++){
                if(given[i].a>given[j].b){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                    break;
                }
            }

        }
//        for(int i=0;i<size;i++){
//            System.out.print(dp[i]+" ");
//        }
        System.out.println(max);

    }
}
