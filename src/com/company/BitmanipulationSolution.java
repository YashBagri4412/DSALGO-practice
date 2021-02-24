package com.company;

public class BitmanipulationSolution {
    public static boolean KthSetBit(int n,int k){
        return ((n >> (k - 1)) & 1) == 1;
    }
    public static int countSetBit(int n) {
        /*int res = 0;
        while(n>0){
         *if(n % 2 != 0)
         *   res++
         * n = n/2;
         *
            if((n&1) == 1){
                res ++;
            }
            n= n>>1;
        }
        return res;
        */
        //Brian keningham algo
        int res = 0 ;
        while(n>0){
            n = n&(n-1);
            res++;
        }
        return res++;
    }
    }

