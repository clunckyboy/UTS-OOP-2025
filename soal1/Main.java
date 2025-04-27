import java.util.Scanner; //import Scanner untuk menerima input user

public class Main{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        Perusahaan perusahaan = new Perusahaan(); //menginstansasi objek dari class perusahaan agar bisa menggunakan method methodnya
        String id, nama, posisi;
        int gaji, pilihan; //variabel pilihan sebagai pilihan menu dari user
        boolean i; //sebagai validasi ID
    
        do {
            System.out.print("\033[H\033[2J"); //clearscreen terminal

            System.out.println("== Sistem Manajemen Karyawan ==");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi Karyawan");
            System.out.println("4. Ubah Gaji Karyawan");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Tampilkan karyawan berdasarkan ID");
            System.out.println("7. Keluar");
            
            System.out.print("Masukkan Pilihan : ");
            pilihan = input.nextInt();
            input.nextLine();


            switch (pilihan) {
                case 1:          
                    System.out.print("Masukkan ID: ");
                    id = input.nextLine();
                    System.out.print("Masukkan Nama: ");
                    nama = input.nextLine();
                    System.out.print("Masukkan Posisi: ");
                    posisi = input.nextLine();
                    System.out.print("Masukkan Gaji: ");
                    gaji = input.nextInt();
                    if(gaji <= 0){ //memvalidasi gaji, jika minus atau 0, break switch.
                        System.out.print("Gaji tidak valid");
                        input.nextLine();
                        break;
                    } 
                    Karyawan karyawanBaru = new Karyawan(id, nama, posisi, gaji);
                    perusahaan.tambahKaryawan(karyawanBaru);//setelah menambahkan karyawan, dimasukkan ke array daftarKaryawan
                    input.nextLine();
                    input.nextLine();
                    break;
                
                case 2: 
                    System.out.print("Pilih ID Karyawan yang akan dihapus: ");
                    id = input.nextLine();
                    perusahaan.hapusKaryawan(id);
                    input.nextLine();
                    break;

                case 3: 
                    System.out.print("Masukkan ID karyawan: ");
                    id = input.nextLine();
                    i = perusahaan.validasiId(id);
                    if(i == false){ //jika id tidak ditemukan, maka break switch.
                        System.out.print("ID tidak ditemukan"); 
                        input.nextLine();
                        break;
                    }
                    System.out.print("Masukkan posisi baru: ");
                    posisi = input.nextLine();

                    perusahaan.ubahPosisi(id, posisi);
                    input.nextLine();
                    break;

                case 4: 
                    System.out.print("Masukkan ID karyawan: ");
                    id = input.nextLine();
                    i = perusahaan.validasiId(id);
                    if(i == false){ //jika id tidak ditemukan, maka break switch.
                        System.out.print("ID tidak ditemukan"); 
                        input.nextLine();
                        break;
                    }
                    System.out.print("Masukkan gaji baru: ");
                    gaji = input.nextInt();
                    if(gaji <= 0){ //memvalidasi gaji, jika minus atau 0, break switch.
                        System.out.print("Gaji tidak valid");
                        input.nextLine();
                        break;
                    }
                    
                    perusahaan.ubahGaji(id, gaji);
                    input.nextLine();
                    input.nextLine();
                    break;

                case 5: 
                    perusahaan.tampilkanDaftarKaryawan();
                    input.nextLine();
                    break;

                case 6: 
                    System.out.print("Masukkan ID Karyawan: ");
                    id = input.nextLine();
                    
                    Karyawan karyawan = perusahaan.cariKaryawan(id);
                    if(karyawan != null){
                        System.out.println("Data Ditemukan: ");
                        System.out.println("ID: " + karyawan.getId() + ", Nama: " + karyawan.getNama() + ", Posisi: " + karyawan.getPosisi() + ", Gaji: " + karyawan.getGaji());
                    } else {
                        System.out.println("Karyawan tidak ditemukan");
                    }
                    input.nextLine();
                    break;

                case 7: //mengakhiri program
                    break;
            
                default:
                    System.out.print("Pilihan tidak valid");
                    input.nextLine();
            }
            
        } while (pilihan != 7);
    }
}