package InputParsers;
import DataTypes.PlateauSize;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlateauParserTest {

    @Test
    void correctInputParsePlateauDim() throws IncorrectPlateauFormatException {

        PlateauParser plateauParser = new PlateauParser();


        Scanner scanner = new Scanner("5 2\n2 3");

        int ExpectedOutput1x = 5;
        int ExpectedOutput1y = 2;
        int ExpectedOutput2x = 2;
        int ExpectedOutput2y = 3;

        PlateauSize plateau1 = plateauParser.parsePlateauSize(scanner);
        PlateauSize plateau2 = plateauParser.parsePlateauSize(scanner);

        int actualOutput1x = plateau1.width();
        int actualOutput1y = plateau1.length();
        int actualOutput2x = plateau2.width();
        int actualOutput2y = plateau2.length();


        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);
        assertEquals(ExpectedOutput2x, actualOutput2x);
        assertEquals(ExpectedOutput2y, actualOutput2y);

        scanner.close();

    }

    @Test
    void incorrectInputParsePlateauDim() throws IncorrectPlateauFormatException {
        PlateauParser plateauParser = new PlateauParser();

        Scanner scanner = new Scanner("Hello\n0 0\n-444\n-3 -3\n2 3");

        int ExpectedOutput1x = 2;
        int ExpectedOutput1y = 3;

        assertThrows(IncorrectPlateauFormatException.class, () -> plateauParser.parsePlateauSize(scanner));
        assertThrows(IncorrectPlateauFormatException.class, () -> plateauParser.parsePlateauSize(scanner));
        assertThrows(IncorrectPlateauFormatException.class, () -> plateauParser.parsePlateauSize(scanner));
        assertThrows(IncorrectPlateauFormatException.class, () -> plateauParser.parsePlateauSize(scanner));

        PlateauSize plateau1 = plateauParser.parsePlateauSize(scanner);



        int actualOutput1x = plateau1.width();
        int actualOutput1y = plateau1.length();



        assertEquals(ExpectedOutput1x, actualOutput1x);
        assertEquals(ExpectedOutput1y, actualOutput1y);

        scanner.close();

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