package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class A991 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inp.readLine());
        int[] given = new int[size];
        String[] s1 = inp.readLine().split(" ");
        int check = Integer.parseInt(s1[0]);
        int one = 0;
        boolean find = false;
        int count = 1;
        for(int i=0;i<size;i++) {
            given[i] = Integer.parseInt(s1[i]);
            if (i > 0) {
                check = GCD(check, given[i]);
            }
            if(given[i]==1){
                one++;
                find = true;
            }
        }
        if(check==1) {
            int min = Integer.MAX_VALUE;
            int gcd = given[0];


            ArrayList<Integer> dp1 = new ArrayList<>();
            if(!find) {
                for (int i = 0; i < size - 1; i++) {
                    dp1.add(GCD(given[i], given[i + 1]));
                    if (dp1.get(i) == 1) {
                        find = true;
                        break;
                    }
                }
            }
            ArrayList<Integer> dp = new ArrayList<>();
            //System.out.println("ss");
            while (!find){
                dp = new ArrayList<Integer>();
                count++;
                for(int i=0;i<dp1.size()-1;i++){
                    dp.add(GCD(dp1.get(i),dp1.get(i+1)));
                    if(dp.get(i)==1){
                        find = true;
                        break;
                    }

                }
                dp1 = (ArrayList<Integer>) dp.clone();
            }
           // System.out.println(dp1);
            System.out.println(count+size-1-one);
        }
        else{
            System.out.println(-1);
        }
    }

    static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
