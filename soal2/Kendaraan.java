public class Kendaraan {
    private String jenisKendaraan;
    private int lamaParkir;
    private int biaya;

    public Kendaraan(String jenisKendaraan){
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getJenisKendaraan(){
        return this.jenisKendaraan;
    }

    public int getLamaParkir(){
        return this.lamaParkir;
    }

    public int getBiaya(){
        return this.biaya;
    }

    public void hitungBiaya(int durasi, int harga){
        this.lamaParkir = durasi;
        if(this.lamaParkir > 5){
            this.biaya = harga * this.lamaParkir - (harga * this.lamaParkir * 10 / 100);   
        } else {
            this.biaya = harga * this.lamaParkir;
        }
    }

    public void hitungBiaya(int masuk, int keluar, int harga){
        this.lamaParkir = keluar - masuk;
        if(this.lamaParkir > 5){
            this.biaya = harga * this.lamaParkir - (harga * this.lamaParkir * 10 / 100);
        } else {
            this.biaya = harga * this.lamaParkir;
        }
    }
}
