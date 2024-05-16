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

        assertTrue(PlateauParser.plateauFormatVerify.test(input1));
        assertTrue(PlateauParser.plateauFormatVerify.test(input2));
        assertTrue(PlateauParser.plateauFormatVerify.test(input3));
    }

    @Test
    void noNegativeInputPlateauFormatVerifyTest(){
        String input1 = "-55 23";
        String input2 = "50 -20";
        String input3 = "-2 -1000";


        assertFalse(PlateauParser.plateauFormatVerify.test(input1));
        assertFalse(PlateauParser.plateauFormatVerify.test(input2));
        assertFalse(PlateauParser.plateauFormatVerify.test(input3));
    }

    @Test
    void zeroStartPlateauFormatVerifyTest(){
        String input1 = "0 0";
        String input2 = "0 32";
        String input3 = "050 0";
        String input4 = "323 03";


        assertFalse(PlateauParser.plateauFormatVerify.test(input1));
        assertFalse(PlateauParser.plateauFormatVerify.test(input2));
        assertFalse(PlateauParser.plateauFormatVerify.test(input3));
        assertFalse(PlateauParser.plateauFormatVerify.test(input4));
    }

    @Test
    void missingInputPlateauFormatVerifyTest(){
        String input1 = "1 ";
        String input2 = "32";
        String input3 = " 2320";
        String input4 = "323 03";


        assertFalse(PlateauParser.plateauFormatVerify.test(input1));
        assertFalse(PlateauParser.plateauFormatVerify.test(input2));
        assertFalse(PlateauParser.plateauFormatVerify.test(input3));
        assertFalse(PlateauParser.plateauFormatVerify.test(input4));
    }

    @Test
    void extraInputPlateauFormatVerifyTest(){
        String input1 = "55 23 3323";
        String input2 = "50 20 ";
        String input3 = "2 1000 3232";

        assertFalse(PlateauParser.plateauFormatVerify.test(input1));
        assertFalse(PlateauParser.plateauFormatVerify.test(input2));
        assertFalse(PlateauParser.plateauFormatVerify.test(input3));
    }

}