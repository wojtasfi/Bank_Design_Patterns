public class Starter {

	public static void main(String[] args) {
		Bank bank = new Bank();
		Rachunek rachKowalski = bank.zalozRachunek("1", "Jan", "Kowalski");
		RachunekInterface rachNowak = bank.zalozRachunek("2", "Jacek", "Nowak");

		Odsetki odsA = new OdsetkiA();
		Odsetki odsB = new OdsetkiB();
		Odsetki odsC = new OdsetkiC();

		rachKowalski.wplata(1500);

		rachKowalski.ustawOdsetki(odsA);

		/*
		int odsetkiKowalski = rachKowalski.odsetki();

		System.out.println("odsetki=" + odsetkiKowalski);

		rachKowalski.ustawOdsetki(odsB);
		int odsetkiKowalskiB = rachKowalski.odsetki();

		System.out.println("odsetki=" + odsetkiKowalskiB);
		*/
		
		System.out.println(rachKowalski.saldo());
		//System.out.println(rachNowak.saldo());
		
		/*
		Operacja przelew = new Przelew(rachKowalski, rachNowak, 10);
		
		bank.wykonajOperacje(przelew);
		
		
		System.out.println(rachKowalski.getHistoria());
		System.out.println(rachNowak.getHistoria());
		System.out.println(rachKowalski.saldo());
		System.out.println(rachNowak.saldo());
		*/
		
		RachunekDebetowy rachDebetKowalski = new RachunekDebetowy(rachKowalski, 1000);
		
		Operacja wyplata = new Wyplata(rachDebetKowalski, 2000);
		wyplata.wykonaj();
		System.out.println(rachDebetKowalski.saldo());
		System.out.println(rachDebetKowalski.debet());
		

	}
}
