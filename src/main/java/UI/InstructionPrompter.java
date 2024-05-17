package UI;

import InputParsers.Instruction;
import InputParsers.InstructionParser;
import InputParsers.InvalidInstructionsException;

import java.util.Scanner;

public class InstructionPrompter {

    public Instruction[] prompt(Scanner scanner, InstructionParser instructionParser) {
        while (true) {
            System.out.println("Please input a string of instructions:");
            System.out.println("L - Rotates the rover anti-clockwise 90 degrees.");
            System.out.println("R - Rotates the rover clockwise 90 degrees.");
            System.out.println("M - Moves the rover forward.");
            try {
                return instructionParser.getInstructions(scanner);
            } catch (InvalidInstructionsException e) {
                this.instructionFormatWarning();
            }
        }
    }

    public void instructionFormatWarning(){
        System.out.println("Sorry this is an invalid set of Instructions");
    }
}
