import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RestoranBungar {

    private static final DecimalFormat df = new DecimalFormat("0.00");
	public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
        	int jumlah_orang;
			int pagi, siang, sore,sorePetang, malam;
			String nama;
			double makanan1_price = 9999.99,
			        makanan2_price = 12345.67,
			        makanan3_price = 21108.40,
			        makanan4_price = 13579.13,
			        makanan5_price = 98765.43;


			System.out.println("============== Restoran BUNGAR ==============");
			// Menunjukan Hari Dan Waktu lokal
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatDateTime1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String hariWaktu = currentDateTime.format(formatDateTime1);
			System.out.println("Date and Time : " + hariWaktu);
			System.out.println("==============================================");

			// mengkonversi waktu tipe data string ke integer untuk mencari jam operasional
			DateTimeFormatter formatDateTime2 = DateTimeFormatter.ofPattern("HH");
			String mainHours = currentDateTime.format(formatDateTime2);
			System.out.println();

			int currentHour = Integer.parseInt(mainHours);

			pagi = 6;   // batas jam saat awal pagi hari pukul 06:00 - 11:00
			siang = 11; // batas jam saat awal siang hari pukul 11:00 - 16:00
			sore = 16;  // batas jam saat akhir siang hari (sore) pukul 16:00 - 18:00
			sorePetang = 18 ; // batas jam saat akhir siang hari (sore) pukul 16:00 - 18:00
			malam = 24; // batas jam saat akhir malam hari  pukul 18:00 - 24:00

			if ((currentHour > pagi ) && ( currentHour <= siang)){
				System.out.println("Selamat Pagi...");
			} else if ((siang < currentHour) && (currentHour <= sore)){
				System.out.println("Selamat Siang...");
			} else if ((sore < currentHour) && (currentHour <= sorePetang)) {
				System.out.println("Selamat Sore....");
			} else if ((sorePetang < currentHour) && (currentHour <= malam)) {
				System.out.println("Selamat Malam...");
			} else {
				System.out.println("Mohon maaf, restoran kami sedang tidak melayani pelanggan. Terima kasih");
			}
			System.out.println();

			//====================Add Jumlah==================== //
			System.out.print("Pesanan untuk berapa orang : ");
			jumlah_orang = input.nextInt();

			//====================Add Nama Pemesanan==================== //
			System.out.print("Pesanan atas nama : ");
			nama = input.nextLine();
			input.nextLine();

			//====================Daftar Menu==================== //
			System.out.println("\n Menu Special Hari Ini");
			System.out.println("==========================");
			System.out.println("   1. Nasi Goreng Spesial  " + "\t@" + "\tRp. " + makanan1_price);
			System.out.println("   2. Ayam Bakar Spesial " + "\t\t@" + "\tRp. " + makanan2_price);
			System.out.println("   3. Steak Sirloin Spesial " + "\t@" + "\tRp. " + makanan3_price);
			System.out.println("   4. Kwetiaw Siram Spesial " + "\t@" + "\tRp. " + makanan4_price);
			System.out.println("   5. Kambing Guling Spesial " + "\t@" + "\tRp. " + makanan5_price);
			System.out.println();
			//====================Add Pesanan==================== //
			System.out.println("Pesanan Anda [Batas Pesanan 0-10 Porsi]");
			System.out.print("Nasi Goreng Spesial      = ");
			int A = input.nextInt();
			while(A > 10){
				System.out.println("Maximal pesan 10 porsi, masukan kembali pesanan anda...");
				System.out.print("Nasi Goreng Spesial      = ");
				A = input.nextInt();
		   }
			System.out.print("Ayam Bakar Spesial      = ");
			int B = input.nextInt();
			while(B > 10){
				System.out.println("Maximal pesan 10 porsi, masukan kembali pesanan anda...");
				System.out.print("Ayam Bakar Spesial        = ");
				B = input.nextInt();
		   }

			System.out.print("Steak Sirloin Spesial    = ");
			int C = input.nextInt();
			while(C > 10){
				System.out.println("Maximal pesan 10 porsi, masukan kembali pesanan anda...");
				System.out.print("Steak Sirloin Spesial      = ");
				C = input.nextInt();
		   }
			System.out.print("Kwetiaw Siram Spesial    = ");
			int D = input.nextInt();
			while(D > 10){
				System.out.println("Maximal pesan 10 porsi, masukan kembali pesanan anda...");
				System.out.print("Kwetiaw Siram Spesial      = ");
				D = input.nextInt();
		   }
			System.out.print("Kambing Guling Spesial   = ");
			int E = input.nextInt();
			while(E > 10){
				System.out.println("Maximal pesan 10 porsi, masukan kembali pesanan anda...");
				System.out.print("Kambing Guling Spesial      = ");
				E = input.nextInt();
		   }
			System.out.println();
			
//			System.out.print("Silahkan tekan ENTER Jika anda sudah selesai memilih menu");
//	            try {
//	                System.in.read();
//	            } catch (Exception e) {
//	            }
	            System.out.println("Selamat menikmati makanan anda...\n");
			
			//====================Proses==================== //
	        double Menu1 = (A * makanan1_price);
			double Menu2 = (B * makanan2_price);
			double Menu3 = (C * makanan3_price);
			double Menu4 = (D * makanan4_price);
			double Menu5 = (E * makanan5_price);
			double Total = Menu1 + Menu2 + Menu3 + Menu4 + Menu5;
			double Diskon = Total * 10 / (float) 100;
			double Total_Bayar = Total - Diskon;
			double Pembelian_Perorang = Total_Bayar / jumlah_orang;

			//====================Harga Pembelian dan Perhitungan==================== //
			df.setRoundingMode(RoundingMode.UP);
			System.out.println("Pembelian : ");
			System.out.printf("\n1. Nasi Goreng Spesial \t\t" + A + " Porsi * " + "Rp. " + makanan1_price + "\t= Rp. " + df.format (Menu1));
			System.out.printf("\n2. Ayam Goreng Spesial \t\t" + B + " Porsi * " + "Rp. " + makanan2_price + "\t= Rp. " + df.format (Menu2));
			System.out.printf("\n3. Steak Sirloin Spesial \t" + C + " Porsi * " + "Rp. " + makanan3_price + "\t= Rp. " + df.format (Menu3));
			System.out.printf("\n4. Kwetiaw Siram Spesial \t" + D + " Porsi * " + "Rp. " + makanan4_price + "\t= Rp. " + df.format (Menu4));
			System.out.printf("\n5. Kambing Guling Spesial \t" + E + " Porsi * " + "Rp. " + makanan5_price + "\t= Rp. " + df.format (Menu5));
			System.out.println("\t+");
			System.out.println("=====================================================================");
			System.out.println("Total Pembelian                                  \t= Rp. " + df.format (Total));
			System.out.println("Disc.10% (Masa Promosi)                          \t= Rp. " + df.format (Diskon) + "\t-");
			System.out.println("=====================================================================");
			System.out.println("Total Pembelian Setelah Disc 10%                 \t= Rp. " + df.format(Total_Bayar));
			System.out.println("Pembelian Per Orang (Untuk " + jumlah_orang + " Orang)                = Rp. " + df.format  (Pembelian_Perorang));
			System.out.println();
               
		
			System.out.println("			Terima Kasih Atas Kunjungan Anda...");
			System.out.println("			...Tekan ENTER untuk keluar...");
		        try {
		            System.in.read();
		        } catch (Exception e) {
		            System.exit(0);
		        }
		        System.exit(0);
		        return;
      }
        
    }
}
