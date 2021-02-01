package KumpulanTugas.InheritanceAbstract;

public class Manager extends Worker {
    private double tunjTransport;
    private double tunjEntertaint;

    public Manager(int idKaryawan, String nama, double tunjPulsa, double gajiPokok, int absen, double tunjTransport, double tunjEntertaint) {
        super(idKaryawan, nama, tunjPulsa, gajiPokok, absen);
        this.tunjTransport = tunjTransport;
        this.tunjEntertaint = tunjEntertaint;
    }

    public double getTunjTransport() {
        return tunjTransport;
    }

    public void setTunjTransport() {
        this.tunjTransport = super.getAbsen() * 5000;
    }

    public double getTunjEntertaint() {
        return tunjEntertaint;
    }

    public void setTunjEntertaint(double tunjEntertaint) {
        this.tunjEntertaint = tunjEntertaint;
    }


    @Override
    void absensi() {
        this.setAbsen(getAbsen() + 1);
    }
}
