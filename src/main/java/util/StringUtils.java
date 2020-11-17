package util;

public class StringUtils {

    public static boolean isPositiveNumber(String input){
        return input.chars()
                .mapToObj(Character::isDigit)
                .reduce((x, y) -> x && y)
                .orElse(false);
    }

}
