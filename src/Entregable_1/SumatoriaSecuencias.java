package Entregable_1;

import java.util.Iterator;

public class SumatoriaSecuencias {

	MySimpleLinkedList list = new MySimpleLinkedList();
	
	public SumatoriaSecuencias(MySimpleLinkedList list) {
		this.list = list;
	}
	
	// Resolución del entregable
	public MySimpleLinkedList getSumatoria(int valor) { // O(n) n = cantidad de elementos de la lista (porque debe recorrer todos los elementos para ir sumando)
		System.out.println("UMBRAL: " + valor);
		MySimpleLinkedList exitList = new MySimpleLinkedList();
		
		Iterator<Integer> it = this.list.iterator();
		
		int suma = 0;

		while(it.hasNext()) { // O(n) n = cantidad de elementos de la lista
			boolean insertar = true;
			int i = it.next(); // O(1) es simple
			suma += i;
			// Si la suma ya es mayor al valor significa que encontré la cantidad máxima de sub-secuencias
			// por lo que debo insertar esa suma restándole el valor de la iteración actual
			if (suma > valor) {
				if (suma != i) // Si la suma es diferente a i la inserta (se hizo por si con NINGUNA suma el valor ya era mayor y si se restaba insertaba 0)
					exitList.insertBack(suma - i); // O(1) es simple
				suma = i; // Declaro a suma como i para que no se pierda este valor y comience desde allí
				if (suma > valor) {// Si acá la suma es mayor, la seteo en 0
					suma = 0;
					insertar = false;
				}	
			}  // Si la suma es menor o igual, es el último ciclo del while y insertar es true (no sería el suma = 0 en la última iteración) lo agrega a la lista
			if (suma <= valor && ! it.hasNext() && insertar)
					exitList.insertBack(suma); // O(1) es simple
		}
		
		return exitList;
	}
	
}
