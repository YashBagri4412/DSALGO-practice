package com.company;

public class LookUpMethod {
    int[] table = new int[256];
    public void initialize(){
        table[0] = 0;
        for(int i=1;i<256;i++){
            table[i] = (i&1) + table[i/2];
             //System.out.println(table[i]);
        }

    }
    public int count(int n){
        int res = 0;
        res = table[n&0xff];
        n = n>>8;
        res = res + table[n&0xff];
        n = n>>8;
        res = res + table[n&0xff];
        n = n>>8;
        res = res + table[n&0xff];
        return res;
    }
}
