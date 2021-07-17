package Entregable_3;

import java.util.ArrayList;

public class Camino {

	private ArrayList<String> ciudades;
	private int cantidadTotalKm;
	private boolean llegoDestino;
	
	public Camino() {
		this.ciudades = new ArrayList<String>();
		this.cantidadTotalKm = 0;
		this.llegoDestino = false;
	}
	
	// Complejidad: O(1)
	public boolean getLlegoDestino() {
		return this.llegoDestino;
	}
	
	// Complejidad: O(1)
	public int getCantidadKm() {
		return this.cantidadTotalKm;
	}
	
	// Complejidad: O(1)
	public void addCiudad(Integer km, String ciudad, boolean llegoDestino) {
		this.ciudades.add(ciudad);
		this.cantidadTotalKm = km;
		this.llegoDestino = true;
	}
	
	// Complejidad: O(1)
	public void addCiudadActual(String ciudad) {
		this.ciudades.add(0, ciudad);
	}

	// Complejidad: O(1)
	public String toString() {
		if ( ! this.ciudades.isEmpty()) // Complejidad O(1)
			return "Ciudades: " + this.ciudades + " Total KM: " + this.getCantidadKm();
		return "No se encontró un recorrido";
	}
}
