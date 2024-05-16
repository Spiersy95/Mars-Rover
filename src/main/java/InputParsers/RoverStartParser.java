package InputParsers;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoverStartParser {

    public static Position getRoverStart(Scanner scanner, PlateauSize plateauSize){
        while(true){
            try {

                System.out.println("Please give a starting location of your rover in the following format");
                System.out.println("PositiveInteger PositiveInteger CompassDirections");

                String roverStartPositionInput = scanner.nextLine();


                if (verifyFormat.test(roverStartPositionInput)){

                    String[] roverStartPositionArray = roverStartPositionInput.split(" ");
                    int roverXCoord = Integer.parseInt(roverStartPositionArray[0]);
                    int roverYCoord = Integer.parseInt(roverStartPositionArray[1]);
                    CompassDirection roverDirection = getCompassDirection.apply(roverStartPositionArray[2]);

                    if (checkRoverInBounds.test(roverXCoord, plateauSize.getWidth())
                            && checkRoverInBounds.test(roverYCoord, plateauSize.getLength())){
                        return new Position(roverXCoord, roverYCoord, roverDirection);
                    } else {
                        throw new NotInPlateauException();
                    }
                } else {

                    throw new IncorrectStartingPositionFormatException();

                }
            } catch (IncorrectStartingPositionFormatException e) {
                System.out.println("Sorry your input was in the wrong format.");

            } catch (NotInPlateauException e) {
                System.out.println("Sorry this is not a valid starting location for our research.");
            }



        }
    }

    static Predicate<String> verifyFormat = input -> {
        Pattern pattern = Pattern.compile("[0-5]\\s[0-5]\\s[NSWE]");
        Matcher match = pattern.matcher(input);
        return match.matches();
    };

    static Function<String, CompassDirection> getCompassDirection = input -> {
        return switch (input) {
            case "N" -> CompassDirection.N;
            case "E" -> CompassDirection.E;
            case "S" -> CompassDirection.S;
            case "W" -> CompassDirection.W;
            default -> null;
        };
    };

    static BiPredicate<Integer, Integer> checkRoverInBounds = (location, plateauDim) -> location < plateauDim;

}
