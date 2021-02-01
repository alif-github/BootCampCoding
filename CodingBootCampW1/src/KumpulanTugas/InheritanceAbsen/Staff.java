package KumpulanTugas.InheritanceAbsen;

public class Staff extends Worker{
    private String jabatan;

    public Staff(int idKaryawan, String nama, int absensi, String jabatan) {
        super(idKaryawan, nama, absensi);
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void inputData (){

    }

    public void tambahAbsen (){
        this.absensi = this.absensi+1;

    }
}
