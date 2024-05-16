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



}