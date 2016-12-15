
import java.rmi.server.Operation;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
	private HashMap rachunki = new HashMap();
	private ArrayList<Operacja> historia = new ArrayList();
	
	
	public void dodajHistorie(Operacja o){
		historia.add(o);
	}

	/**
	 * Zakładanie rachunku. Rachunek zostanie stworzony i zapamiętany przez bank.
	 * @param numer
	 * @param imie
	 * @param nazwisko
	 * @return
	 */
	public Rachunek zalozRachunek(String numer, String imie, String nazwisko) {
		Rachunek rach = new Rachunek(numer, imie, nazwisko);
		rachunki.put(numer, rach);
		return rach;
	}

	/**
	 * Wyszukiwanie rachunku
	 * @param numer
	 * @return obiekt rachunku, jeżeli zostanie znaleziony, i null, jeżeli go nie ma
	 */	
	public RachunekInterface szukaj(String numer) {
		return (RachunekInterface) rachunki.get(numer);
	}
	
	/**
	 * Przelew w kwocie kwota z rachunku o numerze numer1 na rachunek o numerze numerw
	 * @param numer1
	 * @param numer2
	 * @param kwota
	 * @return -1, jeżeli przelew się nie powiedzie, 0 - jeżeli przelew się powiedzie
	 */
	public int przelew(String numer1, String numer2, int kwota) {
		RachunekInterface rach1 = szukaj(numer1);
		RachunekInterface rach2 = szukaj(numer2);
		
		return przelew(rach1, rach2, kwota);
	}
	
	/**
	 * Przelew w kwocie kwota z rachunku rach1 na rachunek rach2
	 * @param rach1
	 * @param rach2
	 * @param kwota
	 * @return
	 */
	public int przelew(RachunekInterface rach1, RachunekInterface rach2, int kwota) {
		if (rach1.wyplata(kwota) > 0) {
			rach2.wplata(kwota);
			return 1;
		}
		
		return 0;
	}
	
	
	public void wykonajOperacje(Operacja o){
		int correct = o.wykonaj();
		o.setWykonana(true);
		dodajHistorie(o);
		
		if(correct == 1){
			System.out.println("Opercaja wykonana poprawnie");
		}else{
			System.out.println("Opercaja wykonana poprawnie");
		}
	}
}