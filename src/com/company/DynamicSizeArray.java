package com.company;

import java.util.ArrayList;

public class DynamicSizeArray {

    public static ArrayList<Integer> addInt() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        return arr;
    }

    public static int searchUnsortedArray(ArrayList<Integer> arr, int x) {
        for (int i = 0; i < arr.size(); i++) {
            if (x == arr.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
