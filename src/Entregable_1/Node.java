package Entregable_1;

public class Node {

	private int info;
	private Node next;
	private Node back;

	public Node() {
		this.info = 0;
		this.next = null;
		this.back = null;
	}
	
	public Node(int o) { 
		this.setInfo(o);
	}
	
	public Node getNext() { // O(1) es simple
		return next;
	}

	public void setNext(Node next) { // O(1) es simple
		this.next = next;
	}
	
	public void setBack(Node back) { // O(1) es simple
		this.back = back;
	}
	
	public Node getBack() { // O(1) es simple
		return this.back;
	}

	public int getInfo() { // O(1) es simple
		return info;
	}

	public void setInfo(int info) { // O(1) es simple
		this.info = info;
	}
	
	public String toString() { // O(1) es simple
		return "" + this.getInfo();
	}
}
