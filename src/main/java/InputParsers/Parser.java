package InputParsers;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser {

    static boolean verifyFormat(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.matches();
    };
    
}
