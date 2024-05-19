package UI;

import InputParsers.*;

import java.util.Scanner;

public class RoverStartPrompter {

    public Position prompt(Scanner scanner, RoverStartParser roverStartParser, PlateauSize plateauSize) {
        while (true) {
            System.out.println("\nPlease give a starting location of your rover in the following format");
            System.out.println("[X-Coordinate][space][Y-Coordinate][space][FirstLetter of CardinalDirection]");
            System.out.println("e.g. \"2 4 N\" would place the rover at the coordinate (2,4) facing north.\n");

            try {
                return roverStartParser.parseRoverStart(scanner, plateauSize);
            } catch (IncorrectStartingPositionFormatException e) {
                this.formatWarning();

            } catch (NotInPlateauException e) {
                this.notInPlateauWarning();
            }
        }
    }

    public void notInPlateauWarning() {
        System.out.println("\nSorry this is not a valid starting location for our research.\n");

    }

    public void formatWarning() {
        System.out.println("\nSorry your input was in the wrong format.\n");

    }

}