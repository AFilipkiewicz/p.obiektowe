import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {
 private static int nr=0;
 private static String marka;
 private static String model;
 private static int rocznik;
 private static int pojemnosc;
 private static int przebieg; 
 private static String skrzynia;
 private static int t;
 private static int e,r;
 private static String y;
 private static String filePath = "files/katalog";
 private static String line;

	public static void main(String[] args) throws IOException {
		BufferedReader fileReader = null;
		FileWriter fileWriter = null;
		Vector<Samochod> lista = new Vector<>();
		Scanner scan = new Scanner(System.in);
		
		try {
		    fileReader = new BufferedReader(new FileReader(filePath));
		    String numberAsString;
		    while ((line = fileReader.readLine()) != null) {
		    nr = Integer.parseInt(line);
		    marka = fileReader.readLine();
		    model = fileReader.readLine();
		    numberAsString = fileReader.readLine();
		    rocznik = Integer.parseInt(numberAsString);
		    numberAsString = fileReader.readLine();
		    pojemnosc = Integer.parseInt(numberAsString);
		    numberAsString = fileReader.readLine();
		    przebieg = Integer.parseInt(numberAsString);
		    skrzynia = fileReader.readLine();
		    Samochod samochod = new Samochod(nr, marka, model,rocznik,pojemnosc,przebieg,skrzynia);
		    samochod.nr=nr;
			samochod.marka=marka;
			samochod.model=model;
			samochod.pojemnosc=pojemnosc;
			samochod.przebieg=przebieg;
			samochod.rocznik=rocznik;
			samochod.skrzynia=skrzynia;
			lista.add(samochod);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    if (fileReader != null) {
		        fileReader.close();
		    }
		}
		do {
			System.out.println("\nWybierz jedn� z opcji: ");
			System.out.println("1. Wprowadzenie danych nowego samochodu.");
			System.out.println("2. Wy�wietlenie listy samochod�w.");
			System.out.println("3. Wy�wietlenie warunkowe listy samochod�w.");
			System.out.println("4. Wy�wietlenie danych pojedynczego samochodu.");
			System.out.println("5. Posortowanie samochod�w po wybranym parametrze.");
			System.out.println("6. Usuni�cie samochodu z katalogu.");
			System.out.println("7. Zapisanie katalogu do pliku.");
			System.out.println("\nNumer wybranej opcji: ");
			t=scan.nextInt();
			scan.nextLine();
			System.out.println("Zota�a wybrana opcja numer: " + t);
		
		switch(t) {
			case 1:
				do {
					Samochod samochod = new Samochod(nr, marka, model,rocznik,pojemnosc,przebieg,skrzynia);
					nr++;
					System.out.println("Podaj nazw� marki: ");
					marka=scan.nextLine();
					System.out.println("Podaj nazw� modelu: ");
					model=scan.nextLine();
					System.out.println("Podaj rocznik: ");
					rocznik=scan.nextInt();
					scan.nextLine();
					System.out.println("Podaj pojemnosc: ");
					pojemnosc=scan.nextInt();
					scan.nextLine();
					System.out.println("Podaj przebieg: ");
					przebieg=scan.nextInt();
					scan.nextLine();
					System.out.println("Typy skrzy�:\n- manualna\n- automatyczna stopniowa\n- p�automatycznia stopniowa\n- bezstopniowa ");
					System.out.println("Podaj skrzyni�: ");
					skrzynia=scan.nextLine();

					samochod.nr=nr;
					samochod.marka=marka;
					samochod.model=model;
					samochod.pojemnosc=pojemnosc;
					samochod.przebieg=przebieg;
					samochod.rocznik=rocznik;
					samochod.skrzynia=skrzynia;
					lista.add(samochod);
		
					System.out.println("\nczy chcesz wpisa� kolejny samoch�d? napisz \"1\" je�li tak\n");
					t=scan.nextInt();
					scan.nextLine();
				}while(t==1);
				break;
			case 2:
				System.out.println("\n\n---Katalog samochod�w: ---\n");
				if(lista.size()>=1)
					for(int i=0;i<lista.size();i++)
//						System.out.println((lista.get(i)).toString());
						System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
				else 
					System.out.println("W katalogu nie ma zapisanych �adnych samochod�w");
				break;
			case 3:	
				System.out.println("\nWybierz jedn� z opcji: ");
				System.out.println("1. Ustaw minimalny rocznik wy�wietlanych samochod�w.");
				System.out.println("2. Ustaw minimaln� pojemno�� wy�wietlanych samochod�w.");
				System.out.println("3. Ustaw maksymalny przebieg wy�wietlanych samochod�w.");
				System.out.println("4. Ustaw nazw� modeli wy�wietlanych samochod�w.");
				System.out.println("5. Ustaw nazw� marek wy�wietlanych samochod�w.");
				System.out.println("\nNumer wybranej opcji: ");
				t=scan.nextInt();
				scan.nextLine();
				switch(t) {
				case 1:
					System.out.println("Podaj minimalny rocznik wy�wietlanych samochod�w.");
					t=scan.nextInt();
					scan.nextLine();
					System.out.println("\n\n---Katalog samochod�w o roczniku nie starszym ni�: " + t + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).rocznik>=t)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych �adnych samochod�w");
					break;
				case 2:
					System.out.println("Podaj minimaln� pojemno�� wy�wietlanych samochod�w.");
					t=scan.nextInt();
					scan.nextLine();
					System.out.println("\n\n---Katalog samochod�w o pojemno�ci nie mniejszej ni�: " + t + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).pojemnosc>=t)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych �adnych samochod�w");
					break;
				case 3:
					System.out.println("Podaj maksymalny przebieg wy�wietlanych samochod�w.");
					t=scan.nextInt();
					scan.nextLine();
					System.out.println("\n\n---Katalog samochod�w o przebiegu nie wi�kszym ni�: " + t + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).przebieg<=t)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych �adnych samochod�w");
					break;
				case 4:
					System.out.println("Podaj nazw� modeli wy�wietlanych samochod�w.");
					y=scan.nextLine();
					System.out.println("\n\n---Katalog samochod�w o marce: " + y + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).marka==y)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych �adnych samochod�w");
					break;
				case 5:
					System.out.println("Podaj nazw� marek wy�wietlanych samochod�w.");
					y=scan.nextLine();
					System.out.println("\n\n---Katalog samochod�w o modelu: " + y + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).model==y)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych �adnych samochod�w");
					
					break;
				default:
					System.out.println("Brak opcji o podanym numerze.");
				}
				break;
			case 4:
				System.out.println("Dane, kt�rego samochodu chcesz wy�wietli�? Podaj numer samochodu: ");
				t=scan.nextInt();
				scan.nextLine();
				System.out.println("\n\n---Katalog samochod�w o modelu: " + y + " ---\n");
				if(lista.size()>=t)
					System.out.println("\nNumer: " + lista.get(t).nr + "\nMarka: " + lista.get(t).marka + "\nModel: " + lista.get(t).model + "\nRocznik: " + lista.get(t).rocznik + "\nPojemno��: " + lista.get(t).pojemnosc + "\nPrzebieg: " + lista.get(t).przebieg + "\nSkrzynia: " + lista.get(t).skrzynia);
				else 
					System.out.println("W katalogu nie ma zapisanego samochodu o podanym numerze");
				break;
			case 5:
				System.out.println("\nWybierz jedn� z opcji: ");
				System.out.println("1. Sortuj po roczniku.");
				System.out.println("2. Sortuj po pojemno�ci.");
				System.out.println("3. Sortuj po przebiegu.");
				System.out.println("\nNumer wybranej opcji: ");
				t=scan.nextInt();
				scan.nextLine();
				System.out.println("Zota�a wybrana opcja numer: " + t);
				switch(t) {
				case 1:
					e=0;
					r=0;
					System.out.println("\n---Katalog samochod�w: ---");
					if(lista.size()>=1) {
						for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik>e)
						   	e=lista.get(i).rocznik;
						}
						do{
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik==e)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							r=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik>r && lista.get(i).rocznik<e)
							r=lista.get(i).rocznik;
						   	}
						   	for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik==r)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							e=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik>e && lista.get(i).rocznik<r)
							e=lista.get(i).rocznik;
						   	}
						}while(e!=0);
						}
					else
						System.out.println("W katalogu nie ma zapisanych �adnych samochod�w.");
					break;
				case 2:
					e=0;
					r=0;
					System.out.println("\n---Katalog samochod�w: ---");
					if(lista.size()>=1) {
						for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc>e)
						   	e=lista.get(i).pojemnosc;
						}
						do{
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc==e)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							r=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc>r && lista.get(i).pojemnosc<e)
							r=lista.get(i).pojemnosc;
						   	}
						   	for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc==r)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							e=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc>e && lista.get(i).pojemnosc<r)
							e=lista.get(i).pojemnosc;
						   	}
						}while(e!=0);
						}
					else
						System.out.println("W katalogu nie ma zapisanych �adnych samochod�w.");
					break;
				case 3:
					e=0;
					r=0;
					System.out.println("\n---Katalog samochod�w: ---");
					if(lista.size()>=1) {
						for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg>e)
						   	e=lista.get(i).przebieg;
						}
						do{
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg==e)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							r=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg>r && lista.get(i).przebieg<e)
							r=lista.get(i).przebieg;
						   	}
						   	for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg==r)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemno��: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							e=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg>e && lista.get(i).przebieg<r)
							e=lista.get(i).przebieg;
						   	}
						}while(e!=0);
						}
					else
						System.out.println("W katalogu nie ma zapisanych �adnych samochod�w.");
					break;
				default:
					System.out.println("Brak opcji o podanym numerze.");
				}
			case 6:
				System.out.println("Dane, kt�rego samochodu chcesz usun��? Podaj numer samochodu: ");
				t=scan.nextInt();
				scan.nextLine();
				if(lista.size()>=t)
					lista.remove(t-1);
				else 
					System.out.println("W katalogu nie ma zapisanego samochodu o podanym numerze");
				break;
			case 7:
				try {
				    fileWriter = new FileWriter(filePath);
				    for(int i=0;i<lista.size();i++) {
				    	fileWriter.write(Integer.toString(lista.get(i).nr)+ "\n");
				    	fileWriter.write(lista.get(i).marka + "\n");
				    	fileWriter.write(lista.get(i).model + "\n");
				    	fileWriter.write(Integer.toString(lista.get(i).rocznik) + "\n");
				    	fileWriter.write(Integer.toString(lista.get(i).pojemnosc) + "\n");
				    	fileWriter.write(Integer.toString(lista.get(i).przebieg) + "\n");
				    	fileWriter.write(lista.get(i).skrzynia + "\n");
				    }
				} finally {
				    if (fileWriter != null) {
				        fileWriter.close();
				    }
				}
				break;
			default:
				System.out.println("Brak opcji o podanym numerze.");
			
}
		System.out.println("czy chcesz wr�ci� do katalogu? napisz \"1\" je�li tak");
		t=scan.nextInt();
		scan.nextLine();
		}while(t==1);
	}

	}
