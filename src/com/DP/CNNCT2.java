package com.DP;

import java.io.*;
import java.security.UnrecoverableEntryException;
import java.util.*;

public class CNNCT2 {
    static class Graph{
        static class Pair{
            int a;
            int b;
            Pair(int a,int b){
                this.a = a;
                this.b = b;
            }

            @Override
            public int hashCode() {
                return this.a*23+this.b*7;
            }

            @Override
            public boolean equals(Object obj) {
                if(this.getClass().equals(obj.getClass())){
                    Pair p = (Pair) obj;
                    if(this.a==p.a){
                        if(this.b==p.b){
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        int vertices;
        ArrayList<Integer> edge[];
        static Map<Pair,Pair> edgeEdge;
        static Set<Integer> mapB;
        static int countB;
        static int countA;
        static int max;
        Graph(int vertices){
            countA = 0;
            countB = 0;
            max = 0;
            mapB = new HashSet<>();
            edgeEdge = new HashMap<>();
            this.vertices = vertices;
            edge = new ArrayList[vertices+1];
            for(int i=1;i<=vertices;i++){
                edge[i] = new ArrayList<>();
            }
        }
        void addEdge(int a,int b){
            edge[a].add(b);
            edge[b].add(a);
        }
        static void solve() throws IOException{
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int testCase = Integer.parseInt(inp.readLine());
            for(int t=0;t<testCase;t++) {
                String[] s1 = inp.readLine().split(" ");
                int v = Integer.parseInt(s1[0]);
                int e = Integer.parseInt(s1[1]);
                Pair[] a = new Pair[e];
                Pair[] b = new Pair[e];
                Graph graph = new Graph(v);
                for (int i = 0; i < e; i++) {
                    String[] s2 = inp.readLine().split(" ");
                    int u1 = Integer.parseInt(s2[0]);
                    int u2 = Integer.parseInt(s2[1]);
                    a[i] = new Pair(u1, u2);
                    graph.addEdge(u1, u2);
                }
                for (int i = 0; i < e; i++) {
                    String[] s2 = inp.readLine().split(" ");
                    b[i] = new Pair(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
                }
                for (int i = 0; i < e; i++) {
                    edgeEdge.put(a[i], b[i]);
                }
                graph.DFS();
                System.out.println(graph.max);
            }

        }
        void DFS(){
            boolean[] visited = new boolean[vertices+1];
            DFSutil(1,visited);
        }
        private void DFSutil(int v,boolean[] visited){
            visited[v] = true;
            Iterator<Integer> iterator = edge[v].listIterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                Pair pair = new Pair(v,n);
                Pair pair1 = new Pair(n,v);
                if(!visited[n]){
                    Pair p;
                    if(edgeEdge.containsKey(pair)){
                        p = edgeEdge.get(pair);
                    }
                    else{
                        p = edgeEdge.get(pair1);
                    }
                    boolean aa = false;
                    boolean bb = false;
                    //System.out.println(edgeEdge);
                    //System.out.println(p.a);
                    if(!mapB.contains(p.a)){
                        aa = true;
                    }
                    if(!mapB.contains(p.b)){
                        bb = true;
                    }
                    if(aa || bb) {
                        if(aa) {
                            mapB.add(p.a);
                        }
                        if(bb) {
                            mapB.add(p.b);
                        }
                        max = Math.max(max,mapB.size());
                        System.out.println(mapB);
                        DFSutil(n, visited);  // recursive DFS.....
                        visited[n] = false;
                        if(aa) {
                            mapB.remove(p.a);
                        }
                        if(bb) {
                            mapB.remove(p.b);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        Graph.solve();
//        Graph.Pair a = new Graph.Pair(1,1);
//        Graph.Pair b = new Graph.Pair(1,1);
//        Map<Graph.Pair,Integer> map = new HashMap<>();
//        map.put(a,1);
//        System.out.println(map.containsKey(b));

    }
}
