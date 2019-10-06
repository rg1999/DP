package com.DP;

import java.io.*;

public class C660 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int[] given = new int[size];
        String[] s2 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s2[i]);
        }
        int maxOne = 0;
        int maxZero = 0;
        int countOne = 0;
        int countZero = 0;
        int left = 0;
        int right = 0;
        int indiR = -1;
        int indiL = -1;
//        if(given[0]==0){
//            countZero++;
//            maxZero++;
//        }
//        else{
//            countOne++;
//            maxOne++;
//        }
        while (right<size){
            if(countZero<=k){
                if(given[right]==0){
                    countZero++;
                }
                else{
                    countOne++;
                }

                maxOne = Math.max(countOne,maxOne);
                if(maxOne==countOne){
                    indiR = right;
                    indiL = left;
                }
                right++;
                maxZero = Math.max(countZero,maxZero);
            }
            else{
                if(left<right) {
                    if (given[left] == 0) {
                        countZero--;
                    } else {
                        countOne--;
                    }
                    left++;
                }
                else if(left==right){
                    if(given[right]==0){
                        countZero = 1;
                    }
                    else{
                        countOne = 1;
                    }
                    right++;
                }
            }
            System.out.println(countZero+" "+countOne+" "+left+" "+right);
        }
        //System.out.println(maxOne+" "+maxZero);
        System.out.println(maxOne+Math.min(maxZero,k));
        for(int i=0;i<size;i++){

            if(i>=indiL && i<=indiR){
                out.write(1+" ");
            }
            else{
                out.write(given[i]+" ");
            }
        }
        out.flush();

    }
}
