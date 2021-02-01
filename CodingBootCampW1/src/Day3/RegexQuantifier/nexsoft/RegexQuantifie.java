package Day3.RegexQuantifier.nexsoft;

import java.util.regex.Pattern;

public class RegexQuantifie {
    public static void main(String[] args) {
        System.out.println("?quantifier....");
        System.out.println(Pattern.matches("[amn]?","a")); //true (a or m or n comes one time)
        System.out.println(Pattern.matches("[amn]?","aaa"));
        System.out.println(Pattern.matches("[amn]?","azzzta"));
        System.out.println(Pattern.matches("[amn]?","am"));

        System.out.println("+quantifier....");
        System.out.println(Pattern.matches("[amn]+","a"));//true(a or m or n once or more times)
        System.out.println(Pattern.matches("[amn]+","aaa"));//true(a comes more than one time)
        System.out.println(Pattern.matches("[amn]+","aammmn"));//true (a or m or n comes more than once)
        System.out.println(Pattern.matches("[amn]+","aazzta"));//false (z and t are not matching pattern)

        System.out.println("*quantifier....");
        System.out.println(Pattern.matches("[amn]*","ammmna"));

    }
}
