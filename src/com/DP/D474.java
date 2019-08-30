package com.DP;

import java.io.*;
import java.nio.BufferUnderflowException;

public class D474 {
    static int MODULO = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter pot = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int testCase = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        for(int t=0;t<testCase;t++){

            String[] s3 = inp.readLine().split(" ");
            int low = Integer.parseInt(s3[0]);
            int high = Integer.parseInt(s3[1]);

            int ans = 0;
            int total = 0;
            int[] dp = new int[high];
            for(int i=0;i<high;i++){

                

            }

        }
    }
}
