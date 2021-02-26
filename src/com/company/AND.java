package com.company;

import java.util.Arrays;

public class AND {
    public static int checkCount(int pattern,int arr[],int n){
        int count = 0;
        for(int i=0;i<n;i++){
            if((pattern&arr[i]) == pattern){
                count++;

            }
        }

        return count;
    }
    public static int maxAND (int arr[], int n) {
        int res=0;
        int count;
        for(int i=31;i>=0;i--){
            count = checkCount(res|(1<<i),arr,n);
            if(count>=2){
                res |= (1<<i);
            }
        }



    return res;
    }
}
