package InputParsers;

import DataTypes.CompassDirection;
import DataTypes.PlateauSize;
import DataTypes.Position;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoverStartParser extends Parser {

    public Position parseRoverStart(Scanner scanner, PlateauSize plateauSize) throws IncorrectStartingPositionFormatException, NotInPlateauException {
        String roverStartPositionInput = scanner.nextLine();
        if (verifyFormat.test(roverStartPositionInput)){
            String[] roverStartPositionArray = roverStartPositionInput.split(" ");
            int roverXCoord = Integer.parseInt(roverStartPositionArray[0]);
            int roverYCoord = Integer.parseInt(roverStartPositionArray[1]);
            CompassDirection roverDirection = getCompassDirection.apply(roverStartPositionArray[2]);

            if (checkRoverInBounds.test(roverXCoord, plateauSize.width())
                    && checkRoverInBounds.test(roverYCoord, plateauSize.length())){
                return new Position(roverXCoord, roverYCoord, roverDirection);
            } else {
                throw new NotInPlateauException();
            }
        } else {
            throw new IncorrectStartingPositionFormatException();
        }
    }

    static Predicate<String> verifyFormat = input -> {
        Pattern pattern = Pattern.compile("[0-5]\\s[0-5]\\s[NSWE]");
        Matcher match = pattern.matcher(input);
        return match.matches();
    };

    static Function<String, CompassDirection> getCompassDirection = input -> switch (input) {
        case "N" -> CompassDirection.N;
        case "E" -> CompassDirection.E;
        case "S" -> CompassDirection.S;
        case "W" -> CompassDirection.W;
        default -> null;
    };

    static BiPredicate<Integer, Integer> checkRoverInBounds = (location, plateauDim) -> location <= plateauDim;

}
