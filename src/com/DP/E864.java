package com.DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class E864 {
    static BufferedWriter out;
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(inp.readLine());
        ArrayList<Tri> given = new ArrayList<>();
        int maxTime = 0;
        for(int i=0;i<size;i++){
            String[] s1 = inp.readLine().split(" ");
            given.add(new Tri(Integer.parseInt(s1[0]),Integer.parseInt(s1[1]),Integer.parseInt(s1[2]),i+1));
            maxTime = Math.max(Integer.parseInt(s1[1]),maxTime);
        }
        Collections.sort(given);
//            for (int i=0;i<size;i++){
//                given.get(i).print();
//            }
            //System.out.println(maxTime);
        solve(given,size,maxTime);
    }
    static void solve(ArrayList<Tri> given,int size,int maxTime) throws IOException {
        int[][] dp = new int[size + 1][maxTime + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= maxTime; j++) {
                if (j < given.get(i - 1).lasttingTime && given.get(i - 1).burningTime <= j) {
                    //System.out.println(i+" "+j);
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - given.get(i - 1).burningTime] + given.get(i - 1).value);
                    dp[i][j] = Math.max(dp[i][j-1],dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //print(dp);
        int x = maxTime;
        int y = size;
        int maxValue = dp[size][maxTime];
        out.write(maxValue + "\n");
        ArrayList<Integer> list = new ArrayList<>();
        while (x > 0 && y > 0) {
            if (maxValue == dp[y][x - 1]) {
                x--;
            } else if (maxValue == dp[y - 1][x]) {
                y--;
            } else {
                list.add(given.get(y - 1).index);
                x = x - given.get(y - 1).burningTime;
                maxValue = maxValue - given.get(y - 1).value;
                y--;
            }
        }
        //System.out.println(list);
        //Collections.sort(list);
        if (list.size() > 0) {
            if (list.get(0) == 0) {
                list.remove(0);
            }
        }
        out.write(list.size()+"\n");
        for(int i=0;i<list.size();i++){
            out.write(list.get(list.size()-1-i)+" ");
        }
        out.flush();
    }
    static void print(int[][] a){
        for(int i=0;i<a[0].length;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<a.length;i++){
            for(int k=0;k<a[0].length;k++){
                System.out.print(a[i][k]+" ");
            }
            System.out.println();
        }
    }
}
class Tri implements Comparable<Tri>{
    int burningTime;
    int lasttingTime;
    int value;
    int index;
    Tri(int burningTime,int lasttingTime,int value,int index){
        this.burningTime = burningTime;
        this.lasttingTime = lasttingTime;
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Tri o) {
        if(this.lasttingTime>o.lasttingTime){
            return 1;
        }
        if(this.lasttingTime==o.lasttingTime){
            if(this.value>o.value){
                return 1;
            }
            return -1;
        }
        return -1;
    }
    void print(){
        System.out.println(burningTime+" "+lasttingTime+" "+value);
    }
}
