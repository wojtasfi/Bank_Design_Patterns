
public class OdsetkiC extends Odsetki {

	@Override
	public int obliczOdsetki(RachunekInterface r) {

		if (r.saldo() <= 1000) {
			odsetki = (int) (r.saldo() * 0.03 + 500);
		} else if (r.saldo() > 1000 && r.saldo() <= 10000) {
			odsetki = (int) (r.saldo() * 0.04 + 1500);
		} else if (r.saldo() > 10000) {
			odsetki = (int) (r.saldo() * 0.05 + 2500);
		}

		r.wplata(odsetki);
		return odsetki;
	}

}
