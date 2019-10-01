package com.DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B264 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(inp.readLine());
        int[] given = new int[size];
        String[] s1 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> value = new ArrayList<>();
        list.add(0);
        value.add(given[0]);
        if(given.length>1) {
            for (int i = 1; i < size; i++) {

                if(given[i]>given[list.get(list.size()-1)]){
                    if(gcd(given[i],list.get(list.size()-1))>1){
                        list.add(i);
                        value.add(given[i]);
                    }
                    else{
                        int ind = list.size()-1;
                        if(ind<0){
                            ind = -ind-1;
                        }
                        while (ind>=1){
                            if(gcd(given[list.get(ind-1)],given[i])>1){
                                list.remove(ind);
                                list.add(ind,i);
                                value.remove(ind);
                                value.add(ind,given[i]);
                                break;
                            }
                            else{
                                ind--;
                            }
                        }
                    }


                }
                else if(given[i]<list.get(list.size()-1)){
                    list.remove(0);
                    value.remove(0);
                    value.add(given[i]);
                    list.add(i);
                }
                else{
                    int ind = Collections.binarySearch(value,given[i]);
                    if(ind<0){
                        ind = -ind-1;
                    }
                    while (ind>=1){
                        if(gcd(given[list.get(ind-1)],given[i])>1){
                            list.remove(ind);
                            list.add(ind,i);
                            value.remove(ind);
                            value.add(ind,given[i]);
                            break;
                        }
                        else{
                            ind--;
                        }
                    }
                }
                System.out.println(list);
                System.out.println(value);
            }

        }
        else{
            System.out.println(1);
        }
    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
