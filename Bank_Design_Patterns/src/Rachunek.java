
import java.util.ArrayList;

public class Rachunek implements RachunekInterface {
	private String numer;
	private String imie, nazwisko;
	private int saldo;
	private int dopuszczalnyDebet;
	private ArrayList historia = new ArrayList();
	private Odsetki ods = new OdsetkiA();
	
	
	
	/* (non-Javadoc)
	 * @see RachunekInterface#setSaldo(int)
	 */
	@Override
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	/* (non-Javadoc)
	 * @see RachunekInterface#getHistoria()
	 */
	@Override
	public ArrayList getHistoria() {
		return historia;
	}

	/* (non-Javadoc)
	 * @see RachunekInterface#ustawOdsetki(Odsetki)
	 */
	@Override
	public void ustawOdsetki(Odsetki ods){
		this.ods = ods;
	}
	
	/**
	 * Utworzenie rachunku
	 * @param numer
	 * @param imie
	 * @param nazwisko
	 */
	public Rachunek(String numer, String imie, String nazwisko) {
		this.numer = numer;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.saldo = 0;
	}
	
	/* (non-Javadoc)
	 * @see RachunekInterface#numer()
	 */
	@Override
	public String numer() {
		return numer;
	}
	
	/* (non-Javadoc)
	 * @see RachunekInterface#wlasciciel()
	 */
	@Override
	public String wlasciciel() {
		return imie + " " + nazwisko;
	}
	
	/* (non-Javadoc)
	 * @see RachunekInterface#saldo()
	 */
	@Override
	public int saldo() {
		return saldo;
	}
	
	/*
	public void ustawDebet(int debet) {
		if (debet > 100)
			dopuszczalnyDebet = debet;
	}
	*/
	/**
	 * Ustawia dopuszczalny debet na podaną wartość
	 * @param debet
	 */
	public int debet() {
		return dopuszczalnyDebet;
	}

	/* (non-Javadoc)
	 * @see RachunekInterface#piszHistorie()
	 */
	@Override
	public void piszHistorie() {
		System.out.println(historia);
	}
	
	/* (non-Javadoc)
	 * @see RachunekInterface#wplata(int)
	 */
	@Override
	public int wplata(int kwota) {
		saldo += kwota;
		historia.add("Wpłata: " + kwota + ", saldo: " + saldo);
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see RachunekInterface#wyplata(int)
	 */
	@Override
	public int wyplata(int kwota) {
		if (saldo + dopuszczalnyDebet >= kwota) {
			saldo -= kwota;
			historia.add("Wypłata: " + kwota + ", saldo: " + saldo);
			return 1;
		}
		historia.add("Nieudana wypłata: " + kwota + ", saldo: " + saldo);
		return -1;
	}
	
	/* (non-Javadoc)
	 * @see RachunekInterface#odsetki()
	 */
	@Override
	public int odsetki() {
		
		int odset = ods.obliczOdsetki(this);
		
		piszHistorie();
		
		return odset;
		
	}

	@Override
	public int getMaxDebet() {
		// TODO Auto-generated method stub
		return 0;
	}
}
