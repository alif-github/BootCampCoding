package Day4.cobathread;

public class latihan_thread{

    Thread thread;
    int jumlah = 7;

    public static void main(String[] args) {
        latihan_thread test = new latihan_thread();
        test.proses_satu();
        test.proses_dua();
    }

    void proses_satu(){
        thread = new Thread(){
            public void run(){
                try{
                    for(int w=1; w<=jumlah; w++){
                        System.out.println("Nomor: "+w);
                        sleep(1000); //Waktu Pending
                    }
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }

    void proses_dua(){
        thread = new Thread(){
            public void run(){
                try{
                    for(int w=1; w<=jumlah; w++){
                        System.out.println("Salam Programmer");
                        sleep(1000); //Waktu Pending
                    }
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }
}