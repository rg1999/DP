package com.DP;

import java.io.*;

public class C366 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int[][] dp = new int[size+1][2001];
        int[] a = new int[size+1];
        int[] b = new int[size+1];
        String[] s2 = inp.readLine().split(" ");
        String[] s3 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            a[i+1] = Integer.parseInt(s2[i]);
            b[i+1] = Integer.parseInt(s3[i])*k;
        }

        for(int i=0;i<=size;i++){
            for(int j=0;j<=1000;j++){
                dp[i+1][j] = Math.max(dp[i][j],dp[i+1][j]);
                dp[i+1][j+a[i+1]-b[i+1]] = Math.max(dp[i+1][j+a[i+1]-b[i+1]],dp[i+1][j]+a[i+1]);
            }
        }

        System.out.println(dp[size][0]);

    }
}
