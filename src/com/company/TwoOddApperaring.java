package com.company;

public class TwoOddApperaring {
    public static int[] twoOddAppearing(int[] arr){
        int[] returnArray = new int[2];
        int Xor=0,res1=0,res2=0;
        //xor of entire array even appearning number cancel
        for(int i=0;i<arr.length;i++){
            Xor ^= arr[i];
        }
        //calculate rightmost set bit
        int rightMostSetBit = Xor & (~(Xor-1));
        //check in array which element has rightmost set bit as 1
        for(int i=0;i<arr.length;i++){
            if((arr[i]&rightMostSetBit) == 1){
                res1 ^= arr[i];
            }else{
                res2 ^= arr[i];
            }
        }
        returnArray[0] = res1;
        returnArray[1] = res2;
        return returnArray;
    }
}
