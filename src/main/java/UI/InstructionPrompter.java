package UI;

import InputParsers.Instruction;
import InputParsers.InstructionParser;
import InputParsers.InvalidInstructionsException;

import java.util.Scanner;

public class InstructionPrompter {

    public Instruction[] prompt(Scanner scanner, InstructionParser instructionParser) {
        while (true) {
            System.out.println("\nPlease input a string of instructions:\n");
            System.out.println("L - Rotates the rover anti-clockwise 90 degrees.");
            System.out.println("R - Rotates the rover clockwise 90 degrees.");
            System.out.println("M - Moves the rover forward.\n");

            try {
                return instructionParser.parseInstructions(scanner);
            } catch (InvalidInstructionsException e) {
                this.formatWarning();
            }
        }
    }

    public void formatWarning(){
        System.out.println("\nSorry this is an invalid set of Instructions.\n");

    }
}
