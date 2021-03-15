package com.company;

import java.util.ArrayList;

public class FixedSizeArray {
    public static int[] fixSizeArray(int[] arr,int n,int cap,int value,int pos){
        if(cap == n){
            return null;
        }
        int idx = pos-1;
        for(int i=cap-1;i>=idx;i--){
            arr[i+1] = arr[i];
        }
        arr[idx] = value;
        return arr;
    }

    public static int[] deletion(int[] arr,int n,int cap,int element){
        int pos = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] == element){
                pos = i;
                break;
            }
        }
        if(pos == Integer.MAX_VALUE){
            return null;
        }
        for(int i=pos;i<n-1;i++){
            arr[i] = arr[i+1];
        }
        arr[n-1]=0;
        return arr;
    }

    public static int findLargestElement(int[] arr){

        int indexOfLargest = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[indexOfLargest]<arr[i]){
                indexOfLargest = i;
            }
        }
        return indexOfLargest;
    }

    public static int secondLargestElement(int[] arr){
        int largest = 0;
        int secondLargest = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[largest]){
                secondLargest = largest;
                largest = i;
            }
            if(arr[i] != arr[largest]){
                if(secondLargest == -1 || arr[secondLargest]<arr[i]){
                    secondLargest = i;
                }
            }
        }
        return secondLargest;
    }

    public static boolean sortedOrNot(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void swap(int first,int second){
        first = first - second;
        second = second - first;
        first = first + second;
    }
    public static int[] reverseAnArray(int[] arr){
        int runs = arr.length/2;
        for(int i=0;i<runs;i++){
            //arr[i] && arr[length-1-i]
            int temp = arr[i];
            arr[i] = arr[arr.length -1 -i];
            arr[arr.length -1-i] = temp;
        }
        return  arr;

    }

   public static int[] moveZeroToEnd(int[] arr){
       /* int[] temp = new int[arr.length];
        int res = 0;
       for (int i = 0; i < arr.length; i++) {
           if(arr[i]!=0){
               temp[res] = arr[i];
               res++;
           }
       }
       for (int i = 0; i < arr.length; i++) {
           arr[i] = temp[i];
       }
       return arr;*/

       int count = 0;
       for (int i = 0; i < arr.length; i++) {
           if(arr[i]!=0){
               int temp = arr[i];
               arr[i] = arr[count];
               arr[count] = temp;
               count++;
           }

       }
       return arr;
   }

   public static int[] rotateLeftByOne(int[] arr){
        int temp = arr[0];
       for (int i = 1; i < arr.length; i++) {
           arr[i-1] = arr[i];
       }
       arr[arr.length-1] = temp;
       return arr;
   }
    public static int[] reverse(int[] arr,int low,int high){
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }

   public static int[] rotateLeftByDPlaces(int[] arr,int d) {
       //Theta(d*n) solution constant aux space
        /*for (int i = 0; i < d; i++) {
           int temp = arr[0];
           for (int j = 1; j < arr.length; j++) {
               arr[j-1] = arr[j];
           }
           arr[arr.length-1] = temp;
       }
       return arr;*/
       /*int[] temp = new int[arr.length];
       for (int i = 0; i < arr.length; i++) {
           if(i>=d){
               temp[i-d] = arr[i];
           }else{
               temp[(arr.length-d)+i] = arr[i];
           }
       }
       for (int i = 0; i < temp.length; i++) {
           arr[i] = temp[i];
       }
       return arr;*/
       reverse(arr, 0, d - 1);
       reverse(arr, d, arr.length - 1);
       reverse(arr, 0, arr.length - 1);
       return arr;
   }
   public static void leaderInArray(int[] arr){
        ArrayList<Integer> returnValue = new ArrayList<>();
        int leader = arr[arr.length - 1];
       System.out.print(leader+" ");
        for(int i = arr.length-2;i>=0;i--) {
            if (arr[i] > leader) {
                leader = arr[i];
                System.out.print(leader + " ");
            }
        }
   }
   public static int maxDifference(int[] arr){
        /*int small = 0;
        int large = 0;
        int sum = Integer.MIN_VALUE;
       for (int i = 1; i < arr.length ; i++) {
           if(arr[i]<small){
                small = i;
           }
           if(arr[i]>large){
               large = i;
           }
           if((arr[large]-arr[small]) > sum && large>small){
               sum = arr[large] - arr[small];
           }
       }
       return sum;*/

       int minValue = arr[0];
       int maxSum = arr[1] - arr[0];
       for (int i = 1; i < arr.length ; i++) {
           maxSum = Math.max(maxSum,arr[i]-minValue);
           minValue = Math.min(arr[i],minValue);
       }
       return maxSum;
   }


}
