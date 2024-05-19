package InputParsers;

import org.junit.jupiter.api.Test;

import static InputParsers.InstructionParser.convertingStringToInstruction;
import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    void correctInputVerifyFormat(){
        String input1 = "LMR";
        String input2 = "LLLLRRRRMMMMM";
        String input3 = "";
        String input4 = "LLLRRRRRMMMM";

        assertTrue(InstructionParser.verifyFormat.test(input1));
        assertTrue(InstructionParser.verifyFormat.test(input2));
        assertTrue(InstructionParser.verifyFormat.test(input3));
        assertTrue(InstructionParser.verifyFormat.test(input4));

    }

    @Test
    void incorrectInputVerifyFormat(){
        String input1 = " ";
        String input2 = "LLL LRRRRMMMMM";
        String input3 = "RJKL";
        String input4 = "lrm";

        assertFalse(InstructionParser.verifyFormat.test(input1));
        assertFalse(InstructionParser.verifyFormat.test(input2));
        assertFalse(InstructionParser.verifyFormat.test(input3));
        assertFalse(InstructionParser.verifyFormat.test(input4));

    }

    @Test
    void convertingStringToInstructions(){

        String input1 = "L";
        String input2 = "R";
        String input3 = "M";

        assertEquals(Instruction.L, convertingStringToInstruction.apply("L"));
        assertEquals(Instruction.R, convertingStringToInstruction.apply("R"));
        assertEquals(Instruction.M, convertingStringToInstruction.apply("M"));
    }
}