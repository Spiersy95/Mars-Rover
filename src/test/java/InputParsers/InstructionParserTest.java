package InputParsers;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static InputParsers.InstructionParser.convertingStringToInstruction;
import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {
    @Test
    void correctInputGetInstructions() throws InvalidInstructionsException {
        Scanner scanner = new Scanner("LMR\nMMMM\n\n");
        InstructionParser instructionParser = new InstructionParser();


        Instruction[] expectedOutput1 = new Instruction[]{Instruction.L, Instruction.M, Instruction.R};
        Instruction[] expectedOutput2 = new Instruction[]{Instruction.M, Instruction.M, Instruction.M, Instruction.M};
        Instruction[] expectedOutput3 = new Instruction[]{};

        Instruction[] actualOutput1 = instructionParser.parseInstructions(scanner);
        Instruction[] actualOutput2 = instructionParser.parseInstructions(scanner);
        Instruction[] actualOutput3 = instructionParser.parseInstructions(scanner);

        assertArrayEquals(expectedOutput1,actualOutput1);
        assertArrayEquals(expectedOutput2,actualOutput2);
        assertArrayEquals(expectedOutput3,actualOutput3);
    }

    @Test
    void incorrectInputGetInstructions() throws InvalidInstructionsException {
        Scanner scanner = new Scanner("L R\nKE\n \nLLMMNNEEE\nMMMM");
        InstructionParser instructionParser = new InstructionParser();

        Instruction[] expectedOutput1 = new Instruction[]{Instruction.M, Instruction.M, Instruction.M, Instruction.M};

        assertThrows(InvalidInstructionsException.class, () -> instructionParser.parseInstructions(scanner));
        assertThrows(InvalidInstructionsException.class, () -> instructionParser.parseInstructions(scanner));
        assertThrows(InvalidInstructionsException.class, () -> instructionParser.parseInstructions(scanner));
        assertThrows(InvalidInstructionsException.class, () -> instructionParser.parseInstructions(scanner));

        Instruction[] actualOutput1 = instructionParser.parseInstructions(scanner);

        assertArrayEquals(expectedOutput1, actualOutput1);

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
    void stringToInstructionsTest(){
        InstructionParser instructionParser = new InstructionParser();
        String input1 = "LMR";
        String input2 = "MMMM";
        String input3 = "";


        Instruction[] expectedOutput1 = new Instruction[]{Instruction.L, Instruction.M, Instruction.R};
        Instruction[] expectedOutput2 = new Instruction[]{Instruction.M, Instruction.M, Instruction.M, Instruction.M};
        Instruction[] expectedOutput3 = new Instruction[]{};

        assertArrayEquals(expectedOutput1, instructionParser.stringToInstructions(input1));
        assertArrayEquals(expectedOutput2, instructionParser.stringToInstructions(input2));
        assertArrayEquals(expectedOutput3, instructionParser.stringToInstructions(input3));
    }

    @Test
    void convertingLambdaStringToInstruction(){


        assertEquals(Instruction.L, convertingStringToInstruction.apply("L"));
        assertEquals(Instruction.R, convertingStringToInstruction.apply("R"));
        assertEquals(Instruction.M, convertingStringToInstruction.apply("M"));
    }
}