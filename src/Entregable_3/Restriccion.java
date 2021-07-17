package Entregable_3;

public class Restriccion {

	private int cantidadKm;
	private int cantidadBalanzas;
	
	public Restriccion() {
		this.cantidadKm = 0;
		this.cantidadBalanzas = 0;
	}
	
	public int getCantidadKm() {
		return this.cantidadKm;		
	}
	
	public int getCantidadBalanzas() {
		return this.cantidadBalanzas;
	}
	
	public void aumentarCantidadBalanzas() {
		this.cantidadBalanzas++;
	}
	
	public void aumentarCantidadKm(int km) {
		this.cantidadKm += km;
	}
	
	public void disminuirCantidadKm(int km) {
		this.cantidadKm -= km;
	}
	
	public void disminuirCantidadBalanzas(int cb) {
		this.cantidadBalanzas -= cb;
	}
}
