package com.company;

public class GameOfCricket {
    public static int game(int n){
        if(n==0)
            return 1;
        if(n<0)
            return -1;

        return (Math.max(game(n - 2), 0))+(Math.max(game(n - 4), 0))+(Math.max(game(n - 6), 0));
    }
}
