package Day1;

import java.util.ArrayList;

public class ArrayListTryForEach {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Ravi");
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");

        for (String obj : list){
            System.out.println(obj);
        }
    }
}
