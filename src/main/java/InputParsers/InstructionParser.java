package InputParsers;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;



public class InstructionParser extends Parser {

    public Instruction[] getInstructions(Scanner scanner){
        while(true){
            try {
                System.out.println("Please input a string of instructions:");
                System.out.println("L - Rotates the rover anti-clockwise 90 degrees.");
                System.out.println("R - Rotates the rover clockwise 90 degrees.");
                System.out.println("M - Moves the rover forward.");
                String instructionInput = scanner.nextLine();
                if (verifyFormat.test(instructionInput)){
                    return this.stringToInstructions(instructionInput);
                } else {
                    throw new InvalidInstructionsException();
                }
            } catch (InvalidInstructionsException e) {
                System.out.println("Sorry this is an invalid set of Instructions");
            }


        }
    }

    public Instruction[] stringToInstructions(String input){
        Instruction[] instructions = new Instruction[input.length()];
        String[] inputArr = input.split("");
        for (int i = 0; i < input.length(); i++)
            instructions[i] = convertingStringToInstruction.apply(inputArr[i]);
        return instructions;
    }

    static Predicate<String> verifyFormat = input -> Parser.verifyFormat.test("[LMR]*", input);

    static Function<String, Instruction> convertingStringToInstruction = input -> switch (input) {
        case "L" -> Instruction.L;
        case "R" -> Instruction.R;
        case "M" -> Instruction.M;
        default -> null;
    };

}


