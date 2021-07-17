package Entregable_4y5;

import java.util.ArrayList;

public class Backtracking {
	
	private Integer diferenciaOptima;
	private Integer cantIteraciones;
	private Solucion solucionOptima;
	private ArrayList<Empleado> candidatos;

	public Backtracking() {
		this.diferenciaOptima = Integer.MAX_VALUE;
		this.cantIteraciones = 0;
		this.solucionOptima = new Solucion();
	}
	
	public void backtracking(Empresa empresa) {
		Integer i = 0;
		this.candidatos = new ArrayList<Empleado>(empresa.getEmpleados());
		backtracking(new Solucion(), i);
		// Guardo los resultados óptimos en la empresa
		empresa.setGrupoA(solucionOptima.getGrupoA());
		empresa.setGrupoB(solucionOptima.getGrupoB());
		System.out.println(solucionOptima);
	}
	
	private void backtracking(Solucion solucionParcial, Integer i) {
		
		// Cuento la cantidad de iteraciones
		this.cantIteraciones++;
		
		// Función de corte, cuando la suma de ambos grupos sea igual a la de candidatos
		if (mismaCantidad(candidatos, solucionParcial)) {
			// Calculo la diferencia de los grupos actuales
			Integer diferenciaActual = calcularDiferencia(solucionParcial);
			// Si la diferencia actual es mejor que la óptima guardo los datos
			if (this.diferenciaOptima > diferenciaActual) {
				this.diferenciaOptima = diferenciaActual;
				// Se devuelve una copia de solucionParcial por temas de punteros
				this.solucionOptima.setGrupoA(solucionParcial.getCopiaGrupoA());
				this.solucionOptima.setGrupoB(solucionParcial.getCopiaGrupoB());
			}
		} else {
			Empleado empleado = candidatos.get(i);
	
			// Si la diferenciaOptima no es 0, sigo buscando la mejor solución
			if ( ! poda()) {
				solucionParcial.getGrupoA().agregarAlGrupo(empleado);	
				backtracking(solucionParcial, i + 1);
				solucionParcial.getGrupoA().sacarDelGrupo(empleado);
			

				solucionParcial.getGrupoB().agregarAlGrupo(empleado);
				backtracking(solucionParcial, i + 1);	
				solucionParcial.getGrupoB().sacarDelGrupo(empleado);
			}
			
			// Guardo la cantidad de iteraciones en la solución
			this.solucionOptima.setIteraciones(this.cantIteraciones);
		}
	}
	
	private boolean poda() {
		return this.diferenciaOptima == 0;
	}
	 
	private boolean mismaCantidad(ArrayList<Empleado> candidatos, Solucion solucionParcial) {
		return (solucionParcial.getGrupoA().getEmpleados().size() + solucionParcial.getGrupoB().getEmpleados().size()) == candidatos.size();
	}
	
	private Integer calcularDiferencia(Solucion solucionParcial) {
		Integer diferencia = 0;
		Integer puntajeGrupalGA = solucionParcial.getGrupoA().getPuntajeGrupal();
		Integer puntajeGrupalGB = solucionParcial.getGrupoB().getPuntajeGrupal();
		
		return diferencia = (puntajeGrupalGA >= puntajeGrupalGB)
				? puntajeGrupalGA - puntajeGrupalGB
				: puntajeGrupalGB - puntajeGrupalGA;			
	}
}
