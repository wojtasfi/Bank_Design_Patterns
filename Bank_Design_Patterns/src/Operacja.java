
public abstract class Operacja {
	protected boolean wykonana = false;
	
	public abstract int wykonaj();

	public void setWykonana(boolean wykonana) {
		this.wykonana = wykonana;
	}

	

}
