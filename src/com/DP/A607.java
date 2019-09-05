package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A607 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(inp.readLine());
        int[][] given = new int[1000002][2];
        for(int i=0;i<size;i++){
            String[] s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            given[a+1][0] = 1;
            given[a+1][1] = b;
        }
        solve(given,size );
    }
    static void solve(int[][] given,int size){
        int[] dp = new int[1000002];
        int max = 0;
        for(int i=1;i<1000002;i++){
            if(given[i][0]==1){
                dp[i] = dp[Math.max(i-given[i][1]-1,0)]+1;
                max = Math.max(dp[i],max);
            }
            else{
                dp[i] = dp[i-1];
            }
        }
        //print(dp);
        System.out.println(size-max);
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
                System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
