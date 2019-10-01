package com.DP;

import java.io.*;
import java.util.*;

public class C706 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(inp.readLine());
        int[] cost = new int[size];
        String[] s1 = inp.readLine().split(" ");
        String[] given = new String[size];
        String[] reverse = new String[size];
        for(int i=0;i<size;i++){
            given[i] = inp.readLine();
            reverse[i] = rev(given[i]);
            cost[i] = Integer.parseInt(s1[i]);
            //System.out.println(cost[i]);
        }
        //System.out.println("aaa");
        long[][] dp = new long[size][2];
        dp[0][0] = 0;
        dp[0][1] = cost[0];
        for(int i=1;i<size;i++){
            dp[i][0] = Long.MAX_VALUE/2;
            dp[i][1] = Long.MAX_VALUE/2;
        }
        for(int i=1;i<size;i++){
            if(lexo(given[i-1],given[i])){
                dp[i][0] = dp[i-1][0];
            }
            if(lexo(reverse[i-1],given[i])){
                dp[i][0] = Math.min(dp[i-1][1],dp[i][0]);
            }
            if(lexo(given[i-1],reverse[i])){
                dp[i][1] = dp[i-1][0]+cost[i];
            }
            if(lexo(reverse[i-1],reverse[i])){
                dp[i][1] = Math.min(dp[i][1],dp[i-1][1]+cost[i]);
            }
        }
        long min = Math.min(dp[size-1][0],dp[size-1][1]);
        if(min<Long.MAX_VALUE/3){
            System.out.println(min);
        }
        else{
            System.out.println(-1);
        }
    }
    static boolean lexo(String a,String b){
        String[] s1 = a.split("");
        String[] s2 = b.split("");
        int size = Math.min(s1.length,s2.length);
        for(int i=0;i<size;i++){
            int x = s1[i].charAt(0);
            int y = s2[i].charAt(0);

            if(x<y){
                return true;
            }
            else if(x>y){
                return false;
            }
        }
        if(s1.length<=s2.length){
            return true;
        }

        return false;
    }
    static String rev(String a){
        String[] b = a.split("");
        int size = b.length;
        String[] c = new String[size];
        String e = new String();
        for(int i=0;i<size;i++){
            c[i] = b[size-1-i];
            e+=c[i];
        }

        return e;
    }
}
