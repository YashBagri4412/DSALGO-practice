package com.company;

public class Sorting {
    public static void swap(Integer a,Integer b){
        System.out.println("a: "+a+" b: "+b);
        Integer temp = a;
        a = b;
        b = temp;
        System.out.println("After Sorting");
        System.out.println("a: "+a+" b: "+b);
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            boolean swapped = false;
            for(int j = 0 ; j < arr.length - i - 1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
                if(!swapped){
                    break;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        int min_index;
        for(int i=0;i<arr.length-1;i++){
            min_index = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }

    public static void insertionSort(int[] arr){
        // 40 20 10
        for(int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static int[] mergeTwoSortedArray(int[] a,int[] b){
        // 10 15 20
        // 5 6 6 15
        //i=123
        int[] res = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<a.length && j<b.length){
           if(a[i]<b[j]){
               res[count] = a[i];
               count++;
               i++;
           }else if(a[i]>b[j]){
               res[count] = b[j];
               count++;
               j++;
           }else{
               res[count] = a[i];
               res[count+1] = b[j];
               count+=2;
               i++;
               j++;
           }
        }

            while(j<b.length){
                res[count]=b[j];
                count++;
                j++;
            }


            while(i<a.length){
                res[count]=a[i];
                count++;
                i++;
            }

        return res;
    }
}
