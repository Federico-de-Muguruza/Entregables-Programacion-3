package Entregable_1;

public class Main {

	public static void main(String[] args) {
		
		// Datos de prueba
		
		MySimpleLinkedList list0 = new MySimpleLinkedList();
		SumatoriaSecuencias sumatoria0 = new SumatoriaSecuencias(list0);
		
		System.out.println(sumatoria0.getSumatoria(10));
		
		MySimpleLinkedList list1 = new MySimpleLinkedList();
		SumatoriaSecuencias sumatoria1 = new SumatoriaSecuencias(list1);
		
		list1.insertBack(1);
		list1.insertBack(2);
		list1.insertBack(3);
		
		System.out.println(sumatoria1.getSumatoria(10));
		
		MySimpleLinkedList list2 = new MySimpleLinkedList();
		SumatoriaSecuencias sumatoria2 = new SumatoriaSecuencias(list2);
		
		list2.insertBack(1);
		list2.insertBack(2);
		
		System.out.println(sumatoria2.getSumatoria(2));
		
		MySimpleLinkedList list3 = new MySimpleLinkedList();
		SumatoriaSecuencias sumatoria3 = new SumatoriaSecuencias(list3);
		
		list3.insertBack(3);
		list3.insertBack(5);
		list3.insertBack(2);
		list3.insertBack(7);
		list3.insertBack(19);
		list3.insertBack(14);
		list3.insertBack(28);
		
		System.out.println(sumatoria3.getSumatoria(10));
		
		MySimpleLinkedList list4 = new MySimpleLinkedList();
		SumatoriaSecuencias sumatoria4 = new SumatoriaSecuencias(list4);
		
		list4.insertBack(3);
		list4.insertBack(5);
		list4.insertBack(4);
		list4.insertBack(2);
		list4.insertBack(7);
		list4.insertBack(15);
		list4.insertBack(14);
		list4.insertBack(28);
		
		System.out.println(sumatoria4.getSumatoria(15));
		
		// Datos personalizados
		
		MySimpleLinkedList list5 = new MySimpleLinkedList();
		SumatoriaSecuencias sumatoria5 = new SumatoriaSecuencias(list5);
		
		list5.insertBack(30);
		list5.insertBack(50);
		list5.insertBack(5);
		list5.insertBack(30);
		list5.insertBack(4);
		list5.insertBack(100);
		
		System.out.println(sumatoria5.getSumatoria(15));
		
		MySimpleLinkedList list6 = new MySimpleLinkedList();
		SumatoriaSecuencias sumatoria6 = new SumatoriaSecuencias(list6);
		
		list6.insertBack(30);
		list6.insertBack(50);
		list6.insertBack(5);
		list6.insertBack(4);
		list6.insertBack(100);
		list6.insertBack(0);
		
		System.out.println(sumatoria6.getSumatoria(15));
		
	}

}
