package com.DP;

import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        String[] giv = inp.readLine().split(" ");
        int testCase = Integer.parseInt(giv[0]);
        int K = Integer.parseInt(giv[1]);

        for(int j=0;j<testCase;j++) {

            String[] given = inp.readLine().split(" ");

            int a = Integer.parseInt(given[0]);
            int b = Integer.parseInt(given[1]);
            int ans = 0;

            for (int k = a; k <= b; k++) {

                if(k%K==0){
                    ans = ans + 1;
                    System.out.println("a");
                }

                ans = ans + 1;

                if(k>=K && k>K) {
                    ans = ans + (k - K + 1);
                    System.out.println(k- 1);
                }

                ans = ans % 1000000007;

            }

            System.out.println(ans);
        }

    }
}