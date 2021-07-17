package Entregable_3;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	// Complejidad: O(1)
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta); // Complejidad: O(1)
		super.agregarArco(verticeId2, verticeId1, etiqueta); // Complejidad: O(1)
	}
	
	// Complejidad: O(V*a) V = Cantidad de vértices y a = Cantidad de arcos
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2); // Complejidad: O(V*a) V = Cantidad de vértices y a = Cantidad de arcos
		super.borrarArco(verticeId2, verticeId1); // Complejidad: O(V*a) V = Cantidad de vértices y a = Cantidad de arcos
	}
}
