package InputParsers;

import org.junit.jupiter.api.Test;

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
    void WrongFormatVerifyFormat(){
        String input1 = "0 3  N";
        String input2 = "2 ww N";
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

}