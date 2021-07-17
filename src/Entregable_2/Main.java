package Entregable_2;

public class Main {

	public static void main(String[] args) {
		
		int[] valoresIniciales = new int[] {15, 4, 1, 25, 50, 6, 7, 20, 5, 30};
		
		TreeWithNode twn2 = new TreeWithNode(valoresIniciales);
		
		twn2.preOrden();
		System.out.println("getMaxElem: " + twn2.getMaxElem());
		System.out.println("getHeight: " + twn2.getHeight());
		System.out.println("getLongestBranch: " + twn2.getLongestBranch());
		System.out.println("getElemAtLevel: " + twn2.getElemAtLevel(2));
		System.out.println("getFrontera: " + twn2.getFrontera());
		
		System.out.println("");
		
		twn2.add(23);
		twn2.add(3);
		twn2.delete(6);
		twn2.delete(30);
		
		twn2.preOrden();
		System.out.println("getMaxElem: " + twn2.getMaxElem());
		System.out.println("getHeight: " + twn2.getHeight());
		System.out.println("getLongestBranch: " + twn2.getLongestBranch());
		System.out.println("getElemAtLevel: " + twn2.getElemAtLevel(2));
		System.out.println("getFrontera: " + twn2.getFrontera());

		System.out.println("");
		
		twn2.add(65);
		twn2.delete(5);
		twn2.delete(15);
		twn2.add(55);
		
		twn2.preOrden();
		System.out.println("getMaxElem: " + twn2.getMaxElem());
		System.out.println("getHeight: " + twn2.getHeight());
		System.out.println("getLongestBranch: " + twn2.getLongestBranch());
		System.out.println("getElemAtLevel: " + twn2.getElemAtLevel(2));
		System.out.println("getFrontera: " + twn2.getFrontera());
		
		System.out.println("");
		
		System.out.println("DATOS DE PRUEBA");
		TreeWithNode twn3 = new TreeWithNode(new int[] {10, 20, 15, 30});
		
		twn3.delete(10);
		twn3.preOrden();
		
	}

}
