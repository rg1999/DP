package com.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class e1213 {
    static String[] aaaaa = new String[3];
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split("");
        String[] s2 = inp.readLine().split("");
        int a=0,b=0,c=0;
        for(int i=0;i<2;i++){
            if(s1[i].equals("a")){
                a++;
            }
            if(s1[i].equals("b")){
                b++;
            }
            if(s1[i].equals("c")){
                c++;
            }
            if(s2[i].equals("a")){
                a++;
            }
            if(s2[i].equals("b")){
                b++;
            }
            if(s2[i].equals("c")){
                c++;
            }
        }
        boolean once = true;
        while (once){
            once = false;
            String[] s3 = new String[]{"abc","acb","bac","bca","cab","cba" };
            ArrayList<String> list1 = matcssh(s1,s3);
            ArrayList<String> list2 = matcssh(s2,s3);
            String ans = "aa";
            boolean find = false;
            for(int i=0;i<list1.size();i++){
                if (find) {
                    break;
                }
                for(int j=0;j<list2.size();j++){
                    if(list1.get(i).equals(list2.get(j))){
                        ans = list1.get(i);
                        find = true;
                        break;
                    }
                }
            }
            aaaaa = ans.split("");
        }
        if(n==1){
            String[] s3 = new String[]{"abc","acb","bac","bca","cab","cba" };
            ArrayList<String> list1 = matcssh(s1,s3);
            ArrayList<String> list2 = matcssh(s2,s3);
            String ans = "aa";
            boolean find = false;
            for(int i=0;i<list1.size();i++){
                if (find) {
                    break;
                }
                for(int j=0;j<list2.size();j++){
                    if(list1.get(i).equals(list2.get(j))){
                        ans = list1.get(i);
                        find = true;
                        break;
                    }
                }
            }
            String[] aaa = ans.split("");
            System.out.println("YES");
            for(int i=0;i<3;i++){
                System.out.print(aaa[i]);
            }
        }
        else{
            String[] s3 = new String[]{"abcabc","acbacb","bacbac","bcabca","cabcab","cbacba","aabbcc","aaccbb","ccbbaa","ccaabb","bbccaa","bbaacc" };

            ArrayList<String> list1 = match(s1,s3);
            ArrayList<String> list2 = match(s2,s3);
            int aaaaaaaa = 0;
            String ans = "aa";
            boolean find = false;
            //System.out.println(list1);
            //System.out.println(list2);
            for(int i=0;i<list1.size();i++){
                if (find) {
                    break;
                }
                for(int j=0;j<list2.size();j++){
                    if(list1.get(i).equals(list2.get(j))){
                        ans = list1.get(i);

                        find = true;
                        break;
                    }
                }
            }

            for(int i=0;i<12;i++){
                if(ans.equals(s3[i])){
                    aaaaaaaa = i;
                }
            }
            //System.out.println(ans);

            if(aaaaaaaa<5) {
                System.out.println("YES");
                String[] aaa = ans.split("");
                int rem = n % 2;
                n = n / 2;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print(aaa[j]);
                    }
                }
                for (int i = 0; i < rem * 3; i++) {
                    System.out.print(aaa[i]);
                }
            }
            else{
                System.out.println("NO");
            }
        }

    }
    static ArrayList<String> match(String[] a, String[] b){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<12;i++){
            String[] c = b[i].split("");
            boolean find = true;
            for(int j=0;j<5;j++){
                if(c[j].equals(a[0])){
                    if(c[j+1].equals(a[1])){
                        find = false;
                    }
                }
            }
            if(find){
                list.add(b[i]);
            }
        }

        return list;

    }
    static ArrayList<String> matcssh(String[] a, String[] b){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<6;i++){
            String[] c = b[i].split("");
            boolean find = true;
            for(int j=0;j<2;j++){
                if(c[j].equals(a[0])){
                    if(c[j+1].equals(a[1])){
                        find = false;
                    }
                }
            }
            if(find){
                list.add(b[i]);
            }
        }

        return list;

    }
    //String

}
