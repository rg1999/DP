package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class C913 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int reqd = Integer.parseInt(s1[1]);
        String[] s2 = inp.readLine().split(" ");
        ArrayList<Pair> given = new ArrayList<>();
        for(int i=0;i<size;i++){
            given.add(new Pair(Integer.parseInt(s2[i]),i));
        }
        Collections.sort(given);

    }
    static void solve(ArrayList<Pair> given,int reqd,int size){

        int[][] dp = new int[size][reqd];

    }
}
class Pair implements Comparable<Pair>{
    long a;
    long b;
    Pair(long a,long b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.a>o.a){
            return 1;
        }
        else{
            return -1;
        }
    }

}
