package com.DP;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class A1098 {
    static class Graph{
        static class Pair{
            int a;
            int b;
            Pair(int a,int b){
                this.a = a;
                this.b = b;
            }
        }
        int vertices;
        Map<Integer,Integer> parent;
        Map<Integer,Integer> cost;
        static int max;
        ArrayList[] edge;
        Graph(int vertices){
            max = 0;
            this.vertices = vertices;
            parent = new HashMap<>();
            edge = new ArrayList[vertices+1];
            cost = new HashMap<>();
            for(int i=0;i<=vertices;i++){
                edge[i] = new ArrayList<Integer>();
            }
        }
        void addEdge(int a,int b){
            edge[a].add(b);
            edge[b].add(a);
        }
        void addCost(int a,int b){
            cost.put(a,b);
        }
        void DFS(){
            boolean[] visited = new boolean[vertices+1];
            max = cost.get(1);
            parent.put(1,0);
            DFSutil(1,visited);
            for(int i=1;i<=vertices;i++){
                if(!visited[i]){
                    max = Integer.MAX_VALUE;
                    break;
                }
            }
            if(max==Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else{
                System.out.println(max);
            }
        }

        private void DFSutil(int i, boolean[] visited) {
            visited[i] = true;
            Iterator<Integer> iterator = edge[i].listIterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                if(!visited[n]){
                    if(cost.get(n)!=-1) {
                        if (cost.get(n) < cost.get(i)) {
                            max = Integer.MAX_VALUE;
                            parent.put(n,i);
                        } else {
                            parent.put(n, i);
                            max = Math.max(max,cost.get(n));
                        }
                    }
                    else{
                        parent.put(n,i);
                        cost.put(n,cost.get(i));
                    }
                    DFSutil(n,visited);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int vertices = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split(" ");
        String[] s2 = inp.readLine().split(" ");
        Graph graph = new Graph(vertices);
        for(int i=2;i<=vertices;i++){
            graph.addEdge(i,Integer.parseInt(s1[i-2]));
        }
        for(int i=0;i<vertices;i++){
            graph.addCost(i+1,Integer.parseInt(s2[i]));
        }
        graph.DFS();
    }
}
