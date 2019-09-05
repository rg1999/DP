package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = inp.readLine().split("");
        String[] s2 = inp.readLine().split("");

        solve(s1,s2);
    }
    static void solve(String[] x, String[] y){
        int[][] dp = new int[y.length+1][x.length+1];

        for(int i=1;i<=y.length;i++){
            for(int j=1;j<=x.length;j++){
                if(y[i-1].equals(x[j-1])){
                    dp[i][j] = dp[i-1][j-1]+1;

                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
//
//        for(int i=0;i<=y.length;i++){
//            for(int j=0;j<=x.length;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        ArrayList<String> list = new ArrayList<>();
        int max = dp[y.length][x.length];
        int a = x.length;
        int b = y.length;

        while (b>0 || a>0){
            if(max==0) {
                break;
            }
                //System.out.println(a + " " + b);
                if (dp[b][a - 1] == max) {
                    a--;
                } else if (dp[b - 1][a] == max) {
                    b--;
                } else {
                    a--;
                    b--;
                    list.add(y[b]);
                    max--;
                }

        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(list.size()-1-i));
        }

    }
}
