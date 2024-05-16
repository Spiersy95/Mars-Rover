package InputParsers;

import org.junit.jupiter.api.Test;

import static InputParsers.RoverStartParser.checkRoverInBounds;
import static InputParsers.RoverStartParser.getCompassDirection;
import static org.junit.jupiter.api.Assertions.*;

class RoverStartParserTest {

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
        String inputN = "N";
        String inputE = "E";
        String inputS = "S";
        String inputW = "W";

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