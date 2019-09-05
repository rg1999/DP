package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class c1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++){
            String[] s1 = inp.readLine().split(" ");
            long a = Long.parseLong(s1[0]);
            long b = Long.parseLong(s1[1]);
            long muth = a/b;
            long rem = muth%10;
            muth = muth/10;

            long boobs = muth*gangbang(b);
            boobs = boobs + tatti(b,rem);
            System.out.println(boobs);
        }
    }
    static long gangbang(long a){
        long boobs = 0;
        long sex = 0;
        for(int i=1;i<=10;i++){

            sex = i*a;
            String[] s  = Long.toString(sex).split("");
            boobs = boobs + Long.parseLong(s[s.length-1]);
        }
        return boobs;
    }
    static long tatti(long a,long r){
        long boobs = 0;
        long sex = 0;
        for(int i=1;i<=r;i++){

            sex = i*a;
            String[] s  = Long.toString(sex).split("");
            boobs = boobs + Long.parseLong(s[s.length-1]);
        }
        return boobs;
    }
}
