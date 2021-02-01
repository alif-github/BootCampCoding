package Day3.RegexCharacter.nexsoft;

import java.util.regex.Pattern;

public class RegexCharacter {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("[amn]","abcd"));
        System.out.println(Pattern.matches("[amn]","a"));
        System.out.println(Pattern.matches("[amn]","ammmna"));
    }
}
