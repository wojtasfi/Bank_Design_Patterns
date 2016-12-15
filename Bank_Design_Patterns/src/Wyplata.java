import java.util.ArrayList;

public class Wyplata extends Operacja {

	private RachunekInterface r;
	private int kwota;
	
	
	public Wyplata(RachunekInterface r, int kwota) {
		this.r = r;
		this.kwota = kwota;
	}



	@Override
	public int wykonaj() {
		int saldo = r.saldo();
		ArrayList historia = r.getHistoria();
		int maxDebet = r.getMaxDebet();
		
		if(r instanceof Rachunek){
		
		if (saldo >= kwota) {
			saldo -= kwota;
			historia.add("Wypłata: " + kwota + ", saldo: " + saldo);
			return 1;
		}
		historia.add("Nieudana wypłata: " + kwota + ", saldo: " + saldo);
		return -1;
		}
		
		else if(r instanceof RachunekDebetowy){
			

			if (saldo > kwota) {
				saldo -= kwota;
				r.setSaldo(saldo);
				historia.add("Wypłata: " + kwota + ", saldo: " + saldo);
				return 1;
			} else if (saldo < kwota && ((saldo - kwota) < maxDebet)) {
				int nowaKwota = kwota - saldo;
				((RachunekDebetowy) r).setDebet(r.debet()+ nowaKwota);
				r.setSaldo(0);
				return 1;
			}
		}
		return 0;

	}
}
