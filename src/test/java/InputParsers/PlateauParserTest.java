package InputParsers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlateauParserTest {

    @Test
    void correctInputGetPlateauDim() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("5 2\n2 3".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        int ExpectedOutput1x = 5;
        int ExpectedOutput1y = 2;
        int ExpectedOutput2x = 2;
        int ExpectedOutput2y = 3;

        PlateauSize plateau1 = PlateauParser.getPlateauSize(scanner);
        PlateauSize plateau2 = PlateauParser.getPlateauSize(scanner);

        int actualOutput1x = plateau1.getWidth();
        int actualOutput1y = plateau1.getLength();
        int actualOutput2x = plateau2.getWidth();
        int actualOutput2y = plateau2.getLength();


        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);
        assertEquals(ExpectedOutput2x, actualOutput2x);
        assertEquals(ExpectedOutput2y, actualOutput2y);

        scanner.close();
        System.setIn(sysInBackup);
    }

    @Test
    void incorrectInputGetPlateauDim() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("Hello\n0 0\n-444\n-3 -3\n2 3".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        int ExpectedOutput1x = 2;
        int ExpectedOutput1y = 3;

        PlateauSize plateau1 = PlateauParser.getPlateauSize(scanner);


        int actualOutput1x = plateau1.getWidth();
        int actualOutput1y = plateau1.getLength();



        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);

        scanner.close();
        System.setIn(sysInBackup);
    }


    @Test
    void correctInputPlateauFormatVerifyTest(){
        String input1 = "5 2";
        String input2 = "5 2";
        String input3 = "2 1";

        assertTrue(PlateauParser.verifyFormat.test(input1));
        assertTrue(PlateauParser.verifyFormat.test(input2));
        assertTrue(PlateauParser.verifyFormat.test(input3));
    }
    @Test
    void tooLargeInputPlateauFormatVerifyTest(){
        String input1 = "55 23";
        String input2 = "50 20";
        String input3 = "2 1000";

        assertFalse(PlateauParser.verifyFormat.test(input1));
        assertFalse(PlateauParser.verifyFormat.test(input2));
        assertFalse(PlateauParser.verifyFormat.test(input3));
    }

    @Test
    void noNegativeInputPlateauFormatVerifyTest(){
        String input1 = "-5 2";
        String input2 = "5 -2";
        String input3 = "-2 -1";


        assertFalse(PlateauParser.verifyFormat.test(input1));
        assertFalse(PlateauParser.verifyFormat.test(input2));
        assertFalse(PlateauParser.verifyFormat.test(input3));
    }

    @Test
    void zeroStartPlateauFormatVerifyTest(){
        String input1 = "0 0";
        String input2 = "0 2";
        String input3 = "5 0";
        String input4 = "3 0";


        assertFalse(PlateauParser.verifyFormat.test(input1));
        assertFalse(PlateauParser.verifyFormat.test(input2));
        assertFalse(PlateauParser.verifyFormat.test(input3));
        assertFalse(PlateauParser.verifyFormat.test(input4));
    }

    @Test
    void missingInputPlateauFormatVerifyTest(){
        String input1 = "1 ";
        String input2 = "32";
        String input3 = " 2320";
        String input4 = "323 03";


        assertFalse(PlateauParser.verifyFormat.test(input1));
        assertFalse(PlateauParser.verifyFormat.test(input2));
        assertFalse(PlateauParser.verifyFormat.test(input3));
        assertFalse(PlateauParser.verifyFormat.test(input4));
    }

    @Test
    void extraInputPlateauFormatVerifyTest(){
        String input1 = "5 2 3";
        String input2 = "5 2 ";
        String input3 = "2 1 3";

        assertFalse(PlateauParser.verifyFormat.test(input1));
        assertFalse(PlateauParser.verifyFormat.test(input2));
        assertFalse(PlateauParser.verifyFormat.test(input3));
    }

    @Test
    void wordPlateauFormatVerifyTest(){
        String input1 = "three four";
        String input2 = "one space";
        String input3 = "hello there";

        assertFalse(PlateauParser.verifyFormat.test(input1));
        assertFalse(PlateauParser.verifyFormat.test(input2));
        assertFalse(PlateauParser.verifyFormat.test(input3));
    }



}