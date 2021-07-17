package Entregable_1;

import java.util.Iterator;

public class MySimpleLinkedList implements Iterable<Integer> {
	
	protected Node first;
	protected int size;
	private Node last;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public void insertFront(int o) { // O(1) es simple
		Node tmp = new Node(o);
		tmp.setNext(this.first); // O(1) porque es simple
		if (isEmpty())
			this.last = tmp;
		this.first = tmp;
		this.size++;
	}
	
	public void insertBack(int o) { // O(1) es simple
		Node tmp = new Node(o);
		tmp.setBack(this.last); // O(1) porque es simple
		this.last = tmp;
		
		// En la primera inserción this.first será null por lo que guarda el valor allí y nunca más entrará
		// Esto lo hago para tener una referencia al primer valor agregado e iterar sobre ese con el Iterator
		if (isEmpty()) {
			this.first = tmp;
			this.last = tmp;
		}
		// Aquí siempre entrará a partir de la segunda inserción declarando que:
		// El siguiente valor del anterior valor del actual será el valor actual
		else 
			this.last.getBack().setNext(this.last); // O(1) porque es simple
					
		this.size++;
	}
	
	public Integer extractFront() { // O(1) porque siempre sacará el first
		Node elem = this.first;
		if ( ! isEmpty()) {
			this.first = this.first.getNext(); // O(1) porque es simple
			size--;
			return elem.getInfo();	// O(1) porque es simple		
		}
		// No encontrado
		return null;
	}
	
	public Integer top() { // O(1) porque devuelvo el first
		if (! isEmpty())
			return this.first.getInfo(); // O(1) porque es simple
		return null;
	}

	public boolean isEmpty() { // O(1) porque sólo verifico el primer valor
		return this.first == null;
	}

	public int size() { // O(1) porque tengo el atributo size donde voy modificando el valor
		return this.size;
	}
	
	public Integer indexOf(int valor) { // O(n) n = cantidad de elementos en la lista (porque puede ser que tenga que recorrer todo en el peor caso)
		int contador = 0;
		
		MyIterator it = new MyIterator(this.first);
		
		while(it.hasNext()) { // O(n) n = cantidad de elementos de la lista
			if (it.next() == valor) {			
				return contador;
			}
			contador++;
		}
		// No encontrado
		return null;
	}
	
	public void print(int valor) { // O(n) n = cantidad de elementos en la lista (porque puede ser que tenga que recorrer todo en el peor caso)
		
		MyIterator it = new MyIterator(this.first);
		int contador = 0;
		
		while(it.hasNext() && contador <= valor) { // O(n) n = cantidad de elementos de la lista (porque puede ser que tenga que recorrer todo en el peor caso)
			System.out.println(it.next()); // O(1) es simple
			contador++;
		}
		
	}
	
	public Integer get(int index) { // O(n) n = cantidad de elementos en la lista (porque puede ser que tenga que recorrer todo en el peor caso)
		if (index >= 0) { // Controlo que no inserte números negativos
			int i = 0;
			Node elem = this.first;
			while (elem != null && i < index) { // O(n) = cantidad de elementos de la lista
				elem = elem.getNext(); // O(1) porque es simple
				i++;
			}
			if (elem != null)
				return elem.getInfo(); // O(1) porque es simple
		}
		// No encontrado
		return null;
	}
	
	@Override
	public String toString() { // O(n) n = cantidad de elementos de la lista
		MyIterator it = new MyIterator(this.first);
		String resultado = "";
		
		while(it.hasNext()) { // O(n) n = cantidad de elementos de la lista
			resultado +=  "|" + it.next() + "|"; // O(1) es simple
		}
		return resultado;
	}
	
	@Override
    public MyIterator iterator() {
        return new MyIterator(this.first);
    }

}
