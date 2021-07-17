package Entregable_4y5;

public class GreedyMain {

	public static void main(String[] args) {
		
		Empleado empleado1 = new Empleado("Juan", "Pérez", 32);
		Empleado empleado2 = new Empleado("Roberto", "Hernández", 45);
		Empleado empleado3 = new Empleado("Camila", "Gutiérrez", 33);
		Empleado empleado4 = new Empleado("Francisco", "Martínez", 22);	
		Empleado empleado5 = new Empleado("Benjamín", "Núnez", 55);	
		Empleado empleado6 = new Empleado("Mateo", "Morales", 24);	
		Empleado empleado7 = new Empleado("Delfina", "López", 36);	
		Empleado empleado8 = new Empleado("Catalina", "Cruz", 51);
		Empleado empleado9 = new Empleado("Benicio", "Montero", 48);	
		Empleado empleado10 = new Empleado("Valentino", "González", 58);	
		Empleado empleado11 = new Empleado("Olivia", "Gómez", 33);
		Empleado empleado12 = new Empleado("Martina", "Díaz", 21);
		Empleado empleado13 = new Empleado("Joaquín", "Cabrera", 22);
		Empleado empleado14 = new Empleado("Bautista", "Domínguez", 36);
		Empleado empleado15 = new Empleado("Emilia", "Paz", 40);	
		Empleado empleado16 = new Empleado("Francesca", "Figueroa", 43);
		Empleado empleado17 = new Empleado("Santino", "Blanco", 25);
		Empleado empleado18 = new Empleado("Ignacio", "Ibarra", 61);
		Empleado empleado19 = new Empleado("Andrea", "Chávez", 27);
		Empleado empleado20 = new Empleado("Elena", "Mengochea", 52);
		
		Empresa empresa = new Empresa();
		
		// Entrada 1
	
		System.out.println("Entrada 1:");
		
		Greedy greedy1 = new Greedy();
		
		empresa.contratarEmpleado(empleado1, 48);
		empresa.contratarEmpleado(empleado2, 57);
		empresa.contratarEmpleado(empleado3, 51);
		empresa.contratarEmpleado(empleado4, 73);
		empresa.contratarEmpleado(empleado5, 15);
		empresa.contratarEmpleado(empleado6, 33);
		
		System.out.println(greedy1.greedy(empresa));
		
		empresa.despedirEmpleados();
		
		// Entrada 2
		
		System.out.println("Entrada 2:");
		
		Greedy greedy2 = new Greedy();
		
		empresa.contratarEmpleado(empleado7, 92);
		empresa.contratarEmpleado(empleado4, 73);
		empresa.contratarEmpleado(empleado8, 71);
		empresa.contratarEmpleado(empleado15, 16);
		
		System.out.println(greedy2.greedy(empresa));
		
		empresa.despedirEmpleados();
		
		// Entrada 3
		
		System.out.println("Entrada 3:");
		
		Greedy greedy3 = new Greedy();
		
		empresa.contratarEmpleado(empleado19, 78);
		empresa.contratarEmpleado(empleado12, 49);
		empresa.contratarEmpleado(empleado11, 41);
		empresa.contratarEmpleado(empleado13, 14);
		
		System.out.println(greedy3.greedy(empresa));
		
		empresa.despedirEmpleados();
		
		// Entrada 4
		
		System.out.println("Entrada 4:");
		
		Greedy greedy4 = new Greedy();
		
		empresa.contratarEmpleado(empleado19, 78);
		empresa.contratarEmpleado(empleado18, 32);
		empresa.contratarEmpleado(empleado14, 33);
		empresa.contratarEmpleado(empleado16, 21);
		
		System.out.println(greedy4.greedy(empresa));
		
		empresa.despedirEmpleados();
		
		// Entrada 5
		
		System.out.println("Entrada 5:");
		
		Greedy greedy5 = new Greedy();
		
		empresa.contratarEmpleado(empleado7, 92);
		empresa.contratarEmpleado(empleado8, 71);
		empresa.contratarEmpleado(empleado20, 67);
		empresa.contratarEmpleado(empleado3, 51);
		empresa.contratarEmpleado(empleado16, 21);
		
		System.out.println(greedy5.greedy(empresa));
		
		empresa.despedirEmpleados();
		
		// Entrada 6
		
		System.out.println("Entrada 6:");
		
		Greedy greedy6 = new Greedy();
		
		empresa.contratarEmpleado(empleado6, 92);
		empresa.contratarEmpleado(empleado15, 71);
		empresa.contratarEmpleado(empleado17, 67);
		empresa.contratarEmpleado(empleado13, 51);
		empresa.contratarEmpleado(empleado16, 21);
		empresa.contratarEmpleado(empleado10, 22);
		
		System.out.println(greedy6.greedy(empresa));
		
		empresa.despedirEmpleados();
		
		
		// Entrada 7
		
		System.out.println("Entrada 7:");
		
		Greedy greedy7 = new Greedy();
		
		empresa.contratarEmpleado(empleado17, 79);
		empresa.contratarEmpleado(empleado2, 57);
		empresa.contratarEmpleado(empleado19, 78);
		empresa.contratarEmpleado(empleado20, 67);
		empresa.contratarEmpleado(empleado4, 73);
		empresa.contratarEmpleado(empleado12, 49);
		empresa.contratarEmpleado(empleado15, 16);
		
		System.out.println(greedy7.greedy(empresa));
		
		empresa.despedirEmpleados();
		
		// Entrada 8
		
		System.out.println("Entrada 8:");
		
		Greedy greedy8 = new Greedy();
		
		empresa.contratarEmpleado(empleado12, 49);
		empresa.contratarEmpleado(empleado14, 33);
		empresa.contratarEmpleado(empleado18, 32);
		empresa.contratarEmpleado(empleado6, 33);
		empresa.contratarEmpleado(empleado2, 57);
		empresa.contratarEmpleado(empleado9, 19);
		empresa.contratarEmpleado(empleado10, 22);
		empresa.contratarEmpleado(empleado16, 21);
		
		System.out.println(greedy8.greedy(empresa));
		
		empresa.despedirEmpleados();
		
		// Entrada 9
		
		System.out.println("Entrada 9:");
		
		Greedy greedy9 = new Greedy();
		
		empresa.contratarEmpleado(empleado1, 48);
		empresa.contratarEmpleado(empleado2, 57);
		empresa.contratarEmpleado(empleado3, 51);
		empresa.contratarEmpleado(empleado4, 73);
		empresa.contratarEmpleado(empleado5, 15);
		empresa.contratarEmpleado(empleado6, 33);
		empresa.contratarEmpleado(empleado7, 92);
		empresa.contratarEmpleado(empleado8, 71);
		empresa.contratarEmpleado(empleado9, 19);
		empresa.contratarEmpleado(empleado10, 22);
		empresa.contratarEmpleado(empleado11, 41);
		empresa.contratarEmpleado(empleado12, 49);
		empresa.contratarEmpleado(empleado13, 14);
		empresa.contratarEmpleado(empleado14, 33);
		empresa.contratarEmpleado(empleado15, 16);
		empresa.contratarEmpleado(empleado16, 21);
		empresa.contratarEmpleado(empleado17, 79);
		empresa.contratarEmpleado(empleado18, 32);
		empresa.contratarEmpleado(empleado19, 78);
		empresa.contratarEmpleado(empleado20, 67);
		
		System.out.println(greedy9.greedy(empresa));
	}
}
