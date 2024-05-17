package UI;

import InputParsers.*;

import java.util.Scanner;

public class RoverStartPrompter {

    public Position prompt(Scanner scanner, RoverStartParser roverStartParser, PlateauSize plateauSize) {
        while (true) {
            System.out.println("Please give a starting location of your rover in the following format");
            System.out.println("[X-Coordinate][space][Y-Coordinate][space][FirstLetter of CardinalDirection]");
            System.out.println("e.g. \"2 4 N\" would place the rover at the coordinate (2,4) facing north.");
            try {
                return roverStartParser.getRoverStart(scanner, plateauSize);
            } catch (IncorrectStartingPositionFormatException e) {
                this.incorrectFormatWarning();

            } catch (NotInPlateauException e) {
                System.out.println("Sorry this is not a valid starting location for our research.");
            }
        }
    }

    public void notInPlateauWarning() {
        System.out.println("Sorry this is not a valid starting location for our research.");
    }

    public void incorrectFormatWarning() {
        System.out.println("Sorry your input was in the wrong format.");
    }

}