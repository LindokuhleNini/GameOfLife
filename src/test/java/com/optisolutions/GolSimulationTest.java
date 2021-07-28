package com.optisolutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GolSimulationTest {
    GolSimulation gol;
    Board b, newB;
    public int rows = Main.rows;
    public int cols = Main.cols;

    @BeforeEach
    void setUp() {
        gol = new GolSimulation();
        b = new Board(rows, cols);
        newB = new Board(rows, cols);
    }

    @Test
    void a_testSetAlive(){
        b.set(7, 5, 1);
        gol.displayBoard(b);
        assertEquals(1, b.get(7, 5));
    }

    @Test
    void b_testSetDead(){
        b.set(6, 5, 0);
        gol.displayBoard(b);
        assertEquals(0, b.get(6, 5));
    }

    @Test
    void c_firstRuleTest(){
        b.set(4, 5, 1);
        b.set(5, 5, 1);
        //b.set(6, 5, 1);
        gol.createNewGeneration(b, newB);
        gol.newBoard(b, newB);
        gol.displayBoard(b);
        assertEquals(0, b.get(5, 5));
    }

    @Test
    void d_secondRuleTest(){
        b.set(4, 5, 1);
        b.set(5, 5, 1);
        b.set(6, 5, 1);
        b.set(5, 4, 1);
        gol.displayBoard(b);
        gol.createNewGeneration(b, newB);
        gol.newBoard(b, newB);
        gol.displayBoard(b);
        assertEquals(1, b.get(5, 5));
    }

    @Test
    void e_thirdRuleTest(){
        b.set(4, 5, 1);
        b.set(5, 5, 1);
        b.set(6, 5, 1);
        b.set(5, 4, 1);
        b.set(5, 6, 1);
        gol.displayBoard(b);
        gol.createNewGeneration(b, newB);
        gol.newBoard(b, newB);
        gol.displayBoard(b);
        assertEquals(0, b.get(5, 5));
    }

    @Test
    void f_fourthRuleTest(){
        b.set(4, 5, 1);
        b.set(5, 5, 0);
        b.set(6, 5, 1);
        b.set(5, 4, 1);
        gol.displayBoard(b);
        gol.createNewGeneration(b, newB);
        gol.newBoard(b, newB);
        gol.displayBoard(b);
        assertEquals(1, b.get(5, 5));
    }
}