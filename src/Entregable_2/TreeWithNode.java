package Entregable_2;

import java.util.ArrayList;

public class TreeWithNode {
	
	private TreeNode raiz;
	
	public TreeWithNode() {
		this.raiz = null;
	}
	 
	public TreeWithNode(int[] arreglo) {
		this.addArreglo(arreglo);
	}
	
	// Complejidad: O(n*h) n = Cantidad de elementos en el arreglo (en el peor caso voy a tener n cantidad de elementos en el arreglo)
	// y h = Altura del árbol (porque en el peor caso voy a insertar el valor en la altura máxima del árbol)
	private void addArreglo(int[] arreglo) {
		for (int i = 0; i < arreglo.length; i++) {
			this.add(arreglo[i]);
		}
	}
	
	// Complejidad: O(h) h = Altura del árbol (tomará una rama mayor o menor a la raíz y en base a eso recorré en el peor caso la altura del árbol)
	public void add(int value) {
		if (isEmpty()) 
			this.raiz = new TreeNode(value);
		else // Si ya hay una raíz uso el método add privado para pasarle su raíz y el nuevo valor
			this.add(this.raiz, value);
	}
	
	// Complejidad: O(h) h = Altura del árbol (tomará una rama mayor o menor a la raíz y en base a eso recorré en el peor caso la altura del árbol)
	private void add(TreeNode node, int value) {
		if (value < node.getValue()) { // Si el valor ingresado es menor a la raíz
			if (node.getIzq() == null) { // Si es null significa que encontró su posición
				TreeNode temp = new TreeNode(value);
				temp.setPadre(node);
				node.setIzq(temp);
			} else { // Si no es null sigo buscando recursivamente
				add(node.getIzq(), value);
			}
		} else { // Si el valor ingresado es mayor a la raíz
			if (node.getDer() == null) { // Si es null significa que encontró su posición
				TreeNode temp = new TreeNode(value);
				temp.setPadre(node);
				node.setDer(temp);
			} else { // Si no es null sigo buscando recursivamente
				add(node.getDer(), value);
			}
		}
	}
	
	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
	public boolean delete(int value) {
		if ( ! isEmpty()) 
			return delete(value, this.raiz);
		 else {
			return false;
		}
	}
	
	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
	private boolean delete(int value, TreeNode node) {

		TreeNode currentNode = getNode(value, node);		
		
		// Si hay nodos en mi árbol
		if ( ! isEmpty()) { 
			
			// Si el nodo actual existe
			if (currentNode != null) { 
				
				 // Si el padre existe
				if (currentNode.getPadre() != null) { 
						
					// Si se quiere borrar un nodo hoja
					if (currentNode.getIzq() == null && currentNode.getDer() == null) {
						// Si el que se quiere borrar es el hijo izquierdo respecto al padre
						if (currentNode.getValue() < currentNode.getPadre().getValue()) {
							currentNode.getPadre().setIzq(null);
						// Si el que se quiere borrar es el hijo derecho respecto al padre
						} else {
							currentNode.getPadre().setDer(null);
						}
						currentNode.setPadre(null);
						return true;
					// Si el que se quiere borrar tiene el hijo izquierdo pero no el derecho
					} else if (currentNode.getIzq() != null && currentNode.getDer() == null) {
						currentNode.getIzq().setPadre(currentNode.getPadre());
						// Si el que se quiere borrar es el hijo izquierdo respecto al padre
						if (currentNode.getValue() < currentNode.getPadre().getValue()) {
							currentNode.getPadre().setIzq(currentNode.getIzq());
						// Si el que se quiere borrar es el hijo derecho respecto al padre
						} else {
							currentNode.getPadre().setDer(currentNode.getIzq());
						}
						currentNode.setPadre(null);
						currentNode.setIzq(null);
						return true;
					// Si el que se quiere borrar tiene el hijo derecho pero no el izquierdo
					} else if (currentNode.getIzq() == null && currentNode.getDer() != null) {
						currentNode.getDer().setPadre(currentNode.getPadre());
						// Si el que se quiere borrar es el hijo izquierdo respecto al padre
						if (currentNode.getValue() < currentNode.getPadre().getValue()) {
							currentNode.getPadre().setIzq(currentNode.getDer());
						// Si el que se quiere borrar es el hijo derecho respecto al padre
						} else {
							currentNode.getPadre().setDer(currentNode.getDer());
						}
						currentNode.setPadre(null);
						currentNode.setDer(null);
						return true;
					// Si el que se quiere borrar tiene ambos hijos
					} else {
						// Si la izquierda de la derecha del nodo a borrar existe
						if (currentNode.getDer().getIzq() != null) {
							TreeNode mostIzq = getMinElem(currentNode.getDer().getIzq());
							// Si el que se quiere borrar es el hijo izquierdo respecto al padre
							if (currentNode.getValue() < currentNode.getPadre().getValue()) {
								currentNode.getPadre().setIzq(mostIzq);
							} else {
								currentNode.getPadre().setDer(mostIzq);
							}
							this.delete(mostIzq.getValue(), mostIzq);
							mostIzq.setIzq(currentNode.getIzq());
							mostIzq.setDer(currentNode.getDer());
							return true;
						// Si la izquierda de la derecha del nodo a borrar no existe
						} else {
							TreeNode currentNodeDer = currentNode.getDer();
							// Si el que se quiere borrar es el hijo izquierdo respecto al padre
							if (currentNode.getValue() < currentNode.getPadre().getValue()) {
								currentNode.getPadre().setIzq(currentNode.getDer());
							} else {
								currentNode.getPadre().setDer(currentNode.getDer());
							}
							this.delete(currentNode.getDer().getValue(), currentNode.getDer());
							currentNodeDer.setIzq(currentNode.getIzq());
							currentNode.getIzq().setPadre(currentNodeDer);
							currentNode.setPadre(null);
							currentNode.setDer(null);
							currentNode.setIzq(null);
							return true;
						}
					}
				// Si se quiere borrar la raíz	
				} else {
					// Si la raíz no tiene hijos
					if (currentNode.getIzq() == null && currentNode.getDer() == null) {
						this.raiz = null;
					// Si la raíz tiene sólo hijo izquierdo
					} else if (currentNode.getIzq() != null && currentNode.getDer() == null) {
						this.raiz = currentNode.getIzq();
						this.raiz.setPadre(null);
					// Si la raíz tiene sólo hijo derecho
					} else if (currentNode.getIzq() == null && currentNode.getDer() != null) {
						// Si la izquierda de la derecha de la raíz existe
						if (currentNode.getDer().getIzq() != null) {
							TreeNode mostIzq = getMinElem(currentNode.getDer().getIzq());
							this.delete(mostIzq.getValue(), mostIzq);
							this.raiz = mostIzq;
							mostIzq.setDer(currentNode.getDer());
							currentNode.getDer().setPadre(this.raiz);
						// Si la izquierda de la derecha de la raíz no existe
						} else {
							this.raiz = currentNode.getDer();
							this.raiz.setPadre(null);
						}
					// Si la raíz tiene ambos hijos
					} else {
						// Si la izquierda de la derecha de la raíz existe
						if (currentNode.getDer().getIzq() != null) {
							TreeNode mostIzq = getMinElem(currentNode.getDer().getIzq());
							this.delete(mostIzq.getValue(), mostIzq);
							this.raiz = mostIzq;
							this.raiz.setIzq(currentNode.getIzq());
							this.raiz.setDer(currentNode.getDer());
							currentNode.getIzq().setPadre(this.raiz);
							currentNode.getDer().setPadre(this.raiz);
							this.raiz.setPadre(null);
						// Si la izquierda de la derecha de la raíz no existe
						} else {
							this.raiz = currentNode.getDer();
							this.delete(currentNode.getDer().getValue(), currentNode.getDer());
							currentNode.getIzq().setPadre(this.raiz);
							this.raiz.setIzq(currentNode.getIzq());
							this.raiz.setDer(currentNode.getDer());
							this.raiz.setPadre(null);
						}
					}
					return true;
				}
			}
		}
		return false;	
	}
	
	// Complejidad: O(n) n = Cantidad de nodos en el árbol (En el peor caso voy a pasar por todos los nodos)
	public ArrayList<Integer> getElemAtLevel(int level) {
		if (isEmpty()) 
			return new ArrayList<Integer>();
		return getElemAtLevel(level, 0, this.raiz);
	}
	
	// Complejidad: O(n) n = Cantidad de nodos en el árbol (En el peor caso voy a pasar por todos los nodos)
	private ArrayList<Integer> getElemAtLevel(int level, int contador, TreeNode node) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		if (node != null) {
			
			if (contador == level) {
				list.add(node.getValue());
			}
			
			if (contador <= level) {
				list.addAll(getElemAtLevel(level, contador + 1, node.getIzq()));
				list.addAll(getElemAtLevel(level, contador + 1, node.getDer()));	
			}
		}
		return list;
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos)
	public ArrayList<Integer> getLongestBranch() {
		if (isEmpty())
			return new ArrayList<Integer>();
		return getLongestBranch(this.raiz);
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos)
	private ArrayList<Integer> getLongestBranch(TreeNode node) {
		
		ArrayList<Integer> izq = new ArrayList<>();
		ArrayList<Integer> der = new ArrayList<>();
		
		izq.add(node.getValue());
		der.add(node.getValue());
		
		if (node.getIzq() != null)
			izq.addAll(getLongestBranch(node.getIzq()));
		
		if (node.getDer() != null)
			der.addAll(getLongestBranch(node.getDer()));
		
		if (izq.size() < der.size())
			return der;
		else
			return izq;
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos)
	public int getHeight() {
		if (isEmpty())
			return 0;
		return getHeight(this.raiz);
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos)
	private int getHeight(TreeNode node) {
		
		int valorIzq = 0;
		int valorDer = 0;
		
		if (node.getIzq() != null)
			valorIzq = getHeight(node.getIzq()) + 1;
		
		if (node.getDer() != null)
			valorDer = getHeight(node.getDer()) + 1;
		
		return Math.max(valorIzq, valorDer);
		
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos)
	public ArrayList<Integer> getFrontera() {
		if ( ! isEmpty())
			return getFrontera(this.raiz);
		else
			return new ArrayList<Integer>();
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos)
	private ArrayList<Integer> getFrontera(TreeNode node) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		if (node != null) {
			if (node.getIzq() == null && node.getDer() == null) {
				list.add(node.getValue());
			}
			list.addAll(getFrontera(node.getIzq()));
			list.addAll(getFrontera(node.getDer()));
		}
		return list;
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos) 
	public void preOrden() {
		preOrden(this.raiz);
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos)
	private void preOrden(TreeNode node) {		
		if (node != null) {
			System.out.println(node.getValue());
			preOrden(node.getIzq());
			preOrden(node.getDer());
		} else {
			System.out.println("-");
		}
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos) 
	public void postOrder() {
		postOrder(this.raiz);
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos) 
	private void postOrder(TreeNode node) {
		if (node != null) {
			postOrder(node.getIzq());
			postOrder(node.getDer());
			System.out.println(node.getValue());
		} else {
			System.out.println("-");
		}
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos) 
	public void inOrder() {
		inOrder(this.raiz);
	}
	
	// Complejidad: O(n) n = Cantidad de nodos (paso por todos los nodos) 
	private void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.getIzq());
			System.out.println(node.getValue());
			inOrder(node.getDer());
		} else {
			System.out.println("-");
		}
	}
	
	// Complejidad: O(1) 
	public Integer getRoot() {
		if ( ! isEmpty())
			return this.raiz.getValue();
		return null;
	}
	
	// Complejidad: O(1)
	public boolean isEmpty() {
		return this.raiz == null;
	}
	
	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
	public boolean hasElem(int value) {
		if ( ! isEmpty()) {
			TreeNode aux = getNode(value, this.raiz);
			if (aux != null)
				return true;
			
		}
		return false;
	}
	
//	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
//	private boolean hasElem(int value, TreeNode node) {
//		if (node != null) {
//			if (value > node.getValue()) 
//				return hasElem(value, node.getDer());
//			else if (value < node.getValue()) 
//				return hasElem(value, node.getIzq());
//			else 
//				return true;			
//		}
//		return false;
//	}
	
	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
	private TreeNode getNode(int value, TreeNode node) {
		if (node != null) {
			if (value > node.getValue()) 
				return getNode(value, node.getDer());
			else if (value < node.getValue()) 
				return getNode(value, node.getIzq());
			else 
				return node;			
			
		}
		return null;
	}
	
	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
	public Integer getMaxElem() {
		if ( ! isEmpty()) {
			TreeNode node = getMaxElem(this.raiz);
			return node.getValue();
		}
		return null;
	}
	
	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
	private TreeNode getMaxElem(TreeNode node) {
		if (node.getDer() != null)
			return getMaxElem(node.getDer());
		return node;
	}
	
	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
	public Integer getMinElem() { 
		if ( ! isEmpty()) {
			TreeNode node = getMinElem(this.raiz);
			return node.getValue();
		}
		return null;
	}
	
	// Complejidad: O(h) h = Altura del árbol (En el peor caso recorro hasta la altura máxima del árbol)
	private TreeNode getMinElem(TreeNode node) {
		if (node.getIzq() != null)
			return getMinElem(node.getIzq());
		return node;
	}
}
