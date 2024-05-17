import InputParsers.*;
import Logic.Plateau;
import Logic.Rover;
import UI.InstructionPrompter;
import UI.PlateauPrompter;
import UI.RoverStartPrompter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //initialising
        PlateauPrompter plateauPrompter = new PlateauPrompter();
        PlateauParser plateauParser = new PlateauParser();
        PlateauSize plateauSize;

        RoverStartPrompter roverStartPrompter = new RoverStartPrompter();
        RoverStartParser roverStartParser = new RoverStartParser();
        Position roverPosition;

        InstructionParser instructionParser = new InstructionParser();
        InstructionPrompter instructionPrompter = new InstructionPrompter();

        Scanner scanner = new Scanner(System.in);
        //prompting

        plateauSize = plateauPrompter.prompt(scanner, plateauParser);
        Plateau plateau = new Plateau(plateauSize);

        roverPosition = roverStartPrompter.prompt(scanner, roverStartParser, plateauSize);
        Rover rover = new Rover(roverPosition, plateau);

        Instruction[] instructions = instructionPrompter.prompt(scanner, instructionParser);
        rover.followInstructions(instructions);

        System.out.printf("Rover is at position %s %s %s", rover.getPosition().getX(), rover.getPosition().getY(), rover.getPosition().getFacing() );
    }
}
