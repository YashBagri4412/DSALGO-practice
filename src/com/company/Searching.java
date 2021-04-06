package com.company;

import java.util.ArrayList;

public class Searching {
    static public int binarySearchIterative(int[] arr,int x){
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end)/2;
        while(start<=end){
            if(arr[mid]>x){
                end = mid-1;
            }else if(arr[mid]<x){
                start = mid+1;
            }
            if(arr[mid]==x){
                return mid;
            }
            System.out.println("Start : " + start);
            System.out.println("End : " + end);
            mid = (start+end)/2;
        }
        return -1;
    }

    static public int binarySearchRecursive(int[] arr,int x,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(arr[mid]==x)
            return mid;
        else if(arr[mid]>x){
            return binarySearchRecursive(arr,x,start,mid-1);
        }else{
            return binarySearchRecursive(arr,x,mid+1,end);
        }

    }

    static public int ocurenceOfSmallestIndex(int[] arr,int x){
        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid]>x){
                end = mid - 1;
            }else if(arr[mid]<x){
                start = mid + 1;
            }else if(arr[mid] == x){
                if(mid == 0 || arr[mid]!=arr[mid-1]){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    static public int occurenceOfLargestIndex(int[] arr,int x){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]>x){
                end = mid - 1;
            }else if(arr[mid]<x){
                start = mid + 1;
            }else{
                if(mid == arr.length-1 || arr[mid+1]!=arr[mid]){
                    return mid;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }

    static public int countOfOcc(int[] arr,int x){
        int largestIndex = occurenceOfLargestIndex(arr,x);
        int smallestIndex = ocurenceOfSmallestIndex(arr,x);
        if(largestIndex == -1 || smallestIndex ==-1){
            return 0;
        }else{
            return largestIndex - smallestIndex + 1;
        }
    }

    static public int noOf1(int[] arr){
        int firstOcc = ocurenceOfSmallestIndex(arr,1);
        if(firstOcc == -1)
            return 0;
        else
            return arr.length - firstOcc;
    }

    static public int sqaureRoot(int x){
        int start = 1;
        int end = x;
        int res = Integer.MIN_VALUE;
        while(start<=end){
            int mid = (start+end)/2;
            int midSq = mid*mid;
            if(midSq>x){
                end = mid - 1;
            }else if(midSq == x){
                return mid;
            }else{
                start = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public static int searchInRotatedAndSorted(int[] arr,int x){
        int start = 0;
        int end = arr.length - 1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] == x){
                return mid;
            }
            if(arr[start] < arr[mid]){
                if(arr[start]<=x && arr[mid]>x){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(arr[mid]<x&&arr[end]>=x){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int getPeak(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start<=end){
            int mid = (start+end)/2;
            if((mid == 0 || arr[mid-1]<=arr[mid]) && (mid == arr.length - 1 || arr[mid+1]<=arr[mid])){
                return mid;
            }
            if(mid>0 && arr[mid]<=arr[mid-1]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    static public ArrayList<Integer> getUnsortedSum(int[] arr,int sum){
        //Hashing is best for this
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0 ; i < arr.length ;i++){
            for(int j = i+1 ;j<arr.length;j++){
                if((arr[i]+arr[j]) == sum ){
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return res;
    }

    static public ArrayList<Integer> getSortedSum(int[] arr,int sum){
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        int end = arr.length - 1;
        while(start<end){
            if(arr[start]+arr[end] == sum){
                res.add(start);
                res.add(end);
                return res;
            }else if((arr[start]+arr[end]) > sum){
                end--;
            }else{
                start++;
            }
        }
        return res;
    }

    static public boolean isPair(int[] arr,int start,int end,int sum){
        while(start<end){
            if((arr[start]+arr[end])==sum){
                return true;
            }else if((arr[start]+arr[end])>sum){
                end--;
            }else{
                start++;
            }
        }
        return false;
    }

    static public boolean isTriplet(int[] arr,int sum){
        for(int i=0;i<arr.length;i++){
            if(isPair(arr,i+1,arr.length-1,sum-arr[i])){
                return true;
            }
        }
        return false;
    }

    static public double getMedian(int[] a1,int[] a2){
        int n1 = a1.length, n2 = a2.length;
        int start = 0,end = n1;
        while(start<=end){
            int i1 = (start+end)/2;
            int i2 = ((n1+n2+1)/2) - i1;
            int min1 = (i1==n1)?Integer.MAX_VALUE:a1[i1];
            int max1 = (i1==0)?Integer.MIN_VALUE:a1[i1-1];
            int min2 = (i2==n2)?Integer.MAX_VALUE:a2[i2];
            int max2 = (i2==0)?Integer.MIN_VALUE:a2[i2-1];
            if(max1<=min2 && max2<=min1){
                if((n1+n2)%2 == 0){
                    return (double) (Math.min(min2,min1)+Math.max(max1,max2))/2;
                }else{
                    return (double) Math.max(max1,max2);
                }
            }
            if(min2<max1){
                end = i1 - 1;
            }else{
                start = i1 + 1;
            }
        }
        return 0;
    }
}
