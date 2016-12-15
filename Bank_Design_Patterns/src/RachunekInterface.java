import java.util.ArrayList;

public interface RachunekInterface {

	void setSaldo(int saldo);

	ArrayList getHistoria();

	void ustawOdsetki(Odsetki ods);

	/**
	 * Zwraca numer rachunku
	 * @return
	 */
	String numer();

	/**
	 * Zwraca właściciela rachunu
	 * @return
	 */
	String wlasciciel();

	/** 
	 * Zwraca saldo rachunku
	 * @return
	 */
	int saldo();

	/**
	 * Zwraca aktualną wartość dopuszczalnego debetu
	 * @return
	 */
	void piszHistorie();

	/**
	 * Wyświetla historię rachunku
	 *
	 */
	int wplata(int kwota);

	/**
	 * Wpłaca podaną kwotę na rachunek
	 * @param kwota
	 * @return 0
	 */
	int wyplata(int kwota);

	/**
	 * Zwraca wartość należnych odsetek: do 10000 - 1%, od 10000 do 50000 - 2%, powyżej 50000 - 3%
	 * @return
	 */
	int odsetki();

	int debet();

	int getMaxDebet();

	

}