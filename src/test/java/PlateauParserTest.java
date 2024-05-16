import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauParserTest {

    @Test
    void getPlateauDim() {
    }

    @Test
    void correctInputPlateauFormatVerifyTest(){
        String input1 = "55 23";
        String input2 = "50 20";
        String input3 = "2 1000";

        boolean ExpectedOutput1 = true;
        boolean ExpectedOutput2 = true;
        boolean ExpectedOutput3 = true;

        assertTrue(PlateauParser.plateauFormatVerify.test(input1));
        assertTrue(PlateauParser.plateauFormatVerify.test(input2));
        assertTrue(PlateauParser.plateauFormatVerify.test(input3));
    }

    void noNegativeInputPlateauFormatVerifyTest(){
        String input1 = "55 23";
        String input2 = "50 20";
        String input3 = "2 1000";

        boolean ExpectedOutput1 = true;
        boolean ExpectedOutput2 = true;
        boolean ExpectedOutput3 = true;

        assertTrue(PlateauParser.plateauFormatVerify.test(input1));
        assertTrue(PlateauParser.plateauFormatVerify.test(input2));
        assertTrue(PlateauParser.plateauFormatVerify.test(input3));
    }
}