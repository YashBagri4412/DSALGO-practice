package com.company;

public class Main {

    public static void main(String[] args) {
        /*System.out.println(BitmanipulationSolution.KthSetBit(5,1));
        //true
        System.out.println(BitmanipulationSolution.KthSetBit(8,2));
        //false
        System.out.println(BitmanipulationSolution.countSetBit(5));
        //2
        System.out.println(BitmanipulationSolution.countSetBit(893339));
        //3
        LookUpMethod test = new LookUpMethod();

        test.initialize();
        System.out.println(test.count(13));*/
        int[] arr ={1,3,4};
        System.out.println(FindTheMissingNumber.find(arr));
        //2
        int[] arr2 = {1,5,3,2};
        System.out.println(FindTheMissingNumber.find(arr2));
        //4
        int[] arr3 = {3,4,3,4,5,4,4,6,7,7};
        int[] result =TwoOddApperaring.twoOddAppearing(arr3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        PowerSet.powerSet("abc");



    }
}
