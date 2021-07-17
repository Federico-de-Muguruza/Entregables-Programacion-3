package Entregable_1;

import java.util.Iterator;

public class MyIterator implements Iterator<Integer>{

	private Node cursor;
	
	public MyIterator(Node last) {
		this.cursor = last;
	}
	
	@Override
	public boolean hasNext() { // O(1) es simple
		return this.cursor != null;
	}

	@Override
	public Integer next() { // O(1) es simple
		Node aux = this.cursor;
		this.cursor = this.cursor.getNext(); // O(1) es simple
		return aux.getInfo(); // O(1) es simple
	}

}
