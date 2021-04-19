package com.company;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static void mergeTwoSortedArray(int[] a,int[] b){
        // 10 15 20
        // 5 6 6 15
        //i=123
        int i = 0;
        int j = 0;
        while(i<a.length&&j<b.length){
            if(a[i]<=b[j]){
                System.out.print(a[i]+" ");
                i++;
            }else{
                System.out.print(b[j]+" ");
                j++;
            }
        }
        while(i<a.length){
            System.out.print(a[i]+" ");
            i++;
        }
        while(j<b.length){
            System.out.print(b[j]+" ");
            j++;
        }
    }

    public static void mergeSort(int[] arr,int low,int high){
        if(low<high){
            int mid = low + (high-low)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }



    static void merge(int[] arr,int low,int mid,int high){
        int[] left = new int[mid-low+1];
        int[] right = new int[high - mid];

        for(int i=0;i<left.length;i++){
            left[i] = arr[low+i];
        }
        for(int i=0;i<right.length;i++){
            right[i] = arr[mid+1+i];
        }
        int i = 0;
        int j = 0;
        int count = low;// we have to write from low
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[count++] = left[i++];
            }else{
                arr[count++] = right[j++];
            }
        }
        while(i<left.length){
            arr[count++]=left[i++];
        }
        while(j<right.length){
            arr[count++]=right[j++];
        }
    }

    public static ArrayList<Integer> intersectionOfTwoArray(int[] a,int[] b){
        ArrayList<Integer> res = new ArrayList<>();
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(i>0 && a[i]==a[i-1]){
                i++;
                continue;
            }
            if(j>0 && b[j]==b[j-1]){
                j++;
                continue;
            }
            if(a[i]<b[j]){
                i++;
            }else if(a[i]>b[j]){
                j++;
            }else{
                res.add(a[i]);
                i++;j++;
            }
        }
        return res;
    }

    public static ArrayList<Integer> unionOfTwoArray(int[] a,int[] b){
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i<a.length && j<b.length){
            if(i>0 && a[i]==a[i-1]){
                i++;
                continue;
            }
            if(j>0 && b[j-1]==b[j]){
                j++;
                continue;
            }
            if(a[i]<b[j]){
                res.add(a[i]);
                i++;
            }else if(a[i]>b[j]){
                res.add(b[j]);
                j++;
            }else{
                res.add(a[i]);
                i++;
                j++;
            }
        }
        while(i<a.length){
            res.add(a[i]);i++;
        }
        while(j<b.length){
            res.add(b[j]);j++;
        }
        return res;
    }

    public static int countInv(int[] arr,int low,int high){
        int res = 0;
        if(low<high){
            int mid = (low+high)/2;
            res += countInv(arr,low,mid);
            res += countInv(arr,mid+1,high);
            res += countAndMerge(arr,low,mid,high);
        }
        return res;
    }

    public static int countAndMerge(int[] arr,int low,int mid,int high){
        int[] left = new int[mid-low+1];
        int[] right = new int[high - mid];

        for(int i = 0 ;i<left.length;i++){
            left[i] = arr[low+i];
        }

        for(int j=0;j<right.length;j++){
            right[j] = arr[mid+1+j];
        }

        int res = 0,i = 0,j = 0,k = low;
        while(i<left.length && j<right.length){
            if(right[j]>=left[i]){
                arr[k++] = left[i++];
            }else{
                res += (left.length - i);
                arr[k++] = right[j++];
            }
        }
        while(i<left.length){
            arr[k++]=left[i++];
        }
        while(j<right.length){
            arr[k++] = right[j++];
        }
        return res;
    }

    public static void naivePartition(int[] arr,int low,int high,int partition){
        int[] temp = new int[high-low+1];
        int index = 0;
        for(int i=low;i<=high;i++){
            if(arr[i]<=arr[partition]){
                temp[index++]=arr[i];
            }
        }
        for(int i=low;i<=high;i++){
            if(arr[i]>arr[partition]){
                temp[index++]=arr[i];
            }
        }
        for(int i=low;i<=high;i++){
            arr[i] = temp[i-low];
        }

    }

}
