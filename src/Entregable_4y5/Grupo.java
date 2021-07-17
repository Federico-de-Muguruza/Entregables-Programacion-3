package Entregable_4y5;

import java.util.ArrayList;

public class Grupo {
	
	private String nombre;
	private Integer puntajeGrupal;
	private ArrayList<Empleado> empleados;
	
	public Grupo(String nombre) {
		this.nombre = nombre;
		this.puntajeGrupal = 0;
		this.empleados = new ArrayList<>();
	}
	
	public Grupo(String nombre, ArrayList<Empleado> empleados, Integer puntajeGrupal) {
		this.nombre = nombre;
		this.empleados = new ArrayList<>(empleados);
		this.puntajeGrupal = puntajeGrupal;
	}
	
	public void agregarAlGrupo(Empleado empleado) {
		empleados.add(empleado);
		this.puntajeGrupal += empleado.getPuntaje();
	}
	
	public void sacarDelGrupo(Empleado empleado) {
		this.puntajeGrupal -= empleado.getPuntaje();
		empleados.remove(empleado);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Integer getPuntajeGrupal() {
		return this.puntajeGrupal;
	}
	
	public ArrayList<Empleado> getEmpleados() {
		return new ArrayList<>(this.empleados);
	}
	
	public String toString() {
		return "Puntaje Grupal: " + this.getPuntajeGrupal() + " - Cantidad empleados: " + this.empleados.size();
	}
}
