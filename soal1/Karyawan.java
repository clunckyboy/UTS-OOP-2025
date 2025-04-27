public class Karyawan {
    //private agar tidak dapat diakses dari luar class
    private String id;
    private String nama;
    private String posisi;
    private int gaji;

    public Karyawan(String id, String nama, String posisi, int gaji){ //constructor class karyawan
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }

    //berbagai method untuk dapat mengakses variabel private
    public String getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }
    
    public String getPosisi(){
        return posisi;
    }

    public int getGaji(){
        return gaji;
    }

    public void setPosisi(String posisi){
        this.posisi = posisi;
    }

    public void setGaji(int gaji){
        this.gaji = gaji;
    }

}
