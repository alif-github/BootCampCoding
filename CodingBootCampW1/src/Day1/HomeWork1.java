package Day1;

import java.io.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

class StudentS1 {
    int idStudent;
    String nameStudent;
    Double scoreStudent;

    StudentS1(int idStudent, String nameStudent, Double scoreStudent){
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.scoreStudent = scoreStudent;
    }
}

class ComparatorScID implements Comparator<StudentS1>{

    @Override
    public int compare(StudentS1 o1, StudentS1 o2) {
        return o1.idStudent - o2.idStudent;
    }
}

class ComparatorScScore implements Comparator<StudentS1>{

    @Override
    public int compare(StudentS1 o1, StudentS1 o2) {
        return o2.scoreStudent.compareTo(o1.scoreStudent);
    }
}

public class HomeWork1 {
    static Iterator iterator;
    static LinkedList<StudentS1> listSt = new LinkedList<>();
    static InputStreamReader read = new InputStreamReader(System.in);
    static BufferedReader bread = new BufferedReader(read);

    public static void main(String[] args) throws IOException {
        boolean active = true;

        do {
            System.out.println("Welcome To Menu");
            System.out.println("-------------------------------");
            System.out.println("1. Input Data\n2. Find Data\n3. Remove Data\n4. Print Data\n5. Print Report into txt");
            System.out.print("Choose : ");
            int choose = Integer.parseInt(bread.readLine());
            switch (choose){
                case 1 : {
                    System.out.println("-------------------------------");
                    System.out.println("This is Input Menu");
                    System.out.println("-------------------------------");
                    InputData();
                    break;
                }
                case 2 : {
                    System.out.println("-------------------------------");
                    System.out.println("This is Find Data Menu");
                    System.out.println("-------------------------------");
                    System.out.println("Find Data base on : \n1. id\n2. nama\n");
                    System.out.print("Choose : ");
                    int opsi = Integer.parseInt(bread.readLine());
                    if (opsi == 1){
                        FindByID();
                    }else if (opsi == 2){
                        FindByName();
                    }
                    break;
                }
                case 3 : {
                    System.out.println("-------------------------------");
                    System.out.println("This is Delete Data (By Name) Menu");
                    System.out.println("-------------------------------");
                    Delete();
                    break;
                }
                case 4 : {
                    System.out.println("-------------------------------");
                    System.out.println("This is Print Data (By ID) Menu");
                    System.out.println("-------------------------------");
                    System.out.println("Print by ID");
                    PrintbyID();
                    System.out.println();
                    System.out.println("Print by Score");
                    PrintbyScore();
                    break;
                }
                case 5 : {
                    System.out.println("-------------------------------");
                    System.out.println("This is Print Report Data Menu");
                    System.out.println("-------------------------------");
                    PrintToTxt();
                    break;
                }
                default: {
                    System.out.println("-------------------------------");
                    System.out.println("Thank You For Using This App :)");
                    System.out.println("-------------------------------");
                    active = false;
                }
            }
        }while(active);


        Close();
    }

    public static void InputData(){
        System.out.println("Input Your Data Into System");
        System.out.println("-------------------------------");
        System.out.print("Amount Data : ");

        int parAmount;
        String amount;
        try {
            amount = bread.readLine();
        }catch (Exception e){
            System.out.print("We Found Execption : "+e);
            amount = "";
        }
        parAmount = Integer.parseInt(amount);


        int idMhs = 0;
        double scoreMhs = 0.0;
        String id, name = "", score;

        for (int i = 1; i <= parAmount; i++) {
            try {
                System.out.print("Masukkan Id: ");
                id = bread.readLine();
                idMhs = Integer.parseInt(id);
                System.out.print("Masukkan Nama: ");
                name = bread.readLine();
                System.out.print("Masukkan Score: ");
                score = bread.readLine();
                scoreMhs = Double.parseDouble(score);
            }catch (Exception e){
                System.out.print("We Found Execption : "+e);
            }

            listSt.add(new StudentS1(idMhs,name,scoreMhs));
            System.out.println("-------------------------------");
        }
    }

    public static void PrintbyScore(){
        ComparatorScScore compScore = new ComparatorScScore();
        listSt.sort(compScore);

        iterator = listSt.iterator();

        Print();
    }

    public static void PrintbyID(){
        ComparatorScID compID = new ComparatorScID();
        listSt.sort(compID);

        iterator = listSt.iterator();

        Print();
    }

    public static void Print(){
        int no = 1;
        System.out.println("No.\tID\tName\tStudent_Score");
        System.out.println("-------------------------------");
        while(iterator.hasNext()){
            StudentS1 st = (StudentS1)iterator.next();
            System.out.println(no+".\t"+st.idStudent+"\t"+st.nameStudent+"\t"+ st.scoreStudent);
            no++;
        }
        System.out.println("-------------------------------");
    }

    public static void FindByName(){
        String find;
        try {
            System.out.print("Input Data by Name (Find) : ");
            find = bread.readLine();
            for (StudentS1 obj: listSt) {
                if (obj.nameStudent.equalsIgnoreCase(find)) {
                    System.out.println("Data by Name ("+find+") has Found");
                    break;
                }else{
                    System.out.println("Data Not Found!");
                }
            }
        }catch (Exception e){
            System.out.println("Execption : "+e);
        }
        System.out.println("-------------------------------");

    }

    public static void FindByID(){
        int find;
        try {
            System.out.print("Input Data by Name (Find) : ");
            find = Integer.parseInt(bread.readLine());
            for (StudentS1 obj: listSt) {
                if (obj.idStudent == find) {
                    System.out.println("Data by ID ("+find+") has Found");
                    break;
                }else{
                    System.out.println("Data Not Found!");
                }
            }
        }catch (Exception e){
            System.out.println("Execption : "+e);
        }
        System.out.println("-------------------------------");

    }

    public static void Delete() throws IOException{
        System.out.print("Input Data by Name (Remove) : ");
        String delete = bread.readLine();
        for (StudentS1 obj: listSt) {
            if (obj.nameStudent.equalsIgnoreCase(delete)) {
                listSt.remove(obj);
                System.out.println("Data Have been Removed");
                break;
            }else{
                System.out.println("Data Not Found!");
            }
        }
        System.out.println("-------------------------------");
    }

    public static void PrintToTxt() throws IOException{
        iterator = listSt.iterator();
        FileWriter writer = new FileWriter("C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\Data_Mahasiswa.txt");
        int no = 1;
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write("No.\tID\tName\tStudent_Score\n");
        buffer.write("---------------------------------------\n");
        while(iterator.hasNext()){
            StudentS1 st = (StudentS1)iterator.next();
            buffer.write(no+".\t"+st.idStudent+"\t"+st.nameStudent+"\t"+ st.scoreStudent+"\n");
            no++;
        }
        buffer.write("---------------------------------------\n");
        buffer.close();
        System.out.println("Success....");

    }

    public static void Close() throws IOException{
        bread.close();
        read.close();
    }


}
