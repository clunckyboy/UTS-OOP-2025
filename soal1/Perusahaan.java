import java.util.ArrayList;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan = new ArrayList<>(); //membuat arraylist dari kumpulan karyawan

    public void tambahKaryawan(Karyawan karyawan){ // Method menambahkan karyawan ke ArrayList
        if (cariKaryawan(karyawan.getId()) == null){
            daftarKaryawan.add(karyawan);
            System.out.println("Karyawan berhasil ditambahkan");
        } else {
            System.out.print("ID sudah digunakan");
        }
    }

    public void hapusKaryawan(String id){//Method menghapus karyawan dari ArrayLists
        Karyawan karyawan = cariKaryawan(id);
        if(karyawan != null){
            daftarKaryawan.remove(karyawan);
            System.out.print("Karyawan berhasil dihapus");
        } else {
            System.out.print("ID tidak ditermukan");
        }
    }

    public void ubahPosisi(String id, String posisiBaru){ //Mengubah posisi seorang karyawan dalam perusahaan
        Karyawan karyawan = cariKaryawan(id);
        if(karyawan != null){
            karyawan.setPosisi(posisiBaru);
            System.out.print("Posisi berhasil diubah");
        } else {
            System.out.print("ID tidak ditermukan");
        }
    }

    public void ubahGaji(String id, int gajiBaru){//Mengubah gaji seorang karyawan dalam perusahaan
        Karyawan karyawan = cariKaryawan(id);
        if(karyawan != null){
            karyawan.setGaji(gajiBaru);
            System.out.println("Gaji berhasil diubah");
        } else {
            System.out.print("ID tidak ditemukan");
        }
    }

    public void tampilkanDaftarKaryawan(){//menampilkan isi dari ArrayList daftarKaryawan
        if(daftarKaryawan.isEmpty()){
            System.out.print("Belum ada karyawan");
        } else {
            for (Karyawan karyawan : daftarKaryawan){
                System.out.println("ID: " + karyawan.getId() + ", Nama: " + karyawan.getNama() + ", Posisi: " + karyawan.getPosisi() + ", Gaji: " + karyawan.getGaji());
            }
        }
    }

    public Karyawan cariKaryawan(String id){//mengembalikan objek karyawan berdasarkan ID yang sesuai
        for(Karyawan karyawan : daftarKaryawan){
            if(karyawan.getId().equals(id)){
                return karyawan;
            }
        }
        return null;
    }

    public boolean validasiId(String id){//memvalidasi id karyawan apakah ada dalam array daftarKAryawan
        for(Karyawan karyawan : daftarKaryawan) {
            if(karyawan.getId().equals(id)){
                return true;
            }
        }      
        return false;
    }
}
