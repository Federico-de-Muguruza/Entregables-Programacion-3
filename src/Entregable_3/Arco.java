package Entregable_3;

public class Arco<T> {

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	// Complejidad: O(1)
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	// Complejidad: O(1)
	public int getVerticeDestino() {
		return verticeDestino;
	}

	// Complejidad: O(1)
	public T getEtiqueta() {
		return etiqueta;
	}

	// Complejidad: O(1)
	public String toString() {
		return "" + this.getEtiqueta();
	}
}
