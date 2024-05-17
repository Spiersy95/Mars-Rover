package InputParsers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static InputParsers.RoverStartParser.*;
import static org.junit.jupiter.api.Assertions.*;

class RoverStartParserTest {
    RoverStartParser roverStartParser = new RoverStartParser();

    @Test
    void correctInputGetRoverStartTest() throws NotInPlateauException, IncorrectStartingPositionFormatException {

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("5 2 N\n2 3 E\n0 0 W\n2 1 S".getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

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

        Position position1 = roverStartParser.getRoverStart(scanner, plateau1);
        Position position2 = roverStartParser.getRoverStart(scanner, plateau2);
        Position position3 = roverStartParser.getRoverStart(scanner, plateau3);
        Position position4 = roverStartParser.getRoverStart(scanner, plateau4);

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
        System.setIn(sysInBackup);
    }

    @Test
    void incorrectInputGetRoverStartTest() throws NotInPlateauException, IncorrectStartingPositionFormatException {

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("5 2 N\n4 3 F\n0   0 W\n2 3 N".getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        int ExpectedOutput1x = 2;
        int ExpectedOutput1y = 3;
        CompassDirection ExpectedOutputCompass1 = CompassDirection.N;

        PlateauSize plateau1 = new PlateauSize(2, 3);
        Position position1 = roverStartParser.getRoverStart(scanner, plateau1);


        int actualOutput1x = position1.getX();
        int actualOutput1y = position1.getY();
        CompassDirection actualOutputFacing1 = position1.getFacing();

        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);
        assertEquals(ExpectedOutputCompass1, actualOutputFacing1);
        scanner.close();
        System.setIn(sysInBackup);
    }

    @Test
    void correctInputVerifyFormat(){
        String input1 = "0 3 N";
        String input2 = "2 3 N";
        String input3 = "0 3 N";
        String input4 = "5 3 N";

        assertTrue(RoverStartParser.verifyFormat.test(input1));
        assertTrue(RoverStartParser.verifyFormat.test(input2));
        assertTrue(RoverStartParser.verifyFormat.test(input3));
        assertTrue(RoverStartParser.verifyFormat.test(input4));
    }

    @Test
    void WrongInputFormatVerifyFormat(){
        String input1 = "0 3  N";
        String input2 = "2 3 F";
        String input3 = " 3 N";
        String input4 = "5 3 ";
        String input5 = "";
        String input6 = " ";
        String input7 = "sdkfjdskhfk";
        String input8 = "s3 59 ";

        assertFalse(RoverStartParser.verifyFormat.test(input1));
        assertFalse(RoverStartParser.verifyFormat.test(input2));
        assertFalse(RoverStartParser.verifyFormat.test(input3));
        assertFalse(RoverStartParser.verifyFormat.test(input4));
        assertFalse(RoverStartParser.verifyFormat.test(input5));
        assertFalse(RoverStartParser.verifyFormat.test(input6));
        assertFalse(RoverStartParser.verifyFormat.test(input7));
        assertFalse(RoverStartParser.verifyFormat.test(input8));
    }

    @Test
    void getCompassDirectionsTest(){

        assertEquals(CompassDirection.N, getCompassDirection.apply("N"));
        assertEquals(CompassDirection.E, getCompassDirection.apply("E"));
        assertEquals(CompassDirection.S, getCompassDirection.apply("S"));
        assertEquals(CompassDirection.W, getCompassDirection.apply("W"));

    }

    @Test
    void CheckRoverInBoundsTest(){
        int inputNum1 = 0;
        int inputBound1 = 5;

        int inputNum2 = 1;
        int inputBound2 = 1;

        int inputNum3 = 5;
        int inputBound3 = 3;

        assertTrue(checkRoverInBounds.test(inputNum1, inputBound1));
        assertTrue(checkRoverInBounds.test(inputNum2, inputBound2));
        assertFalse(checkRoverInBounds.test(inputNum3, inputBound3));
    }

}