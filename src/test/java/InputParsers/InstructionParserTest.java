package InputParsers;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static InputParsers.InstructionParser.convertingStringToInstruction;
import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    InstructionParser instructionParser = new InstructionParser();

    @Test
    void correctInputGetInstructions() {
        Scanner scanner = new Scanner("LMR\nMMMM\n\n");

        Instruction[] expectedOutput1 = new Instruction[]{Instruction.L, Instruction.M, Instruction.R};
        Instruction[] expectedOutput2 = new Instruction[]{Instruction.M, Instruction.M, Instruction.M, Instruction.M};
        Instruction[] expectedOutput3 = new Instruction[]{};

        Instruction[] actualOutput1 = instructionParser.getInstructions(scanner);
        Instruction[] actualOutput2 = instructionParser.getInstructions(scanner);
        Instruction[] actualOutput3 = instructionParser.getInstructions(scanner);

        assertArrayEquals(expectedOutput1,actualOutput1);
        assertArrayEquals(expectedOutput2,actualOutput2);
        assertArrayEquals(expectedOutput3,actualOutput3);
    }

    @Test
    void incorrectInputGetInstructions() {
        Scanner scanner = new Scanner("L R\nKE\n \nLLMMNNEEE\nMMMM");


        Instruction[] expectedOutput1 = new Instruction[]{Instruction.M, Instruction.M, Instruction.M, Instruction.M};



        Instruction[] actualOutput1 = instructionParser.getInstructions(scanner);


        assertArrayEquals(expectedOutput1,actualOutput1);

    }

    @Test
    void stringToInstructions() {
        String input1 = "LMR";
        String input2 = "MMMM";
        String input3 = "";

        Instruction[] ExpectedOutput1 = new Instruction[]{Instruction.L, Instruction.M, Instruction.R};
        Instruction[] ExpectedOutput2 = new Instruction[]{Instruction.M, Instruction.M, Instruction.M, Instruction.M};
        Instruction[] ExpectedOutput3 = new Instruction[]{};

        assertArrayEquals(ExpectedOutput1, instructionParser.stringToInstructions(input1));
        assertArrayEquals(ExpectedOutput2, instructionParser.stringToInstructions(input2));
        assertArrayEquals(ExpectedOutput3, instructionParser.stringToInstructions(input3));

    }

    @Test
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