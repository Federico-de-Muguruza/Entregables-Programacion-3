package Entregable_4y5;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy {
	
	private Integer cantIteraciones;
	
	public Greedy() {
		this.cantIteraciones = 0;
	}
	
	public Solucion greedy(Empresa empresa) {

		ArrayList<Empleado> candidatos = new ArrayList<>(empresa.getEmpleados());
		
		Solucion solucion = new Solucion();
		
		Collections.sort(candidatos, new ComparatorPuntaje());
		
		while ( ! candidatos.isEmpty()) {
			
			this.cantIteraciones++;
			
		 	seleccionar(candidatos.get(0), solucion);
			
			candidatos.remove(0);
		}	
		solucion.setIteraciones(this.cantIteraciones);
		// Los agrego a la empresa para que tenga algo de sentido
		empresa.setGrupoA(solucion.getGrupoA());
		empresa.setGrupoB(solucion.getGrupoB());
		return solucion;
	}
	
	private void seleccionar(Empleado candidato, Solucion solucion) {
		if (solucion.getGrupoA().getPuntajeGrupal() <= solucion.getGrupoB().getPuntajeGrupal())
			solucion.getGrupoA().agregarAlGrupo(candidato);
		else
			solucion.getGrupoB().agregarAlGrupo(candidato);
	
	}
}
