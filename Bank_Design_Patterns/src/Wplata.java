import java.util.ArrayList;

public class Wplata extends Operacja {
	
	private RachunekInterface r;
	private int kwota;
	
	
	public Wplata(RachunekInterface r, int kwota) {
		this.r = r;
		this.kwota = kwota;
	}



	@Override
	public int wykonaj() {
		
		int saldo = r.saldo();
		ArrayList historia = r.getHistoria();
		
		saldo += kwota;
		historia.add("Wpłata: " + kwota + ", saldo: " + saldo);
		return 1;
		

	}


}
