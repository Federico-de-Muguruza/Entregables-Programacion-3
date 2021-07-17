package Entregable_4y5;

import java.util.Comparator;

public class ComparatorPuntaje implements Comparator<Empleado> {

	public int compare(Empleado emp1, Empleado emp2) {
		return emp2.getPuntaje() - emp1.getPuntaje();
	}
}
