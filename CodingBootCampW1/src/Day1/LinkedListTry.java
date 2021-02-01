package Day1;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTry {
    public static void main(String[] args) {
        LinkedList<String> al = new LinkedList<>();

        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        Iterator<String> itr = al.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
