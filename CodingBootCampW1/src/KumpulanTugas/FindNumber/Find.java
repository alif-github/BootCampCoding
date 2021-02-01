package KumpulanTugas.FindNumber;

import java.util.Arrays;
import java.util.Scanner;

public class Find {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int[] a = {21,23,26,12,15};

        Arrays.sort(a);
        System.out.print("Masukkan Nomor yang akan di cari : ");
        int target = userInput.nextInt();
        int first = 0;
        int middle;
        int last = a.length - 1;
        while (first <= last){
            middle = (first + last)/2;
            if (a[middle] == target){
                System.out.println(target+" found at index "+middle);
                System.out.println("Urutan Array : ");
                System.out.println("===============================");
                for (int j : a) {
                    System.out.println(j);
                }
                break;
            }else if(a[middle] < target) {
                first = middle + 1;
            }else if(a[middle] > target) {
                last = middle - 1;
            }
        }
    }
}