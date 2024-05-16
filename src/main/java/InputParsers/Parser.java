package InputParsers;


import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Parser {

    protected static BiPredicate<String, String> verifyFormat = (regex, input)->{
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.matches();
    };
}
