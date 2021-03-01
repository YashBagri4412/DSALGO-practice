package com.company;

public class GameOfCricket {
    public static int game(int n){
        int[] array = {2,4,6};
        int count = 0;
        if(n%2 == 0){
            count += 1;
        }
        if(n%4 == 0){
            count ++;
        }
        if(n%6 == 0){
            count ++;
        }
        for(int i=0;i<array.length;i++){
            int number = n - array[i];
            for(int j = 0;j< array.length;j++){
                if(number%array[j] == 0 && array[i]!=array[j] && number !=0 && number>0){
                    count++;
                }
            }
            number = 0;
        }
        return count;
    }
}
