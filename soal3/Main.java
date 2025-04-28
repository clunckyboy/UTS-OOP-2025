import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        LotreBoard lotre = new LotreBoard();
            
        System.out.println("Welcome to E-Lottery Gosok");
        lotre.generateBoard();
        do {
            lotre.displayBoard();
            System.out.print("Masukkan tebakan anda (baris dan kolom) : ");
            int row = input.nextInt();
            int col = input.nextInt();
                
            if(!lotre.guess(row, col)){
                lotre.displayBoard();
                System.out.print("BOOM! Anda menemukan bom! Permainan berakhir.");
                break;
            }

            System.out.println("Kotak aman");
                
        } while (!lotre.isGameOver());

        if (!lotre.boomed) {
            System.out.println("Selamat! Anda telah membuka semua kotak aman.");
        }

        input.close();
    }
}
