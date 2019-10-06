package com.DP;

import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    static class Pair{
        int a;
        int b;
        Pair(int a,int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            if(p.a==this.a){
                if(p.b==this.b) {
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
       //System.out.println(Integer.MAX_VALUE);
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(1,1));
        set.add(new Pair(1,1));
        Iterator<Pair> p = set.iterator();
        Pair a = p.next();
        Pair b = p.next();
        Pair c = new Pair(1,2);
        if(a.equals(c)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }

}