
public class Samochod {
	public int nr;
	public String marka;
	public String model;
	public int rocznik;
	public int pojemnosc;
	public int przebieg;
	public String skrzynia;
	
	public Samochod(int nr, String marka, String model, int rocznik, int pojemnosc, int przebieg, String skrzynia) {
		this.nr=nr;
		this.marka=marka;
		this.model=model;
		this.pojemnosc=pojemnosc;
		this.przebieg=przebieg;
		this.rocznik=rocznik;
		this.skrzynia=skrzynia;
		
	}
	public String toString() {
		return nr + " " +marka + " " + model + " " + rocznik + " "+ pojemnosc + " "+ przebieg + " "+ skrzynia;
	}
}
