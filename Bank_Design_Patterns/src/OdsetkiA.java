
public class OdsetkiA extends Odsetki {

	@Override
	public int obliczOdsetki(RachunekInterface r) {

		if (r.saldo() <= 1000) {
			odsetki = (int) (r.saldo() * 0.03);
		} else if (r.saldo() > 1000 && r.saldo() <= 10000) {
			odsetki = (int) (r.saldo() * 0.04);
		} else if (r.saldo() > 10000) {
			odsetki = (int) (r.saldo() * 0.05);
		}

		r.wplata(odsetki);
		return odsetki;
	}

}
