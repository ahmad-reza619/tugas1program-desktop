package main;

import java.util.Scanner;

public class RestoApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Menu menu[] = {
				new Menu("Nasi padang", 10_000, "Makanan"),
				new Menu("Nasi ramas", 12_000, "Makanan"),
				new Menu("Es teh", 5000, "Minuman"),
				new Menu("Kopi hangat", 6000, "Minuman"),
		};
		
		System.out.println("Selamat datang di Restoran, berikut daftar menu yang tersedia:");
		System.out.println("1." + menu[0]);
		System.out.println("2." + menu[1]);
		System.out.println("3." + menu[2]);
		System.out.println("4." + menu[3]);
		
		System.out.print("Anda ingin pesan berapa?");
		double jumlahPesanan = input.nextDouble();
		input.nextLine();
		
		if (jumlahPesanan > 4 || jumlahPesanan < 1) {
			System.out.println("Jumlah pesanan harus diantara 1-4!");
			return;
		}
		
		Pesanan pesanan[] = new Pesanan[4];
		
		System.out.print("\nSilahkan input nomor menu yang anda inginkan");
		int nomor1 = input.nextInt();
		input.nextLine();
		if (nomor1 > 4 || nomor1 < 1) {
			System.out.println("Menu yang dipilih invalid");
			return;
		}
		
		Menu menuTerpilih = menu[nomor1 - 1];
		System.out.print("\n Input berapa jumlah yang ingin dipesan");
		int jumlah = input.nextInt();
		input.nextLine();
		pesanan[0] = new Pesanan(menuTerpilih, jumlah);
		
		if (jumlahPesanan >= 2) {
			System.out.print("\nSilahkan input nomor menu yang anda inginkan");
			int nomor = input.nextInt();
			input.nextLine();
			if (nomor > 4 || nomor < 1) {
				System.out.println("Menu yang dipilih invalid");
				return;
			}
			
			Menu menu2 = menu[nomor - 1];
			System.out.print("\n Input berapa jumlah yang ingin dipesan");
			int jumlah2 = input.nextInt();
			input.nextLine();
			pesanan[1] = new Pesanan(menu2, jumlah2);
		}
		if (jumlahPesanan >= 3) {
			System.out.print("\nSilahkan input nomor menu yang anda inginkan");
			int nomor = input.nextInt();
			input.nextLine();
			if (nomor > 4 || nomor < 1) {
				System.out.println("Menu yang dipilih invalid");
				return;
			}
			
			Menu menu2 = menu[nomor - 1];
			System.out.print("\n Input berapa jumlah yang ingin dipesan");
			int jumlah2 = input.nextInt();
			input.nextLine();
			pesanan[2] = new Pesanan(menu2, jumlah2);
		}
		if (jumlahPesanan == 4) {
			System.out.print("\nSilahkan input nomor menu yang anda inginkan");
			int nomor = input.nextInt();
			input.nextLine();
			if (nomor > 4 || nomor < 1) {
				System.out.println("Menu yang dipilih invalid");
				return;
			}
			
			Menu menu2 = menu[nomor - 1];
			System.out.print("\n Input berapa jumlah yang ingin dipesan");
			int jumlah2 = input.nextInt();
			input.nextLine();
			pesanan[3] = new Pesanan(menu2, jumlah2);
		}
		
		double subtotal = pesanan[0].subtotal();
		if (jumlahPesanan >= 2) subtotal += pesanan[1].subtotal();
		if (jumlahPesanan >= 3) subtotal += pesanan[2].subtotal();
		if (jumlahPesanan == 4) subtotal += pesanan[3].subtotal();
		
		double subtotalSebelumDiskon = subtotal;
		
		double pajak = subtotal * 0.1;
		double biayaLayanan = 20_000;
		
		double diskon = subtotal * 0.1;
		Menu minumGratis = null;
		boolean dapatDiskon = false;
		boolean dapatMinumGratis = false;
		
		if (subtotalSebelumDiskon > 100_000) {
			dapatDiskon = true;
			subtotal -= diskon;
		}
		if (subtotalSebelumDiskon > 50_000) {
			dapatMinumGratis = true;
			System.out.println("Selamat, anda mendapat minum gratis, silahkan pilih salah satu minuman dibawah ini:");
			System.out.println("1." + menu[2]);
			System.out.println("2." + menu[3]);
			int nomorMinum = input.nextInt();
			input.nextLine();
			
			if (nomorMinum > 4 || nomorMinum < 1) {
				System.out.println("Nomor minum tidak valid!");
				return;
			}
			minumGratis = menu[nomorMinum + 1];
		}
		
		double total = subtotal + pajak + biayaLayanan;
		
		System.out.println("Struk pembayaran");
		System.out.println("----------------");
		
		System.out.println("1." + pesanan[0].menu.nama + "(" + pesanan[0].jumlah + ") =" + pesanan[0].subtotal());
		if (jumlahPesanan >= 2) {
			System.out.println("2." + pesanan[1].menu.nama + "(" + pesanan[1].jumlah + ") =" + pesanan[1].subtotal());
		}
		if (jumlahPesanan >= 3) {
			System.out.println("3." + pesanan[2].menu.nama + "(" + pesanan[2].jumlah + ") =" + pesanan[2].subtotal());
		}
		if (jumlahPesanan == 4) {
			System.out.println("4." + pesanan[3].menu.nama + "(" + pesanan[3].jumlah + ") =" + pesanan[3].subtotal());
		}
		
		System.out.println("Subtotal:" + subtotalSebelumDiskon);
		if (dapatDiskon) {
			System.out.println("Anda mendapatkan diskon 10%:" + diskon);
		}
		if (dapatMinumGratis && minumGratis != null) {
			System.out.println("Minuman Gratis:" + minumGratis.nama + "(Gratis)");
		}
		System.out.println("Pajak (10%):" + pajak);
		System.out.println("Biaya Layanan:" + biayaLayanan);
		System.out.println("Total: " + total);
	}
}
