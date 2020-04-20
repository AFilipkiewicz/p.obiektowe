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
			System.out.println("\nWybierz jedn¹ z opcji: ");
			System.out.println("1. Wprowadzenie danych nowego samochodu.");
			System.out.println("2. Wyœwietlenie listy samochodów.");
			System.out.println("3. Wyœwietlenie warunkowe listy samochodów.");
			System.out.println("4. Wyœwietlenie danych pojedynczego samochodu.");
			System.out.println("5. Posortowanie samochodów po wybranym parametrze.");
			System.out.println("6. Usuniêcie samochodu z katalogu.");
			System.out.println("7. Zapisanie katalogu do pliku.");
			System.out.println("\nNumer wybranej opcji: ");
			t=scan.nextInt();
			scan.nextLine();
			System.out.println("Zota³a wybrana opcja numer: " + t);
		
		switch(t) {
			case 1:
				do {
					Samochod samochod = new Samochod(nr, marka, model,rocznik,pojemnosc,przebieg,skrzynia);
					nr++;
					System.out.println("Podaj nazwê marki: ");
					marka=scan.nextLine();
					System.out.println("Podaj nazwê modelu: ");
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
					System.out.println("Typy skrzyñ:\n- manualna\n- automatyczna stopniowa\n- pó³automatycznia stopniowa\n- bezstopniowa ");
					System.out.println("Podaj skrzyniê: ");
					skrzynia=scan.nextLine();

					samochod.nr=nr;
					samochod.marka=marka;
					samochod.model=model;
					samochod.pojemnosc=pojemnosc;
					samochod.przebieg=przebieg;
					samochod.rocznik=rocznik;
					samochod.skrzynia=skrzynia;
					lista.add(samochod);
		
					System.out.println("\nczy chcesz wpisaæ kolejny samochód? napisz \"1\" jeœli tak\n");
					t=scan.nextInt();
					scan.nextLine();
				}while(t==1);
				break;
			case 2:
				System.out.println("\n\n---Katalog samochodów: ---\n");
				if(lista.size()>=1)
					for(int i=0;i<lista.size();i++)
//						System.out.println((lista.get(i)).toString());
						System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
				else 
					System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów");
				break;
			case 3:	
				System.out.println("\nWybierz jedn¹ z opcji: ");
				System.out.println("1. Ustaw minimalny rocznik wyœwietlanych samochodów.");
				System.out.println("2. Ustaw minimaln¹ pojemnoœæ wyœwietlanych samochodów.");
				System.out.println("3. Ustaw maksymalny przebieg wyœwietlanych samochodów.");
				System.out.println("4. Ustaw nazwê modeli wyœwietlanych samochodów.");
				System.out.println("5. Ustaw nazwê marek wyœwietlanych samochodów.");
				System.out.println("\nNumer wybranej opcji: ");
				t=scan.nextInt();
				scan.nextLine();
				switch(t) {
				case 1:
					System.out.println("Podaj minimalny rocznik wyœwietlanych samochodów.");
					t=scan.nextInt();
					scan.nextLine();
					System.out.println("\n\n---Katalog samochodów o roczniku nie starszym ni¿: " + t + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).rocznik>=t)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów");
					break;
				case 2:
					System.out.println("Podaj minimaln¹ pojemnoœæ wyœwietlanych samochodów.");
					t=scan.nextInt();
					scan.nextLine();
					System.out.println("\n\n---Katalog samochodów o pojemnoœci nie mniejszej ni¿: " + t + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).pojemnosc>=t)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów");
					break;
				case 3:
					System.out.println("Podaj maksymalny przebieg wyœwietlanych samochodów.");
					t=scan.nextInt();
					scan.nextLine();
					System.out.println("\n\n---Katalog samochodów o przebiegu nie wiêkszym ni¿: " + t + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).przebieg<=t)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów");
					break;
				case 4:
					System.out.println("Podaj nazwê modeli wyœwietlanych samochodów.");
					y=scan.nextLine();
					System.out.println("\n\n---Katalog samochodów o marce: " + y + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).marka==y)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów");
					break;
				case 5:
					System.out.println("Podaj nazwê marek wyœwietlanych samochodów.");
					y=scan.nextLine();
					System.out.println("\n\n---Katalog samochodów o modelu: " + y + " ---\n");
					if(lista.size()>=1)
						for(int i=0;i<lista.size();i++)
							if(lista.get(i).model==y)
							System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
					else 
						System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów");
					
					break;
				default:
					System.out.println("Brak opcji o podanym numerze.");
				}
				break;
			case 4:
				System.out.println("Dane, którego samochodu chcesz wyœwietliæ? Podaj numer samochodu: ");
				t=scan.nextInt();
				scan.nextLine();
				System.out.println("\n\n---Katalog samochodów o modelu: " + y + " ---\n");
				if(lista.size()>=t)
					System.out.println("\nNumer: " + lista.get(t).nr + "\nMarka: " + lista.get(t).marka + "\nModel: " + lista.get(t).model + "\nRocznik: " + lista.get(t).rocznik + "\nPojemnoœæ: " + lista.get(t).pojemnosc + "\nPrzebieg: " + lista.get(t).przebieg + "\nSkrzynia: " + lista.get(t).skrzynia);
				else 
					System.out.println("W katalogu nie ma zapisanego samochodu o podanym numerze");
				break;
			case 5:
				System.out.println("\nWybierz jedn¹ z opcji: ");
				System.out.println("1. Sortuj po roczniku.");
				System.out.println("2. Sortuj po pojemnoœci.");
				System.out.println("3. Sortuj po przebiegu.");
				System.out.println("\nNumer wybranej opcji: ");
				t=scan.nextInt();
				scan.nextLine();
				System.out.println("Zota³a wybrana opcja numer: " + t);
				switch(t) {
				case 1:
					e=0;
					r=0;
					System.out.println("\n---Katalog samochodów: ---");
					if(lista.size()>=1) {
						for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik>e)
						   	e=lista.get(i).rocznik;
						}
						do{
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik==e)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							r=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik>r && lista.get(i).rocznik<e)
							r=lista.get(i).rocznik;
						   	}
						   	for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik==r)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							e=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).rocznik>e && lista.get(i).rocznik<r)
							e=lista.get(i).rocznik;
						   	}
						}while(e!=0);
						}
					else
						System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów.");
					break;
				case 2:
					e=0;
					r=0;
					System.out.println("\n---Katalog samochodów: ---");
					if(lista.size()>=1) {
						for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc>e)
						   	e=lista.get(i).pojemnosc;
						}
						do{
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc==e)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							r=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc>r && lista.get(i).pojemnosc<e)
							r=lista.get(i).pojemnosc;
						   	}
						   	for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc==r)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							e=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).pojemnosc>e && lista.get(i).pojemnosc<r)
							e=lista.get(i).pojemnosc;
						   	}
						}while(e!=0);
						}
					else
						System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów.");
					break;
				case 3:
					e=0;
					r=0;
					System.out.println("\n---Katalog samochodów: ---");
					if(lista.size()>=1) {
						for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg>e)
						   	e=lista.get(i).przebieg;
						}
						do{
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg==e)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							r=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg>r && lista.get(i).przebieg<e)
							r=lista.get(i).przebieg;
						   	}
						   	for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg==r)
								System.out.println("\nNumer: " + lista.get(i).nr + "\nMarka: " + lista.get(i).marka + "\nModel: " + lista.get(i).model + "\nRocznik: " + lista.get(i).rocznik + "\nPojemnoœæ: " + lista.get(i).pojemnosc + "\nPrzebieg: " + lista.get(i).przebieg + "\nSkrzynia: " + lista.get(i).skrzynia);
							}
							e=0;
							for(int i=0;i<lista.size();i++){
							if(lista.get(i).przebieg>e && lista.get(i).przebieg<r)
							e=lista.get(i).przebieg;
						   	}
						}while(e!=0);
						}
					else
						System.out.println("W katalogu nie ma zapisanych ¿adnych samochodów.");
					break;
				default:
					System.out.println("Brak opcji o podanym numerze.");
				}
			case 6:
				System.out.println("Dane, którego samochodu chcesz usun¹æ? Podaj numer samochodu: ");
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
		System.out.println("czy chcesz wróciæ do katalogu? napisz \"1\" jeœli tak");
		t=scan.nextInt();
		scan.nextLine();
		}while(t==1);
	}

	}
