package Day3.Tugas1.nexsoft;

public class Mahasiswa {
    private int idMahasiswa;
    private String namaMahasiswa;
    private Double bInggris;
    private Double fisika;
    private Double algoritma;

    public Mahasiswa(int idMahasiswa, String namaMahasiswa, Double bInggris, Double fisika, Double algoritma) {
        this.idMahasiswa = idMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.bInggris = bInggris;
        this.fisika = fisika;
        this.algoritma = algoritma;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public Double getbInggris() {
        return bInggris;
    }

    public void setbInggris(Double bInggris) {
        this.bInggris = bInggris;
    }

    public Double getFisika() {
        return fisika;
    }

    public void setFisika(Double fisika) {
        this.fisika = fisika;
    }

    public Double getAlgoritma() {
        return algoritma;
    }

    public void setAlgoritma(Double algoritma) {
        this.algoritma = algoritma;
    }
}
