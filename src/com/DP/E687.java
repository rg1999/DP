package com.DP;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class E687 {
    static int MODULO = 1000000007;
    static Map<Integer,Integer> index;
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] s2 = inp.readLine().split(" ");
        int[] given = new int[size];
        index = new HashMap<>();
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s2[i]);
            index.put(given[i],i);
        }
        Arrays.sort(given);
        solve(given,size,k);

    }
    static void solve(int[] given,int size,int k){
        boolean[][] dp = new boolean[size+1][k+1];
        for(int i=0;i<=size;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<size+1;i++){
            for(int j=0;j<k+1;j++){
                if(j<given[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j - given[i - 1]];
                }
            }
        }
        print(dp);
        transversal(dp,given,k);
    }
    static void transversal(boolean[][] dp,int[] given,int sum){

        GraphE687 graph = new GraphE687(sum);
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        queue.add(sum);
        while (queue.size()>0){
            int d = queue.poll();
            if(!map.containsKey(d)) {
                map.put(d, d);
                for (int i = 1; i <= given.length; i++) {
                    if (given[i - 1] <= d) {
                        if (dp[i][d]) {
                            queue.add(d - given[i - 1]);
                            graph.addEdge(d, given[i - 1]);
                            System.out.println(given[i - 1]);
                        }
                    }
                }
            }
        }
        graph.printGraph();

    }
    static void print(boolean[][] a){
        for(int i=0;i<a.length;i++){
            for(int k=0;k<a[0].length;k++){
                System.out.print(a[i][k]+" ");
            }
            System.out.println();
        }
    }
}
class GraphE687{
    int vertices;
    ArrayList<Integer> edge[];
    GraphE687(int vertices){
        this.vertices = vertices;
        edge = new ArrayList[vertices+1];
        for(int i=0;i<=vertices;i++){
            edge[i] = new ArrayList<>();
        }
    }
    void addEdge(int a,int b){
        edge[a].add(b);
    }
    void DFS(int v){
        boolean[] visited = new boolean[vertices+1];

    }
    void DFSutil(int v,boolean[] visited){
        visited[v] = true;
        Iterator<Integer> iterator = edge[v].listIterator();
        while (iterator.hasNext()){
            int n = iterator.next();
            if(!visited[n]){
                DFSutil(n,visited);
            }
        }
    }
    void printGraph(){
        System.out.println("graph");
        for (int i=0;i<=vertices;i++){
            System.out.print(i+" ");
            for(int j=0;j<edge[i].size();j++){
                System.out.print(edge[i].get(j)+" ");
            }
            System.out.println();
        }
    }
}