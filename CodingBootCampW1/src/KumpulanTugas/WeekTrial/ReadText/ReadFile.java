package KumpulanTugas.WeekTrial.ReadText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    static String file = "C:\\Users\\user\\IdeaProjects\\KumpulanTugas_Week1_Bootcamp\\src\\main\\java\\WeekTrial\\ReadText\\tabel.txt";

    public static void main(String[] args) {
        ArrayList<String[]> arr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null){
                arr.add(sCurrentLine.split(","));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}