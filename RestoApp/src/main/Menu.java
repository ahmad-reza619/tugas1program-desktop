package main;

public class Menu {
	String nama;
	double harga;
	String kategori;
	
	public Menu(String nama, double harga, String kategori) {
		this.nama = nama;
		this.harga = harga;
		this.kategori = kategori;
	}
	
	@Override
	public String toString() {
		return this.nama + "(" + this.kategori + ")" + " - " + this.harga;
	}
}
