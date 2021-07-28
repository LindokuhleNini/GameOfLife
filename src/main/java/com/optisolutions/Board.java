package com.optisolutions;

public class Board {

    private int[][] board;

    /**
     *Constructor for Board object
     * @param rows is the number of rows in the grid
     * @param cols is the number of columns in the grid
     */
    public Board(int rows, int cols) {
        this.board = new int[rows][cols];
    }

    //Returns the value that is in a specific row and column
    public int get(int row, int col) {
        return board[row][col];
    }

    //Store value to a specific row and column
    public void set(int row, int col, int value){
        board[row][col] = value;
    }

    //Returns the number of rows in a grid
    public int getRows(){
        return board.length;
    }

    //Returns the number of columns in a grid
    public int getColumns(){
        return board[0].length;
    }

    public String toString(){
        String result = "";
        for(int r = 0; r<getRows(); r++){
            for(int c = 0; c<getColumns(); c++){
                result += String.valueOf(board[r][c]);
            }
            result += "\n";
        }
        return result;
    }
}
