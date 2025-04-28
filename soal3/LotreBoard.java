// package soal3;
import java.util.Random;

public class LotreBoard {
    char[][] board = new char[4][5]; //papan untuk menampilkan status (belum dibuka, aman, bom).
    boolean[][] revealed = new boolean[4][5]; //menyimpan informasi apakah suatu kotak sudah dibuka.
    int[][] data = new int[4][5]; //menyimpan data asli kotak (0 = aman, 1 = bom).
    boolean boomed = false; //memvalidasi apakah permainan berkahir karena kena bom atau aman semua

    public void generateBoard(){ //menghasilkan papan dengan 2 bom di posisi acak.
        Random random = new Random(); //untuk merandom kotak yang ada bomnya

        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                this.board[i][j] = '*';
                this.revealed[i][j] = false;
                this.data[i][j] = 0;
            }
        }

        //merandom letak bom di lotre
        int bomb = 0;
        while(bomb < 2){
            int row = random.nextInt(4);
            int col = random.nextInt(5);
            if(this.data[row][col] == 0){
                this.data[row][col] = 1;
                bomb++;
            }
        }
    }

    public void displayBoard(){ //menampilkan papan saat ini ke layar (* untuk kotak yang belum dibuka, O untuk aman, X jika bom ditemukan).
        for(int i = 0; i<4; i++){
            for(int j=0; j<5; j++){
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col){ //memproses tebakan pemain. Mengembalikan false jika pemain mengenai bom, true jika aman.
        //jika inputan diluar batas lotre
        if(row < 0 || row > 3 || col < 0 || col > 4){
            System.out.println("Area diluar papan, coba lagi!");
            return true;
        }

        //jika inputan adalah kotak yang sudah terbuka
        if(this.revealed[row][col]){
            System.out.println("Kotak sudah dibuka, coba kotak lain!");
            return true;
        }

        this.revealed[row][col] = true;

        if(this.data[row][col] == 1){
            this.board[row][col] = 'X';
            this.boomed = true;
            return false;
        } else {
            this.board[row][col] = 'O';
            return true;
        }
    }

    public boolean isGameOver(){ //mengecek apakah permainan selesai (menemukan bom atau berhasil membuka semua aman)
        // Cek jika ada bom yang terungkap
        for(int i = 0; i<4; i++){
            for(int j=0; j<5; j++){
                if(this.board[i][j] == 'X'){
                    return true;
                }
            }
        }

        // Cek jika semua kotak aman sudah terungkap
        for(int i = 0; i<4; i++){
            for(int j=0; j<5; j++){
                if(this.data[i][j] == 0 && !this.revealed[i][j]){
                    return false; // Masih ada kotak aman yang belum dibuka
                }
            }
        }

        return true; // Semua kotak aman sudah dibuka
    }
}
