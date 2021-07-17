package Entregable_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap <Integer, ArrayList<Arco<T>>> vertices; 
	private int cantidadArcos;

	public GrafoDirigido() {
		this.vertices = new HashMap<Integer, ArrayList<Arco<T>>>();
		this.cantidadArcos = 0;
	}
	
	// Complejidad: O(1)
	@Override
	public void agregarVertice(int verticeId) {
		if ( ! contieneVertice(verticeId)) // Complejidad: O(1)
			this.vertices.put(verticeId, new ArrayList<Arco<T>>()); // Complejidad: O(1)
	}

	// Complejidad: O(V*a) V = Cantidad de vértices y a = Cantidad de arcos
	@Override
	public void borrarVertice(int verticeId) {
		if (contieneVertice(verticeId)) { // Complejidad: O(1)
			Iterator<Arco<T>> itArcos = obtenerArcos(); // Complejidad: O(V*a) V = Cantidad de vértices y a = Cantidad de arcos
			
			while (itArcos.hasNext()) { // Complejidad: O(a) a = Cantidad de arcos
				Arco<T> arco = itArcos.next(); // Complejidad: O(1)
				if (arco.getVerticeDestino() == verticeId) {
					this.vertices.get(arco.getVerticeOrigen()).remove(arco); // Complejidad: O(1)
					this.cantidadArcos--;
				}
			}
			int cantidadArcosVertice = this.vertices.get(verticeId).size(); // Complejidad: O(1)
			this.cantidadArcos -= cantidadArcosVertice;
			this.vertices.remove(verticeId); // Complejidad: O(1)	
		}
	}

	// Complejidad O(a) a = Cantidad de arcos entre el verticeId1 y verticeId2
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) { // Complejidad: O(1)
			boolean existeArco = this.existeArco(verticeId1, verticeId2); // Complejidad O(a) a = Cantidad de arcos entre el verticeId1 y verticeId2
			if ( ! existeArco) {
				Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
				this.vertices.get(verticeId1).add(arco); // Complejidad: O(1)
				this.cantidadArcos++;				
			}
		}
	}

	// Complejidad: O(a) a = Cantidad de arcos
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
			Arco<T> arco = this.obtenerArco(verticeId1, verticeId2); // Complejidad: O(a) a = Cantidad de arcos
			if (arco != null) {
				this.vertices.get(verticeId1).remove(arco); // Complejidad: O(1)
				this.cantidadArcos--;
			}
	}	

	// Complejidad: O(1) 
	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId); // Complejidad: O(1)
	}

	// Complejidad: O(a) a = Cantidad de arcos entre el verticeId1 y verticeId2
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
			Arco<T> arco = this.obtenerArco(verticeId1, verticeId2); // Complejidad: O(a) a = Cantidad de arcos entre el verticeId1 y verticeId2
			return arco != null;			
		}
		return false;
	}

	// Complejidad: O(a) a = Cantidad de arcos del verticeId1
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {	
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) { // Complejidad: O(1)
			Iterator<Arco<T>> it = obtenerArcos(verticeId1); // Complejidad: O(1)
			while (it.hasNext()) { // O(a) a = Cantidad de arcos del verticeId1
				Arco<T> arco = it.next(); // Complejidad: O(1)
				if (arco.getVerticeDestino() == verticeId2) {
					return arco;
				}
			}
		}
		return null;
	}

	// Complejidad: O(1) 
	@Override
	public int cantidadVertices() {
		return this.vertices.size(); // Complejidad: O(1)
	}

	// Complejidad: O(1)
	@Override
	public int cantidadArcos() {
		return this.cantidadArcos; // Complejidad: O(1)
	}

	// Complejidad: O(1)
	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}
	
	// Complejidad: O(a) a = Cantidad de arcos del vértice
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> adyacentes = new ArrayList<>();
		if (contieneVertice(verticeId)) { // Complejidad: O(1)
			Iterator<Arco<T>> it = obtenerArcos(verticeId); // Complejidad: O(1)
			
			while (it.hasNext()) { // Complejidad: O(a) a = Cantidad de arcos del vértice
				Arco<T> arco = it.next(); // Complejidad: O(1)
				adyacentes.add(arco.getVerticeDestino()); // Complejidad: O(1)
			}
		}
		return adyacentes.iterator();
	}

	// Complejidad: O(V*a) V = Cantidad de vértices total y a = Cantidad de arcos del vértice 
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		Iterator<Integer> it = obtenerVertices(); // Complejidad: O(1)
		ArrayList<Arco<T>> arcos = new ArrayList<>();
	
		while (it.hasNext()) { // Complejidad: O(V) V = Cantidad de vértices total
			Integer vertice = it.next(); // Complejidad: O(1)
			arcos.addAll(this.vertices.get(vertice)); // Complejidad: O(a) a = Cantidad de arcos del vértice
		}
		return arcos.iterator();
	}

	// Complejidad: O(1)
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		if (contieneVertice(verticeId)) { // Complejidad: O(1)
			arcos = this.vertices.get(verticeId); // Complejidad: O(1)
		}
		return arcos.iterator();
	}
}
