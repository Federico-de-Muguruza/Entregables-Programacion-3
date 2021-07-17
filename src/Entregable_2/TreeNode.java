package Entregable_2;

public class TreeNode {

	private int value;
	private TreeNode izq;
	private TreeNode der;
	private TreeNode Padre;
	
	public TreeNode(int value) {
		this.value = value;
		this.izq = null;
		this.der = null;
	}
	
	// Complejidad: O(1)
	public int getValue() {
		return this.value;
	}
	
	// Complejidad: O(1)
	public void setPadre(TreeNode node) {
		this.Padre = node;
	}
	
	// Complejidad: O(1)
	public TreeNode getPadre() {
		return this.Padre;
	}
	
	// Complejidad: O(1)
	public void setValue(int value) {
		this.value = value;
	}
	
	// Complejidad: O(1)
	public TreeNode getIzq() {
		return this.izq;
	}
	
	// Complejidad: O(1)
	public TreeNode getDer() {
		return this.der;
	}
	
	// Complejidad: O(1)
	public void setIzq(TreeNode node) {
		this.izq = node;
	}
	
	// Complejidad: O(1)
	public void setDer(TreeNode node) {
		this.der = node;
	}
	
	// Complejidad: O(1)
	public String toString() {
		return "" + this.getValue();
	}
}
