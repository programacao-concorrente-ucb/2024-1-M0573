package jantar_filosofos;

public class Prato {
	private int macarrao;
	
	public Prato(int macarrao) {
		this.macarrao = macarrao;
	}
	
	public void comer() {
		this.macarrao--;
	}
	
	public boolean temMacarrao() {
		return this.macarrao > 0;
	}
}
