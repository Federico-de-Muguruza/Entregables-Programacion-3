package Entregable_3;

import java.util.HashMap;
import java.util.Iterator;

public class Mapa {

	private Grafo<Integer> grafito;
	private HashMap<Integer, Ciudad> ciudades;
	
	public Mapa() {
		this.grafito = new GrafoNoDirigido<>();
		this.ciudades = new HashMap<>();
	}
	
	// Complejidad: O(a) a = Cantidad de rutas de la ciudad
	public Iterator<Integer> getAdyacentesCiudad(int ciudad) {
		return this.grafito.obtenerAdyacentes(ciudad); 	// Complejidad: O(a) a = Cantidad de rutas de la ciudad
	}
	
	// Complejidad: O(1)
	public Iterator<Integer> getCiudades() {
		return this.grafito.obtenerVertices(); // Complejidad: O(1)
	}
	
	// Complejidad: O(1)
	public void addCiudad(Ciudad ciudad) {
		this.ciudades.put(ciudad.getIdCiudad(), ciudad); // Complejidad: O(1)
		this.grafito.agregarVertice(ciudad.getIdCiudad()); // Complejidad: O(1)
	}
	
	// Complejidad: O(V*a) V = Cantidad de ciudades y a = Cantidad de rutas
	public void deleteCiudad(Ciudad ciudad) {
		this.grafito.borrarVertice(ciudad.getIdCiudad()); // Complejidad: O(V*a) V = Cantidad de ciudades y a = Cantidad de rutas
		this.ciudades.remove(ciudad.getIdCiudad()); // Complejidad: O(1)
	}
	
	// Complejidad: O(1)
	public void addRuta(Ciudad origen, Ciudad destino, Integer km) {
		this.grafito.agregarArco(origen.getIdCiudad(), destino.getIdCiudad(), km); // Complejidad: O(1)
	}
	
	// Complejidad: O(a) a = Cantidad de rutas
	public void deleteRuta(Ciudad origen, Ciudad destino) {
		this.grafito.borrarArco(origen.getIdCiudad(), destino.getIdCiudad()); // Complejidad: O(a) a = Cantidad de arcos
	}
	
	public Camino getCaminoMasCorto(int ciudadOrigen, int ciudadDestino) {
		DFS dfs = new DFS(this);
		return dfs.dfs(ciudadOrigen, ciudadDestino);
	}
	
	// Complejidad: O(1)
	public Ciudad getCiudad(Integer pos) {
		return this.ciudades.get(pos);
	}

	// Complejidad: O(a) a = Cantidad de rutas
	public Integer obtenerKm(int verticeOrigen, int verticeDestino) {
		Arco<Integer> km = grafito.obtenerArco(verticeOrigen, verticeDestino); // Complejidad: O(a) a = Cantidad de arcos	
		if (km != null) {
			return km.getEtiqueta(); // Complejidad: O(1)
		}
		return null;
	}
}
