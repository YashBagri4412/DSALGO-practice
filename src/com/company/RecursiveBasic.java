package com.company;

public class RecursiveBasic {
    public static void printNto1(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        printNto1(n-1);
    }
    public static void print1ToN(int n){
        if(n==0)
            return;
        print1ToN(n-1);
        System.out.print(n+" ");
    }

    public static void tailRecursion(int n,int k){
        if(n==0)
            return;
        System.out.print(k+" ");
        tailRecursion(n-1,k+1);

    }

    public static int tailRecFact(int n,int k){
        if(n==1||n==0){
            return k;
        }
        return tailRecFact(n-1,k*n);
    }

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        return n*(fact(n-1));
    }

    public static int fib(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fib(n-1)+fib(n-2);
    }

    public static int sumOfNaturalNumber(int n){
        if(n==1)
            return n;
        return n+sumOfNaturalNumber(n-1);
    }

    public static boolean palindromeString (String s){
        if(s.length() == 0 || s.length() == 1)
            return true;
        return (s.charAt(0) == s.charAt(s.length()-1)) && palindromeString(s.substring(1,s.length()-1));
    }
}
