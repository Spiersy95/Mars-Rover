package UI;

import InputParsers.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static InputParsers.RoverStartParser.*;
import static org.junit.jupiter.api.Assertions.*;

class RoverStartPrompterTest {

    @Test
    void correctInputGetRoverStartTest(){

        RoverStartParser roverStartParser = new RoverStartParser();
        RoverStartPrompter roverStartPrompter = new RoverStartPrompter();

        Scanner scanner = new Scanner("5 2 N\n2 3 E\n0 0 W\n2 1 S");

        int ExpectedOutput1x = 5;
        int ExpectedOutput1y = 2;
        CompassDirection ExpectedOutputCompass1 = CompassDirection.N;

        int ExpectedOutput2x = 2;
        int ExpectedOutput2y = 3;
        CompassDirection ExpectedOutputCompass2 = CompassDirection.E;

        int ExpectedOutput3x = 0;
        int ExpectedOutput3y = 0;
        CompassDirection ExpectedOutputCompass3 = CompassDirection.W;

        int ExpectedOutput4x = 2;
        int ExpectedOutput4y = 1;
        CompassDirection ExpectedOutputCompass4 = CompassDirection.S;

        PlateauSize plateau1 = new PlateauSize(5, 3);
        PlateauSize plateau2 = new PlateauSize(2, 3);
        PlateauSize plateau3 = new PlateauSize(1, 1);
        PlateauSize plateau4 = new PlateauSize(2, 2);

        Position position1 = roverStartPrompter.prompt(scanner,roverStartParser, plateau1);
        Position position2 = roverStartPrompter.prompt(scanner,roverStartParser, plateau2);
        Position position3 = roverStartPrompter.prompt(scanner,roverStartParser, plateau3);
        Position position4 = roverStartPrompter.prompt(scanner,roverStartParser, plateau4);

        int actualOutput1x = position1.getX();
        int actualOutput1y = position1.getY();
        CompassDirection actualOutputFacing1 = position1.getFacing();

        int actualOutput2x = position2.getX();
        int actualOutput2y = position2.getY();
        CompassDirection actualOutputFacing2 = position2.getFacing();

        int actualOutput3x = position3.getX();
        int actualOutput3y = position3.getY();
        CompassDirection actualOutputFacing3 = position3.getFacing();

        int actualOutput4x = position4.getX();
        int actualOutput4y = position4.getY();
        CompassDirection actualOutputFacing4 = position4.getFacing();

        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);
        assertEquals(ExpectedOutputCompass1, actualOutputFacing1);

        assertEquals(ExpectedOutput2x, actualOutput2x);
        assertEquals(ExpectedOutput2y, actualOutput2y);
        assertEquals(ExpectedOutputCompass2, actualOutputFacing2);

        assertEquals(ExpectedOutput3x, actualOutput3x);
        assertEquals(ExpectedOutput3y, actualOutput3y);
        assertEquals(ExpectedOutputCompass3, actualOutputFacing3);

        assertEquals(ExpectedOutput4x, actualOutput4x);
        assertEquals(ExpectedOutput4y, actualOutput4y);
        assertEquals(ExpectedOutputCompass4, actualOutputFacing4);
        scanner.close();

    }

    @Test
    void incorrectInputGetRoverStartTest(){

        RoverStartParser roverStartParser = new RoverStartParser();
        RoverStartPrompter roverStartPrompter = new RoverStartPrompter();

        Scanner scanner = new Scanner("5 2 N\n4 3 F\n0   0 W\n2 3 N");

        int ExpectedOutput1x = 2;
        int ExpectedOutput1y = 3;
        CompassDirection ExpectedOutputCompass1 = CompassDirection.N;

        PlateauSize plateau1 = new PlateauSize(2, 3);

        Position position1 = roverStartPrompter.prompt(scanner, roverStartParser, plateau1);


        int actualOutput1x = position1.getX();
        int actualOutput1y = position1.getY();
        CompassDirection actualOutputFacing1 = position1.getFacing();

        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);
        assertEquals(ExpectedOutputCompass1, actualOutputFacing1);
        scanner.close();
    }



}