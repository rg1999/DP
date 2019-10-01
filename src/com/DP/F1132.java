package com.DP;

import java.io.*;
import java.util.ArrayList;

public class F1132 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(inp.readLine());
        String[] given = inp.readLine().split("");

        ArrayList<String> list = new ArrayList<>();
        list.add(given[0]);
        int count = 0;
        for (int i = 1; i < size; i++) {
            if (!list.get(count).equals(given[i])) {
                list.add(given[i]);
                count++;
            }
        }
        if (size > 1) {
            if (given[size - 2] == given[size - 1]) {
                list.add(given[size]);
            }
        }
        String[] nn = new String[list.size()];
        for(int i=0;i<list.size();i++){
            nn[i] = list.get(i);
        }
        int ans = solution(nn);
        System.out.println(ans);


    }
    static int solution(String[] given){
        int size = given.length;
        int[][] dp = new int[size][size];

        for(int i=0;i<size;i++){
            dp[i][i] = 1;
        }

        for(int i=1;i<size;i++){
            for(int j=0;j<size-i;j++){

                if(given[j].equals(given[i+j])){
                    //System.out.println("ss");
                    dp[j][i+j] = dp[j][i+j-1];
                    for(int l=j;l<i+j;l++){
                        //System.out.println(dp[0][l] + " "+dp[l][i+j-1]);
                        int a = dp[0][l] + dp[l][i+j-1];
                        dp[j][i+j] = Math.min(dp[j][j+i],a);
                    }
                }
                else {
                    dp[j][i + j] = dp[j][i+j-1]+1;
                    for(int l=j;l<i+j;l++){
                        //System.out.println(dp[0][l] + " "+dp[l][i+j-1]);
                        int a = dp[0][l] + dp[l][i+j-1];
                        dp[j][i+j] = Math.min(dp[j][j+i],a);
                    }
                }
            }
        }
       print(dp);
        return dp[0][size-1];
    }
    static void print(int[][] a){
        int size = a[0].length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static class A589 {
        public static void main(String[] args) throws IOException{
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int ans = 0;
            boolean find = false;
            for(int i=a;i<=b;i++){
                if(check(i)){
                    ans = i;
                    find = true;
                    break;
                }
            }
            if(find) {
                System.out.println(ans);
            }
            else{
                System.out.println(-1);
            }

        }
        static boolean check(int a){
            boolean[] used = new boolean[10];
            String[] s = Integer.toString(a).split("");
            for(int i=0;i<s.length;i++){
                if(!used[Integer.parseInt(s[i])]){
                    used[Integer.parseInt(s[i])] = true;
                }
                else{
                    return false;
                }
            }
            return true;
        }
    }

    public static class B589 {
        public static void main(String[] args) throws IOException {
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        }
    }

    public static class C589 {
        static long modulo = 1000000007;
        public static void main(String[] args) throws IOException {
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] s1 = inp.readLine().split(" ");
            long a = Long.parseLong(s1[0]);
            long b = Long.parseLong(s1[1]);

            ArrayList<Long> primes = new ArrayList<>();
            ArrayList<Long> fact = new ArrayList<>();
            long c = (long) Math.sqrt(a);
            for(int i=2;i<=c;i++){
                if(a%i==0){
                    if(checkPrime(i)){
                        fact.add((long)i);
                    }
                    if(Math.pow(i,2)!=a) {
                        if (checkPrime(a / i)) {
                            fact.add(a / i);
                        }
                    }
                }
            }
            if(checkPrime(a)){
                fact.add(a);
            }

    long multi = 0;
            long ans = 1;
           // System.out.println(fact);
            for(int i=0;i<fact.size();i++){


                long t =  fact.get(i);
                multi = t;
                long count = 0;
                while (t<=b){
                    count+=b/t;

                    if(t>t*multi){
                        break;
                    }
                    t = t*multi;
                   // System.out.println(t+" "+multi);
                }
                //System.out.println(count);
                ans = (ans*power(multi,count))%modulo;

            }

            //System.out.println(power(2,2));


            System.out.println(ans%modulo);


        }
        static long power(long a,long b){
            if(b==0){
                return 1;
            }
            //int count = 0;
            long ans = a;
            ArrayList<Long> list = new ArrayList<>();

            while (b>1){
                if(b%2==0){
                    b = b/2;
                    ans = ans%modulo;
                    ans = (ans*ans)%modulo;
                }
                else{
                    ans = ans%modulo;
                    list.add(ans);
                    b = b/2;
                    ans = (ans*ans)%modulo;
                }
            }
            ans = ans%modulo;
            for(int i=0;i<list.size();i++){
                ans = (list.get(i)*ans)%modulo;
            }
            //System.out.println(ans);
            return ans%modulo;
        }
        static boolean checkPrime(long a){
            int c =(int) Math.sqrt(a);
            for(int i=2;i<=c;i++){
                if(a%i==0){
                    return false;
                }
            }
            return true;
        }
    }

    public static class D589 {
        public static void main(String[] args) throws IOException {
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        }
    }
}
