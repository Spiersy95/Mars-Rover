package InputParsers;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlateauParser{

    public static PlateauSize getPlateauSize(Scanner scanner){
        while(true){
            try {

                System.out.println("Please input the dimensions of the region of the exploratory mission in the following format:");
                System.out.println("PositiveInteger PositiveInteger");

                String plateauInput = scanner.nextLine();


                if (verifyFormat.test(plateauInput)){

                    String[] plateauInputArray = plateauInput.split(" ");
                    int plateauWidth = Integer.parseInt(plateauInputArray[0]);
                    int plateauLength = Integer.parseInt(plateauInputArray[1]);

                    return  new PlateauSize(plateauWidth, plateauLength);

                } else {

                    throw new IncorrectPlateauFormatException();

                }
            } catch (IncorrectPlateauFormatException e) {
                System.out.println("Sorry your input was in the wrong format");

            }
        }
    }

    public static Predicate<String> verifyFormat = input ->{
        Pattern pattern = Pattern.compile("[1-5]\\s[1-5]");
        Matcher match = pattern.matcher(input);
        return match.matches();
    };


}
