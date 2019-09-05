package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B582 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int multi = Integer.parseInt(s1[1]);
        String[] s2 = inp.readLine().split(" ");
        int[] given = new int[size];
        int[] givenCopy = new int[2*size];
        int times = 100;
        int[] givenCopyCopy = new int[times*size];
        int maxCopy = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<size;i++){
            int a = Integer.parseInt(s2[i]);
            given[i] = a;
            givenCopy[i] = a;
            givenCopy[i+size] = a;
            for(int j=0;j<times;j++){
                givenCopyCopy[i+j*size] = a;
            }
            if(map.containsKey(a)){
                int z = map.get(a);
                map.remove(a);
                z++;
                map.put(a,z);
                maxCopy = Math.max(maxCopy,z);
            }
            else{
                map.put(a,1);
            }
        }
        if(multi>1){
            if(multi>=100){
                int a = solve(givenCopyCopy,100*size);
                //System.out.println(maxCopy);
                System.out.println(a+((multi-100)*maxCopy));
            }
            else{
                int a = solve(givenCopyCopy,multi*size);
                System.out.println(a);
            }

        }
        else{
            int a = solve(given,size);
            System.out.println(a);
        }
    }
    static int solve(int[] given,int size){
        int[] dp = new int[size];
        dp[0] = 1;
        int max = 1;
        for(int i=1;i<size;i++){
            dp[i] =1;
            for(int j=0;j<i;j++){
                if(given[i]>=given[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    max = Integer.max(dp[i],max);
                }
            }
        }
        //print(dp);
        return max;

    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

}
