#include <iostream>
#include <fstream>
#include <string>
using namespace std;
	std::fstream plik;

		int i=0; //ilo�� samochod�w
		
struct samochod{
	string marka;
	string model;
	int rocznik;
	int pojemnosc;
	int przebieg;
	char skrzynia;
};

void dopisanie(){
	samochod x;
 
	char znak;
	plik.open("plik.txt", ios::out | ios::app);
	if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl;
	do{
		cout << endl << "Samoch�d nr " << i+1 << endl;
		cout << "Podaj mark� samochodu: ";
		cin.clear();
		cin >> x.marka;
		cout << "Podaj model samochodu: ";
		cin.clear();
		cin >> x.model;
		cout << "Podaj rocznik samochodu: ";
		cin.clear();
		cin >> x.rocznik;
		cout << "Podaj pojemno�� w cm sze�ciennych samochodu: ";
		cin.clear();
		cin >> x.pojemnosc;
		cout << "Podaj przebieg w km samochodu: ";
		cin.clear();
		cin >> x.przebieg;
		cout << "Typy skrzy� biegu i ich oznaczenia:" << endl << "m - skrzynia manualna;" << endl <<"a - skrzynia automatyczna stopniowa;" << endl <<"p - skrzynia p�automatycznia stopniowa;" << endl <<"b - skrzynia bezstopniowa;" << endl;
		cout << "Podaj typ skrzyni bieg�w samochodu: ";
		cin.clear();
		cin >> x.skrzynia;
		plik.write((char*)&x, sizeof(x));
		
		cout << endl;
		cout << "Czy dopisa� dane kolejnego samochodu? Je�li tak podaj t lub T." << endl;
		cin >> znak;
		i++;
	} while (znak=='t' || znak == 'T');
	plik.close();
}

void wyswietlenie(){
	samochod x;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl << i << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
plik.close();
}

void wyswietlenie2(int a){
	samochod x;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl;
	plik.seekg((i-a+1)*sizeof(samochod), ios::beg);

		plik.read((char*)&x, sizeof(x));
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
plik.close();
}

void wyswietlaniewarunkowe1(int y){
	samochod x;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl << i << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.rocznik>=y)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
plik.close();
}

void wyswietlaniewarunkowe2(int y){
	samochod x;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl << i << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.pojemnosc>=y)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
plik.close();
}

void wyswietlaniewarunkowe3(int y){
	samochod x;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl << i << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.przebieg<=y)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
plik.close();
}

void wyswietlaniewarunkowe4(string u){
	samochod x;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl << i << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.model==u)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
plik.close();
}

void wyswietlaniewarunkowe5(string u){
	samochod x;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl << i << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.marka==u)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
plik.close();
}

void sortuj1(){
	samochod x;
	int e=0;
	int r=0;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.rocznik>e)
		   	e=x.rocznik;
	}
	
	do{
		
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.rocznik==e)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
	r=0;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.rocznik>r && x.rocznik<e)
			r=x.rocznik;
	}
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.rocznik==r)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
	e=0;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.rocznik>e && x.rocznik<r)
			e=x.rocznik;
	}
	
	}while(!e==0);	
plik.close();
}

void sortuj2(){
	samochod x;
	int e=0;
	int r=0;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.pojemnosc>e)
		   	e=x.pojemnosc;
	}
	
	do{
		
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.pojemnosc==e)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
	r=0;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.pojemnosc>r && x.pojemnosc<e)
			r=x.pojemnosc;
	}
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.pojemnosc==r)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
	e=0;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.pojemnosc>e && x.pojemnosc<r)
			e=x.pojemnosc;
	}
	
	}while(!e==0);	
plik.close();
}

void sortuj3(){
	samochod x;
	int e=0;
	int r=0;
	plik.open("plik.txt", ios::in);
		if( plik.good() == true )
		cout << endl << "Uzyskano dostep do pliku!" << endl;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.przebieg>e)
		   	e=x.przebieg;
	}
	
	do{
		
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.przebieg==e)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
	r=0;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.przebieg>r && x.przebieg<e)
			r=x.przebieg;
	}
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.przebieg==r)
			cout << endl << x.marka << " " << x.model << " " << x.rocznik << " " << x.pojemnosc << " " << x.przebieg << " " << x.skrzynia << endl;
	}
	e=0;
	plik.seekg((i)*sizeof(samochod), ios::beg);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		if(x.przebieg>e && x.przebieg<r)
			e=x.przebieg;
	}
	
	}while(!e==0);	
plik.close();
}

void usuwanie(int a){
		samochod x;
		int o=0;
	fstream usuwanie;
	plik.open("plik.txt", ios::in);
	usuwanie.open("usuwanie.txt", ios::trunc | ios::out);
	
	while(o<(i-a+1)*sizeof(samochod))
	{
		plik.read((char*)&x, sizeof(x));
		usuwanie.write((char*)&x, sizeof(x));
		o+=24;
	}
	plik.seekg(sizeof(samochod), ios::end);
	while(!plik.eof())
	{
		plik.read((char*)&x, sizeof(x));
		usuwanie.write((char*)&x, sizeof(x));
	}
	plik.close();
	usuwanie.close();
	
	plik.open("plik.txt", ios::trunc | ios::out);
	usuwanie.open("usuwanie.txt", ios::in);
	while(!usuwanie.eof())
	{
		usuwanie.read((char*)&x, sizeof(x));
		plik.write((char*)&x, sizeof(x));
	}
	plik.close();
	usuwanie.close();
}

int main()
{
	setlocale(LC_ALL, "");
	plik.open("plik.txt", ios::trunc);
	plik.close();
	int q;
	int w;
	int t;
	int a;
	int y;
	string u;
	char znak;
	do{
		cout << "Wybierz jedn� z opcji: " << endl;
		cout << endl;
		cout << "1. Wprowadzenie danych nowego samochodu." << endl;
		cout << "2. Wy�wietlenie listy samochod�w." << endl;
		cout << "3. Wy�wietlenie warunkowe listy samochod�w." << endl;
		cout << "4. Wy�wietlenie danych pojedynczego samochodu." << endl;
		cout << "5. Posortowanie samochod�w po wybranym parametrze." << endl;
		cout << "6. Usuni�cie samochodu z katalogu." << endl;
		cout << endl;
		cout << "Numer wybranej opcji: ";
		cin >> q;
		cout << "Zosta�a wybrana opcja numer: ";
		cout << q;
		switch (q){
			case 1:
				dopisanie();
				break;
			case 2:
				wyswietlenie();
				break;
			case 3:
				cout << endl << "Wybierz jedn� z opcji: " << endl;
				cout << endl;
				cout << "1. Ustaw minimalny rocznik wy�wietlanych samochod�w." << endl;
		   	   	cout << "2. Ustaw minimaln� pojemno�� wy�wietlanych samochod�w." << endl;
				cout << "3. Ustaw maksymalny przebieg wy�wietlanych samochod�w." << endl;
				cout << "4. Ustaw nazw� modeli wy�wietlanych samochod�w." << endl;
				cout << "5. Ustaw nazw� marek wy�wietlanych samochod�w." << endl;
				cout << endl;
				cout << "Numer wybranej opcji: ";
				cin >> t;
		   	   	cout << "Zosta�a wybrana opcja numer: ";
		   	   	cout << t;
		   	   	cout << endl;
	  	   	   	switch(t)
						 {
						 case 1:
						 	cout << "Podaj minimalny rocznik wy�wietlanych samochod�w." << endl;
						 	cin >> y;
						 	wyswietlaniewarunkowe1(y);
						 	 break;
						 case 2:
						 	cout << "Podaj minimaln� pojemno�� wy�wietlanych samochod�w." << endl;
						 	cin >> y;
						 	wyswietlaniewarunkowe2(y);
					 	 	break;
					 	 case 3:
					 	 	cout << "Podaj maksymalny przebieg wy�wietlanych samochod�w." << endl;
					 	 	cin >> y;
					 	 	wyswietlaniewarunkowe3(y);
					 	 	break;
					 	 case 4:
					 	 	cout << "Podaj nazw� modeli wy�wietlanych samochod�w." << endl;
					 	 	cin >> u;
					 	 	wyswietlaniewarunkowe4(u);
					 	 	break;
					 	 case 5:
					 	 	cout << "Podaj nazw� marek wy�wietlanych samochod�w." << endl;
					 	 	cin >> u;
					 	 	wyswietlaniewarunkowe5(u);
					 	 	break;
						 default:
							 cout << endl << "Brak opcji o podanym numerze." << endl;
						 }
				break;
			case 4:
				a=0;
				do{
				cout << endl << "Dane, kt�rego samochodu chcesz wy�wietli�? Podaj numer samochodu: ";
				cin >> a;
				if (a>i || a==0)
					cout << endl << "Nie ma samochodu o takim numerze.";
				}while(a>i || a==0);
				
				wyswietlenie2(a);
				break;
			case 5:
				cout << endl << "Wybierz jedn� z opcji: " << endl;
				cout << endl;
				cout << "1. Sortuj po roczniku." << endl;
		   	   	cout << "2. Sortuj po pojemno�ci." << endl;
				cout << "3. Sortuj po przebiegu." << endl;
				cout << endl;
				cout << "Numer wybranej opcji: ";
				cin >> w;
		   	   	cout << "Zosta�a wybrana opcja numer: ";
		   	   	cout << w;
	  	   	   	switch(w)
						 {
						 case 1:
						 	sortuj1();
						 	 break;
						 case 2:
						 	sortuj2();
					 	 	break;
					 	 case 3:
					 	 	sortuj3();
					 	 	break;
						 default:
							 cout << endl << "Brak opcji o podanym numerze." << endl;
						 }
				break;
			case 6:
				a=0;
				do{
				cout << endl << "Dane, kt�rego samochodu chcesz usun��? Podaj numer samochodu: ";
				cin >> a;
				if (a>i || a==0)
					cout << endl << "Nie ma samochodu o takim numerze.";
				}while(a>i || a==0);
				usuwanie(a);
				break;
			default:
				cout << endl << "Brak opcji o podanym numerze." << endl;
		}
		
		cout << endl;
		cout << "Czy wr�ci� do MENU? Je�li tak podaj t lub T." << endl;
		cin >> znak;
	} while (znak=='t' || znak == 'T');

	return 0;
}