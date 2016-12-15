import java.util.ArrayList;

public class RachunekDebetowy implements RachunekInterface {

	private Rachunek rach;
	private int debet = 0;
	private int maxDebet;

	public RachunekDebetowy(Rachunek rach, int maxDebet) {
		this.rach = rach;
		this.maxDebet = maxDebet;
	};

	@Override
	public void setSaldo(int saldo) {
		// TODO Auto-generated method stub
		rach.setSaldo(saldo);
	}

	@Override
	public ArrayList getHistoria() {
		// TODO Auto-generated method stub
		return rach.getHistoria();
	}

	@Override
	public void ustawOdsetki(Odsetki ods) {
		// TODO Auto-generated method stub
		rach.ustawOdsetki(ods);
	}

	@Override
	public String numer() {
		// TODO Auto-generated method stub
		return rach.numer();
	}

	@Override
	public String wlasciciel() {
		// TODO Auto-generated method stub
		return rach.wlasciciel();
	}

	@Override
	public int saldo() {
		// TODO Auto-generated method stub
		return rach.saldo();
	}

	@Override
	public void piszHistorie() {
		// TODO Auto-generated method stub
		rach.piszHistorie();
	}

	@Override
	public int wyplata(int kwota) {
		// TODO Auto-generated method stub
		int saldo = rach.saldo();

		if (saldo > kwota) {
			return rach.wyplata(kwota);
		} else if (saldo < kwota && ((saldo - kwota) < maxDebet)) {
			int nowaKwota = kwota - saldo;
			debet += nowaKwota;
			return rach.wyplata(nowaKwota);
		}

		// hsqldb
		return 0;
	}

	@Override
	public int wplata(int kwota) {
		//To od razu ogarnia odsetki bo one są przekazywane wpłatą jak narazie

		if (debet > 0) {
			int nowaKwota = kwota - debet;
			debet -= kwota;
			
			if (nowaKwota > 0) {
				rach.wplata(nowaKwota);
			}else{
				return 1;
			}
		}
		
		//nie ma debetu
		return rach.wplata(kwota);
	}

	@Override
	public int odsetki() {
		
		return rach.odsetki();
	}

	@Override
	public int debet() {
		// TODO Auto-generated method stub
		return debet;
	}
	
	public int getMaxDebet() {
		// TODO Auto-generated method stub
		return maxDebet;
	}

	public void setDebet(int debet) {
		this.debet = debet;
	}
	
	

}
