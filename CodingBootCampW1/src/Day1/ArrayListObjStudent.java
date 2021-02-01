package Day1;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListObjStudent {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alif", 21);
        Student s2 = new Student(201, "Silo", 23);
        Student s3 = new Student(301, "Udin", 24);
        //Creating an ArrayList
        ArrayList<Student> al = new ArrayList<>();
        al.add(s1); //adding Student class object
        al.add(s2);
        al.add(s3);
        //getting Iterator
        Iterator itr = al.iterator();
        //transversing element of ArrayList object
        while(itr.hasNext()){
            Student st = (Student)itr.next();
            System.out.println(st.rollno+" "+st.name+" "+st.age);
        }
    }
}
