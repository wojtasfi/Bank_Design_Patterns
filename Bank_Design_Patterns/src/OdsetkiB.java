
public class OdsetkiB extends Odsetki {

	@Override
	public int obliczOdsetki(RachunekInterface r) {
		if (r.saldo() <= 1000) {
			odsetki = (int) (r.saldo() * 0.06);
		} else if (r.saldo() > 1000 && r.saldo() <= 10000) {
			odsetki = (int) (r.saldo() * 0.07);
		} else if (r.saldo() > 10000) {
			odsetki = (int) (r.saldo() * 0.08);
		}

		r.wplata(odsetki);
		return odsetki;
	}

}
