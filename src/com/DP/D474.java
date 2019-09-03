package com.DP;

import java.io.*;
import java.nio.BufferUnderflowException;

public class D474 {
    static int MODULO = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int testCase = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int limit = 100005;
        int[] dp = new int[limit];
        int[] sum = new int[limit];
        for (int i = 0; i < k; i++) {
            dp[i] = 1;
            if (i == k - 1) {
                dp[i]++;
            }
            if(i==0){
                sum[i] = 1;
            }
            else {
                sum[i] = (sum[i - 1] + dp[i]) % MODULO;
            }
        }
        for(int i=k;i<limit;i++){
            dp[i] = (dp[i-1]+dp[i-k])%MODULO;
            sum[i] = (sum[i-1]+dp[i])%MODULO;
        }
        //print(dp);
        //print(sum);
        for(int t=0;t<testCase;t++){

            String[] s3 = inp.readLine().split(" ");
            int low = Integer.parseInt(s3[0]);
            int high = Integer.parseInt(s3[1]);

            if(k<=high){
                low--;
                low--;
                high--;
                int ans = 0;
                if(low==-1){
                    ans = sum[high];
                    if(k==1){
                        ans++;
                    }
                }
                else{
                    ans = sum[high]-sum[low];
                }
                if(ans<0){
                    ans = ans + MODULO;
                }

                out.write(ans+"\n");
            }
            else{
                int ans = high-low+1;
                if(ans<0){
                    ans = ans + MODULO;
                }
                out.write(ans+"\n");
            }
        }
        out.flush();
    }
    static void print(int[] a){
        for(int i=0;i<10;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
