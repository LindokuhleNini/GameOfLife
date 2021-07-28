package com.optisolutions;

public class GolSimulation {
    public int rows = Main.rows;
    public int cols = Main.cols;

    //sets up a board with random cells
    public void setupBoard(Board board){
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                int randomNum = (int) (Math.random() * 3);
                if (randomNum == 0){
                    board.set(r, c, 1);
                }
            }
        }
    }

    //Display board on the screen
    public boolean displayBoard(Board board){
        for(int r = 0; r<rows; r++){
            String line = "";
            for(int c = 0; c<cols; c++){
                if(board.get(r, c) == 0){
                    line += ".";
                }
                else{
                    line += "0";
                }
            }
            System.out.println(line);
        }
        System.out.println("\n");
        return true;
    }

    //Takes current board, implements rules of Game of Life and stores results on a new board.
    public void createNewGeneration(Board board, Board newBoard){

        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(board.get(r, c) == 1){
                    if(countNeighbors(r, c, board) < 2){
                        newBoard.set(r, c, 0);
                    }
                    else if(countNeighbors(r, c, board) < 4){
                        newBoard.set(r, c, 1);
                    }
                    else if(countNeighbors(r, c, board) > 3){
                        newBoard.set(r, c, 0);
                    }
                }
                else if(board.get(r, c) == 0 && countNeighbors(r, c, board) == 3){
                    newBoard.set(r, c, 1);
                }
            }
        }

    }

    public void newBoard(Board board, Board newBoard){
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                board.set(r, c, newBoard.get(r, c));
            }
        }
    }

    //Counts the 8 cells around a given cell
    private int countNeighbors(int row, int col, Board b) {
        int count = 0;

        for(int r =  row - 1; r<=row + 1; r++){
            for(int c =  col - 1; c<=col + 1; c++){
                if(r >= 0 && r < rows &&
                        c >= 0 && c < cols &&
                        !(r == row && c == col) &&
                        b.get(r, c) == 1){
                    count ++;
                }
            }
        }
        return count;
    }

    public void slow(int timeDelay){
        try {
            Thread.sleep(timeDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
