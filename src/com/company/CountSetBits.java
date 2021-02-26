package com.company;

public class CountSetBits {
    public static int countSetBits(int n){
        n++;
        int count = (n)/2;
        int pO2 = 2;
        while(n>=pO2){
            int nOP = n/pO2;
            count+=(nOP/2)*pO2;
            count+=(nOP%2==0)?0:n%pO2;
            pO2 <<= 1;
        }
        return count;
    }
}