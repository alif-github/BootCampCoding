package Day1;

import java.io.FilePermission;
import java.security.PermissionCollection;

public class IOFilePermission {
    public static void main(String[] args) {
        String srg = "C:\\Users\\user\\Documents\\BOOTCAMP_NexSoft_Alif Yudha S\\testout1.txt";
        FilePermission file1 = new FilePermission("C:\\Users\\-","read");

        PermissionCollection permission = file1.newPermissionCollection();
        permission.add(file1);

        FilePermission file2 = new FilePermission(srg,"write");
        permission.add(file2);

        if (permission.implies(new FilePermission(srg, "read,write"))){
            System.out.println("Read, Write permission is granted for the path "+srg);
        }else {
            System.out.println("No Read, Write permission is granted for the path "+srg);
        }
    }
}
