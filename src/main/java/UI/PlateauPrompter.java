package UI;

import InputParsers.IncorrectPlateauFormatException;
import InputParsers.PlateauParser;
import InputParsers.PlateauSize;

import java.util.Scanner;

public class PlateauPrompter implements Prompter {
    public PlateauSize prompt(Scanner scanner, PlateauParser plateauParser) {
        while(true) {
            System.out.println("Please input the dimensions of the region of the exploratory mission in the following format:");
            System.out.println("[Positive between 1 and 5][space][Positive Integer between 1 and 5]");
            System.out.println("e.g. \"2 3\" would create a plateau of 3 x 4 grid.\n");
            try{
                return plateauParser.parsePlateauSize(scanner);
            } catch (IncorrectPlateauFormatException e) {
                this.formatWarning();
            }
        }

    }

    public void formatWarning(){
        System.out.println("Sorry your input was in the wrong format.\n");
    }
}
