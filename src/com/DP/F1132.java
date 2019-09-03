package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class F1132 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inp.readLine());
        String[] given = inp.readLine().split("");

        ArrayList<String> list = new ArrayList<>();
        list.add(given[0]);
        int count = 0;
        for (int i = 1; i < size; i++) {
            if (!list.get(count).equals(given[i])) {
                list.add(given[i]);
                count++;
            }
        }
        if (size > 1) {
            if (given[size - 2] == given[size - 1]) {
                list.add(given[size]);
            }
        }
        String[] nn = new String[list.size()];
        for(int i=0;i<list.size();i++){
            nn[i] = list.get(i);
        }
        int ans = solution(nn);
        System.out.println(ans);


    }
    static int solution(String[] given){
        int size = given.length;
        int[][] dp = new int[size][size];

        for(int i=0;i<size;i++){
            dp[i][i] = 1;
        }

        for(int i=1;i<size;i++){
            for(int j=0;j<size-i;j++){

                if(given[j].equals(given[i+j])){
                    //System.out.println("ss");
                    dp[j][i+j] = dp[j][i+j-1];
                    for(int l=j;l<i+j;l++){
                        //System.out.println(dp[0][l] + " "+dp[l][i+j-1]);
                        int a = dp[0][l] + dp[l][i+j-1];
                        dp[j][i+j] = Math.min(dp[j][j+i],a);
                    }
                }
                else {
                    dp[j][i + j] = dp[j][i+j-1]+1;
                    for(int l=j;l<i+j;l++){
                        //System.out.println(dp[0][l] + " "+dp[l][i+j-1]);
                        int a = dp[0][l] + dp[l][i+j-1];
                        dp[j][i+j] = Math.min(dp[j][j+i],a);
                    }
                }
            }
        }
       print(dp);
        return dp[0][size-1];
    }
    static void print(int[][] a){
        int size = a[0].length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
