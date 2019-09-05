package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D358 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inp.readLine());
        int[] a = new int[size];
        int[] b = new int[size];
        int[] c = new int[size];
        String[] s1 = inp.readLine().split(" ");
        String[] s2 = inp.readLine().split(" ");
        String[] s3 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            a[i] = Integer.parseInt(s1[i]);
            b[i] = Integer.parseInt(s2[i]);
            c[i] = Integer.parseInt(s3[i]);
        }
        c[0] = 0;
        c[size-1] = 0;

        solve(a,b,c);
    }
    static void solve(int[] a,int[] b,int[] c){
        int[] dp0 = new int[a.length+1];
        int[] dp1 = new int[a.length+1];
        dp0[a.length-1] = a[a.length-1];
        dp1[a.length-1] = b[a.length-1];
        for(int i=a.length-2;i>=0;i--){

            dp0[i] = Math.max(dp0[i+1]+b[i],dp1[i+1]+a[i]);
            dp1[i] = Math.max(dp0[i+1]+c[i],dp1[i+1]+b[i]);


        }
        System.out.println(dp0[0]);
    }
}
