package com.company;

public class PowerSet {
    static public void powerSet(String s){
        int n = s.length();
        double powSize = Math.pow(2,n);
        for(int counter = 0 ;counter<powSize;counter++){
            for(int j=0;j<n;j++){
                if((counter & (1<<j)) != 0){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.print("\n");
        }
    }
}
