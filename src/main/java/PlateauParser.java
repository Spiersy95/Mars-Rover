import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlateauParser {

  /*  public static PlateauSize getPlateauDim(Scanner scanner){
        while(true){
            try {
                System.out.println("Please input the dimensions of the region of the exploratory mission in the following format");
                System.out.println("PositiveInteger PositiveInteger");
                String plateauInput = scanner.nextLine();
                if (plateauFormatVerify.test(plateauInput))
            }
        }
    }*/

    public static Predicate<String> plateauFormatVerify = input ->{
        Pattern pattern = Pattern.compile("[1-9]d+?\\s[1-9]d+?");
        Matcher match = pattern.matcher(input);
        return match.matches();
    };

    //public static Predicate<String>
}
