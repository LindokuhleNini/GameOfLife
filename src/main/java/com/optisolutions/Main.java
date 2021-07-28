package com.optisolutions;

import java.util.Scanner;


public class Main {
    public static int rows = 10;
    public static  int cols = 30;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int generations;

        System.out.print("Please enter number of rows: ");
        rows = scan.nextInt();

        System.out.print("Please enter number of columns: ");
        cols = scan.nextInt();

        System.out.print("Number of Generations: \n");
        generations = scan.nextInt();

        GolSimulation gol = new GolSimulation();
        Board b = new Board(rows, cols);
        Board newB = new Board(rows, cols);
        gol.setupBoard(b);

        for(int i = 0; i < generations; i++) {
            gol.displayBoard(b);
            gol.slow(500);
            gol.createNewGeneration(b, newB);
            gol.newBoard(b, newB);
        }

        //System.out.println(b.get(5, 5));

    }
}
