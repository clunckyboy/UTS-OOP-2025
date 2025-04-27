import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String tipe, mode;
        int harga;
        char opt;
        Kendaraan kendaraan = null;
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.print("\033[H\033[2J"); //clearscreen terminal
        System.out.println("======== Welcome to ParkingChan ======== ");
        System.out.println();
        
        do {
            do {
                System.out.print("Enter vehicle type (Motor/Mobil/Truk) : ");
                tipe = input.nextLine();
                kendaraan = new Kendaraan(tipe);
                
                switch (tipe) {
                    case "Motor":
                    harga = 2000;
                    
                    do {
                        System.out.print("Enter duration (Manual/Time) : ");
                        mode = input.nextLine();
                    
                        if(mode.equals("Manual")){
                            System.out.print("Enter duration (in hour) : ");
                                int duration = input.nextInt();
                                input.nextLine(); 

                                kendaraan.hitungBiaya(duration, harga);
                    
                            }else if(mode.equals("Time")){
                                System.out.print("Enter entry time : ");
                                int entry = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter exit time : ");
                                int exit = input.nextInt();
                                input.nextLine();

                                kendaraan.hitungBiaya(entry, exit, harga);
    
                            }else{
                                System.out.println("Masukkan antara Manual atau Time, silahkan ulangi!");
                            }
                        } while (!mode.equals("Manual") && !mode.equals("Time"));
                    break;
                        
                    case "Mobil":
                        harga = 5000;

                        do {
                            System.out.print("Enter duration (Manual/Time) : ");
                            mode = input.nextLine();
                    
                            if(mode.equals("Manual")){
                                System.out.print("Enter duration (in hour) : ");
                                int duration = input.nextInt();
                                input.nextLine();
                    
                                kendaraan.hitungBiaya(duration, harga);
                    
                            }else if(mode.equals("Time")){
                                System.out.print("Enter entry time : ");
                                int entry = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter exit time : ");
                                int exit = input.nextInt();
                                input.nextLine();

                                kendaraan.hitungBiaya(entry, exit, harga);
    
                            }else{
                                System.out.println("Masukkan antara Manual atau Time, silahkan ulangi!");
                            }     
                        } while (!mode.equals("Manual") && !mode.equals("Time"));
                    break;
        
                    case "Truk":
                        harga = 9000;

                        do {
                            System.out.print("Enter duration (Manual/Time) : ");
                            mode = input.nextLine();
                    
                            if(mode.equals("Manual")){
                                System.out.print("Enter duration (in hour) : ");
                                int duration = input.nextInt();
                                input.nextLine();
                    
                                kendaraan.hitungBiaya(duration, harga);
                    
                            }else if(mode.equals("Time")){
                                System.out.print("Enter entry time : ");
                                int entry = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter exit time : ");
                                int exit = input.nextInt();
                                input.nextLine();

                                kendaraan.hitungBiaya(entry, exit, harga);

                            }else{
                                System.out.println("Masukkan antara Manual atau Time, silahkan ulangi!");
                            }      
                        } while (!mode.equals("Manual") && !mode.equals("Time"));
                    break;
                    
                    default:
                        System.out.println("Masukkan jenis kendaraan yang valid!");
                    break;
                }       
            } while (!tipe.equals("Motor") && !tipe.equals("Mobil") && !tipe.equals("Truk"));           

            System.out.println();
            System.out.println("---- PARKING SUMMARY ----");
            System.out.println("Vehicle type    : " + kendaraan.getJenisKendaraan());
            System.out.println("Parking time    : " + kendaraan.getLamaParkir());
            System.out.println("Total fee       : " + kendaraan.getBiaya());
            System.out.println();

            daftarKendaraan.add(kendaraan);
            
            System.out.println("Add another vehicle? (y/n): ");
            opt = Character.toLowerCase(input.next().charAt(0));
            input.nextLine();
        } while (opt == 'y');

        int totalVehicle = 0;
        int finalFees = 0;
        for (Kendaraan kendaraanAkhir: daftarKendaraan){
            totalVehicle++;
            finalFees = finalFees + kendaraanAkhir.getBiaya();
        }
        System.out.println("======== FINAL REPORT ========");
        System.out.println("Total vehicle final         : " + totalVehicle);
        System.out.println("Total parking fees final    : " + finalFees);
        System.out.println("Thank You...");
        
    }
}
