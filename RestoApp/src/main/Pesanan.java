package main;

public class Pesanan {
	Menu menu;
	double jumlah;
	
	public Pesanan(Menu menu, double jumlah) {
		this.menu = menu;
		this.jumlah = jumlah;
	}
	
	public double subtotal() {
		return this.menu.harga * this.jumlah;
	}
}
