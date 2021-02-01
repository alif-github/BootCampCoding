package Day3.RegexMethacharacter.nexsoft;

import java.util.regex.Pattern;

public class RegexMetha {
    public static void main(String[] args) {
        System.out.println("Metacharacters d....");

        System.out.println(Pattern.matches("\\d","abc"));
        System.out.println(Pattern.matches("\\d","1"));
        System.out.println(Pattern.matches("\\d","4443"));
        System.out.println(Pattern.matches("\\d","323abc"));

        System.out.println("Metacharacters D....");

        System.out.println(Pattern.matches("\\D","abc"));
        System.out.println(Pattern.matches("\\D","1"));
        System.out.println(Pattern.matches("\\D","4443"));
        System.out.println(Pattern.matches("\\D","323abc"));
        System.out.println(Pattern.matches("\\D","m"));

        System.out.println("Metacharacters D with Quantifier....");

        System.out.println(Pattern.matches("\\D*","mak"));

        System.out.println("Many Quantifier...");
        System.out.println(Pattern.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}","1233434531")); //Regex Penting untuk nomer telepon
        System.out.println(Pattern.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}","123-343-4531"));
    }
}
