package com.company;

public class DecimalToBinary {
    public static void printDToB(int n){
        if(n==0)
            return;
        printDToB(n/2);
        System.out.print(n%2);
    }
}
