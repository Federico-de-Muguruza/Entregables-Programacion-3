package Entregable_4y5;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<Empleado> empleados = new ArrayList<>();
	private Grupo grupoA;
	private Grupo grupoB;
	
	public Empresa() {
		this.grupoA = new Grupo("A");
		this.grupoB = new Grupo("B");
	}
	
	public void contratarEmpleado(Empleado empleado, Integer puntaje) {
		this.empleados.add(empleado);
		empleado.setPuntaje(puntaje);
	}
	
	public ArrayList<Empleado> getEmpleados() {
		return new ArrayList<>(this.empleados);
	}
	
	public void setGrupoA(Grupo grupo) {
		this.grupoA = grupo;
	}
	
	public void setGrupoB(Grupo grupo) {
		this.grupoB = grupo;
	}
	
	public void despedirEmpleados() {
		this.empleados.clear();
		this.grupoA = new Grupo("A");
		this.grupoB = new Grupo("B");
	}
}