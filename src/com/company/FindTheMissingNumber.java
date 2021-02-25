package com.company;

public class FindTheMissingNumber {
    public static int find(int[] arr){
        int res = 0;
        for(int i=0;i<arr.length;i++){
            res = res ^ arr[i];
        }
        int allRes = 0;
        for(int i=1;i<=arr.length+1;i++){
            allRes ^= i;
        }
        return allRes^res;
    }
}
