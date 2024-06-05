package UI;

import DataTypes.Instruction;
import InputParsers.InstructionParser;
import InputParsers.InvalidInstructionsException;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InstructionPrompterTest {

    @Test
    void correctInputInstructionsPrompt() throws InvalidInstructionsException {
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
    void incorrectInputInstructionsPrompt(){
        Scanner scanner = new Scanner("L R\nKE\n \nLLMMNNEEE\nMMMM");
        InstructionParser instructionParser = new InstructionParser();
        InstructionPrompter instructionPrompter = new InstructionPrompter();

        Instruction[] expectedOutput1 = new Instruction[]{Instruction.M, Instruction.M, Instruction.M, Instruction.M};

        Instruction[] actualOutput1 = instructionPrompter.prompt(scanner, instructionParser);

        assertArrayEquals(expectedOutput1, actualOutput1);

    }

}