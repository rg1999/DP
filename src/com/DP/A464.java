package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class A464 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int max = Integer.parseInt(s1[1]);
        String[] s2 = inp.readLine().split("");
        int[] given = new int[size];
        for(int i=0;i<size;i++){
            given[i] = s2[i].charAt(0);
            given[i] = given[i]-96;
        }
        boolean ans = false;
        if(given.length!=1) {
            while (!ans) {
                print(given);
                given = increase(given, max);
                if (given[0] == -1) {
                    break;
                }
                ans = isTolerable(given);

            }
            if (ans) {
                for (int i = 0; i < size; i++) {
                    char a = (char) (given[i] + 96);
                    System.out.print(a);
                }
            } else {
                System.out.println("NO");
            }
        }
        else{
            if(given[0]==max){
                System.out.println("NO");
            }
            else{
                char a = (char) (given[0]+1+96);
                System.out.println(a);
            }
        }

    }
    static boolean isTolerable(int[] a){
        int size = a.length;
        for(int i=size-1;i>=2;i--){
            if(a[i]==a[i-1]){
                return false;
            }
            if(a[i]==a[i-2]){
                return false;
            }
        }
        if(a[0]==a[1]){
            return false;
        }
        return true;
    }
    static int[] increase(int[] a,int max){
        int size = a.length;
        boolean loop = true;
        int i = size-1;
        a[i]++;
        while (loop && i>0){
            if(a[i]>max){
                a[i]=1;
                a[i-1]++;
                i--;
            }
            else{
                loop=false;
                break;
            }
        }
        if(a[i]>max){
            return new int[]{-1};
        }
        return a;
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
