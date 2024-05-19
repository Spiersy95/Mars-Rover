package InputParsers;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class InstructionParser extends Parser{

    public Instruction[] parseInstructions(Scanner scanner) throws InvalidInstructionsException {
        String instructionInput = scanner.nextLine();
        if (verifyFormat.test(instructionInput)){
            return this.stringToInstructions(instructionInput);
        } else {
            throw new InvalidInstructionsException();
        }
    }

    public Instruction[] stringToInstructions(String input){
        Instruction[] instructions = new Instruction[input.length()];
        String[] inputArr = input.split("");
        for (int i = 0; i < input.length(); i++)
            instructions[i] = convertingStringToInstruction.apply(inputArr[i]);
        return instructions;
    }

    public static Predicate<String> verifyFormat = input -> Parser.verifyFormat("[LMR]*", input);

    static Function<String, Instruction> convertingStringToInstruction = input -> switch (input) {
        case "L" -> Instruction.L;
        case "R" -> Instruction.R;
        case "M" -> Instruction.M;
        default -> null;
    };

}


