package com.company;

public class LookUpMethod {
    static int[] table = new int[256];
    static public void initialize(){
        table[0] = 0;
        for(int i=1;i<256;i++){
            table[i] = (i&1) + table[i/2];
             //System.out.println(table[i]);
        }

    }
    public static int  count(int i){
        initialize();
        int total = 0;
        for(int n=1 ;n<=i;n++) {
            int res = 0;
            res = table[n & 0xff];
            n = n >> 8;
            res = res + table[n & 0xff];
            n = n >> 8;
            res = res + table[n & 0xff];
            n = n >> 8;
            res = res + table[n & 0xff];
            total += res;
            System.out.println(total);
        }
        return total;
    }
}
