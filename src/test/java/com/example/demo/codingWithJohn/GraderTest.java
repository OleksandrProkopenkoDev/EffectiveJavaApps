package com.example.demo.codingWithJohn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GraderTest {

    @Test //test different scenarios in different methods
    void fiftyNineShouldReturnF() {
        var grader = new Grader();
        assertEquals('F',grader.determineLetterGrade(59));
    }

    @Test //test different scenarios in different methods
    void sixtyNineShouldReturnD() {
        var grader = new Grader();
        assertEquals('D',grader.determineLetterGrade(69));
    }

    @Test //test different scenarios in different methods
    void sixtyShouldReturnD() {
        var grader = new Grader();
        assertEquals('D',grader.determineLetterGrade(60));
    }
    @Test //test different scenarios in different methods
    void seventyNineShouldReturnC() {
        var grader = new Grader();
        assertEquals('C',grader.determineLetterGrade(79));
    }
    @Test //test different scenarios in different methods
    void seventyShouldReturnC() {
        var grader = new Grader();
        assertEquals('C',grader.determineLetterGrade(70));
    }
    @Test //test different scenarios in different methods
    void eightyShouldReturnB() {
        var grader = new Grader();
        assertEquals('B',grader.determineLetterGrade(80));
    }

    @Test //test different scenarios in different methods
    void eightyNineShouldReturnB() {
        var grader = new Grader();
        assertEquals('B',grader.determineLetterGrade(89));
    }

    @Test //test different scenarios in different methods
    void ninetyNineShouldReturnA() {
        var grader = new Grader();
        assertEquals('A',grader.determineLetterGrade(99));
    }

    @Test //test different scenarios in different methods
    void ninetyShouldReturnA() {
        var grader = new Grader();
        assertEquals('A',grader.determineLetterGrade(90));
    }
    @Test //test different scenarios in different methods
    void negativeShouldThrow() {
        var grader = new Grader();
        assertThrows(IllegalArgumentException.class,
                ()-> grader.determineLetterGrade(-10));
    }
}