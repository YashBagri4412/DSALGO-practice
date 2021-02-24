package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(BitmanipulationSolution.KthSetBit(5,1));
        //true
        System.out.println(BitmanipulationSolution.KthSetBit(8,2));
        //false
        System.out.println(BitmanipulationSolution.countSetBit(5));
        //2
        System.out.println(BitmanipulationSolution.countSetBit(7));
        //3
        LookUpMethod test = new LookUpMethod();

        test.initialize();
        System.out.println(test.count(13));
    }
}
