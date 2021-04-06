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
    public static void frequencyInSortedArray(int[] arr){
        int currentValue = arr[0];
        int frequency = 1;
        for (int i = 1; i < arr.length ; i++) {
            if(arr[i]!=currentValue){
                System.out.println(currentValue+":"+frequency);
                frequency = 1;
                currentValue = arr[i];
            }else{
                frequency++;
            }
        }
        System.out.println(currentValue+":"+frequency);
    }

    public static int maxProfit(int[] price,int start,int end){
        if(end <= start)
            return 0;

        int profit = 0;

        for(int i = start; i < end; i++)
        {
            for(int j = i + 1; j <= end; j++)
            {
                if(price[j] > price[i])
                {
                    int curr_profit = price[j] - price[i]
                            + maxProfit(price, start, i - 1)
                            + maxProfit(price, j + 1, end);

                    profit = Math.max(profit, curr_profit);
                }
            }
        }

        return profit;
    }

    public static int buyAndSellStocks(int[] arr){
        int profit = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                profit+=arr[i]-arr[i-1];
            }
        }
        return profit;
    }


    public static int trappingRainWater(int[] arr){
        /*int res = 0;
        for(int i=1;i<arr.length-1;i++){
            int lmax = arr[i];
            for (int j = 0;j<i;j++){
                lmax=Math.max(lmax,arr[j]);
            }
            int rmax = arr[i];
            for (int j = i+1;j<arr.length;j++){
                rmax=Math.max(rmax,arr[j]);
            }
            res += (Math.min(lmax,rmax)) - arr[i];
        }
        return res;*/

        //O(n) approach
        int[] rightMax = new int[arr.length];
        int[] leftMax = new int[arr.length];
        int res = 0;
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(arr[i],leftMax[i-1]);
        }
        rightMax[rightMax.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >=0 ; i--) {
            rightMax[i] = Math.max(arr[i],rightMax[i+1]);
        }
        for (int i = 0; i < arr.length; i++) {
            res += (Math.min(rightMax[i],leftMax[i])-arr[i]);
        }
        return res;
    }

    public static int countNoOfOnes(int[] arr){
        int noOfOnes = 0;
        int maxNoOfOnes = 0;
        for(int i=0;i< arr.length;i++){
            if(arr[i] == 1){
                noOfOnes++;
            }else{
                maxNoOfOnes = Math.max(noOfOnes,maxNoOfOnes);
                noOfOnes = 0;
            }

        }
        return Math.max(noOfOnes,maxNoOfOnes);
    }

    public static int maxSubArrSum(int[] arr){

//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++){
//            int cur = 0;
//            for(int j = i ;j<arr.length;j++){
//                cur += arr[j];
//                max = Math.max(cur,max);
//            }
//        }
//        return max;

        /*int max = arr[0];
        int result = Integer.MIN_VALUE;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }else{
                max+=arr[i];

            }
            result = Math.max(result,max);
        }
        return result;*/
        int maxEnding = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            maxEnding = Math.max(maxEnding+arr[i],arr[i]);
            res = Math.max(res,maxEnding);
        }
        return res;
    }

    static public int maxLengthEvenOdd(int[] arr){
        int count = 1;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]%2==0&&arr[i-1]%2!=0 || arr[i]%2!=0&&arr[i-1]%2==0){
                count++;
                res = Math.max(res,count);
            }else{
                count =1;
            }

        }
        return count;
    }


    public static int maxCircularSubarraySum(int[] arr){
        int maxEnding = arr[0];
        int res = arr[0];
        int count = 0;
        int i = 1;
        while(count != 2){

            maxEnding = Math.max(maxEnding + arr[i],arr[i]);
            System.out.println(maxEnding);
            res = Math.max(maxEnding,res);

            System.out.println(res);
            if(i == arr.length-1){
                count++;
                i=0;
                continue;
            }
            i++;
        }
        return res;
    }


    public static int majorityElement(int[] arr){
        int count = 1;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[res]==arr[i]){
                count++;
            }else{
                count --;
            }

            if(count == 0){
                res = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[res]==arr[i]){
                count++;
            }
            if(count>(arr.length/2)){
                return res;
            }
        }
        return -1;
    }

    public static int slidingWindowTechnique(int[] arr,int k){
        /*int res = 0,maxValue = Integer.MIN_VALUE;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count == k-1){
                res+=arr[i];
                maxValue = Math.max(res,maxValue);
                res=0;
                count=0;
            }
            res+=arr[i];
            count++;


        }
        return maxValue;*/

        int curSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            curSum+=arr[i];
        }
        for (int i = k; i < arr.length ; i++) {
            curSum = curSum + arr[i] - arr[i-k];
            res = Math.max(curSum,res);
        }
        return res;
    }

    static public boolean subArraySum(int[] arr,int sum){
        int curSum = arr[0];
        int start = 0;
        for(int end = 1;end<arr.length;end++){
            while(curSum > sum && start<end-1){
                curSum -= arr[start];
                start++;
            }
            if(curSum == sum)
                return true;
            if(end<arr.length){
                curSum+=arr[end];
            }
        }
        return curSum==sum;
    }

    static public int circularSumSubarray(int[] arr){
        int res = arr[0];
        for(int i=0;i<arr.length;i++){
            int cur_sum = arr[i];
            int cur_max = arr[i];
            for(int j = 1;j<arr.length;j++){
                int index = (i+j)%arr.length;
                cur_sum += arr[index];
                cur_max = Math.max(cur_max,cur_sum);
            }
            res = Math.max(res,cur_max);
        }
        return res;
    }

    static public void minNoOfSlips(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=arr[i-1]) {
                if (arr[i] != arr[0])
                    System.out.print("From " + i + " to ");
                else
                    System.out.println(i - 1);
            }
        }
        if(arr[arr.length-1]!= arr[0]){
            System.out.println(arr.length-1);
        }
    }

}
