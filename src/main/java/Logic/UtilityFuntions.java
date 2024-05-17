package Logic;

import InputParsers.CompassDirection;
import InputParsers.Instruction;

import java.util.function.Function;

public class UtilityFuntions {

    static Function<CompassDirection, Integer> directionToModulus = direction -> switch (direction) {
        case CompassDirection.N -> 0;
        case CompassDirection.E -> 1;
        case CompassDirection.S -> 2;
        case CompassDirection.W -> 3;
    };

    static Function<Integer, CompassDirection> directionToModulusInverse = number -> switch (number) {
        case 0 -> CompassDirection.N ;
        case 1 -> CompassDirection.E;
        case 2 -> CompassDirection.S;
        case 3 -> CompassDirection.W;

        default -> throw new IllegalStateException("Unexpected value: " + number);
    };

    static Function<Instruction, Integer> instructionToNumber= direction -> switch (direction) {
        case Instruction.L -> 3;
        case Instruction.R -> 1;
        case Instruction.M -> 0;
    };


}
