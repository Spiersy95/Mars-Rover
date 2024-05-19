package InputParsers;

import java.util.Scanner;
import java.util.function.Predicate;

public class PlateauParser extends Parser{

    public PlateauSize parsePlateauSize(Scanner scanner) throws IncorrectPlateauFormatException {
                String plateauInput = scanner.nextLine();
                if (verifyFormat.test(plateauInput)){

                    String[] plateauInputArray = plateauInput.split(" ");
                    int plateauWidth = Integer.parseInt(plateauInputArray[0]);
                    int plateauLength = Integer.parseInt(plateauInputArray[1]);

                    return  new PlateauSize(plateauWidth, plateauLength);
                } else {

                    throw new IncorrectPlateauFormatException();
                }
        }

    static Predicate<String> verifyFormat = input -> Parser.verifyFormat("[1-5]\\s[1-5]", input);


}
