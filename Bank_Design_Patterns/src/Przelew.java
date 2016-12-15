import java.util.ArrayList;

public class Przelew extends Operacja {

	private Rachunek rach1;
	private RachunekInterface rach2;
	private int kwota;
	
	
	public Przelew(Rachunek r, RachunekInterface r2, int kwota) {
		this.rach1 = r;
		this.rach2 = r2;
		this.kwota = kwota;
	}
	
	@Override
	public int wykonaj() {
		ArrayList historia1 = rach1.getHistoria();
		ArrayList historia2 = rach2.getHistoria();
		
		//Rachunek 1- wyplata
		if (rach1.saldo() + rach1.debet() >= kwota) {
			rach1.setSaldo(rach1.saldo()- kwota);
		}
		
		//Rachunek 2 wplata
		
		rach2.setSaldo(rach2.saldo() + kwota);
		
		historia1.add("Przelew od " + rach1.wlasciciel() + " do " + rach2.wlasciciel() + " w kwocie " + kwota + " PLN.");
		historia2.add("Przelew od " + rach1.wlasciciel() + " do " + rach2.wlasciciel() + " w kwocie " + kwota + " PLN.");
		return 1;

	}

}
